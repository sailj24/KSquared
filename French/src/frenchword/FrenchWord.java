package frenchword;
import java.util.ArrayList;

public class FrenchWord {
		String word;
		ArrayList<String> phonemes;


		/* Default constructor, that takes no parameters
		 * constructors have 3 distinguishing features
		 *   Same name as the class
		 *   No return type, not even void
		 *   Are public
		 * We use constructors to initialize the fields, 
		 * And optionally do other setup.
		 *
		 * Call the constructor that has more parameters
		 */
		public FrenchWord(){
			this(""); 
		}



		/* 
		 * Constructor that takes a string intended to be the word field
		 */
		public FrenchWord(String word){
			this.word = word; // Sets the class field "word" to be the parameter "word"
			this.phonemes = new ArrayList<String>();
		}



		public boolean equals(FrenchWord otherWord){
			return this.word.equals(otherWord.word);
		}


		/**
		 * Creates a String representation of the Word object
		 */
		public String toString(){
			return this.word + ":" + this.phonemes;
		}
	
	
		/**
		 * 
		 * @param a string that is the word, to be phonemified
		 * a whole bunch of if statements:
		 * if string.contains(a letter assortment corresponding to a phoneme)
		 * then replace those letters with a string of phonemes
		 
		public void setPhonemes(String word) {

		
		
		
		
		
			this.phonemes.add(myPho);
		}
		*/
	}


