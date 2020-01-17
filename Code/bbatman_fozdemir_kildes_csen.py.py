import os
import sys
import pandas as pd
import numpy as np
import sklearn
import nltk
from sklearn.feature_extraction.text import TfidfVectorizer

letterValue = {'a':1, 'b':2, 'c':3, 'Ã§':4, 'd':5, 'e':6, 'f':7, 'g':8, 'Ä':9, 'h':10, 'Ä±':11,
             'i':12, 'j':13, 'k':14, 'l':15, 'm':16, 'n':17, 'o':18, 'Ã¶':19, 'p':20, 'r':21,
             's':22, 'Å':23, 't':24, 'u':25, 'Ã¼':26, 'v':27, 'y':28, 'z':29 }

def module1(ws):
    path = r'C:\Users\win7\Desktop\1150haber-\\'
    fileNames = []
    wordList = []
    wordSum = int(ws)
    wordLimit = 100000

    fileNames = [ subdir+os.path.sep+file for subdir, dirs, files in os.walk(path) for file in files ]
    #fileNames = [fileName.replace('\\','/') for fileName in fileNames ] # you may add this line for windows os

    tfidfVectorizer = TfidfVectorizer(decode_error='ignore')
    docTermMatrix = tfidfVectorizer.fit_transform((open(f,encoding="utf8").read() for f in fileNames))
    #tfidfVectorizer.fit_transform(f.split('\n') for f in fileNames)

    wordList = [ word[0] for i,word in zip(range(0,wordLimit),tfidfVectorizer.vocabulary_.items()) ]
    
    for word in wordList:
        total = 0
        values = []
        cont  = True
        for letter in word:
            if letter not in letterValue:
                cont = False
                continue
            values.append(letterValue[letter])
            total = total + letterValue[letter]
        if cont == False:
            continue
        if total == wordSum:
            print(word, values, total)

def module2(ss):
    fileNames = []
    wordListN = []
    wordListA = []
    wordListV = []
    sentenceSum = int(ss)
    wordLimit = 100000
    
    boolean=True
    
    fN= open(r'C:\Users\win7\eclipse-workspace\Zemberek1\nouns.txt',"r")
    for word in fN:
        wordListN.append(word)

    fA= open(r'C:\Users\win7\eclipse-workspace\Zemberek1\adjectives.txt',"r")
    for word in fA:
        wordListA.append(word)

    fV= open(r'C:\Users\win7\eclipse-workspace\Zemberek1\verbs.txt',"r")
    for word in fV:
        wordListV.append(word)
        
    prev=" "
    for word in wordListV:
        if prev==word:
            continue
        total=0
        values = []
        cont  = True
        for letter in word:
            boolean=True
            #   print(letter)
            if letter not in letterValue:
                if letter.isspace():
                    continue
              #      print(letter not in letterValue)
                cont = False
                continue
            values.append(letterValue[letter])
              #  print(letter,letterValue[letter])
            total = total + letterValue[letter]
            #print("v")
            #print(total)
        if cont == False:
             #   print("iff")
            continue
        for word1 in wordListN:
            if boolean==False:
                continue
            total1=total
              #  print("hin")
            Nvalues1=[]
            for letter1 in word1:
                if letter1 not in letterValue:
                    if letter.isspace():
                        continue
                    cont=False
                    continue
                Nvalues1.append(letterValue[letter1])
                total1=total1 + letterValue[letter1]
              #  print("vn")
               # print(total)
            if cont == False:
                continue
            for word2 in wordListA:
                if boolean==False:
                    continue
                total2=total1
                Nvalues2=[]
                for letter2 in word2:
                    if letter2 not in letterValue:
                        if letter.isspace():
                            continue
                        cont=False
                        continue
                    Nvalues2.append(letterValue[letter2])
                    total2=total2 + letterValue[letter2]
                    
                if cont == False:
                    continue
    
                if total2 == sentenceSum:
                    sentence=word2.split()+word1.split()+word.split()
                    boolean=False
                    prev=word
                    print(sentence,total2)
            
def main(): 
    while(1):
        print("press - 1 for module 1, 2 - for module 2")
        input1 = int(input()) 
        if input1 == 1:
            print("enter the number for the word count:")
            input2 = input()
            module1(input2)
        elif input1 == 2:
            print("enter the number for the word count:")
            input3 = input()
            module2(input3)
        else:
            print("enter 1 or 2 !")
            exit()
        
if __name__ == '__main__':
    main()