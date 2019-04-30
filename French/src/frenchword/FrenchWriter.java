package frenchword;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;


public class FrenchWriter {
    ArrayList<FrenchWord> WordList;
    
    public static void main(String[] args) {
        makeWordFileFromBook("src/texts/proust.txt");
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
    			ArrayList<String>frenchWordList = new ArrayList<String>();

    			int count = 0;
    			String line = reader.readLine();
    			while (line != null) {
    				//System.out.println("Read a line with " + line.length() + " characters.");
    				line = line.trim();

    				String[] lineWords = line.split(" ");

    				for(String  word : lineWords){
    					String candidate = word.toLowerCase().replaceAll("[)(\\[\\]!,.?{} :; \"\\']", "");
    					frenchWordList.add(candidate);  // Add the word object
    				}
    				line = reader.readLine();
    			}
    			System.out.println("We read " + frenchWordList.size() + " words from the file");

    			//Collections.sort(wordList, (lambda (w1 w2) (w1 string<? w2)));
    			Collections.sort(frenchWordList, (w1, w2) -> w1.compareTo(w2));

    			// post-process the sorted list to build a new list of unique words
    		    PrintWriter out1;
    	        try {
    	            out1 = new PrintWriter("FrenchWordList.txt");  // DEBUG is the name of the file. 
    	            // You would do something like PrintWriter("FrenchWordList.txt");
        			String lastWord = ""; // Hold the previous word in the list
        			for(String s : frenchWordList){
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
                "l'arc en ciel est une f�te."
    }

}*/
    