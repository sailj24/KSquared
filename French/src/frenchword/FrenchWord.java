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
			this.phonemes = this.phonemize(word);
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
		 * @param w a string that is the word, to be phonemified
		 * a whole bunch of if statements:
		 * if string.contains(a letter assortment corresponding to a phoneme)
		 * then add a phoneme or two to the arrayList 
		 * loop over whole word 
		 * @return arrayList myPho with all the phonemes in the word
		 */
		ArrayList<String> phonemize(String w) {
			ArrayList<String> myPho = new ArrayList<String>();
			String endHuh = "";
			while (w.length() != 0) {
				if(w.endsWith("ant" )|| 
						w.endsWith("ont" )  &&  endHuh.equals("")){
					myPho.add(0, "ô");
					endHuh = String.valueOf(w.charAt(w.length()-3)); 
					w = w.substring(0, (w.length() - 3));
					
			}
				else if(w.endsWith("f")){
					myPho.add(0, "f");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("l")){
					myPho.add(0, "l");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("p")){
					myPho.add(0, "p");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("ie")){
					myPho.add(0, "i");
					endHuh = String.valueOf(w.charAt(w.length()-2)); 
					w = w.substring(0, (w.length() - 2));
					}
				else if((w.endsWith("g") && endHuh.equals("e")) || (w.endsWith("g") && endHuh.equals("i")) ){
					myPho.add(0, "Z");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("o")) {
					myPho.add(0, "o");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("y")){
					myPho.add(0, "i");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("s") && (! endHuh.equals(""))){
					myPho.add(0, "s");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					}
				else if(w.endsWith("ch")){
					myPho.add(0, "k");
					endHuh = String.valueOf(w.charAt(w.length()-2)); 
					w = w.substring(0, (w.length() - 2));
					}
				else return myPho;
		}
		
			return myPho;///////////
		}
			
			
			
			
			
		}
		
	


