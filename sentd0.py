import os
import sys
import pandas as pd
import numpy as np
import sklearn
import nltk
from sklearn.feature_extraction.text import TfidfVectorizer

pathN = "C:/Users/KubraKevser/new-eclipse-ws/zemm/nouns.txt"
pathV = "C:/Users/KubraKevser/new-eclipse-ws/zemm/verbs.txt"
#pathN = "C:/Users/KubraKevser/new-eclipse-ws/zemm/nouns.txt"
#pathN = "C:/Users/KubraKevser/new-eclipse-ws/zemm/nouns.txt"

fileNames = []
wordListN = []
wordListV = []
wordLimit = 100000
wordSum = 120
letterValue = {'a':1, 'b':2, 'c':3, 'ç':4, 'd':5, 'e':6, 'f':7, 'g':8, 'ğ':9, 'h':10, 'ı':11,
             'i':12, 'j':13, 'k':14, 'l':15, 'm':16, 'n':17, 'o':18, 'ö':19, 'p':20, 'r':21,
             's':22, 'ş':23, 't':24, 'u':25, 'ü':26, 'v':27, 'y':28, 'z':29 }

#fileName = [ subdir+os.pathN.sep for subdir, dirs, files in os.walk(pathN)]
#fileNames = [fileName.replace('\\','/') for fileName in fileNames ] # you may add this line for windows os

fN= open("C:/Users/KubraKevser/new-eclipse-ws/zemm/nouns.txt","r")
#tfidfVectorizerN = TfidfVectorizer(decode_error='ignore')
#docTermMatrixN = tfidfVectorizerN.fit_transform((open(pathN,encoding="utf8").read()))

#wordListN = [ word[0] for i,word in zip(range(0,wordLimit),f) ]
for word in fN:
    wordListN.append(word)

#tfidfVectorizerV = TfidfVectorizer(decode_error='ignore')
#docTermMatrixV = tfidfVectorizerV.fit_transform((open(pathV,encoding="utf8").read()))

#wordListV = [ word[0] for i,word in zip(range(0,wordLimit),tfidfVectorizerV.vocabulary_.items()) ]
fV= open("C:/Users/KubraKevser/new-eclipse-ws/zemm/verbs.txt","r")
#tfidfVectorizerN = TfidfVectorizer(decode_error='ignore')
#docTermMatrixN = tfidfVectorizerN.fit_transform((open(pathN,encoding="utf8").read()))

#wordListN = [ word[0] for i,word in zip(range(0,wordLimit),f) ]
#contentV=fV.read();

for word in fV:
    wordListV.append(word)
    


for word in wordListV:
    total=0
    values = []
    cont  = True
    for letter in word:
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
        for word2 in wordListN:
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
        
            if total2 == wordSum:
                sentence=word1.split()+word2.split()+word.split()
                print(sentence,total2)
               