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
		if(word.equals("")) {
			this.word = word;
			this.phonemes = new ArrayList<String>();
		}
		else {
		this.word = word; // Sets the class field "word" to be the parameter "word"
		this.phonemes = this.phonemize(word);
		}
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
			if(w.endsWith("atient") && endHuh.equals("")){
				myPho.add(0,"jâ");
				myPho.add(0,"s");
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-6)); 
				w = w.substring(0, (w.length() - 6));
				continue;
			}
			else if(w.endsWith("aient") && endHuh.equals("")){
				myPho.add(0, "é");
				endHuh = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			}
			else if(w.endsWith("èrent") && endHuh.equals("")){
				myPho.add(0, "ér");
				endHuh = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			}

			else if(w.endsWith("est") && endHuh.equals("")){
				myPho.add(0, "é");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("lle") && (! endHuh.equals(""))){
				if(w.equals("ville")) {
					myPho.add(0,"l");
					myPho.add(0,"i");
					myPho.add(0,"v");
					endHuh = String.valueOf(w.charAt(w.length()-4)); 
					w = w.substring(0, (w.length() - 4));
					continue;
				}
				else {myPho.add(0, "j");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
				}
			}
			else if((w.endsWith("ant" )|| 
					w.endsWith("ont" )|| 
					w.endsWith("and")) &&  endHuh.equals("")){
				myPho.add(0, "ô");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if((w.endsWith("eut") || 
					w.endsWith("eux")) && endHuh.equals("")){
				myPho.add(0, "ö");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("out")){
				myPho.add(0, "u");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("tte")){
				myPho.add(0, "t");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ou")){
				myPho.add(0, "u");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("eu")){
				myPho.add(0, "ö");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ch")){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("er")){
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ie")){
				myPho.add(0, "i");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("gn") && (! endHuh.equals(""))){
				myPho.add(0, "N");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ge") || w.endsWith("gi")){
				myPho.add(0, "Z");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("es") ||
					w.endsWith("er") ||
					w.endsWith("et") ||
					w.endsWith("ed") ||
					w.endsWith("ée") ||
					w.endsWith("êt") ||
					w.endsWith("ai")) && (! endHuh.equals(""))){
				myPho.add(0, "é");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("qu") && (! endHuh.equals(""))){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("ss") || 
					w.endsWith("sc"))  && (! endHuh.equals(""))){
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("oi")){
				myPho.add(0, "wa");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ce") ||
					w.endsWith("ci")){
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("nn")){
				myPho.add(0, "n");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("on")){
				myPho.add(0, "ô");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ll")){
				myPho.add(0, "y");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("rr")){
				myPho.add(0, "r");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("a") || 
					w.endsWith("à") || 
					w.endsWith("â")){
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("à")){
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("é")){
				myPho.add(0, "é");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("e") && (! endHuh.equals(""))){
				myPho.add(0, "è");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("î") || 
					w.endsWith("i")) {
				myPho.add(0, "i");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if((w.endsWith("o") ||
					w.endsWith("ô") )){
				myPho.add(0, "o");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("u") ||
					w.endsWith("ù") ||
					w.endsWith("ü") ||
					w.endsWith("û")){
				myPho.add(0, "y");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("f")){
				myPho.add(0, "f");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("l")){
				myPho.add(0, "l");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("p")){
				myPho.add(0, "p");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("o")) {
				myPho.add(0, "o");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("y")){
				myPho.add(0, "i");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("s") && (! endHuh.equals(""))){
				if((w.length()==1)|| (! endHuh.equals("[aeiou]"))) {
					myPho.add(0, "s");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
				else { 
					myPho.add(0, "z");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
				
			}
			else if(w.endsWith("r")){
				myPho.add(0, "r");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("b") && (! endHuh.equals(""))){
				myPho.add(0, "b");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("c") && (! endHuh.equals(""))){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("ç") && (! endHuh.equals(""))){
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("d") && (! endHuh.equals(""))){
				myPho.add(0, "d");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("j") && (! endHuh.equals(""))){
				myPho.add(0, "Z");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("k") && (! endHuh.equals(""))){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("m") && (! endHuh.equals(""))){
				myPho.add(0, "m");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("n") && (! endHuh.equals(""))){
				myPho.add(0, "n");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if (w.endsWith("t")){
				if (endHuh.equals("")) {
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
				}
				else {
					myPho.add(0, "t");
					endHuh = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));	
				}
			}
			else if(w.endsWith("v") && (! endHuh.equals(""))){
				myPho.add(0, "v");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("w") && (! endHuh.equals(""))){
				myPho.add(0, "v");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("z") && (! endHuh.equals(""))){
				myPho.add(0, "z");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}



			else return myPho;
		}

		return myPho;///////////
	}





}




