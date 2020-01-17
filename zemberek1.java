
import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.io.FilenameFilter;


public class zemberek1 {

    
    public static void main(String[] args)  throws IOException {
File directoryPath = new File("C:\\Users\\KubraKevser\\Desktop\\obje python\\1150haber\\ekonomi");
		
		//List text files only
	//	System.out.println("\n------------Text files------------");
		File[] files=directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
        TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

        /*Scanner in=new Scanner(new File("C:\\Users\\KubraKevser\\Desktop\\obje python\\1150haber\\ekonomi\\1.txt"));
		System.out.println("------"+in.next());
        while(in.hasNext()) {
		List<WordAnalysis> results = morphology.analyze(in.next());
        results.forEach(s -> System.out.println(s.formatLong()));
		}*/
		PrintWriter pwN=new PrintWriter(new File("nouns.txt"));
		PrintWriter pwAdj=new PrintWriter(new File("adjectives.txt"));
		PrintWriter pwVrb=new PrintWriter(new File("verbs.txt"));
		PrintWriter pwConj=new PrintWriter(new File("conjunctions.txt"));
		PrintWriter pwPsPs=new PrintWriter(new File("postpositives.txt"));
		PrintWriter pwAdv=new PrintWriter(new File("adverbs.txt"));
		PrintWriter pwPrN=new PrintWriter(new File("pronouns.txt"));
		PrintWriter pwDet=new PrintWriter(new File("determiners.txt"));

		
		for (File file : files) {
			Scanner in=new Scanner(new File("dosya2.txt")/*new FileInputStream(file.getAbsoluteFile())*/, "ISO-8859-9");
			while(in.hasNext()) {
				//String a=in.next();
				//System.out.println(a);
			List<WordAnalysis> results = morphology.analyze(in.next());
			for(int i=0;i<results.size();i++) {
			//	System.out.println(results.get(i).dictionaryItem.root);
				switch (results.get(i).dictionaryItem.primaryPos.toString()){
				case "Noun":
					//System.out.println(results.get(i).dictionaryItem.lemma);
					pwN.println(results.get(i).dictionaryItem.root);
					break;
				case "Adjective":
					pwAdj.println(results.get(i).dictionaryItem.root);
					break;
				case "Verb":
					pwVrb.println(results.get(i).dictionaryItem.root);
					break;
				case "Conjunction":
					pwConj.println(results.get(i).dictionaryItem.root);
					break;
				case "PostPositive":
					pwPsPs.println(results.get(i).dictionaryItem.root);
					break;
				case "Adverb":
					pwAdv.println(results.get(i).dictionaryItem.root);
					break;
				case "Pronoun":
					pwPrN.println(results.get(i).dictionaryItem.root);
					break;
				case "Determiner":
					pwDet.println(results.get(i).dictionaryItem.root);
					break;
				}
				pwN.flush();
				pwPsPs.flush();
				pwVrb.flush();
				pwAdj.flush();
				pwAdv.flush();
				pwPrN.flush();
				pwConj.flush();
				pwDet.flush();
				
			}
	//        results.forEach(s ->  System.out.println(s.dictionaryItem.lemma));
			}
			in.close();
			break;
		}
	/*	
directoryPath = new File("C:\\Users\\KubraKevser\\Desktop\\obje python\\1150haber\\magazin");
		
		//List text files only
	//	System.out.println("\n------------Text files------------");
		files=directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
       // TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

        /*Scanner in=new Scanner(new File("C:\\Users\\KubraKevser\\Desktop\\obje python\\1150haber\\ekonomi\\1.txt"));
		System.out.println("------"+in.next());
        while(in.hasNext()) {
		List<WordAnalysis> results = morphology.analyze(in.next());
        results.forEach(s -> System.out.println(s.formatLong()));
		}
		
		for (File file : files) {
			Scanner in=new Scanner(new FileInputStream("dosya.txt"), "ISO-8859-9");
			while(in.hasNext()) {
				//String a=in.next();
				//System.out.println(a);
			List<WordAnalysis> results = morphology.analyze(in.next());
			for(int i=0;i<results.size();i++) {
			//	System.out.println(results.get(i).dictionaryItem.root);
				switch (results.get(i).dictionaryItem.primaryPos.toString()){
				case "Noun":
					//System.out.println(results.get(i).dictionaryItem.lemma);
					pwN.println(results.get(i).dictionaryItem.root);
					break;
				case "Adjective":
					pwAdj.println(results.get(i).dictionaryItem.root);
					break;
				case "Verb":
					pwVrb.println(results.get(i).dictionaryItem.root);
					break;
				case "Conjunction":
					pwConj.println(results.get(i).dictionaryItem.root);
					break;
				case "PostPositive":
					pwPsPs.println(results.get(i).dictionaryItem.root);
					break;
				case "Adverb":
					pwAdv.println(results.get(i).dictionaryItem.root);
					break;
				case "Pronoun":
					pwPrN.println(results.get(i).dictionaryItem.root);
					break;
				case "Determiner":
					pwDet.println(results.get(i).dictionaryItem.root);
					break;
				}
				pwN.flush();
				pwPsPs.flush();
				pwVrb.flush();
				pwAdj.flush();
				pwAdv.flush();
				pwPrN.flush();
				pwConj.flush();
				pwDet.flush();
				
			}
	//        results.forEach(s ->  System.out.println(s.dictionaryItem.lemma));
			}
			
			in.close();
		}
		*/
    //    Scanner inFile=new Scanner("")

        

    }
    
}