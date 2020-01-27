package frenchword;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class FrenchWriter {


	public static void main(String[] args) { 
		FrenchWriter François = new FrenchWriter();
	//	 makeWordFileFromBook("src/texts/proust.txt");
	//	François.makePhonemeFileFromWordList("src/texts/FrenchWordList.txt");
	//	François.makePhonemeKey();
	Scanner sc = new Scanner(System.in);
	System.out.println("Type the word you want to pronounce:");
	String word = sc.nextLine();
		FrenchWord myWord = new FrenchWord(word);
		System.out.println(myWord);
		FrenchWord myWord2 = new FrenchWord("");
		System.out.println(myWord2);
		sc.close();

		//makePhonemeFileFromWordList("FrenchWordList.txt");
		//readSampleSentences(); 
	}
	// Turns a book into a word list on disk. Just word list. No phonemes
	static void makeWordFileFromBook(String filename) {
		System.out.println("** Reading Book File: " + filename);

		try { 
			FileReader f = new FileReader(filename); // Declaring and constructing a FileReader object
			BufferedReader reader = new BufferedReader(f);
			// ArrayList is "generic," <> meaning it can be "an ArrayList of various types"
			// We have to tell the compiler which type of things it will hold
			ArrayList<String>wordList = new ArrayList<String>();
			String line = reader.readLine();
			while (line != null) {
				//System.out.println("Read a line with " + line.length() + " characters.");
				line = line.trim();

				String[] lineWords = line.split(" ");

				for(String  word : lineWords){
					String candidate = word.toLowerCase().replaceAll("[)[0-9](\\[\\]!,.?{} :;_ \\\"]", "");
					if (candidate != null) {
					if ((candidate.contains("-") ||
							candidate.contains("—"))) {
						candidate = candidate.replaceAll("[\\-—]", " ");
						String[] cParts = candidate.split(" ");
						for (String s: cParts) {
							wordList.add(s);
						}
					}
					else wordList.add(candidate);
					}
				}
				line = reader.readLine();
			}
			System.out.println("We read " + wordList.size() + " words from the file");

			//Collections.sort(wordList, (lambda (w1 w2) (w1 string<? w2)));
			Collections.sort(wordList, (w1, w2) -> w1.compareTo(w2));

			// post-process the sorted list to build a new list of unique words
			PrintWriter out1;
			try {
				out1 = new PrintWriter("src/texts/FrenchWordList.txt");  // DEBUG is the name of the file. 
				// You would do something like PrintWriter("FrenchWordList.txt");
				String lastWord = ""; // Hold the previous word in the list
				for(String s : wordList){
					if(! s.equals(lastWord)){
						out1.println(s);
						lastWord = s;
					}
				}
				out1.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}


			reader.close();
		} catch (IOException x) {
			System.err.format("IOException: %s\n", x);
		}
		System.out.println("Done Reading Book File"); 
	}

	// Step 1, read the book, like we already do
	//   generating the WordList as it goes.

	// Step 2, when WordList is done, save it to a file.
	//   using the PrintWriter stuff from the email




	// 
	/*static void makePhonemeFileFromWordList(String filename) {
        // Step 1, read the word list file, like we already do
        //   generating phonemes for each as it goes, saving in
        //   ArrayList<FrenchWord> 

        // Step 2, when WordList is done, save it to a file.
        //   using the PrintWriter stuff from the email

    }

    static void readSampleSentences() {
        String[] sentences = {
                "je t'aime",    
                "Non! Allons chez Suzette!",
                "l'arc en ciel est une fête."
    }

}*/
	void makePhonemeFileFromWordList(String filename) {
		System.out.println("** Reading Book File: " + filename);

		try { 
			FileReader f = new FileReader(filename); // Declaring and constructing a FileReader object
			BufferedReader reader = new BufferedReader(f);
			ArrayList<FrenchWord>frenchWordList = new ArrayList<FrenchWord>();

			String line = reader.readLine();
			while (line != null) {
				//System.out.println("Read a line with " + line.length() + " characters.");
				FrenchWord word = new FrenchWord(line);
				frenchWordList.add(word);
				//System.out.println(word.phonemes);
				line = reader.readLine();
			}
			System.out.println("We read " + frenchWordList.size() + " words from the file");

			PrintWriter out1;
			try {
				out1 = new PrintWriter("src/texts/FrenchPhonList.txt");  // DEBUG is the name of the file. 
				// You would do something like PrintWriter("FrenchWordList.txt");
				for(FrenchWord s : frenchWordList){
						out1.println(s);
				} 
				out1.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			reader.close();
		} catch (IOException x) {
			System.err.format("IOException: %s\n", x);
		}
		System.out.println("Done Reading Book File"); 
	}


void makePhonemeKey() {
	PrintWriter out6;
	
	try {
		out6 = new PrintWriter("src/texts/phonKey.txt");
		out6.println("ɑ : ah like 'arm'");
		out6.println("ɑ̃ : ah with soft palette lowered (nasal)");
		out6.println("e : ey like 'day'");
		out6.println("ɛ : eh like 'effect'");
		out6.println("ɛ̃ : eh with soft palette lowered (nasal)");
		out6.println("ə : ugh like you've been punched in the gut (or silent if you're speaking quickly)");
		out6.println("i : ee like pee");
		out6.println("o : oh without the second dipthong");
		out6.println("ɔ : 'ore' just don't close your mouth completely");
		out6.println("ɔ̃ : 'ah ng' like gong");
		out6.println("œ	: uh like 'hoof'");
		out6.println("ø : oogh like 'lune' mixed with being punched in the gut");
		out6.println("u	: oo like 'too'");
		out6.println("y : yu like in 'you'");
		out6.println("j : y like in 'tortilla'");
		out6.println("wa: w + ah, think 'WWHataburger'"); 
		out6.println("ɲ : nnnya like the Knights who Say 'Ni' or 'Knack knack knack' or 'Funyan'");
		out6.println("ŋ : ng like in 'singing'");
		out6.println("ʃ : sh like 'she'");
		out6.println("ʒ : zh like in 'vision', or a very soft jh");
		out6.println("jɑ̃: eyyoh like an abnoxious nasal donkey but really fast so it sounds like 'yoh'");
		out6.println("eʁ: eh-er like 'air'");
		out6.println("ks: x like 'fox");
		out6.println("All other consonants are pronounced like their American counterparts");
		
		out6.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	
}
}

