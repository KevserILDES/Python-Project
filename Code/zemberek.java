import zemberek.morphology.analysis.WordAnalysis;
import zemberek.morphology.analysis.tr.TurkishMorphology;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Scanner;
import java.io.FilenameFilter;

public class zemberek {

	public static void main(String[] args) throws IOException {
		File directoryPath = new File("C:\\Users\\win7\\Desktop\\1150haber\\magazin");

		File[] files = directoryPath.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});

		TurkishMorphology morphology = TurkishMorphology.createWithDefaults();

		OutputStreamWriter pwN = new OutputStreamWriter(new FileOutputStream("nouns.txt"), "8859_9");
		OutputStreamWriter pwAdj = new OutputStreamWriter(new FileOutputStream("adjectives.txt"), "8859_9");
		OutputStreamWriter pwVrb = new OutputStreamWriter(new FileOutputStream("verbs.txt"), "8859_9");

		for (File file : files) {
			Scanner in = new Scanner(new FileInputStream(file.getAbsoluteFile()), "UTF8");
			while (in.hasNext()) {
				List<WordAnalysis> results = morphology.analyze(in.next());
				for (int i = 0; i < results.size(); i++) {
					if (results.get(i).formatLong().contains("Noun") && !results.get(i).formatLong().contains("Agt:")
							&& results.get(i).formatLong().contains("Nom")
							&& !results.get(i).formatLong().contains(")(")
							&& !results.get(i).formatLong().contains("pl")
							&& !results.get(i).formatLong().contains("P1sg")
							&& !results.get(i).formatLong().contains("P2sg:")
							&& !results.get(i).formatLong().contains("P3sg")
							&& results.get(i).formatLong().contains("A3sg")
							&& !results.get(i).formatLong().contains("Verb")) {
						pwN.write(results.get(i).getSurfaceForm() + "\n");

					} else if (results.get(i).formatLong().contains("Adj")
							&& !results.get(i).formatLong().contains("Noun")
							&& !results.get(i).formatLong().contains("Verb")) {
						pwAdj.write(results.get(i).dictionaryItem.root + "\n");

					} else if (results.get(i).formatLong().contains("Verb")
							&& !results.get(i).formatLong().contains("+Dat")
							&& !results.get(i).formatLong().contains("ByDoing")
							&& !results.get(i).formatLong().contains("Opt")
							&& !results.get(i).formatLong().contains("Acquire")
							&& !results.get(i).formatLong().contains("Inf1")
							&& !results.get(i).formatLong().contains("A1sg")
							&& !results.get(i).formatLong().contains("Acc")
							&& !results.get(i).formatLong().contains("PastPart:")
							&& !results.get(i).formatLong().contains("While:")
							&& !results.get(i).formatLong().contains("Noun")
							&& !results.get(i).formatLong().contains("PresPart")
							&& !results.get(i).formatLong().contains("Imp")
							&& (!results.get(i).formatLong().contains("Aor:")
									&& !results.get(i).formatLong().contains("Cond:"))
							&& (results.get(i).formatLong().contains("ecek")
									|| results.get(i).formatLong().contains("acak")
									|| results.get(i).formatLong().contains("di")
									|| results.get(i).formatLong().contains("dı")
									|| results.get(i).formatLong().contains("miş")
									|| results.get(i).formatLong().contains("mış")
									|| results.get(i).formatLong().contains("r+"))) {
						pwVrb.write(results.get(i).getSurfaceForm() + "\n");
					}

					pwN.flush();
					pwVrb.flush();
					pwAdj.flush();

				}
			}
			in.close();
		}

		pwN.close();
		pwAdj.close();
		pwVrb.close();
	}
}