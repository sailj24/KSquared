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
		System.out.println("****" + w);
		ArrayList<String> myPho = new ArrayList<String>();
		String nextLetter = "";
		ArrayList<String> exceptionHuh = isException(w, myPho);
		if(exceptionHuh != null) return exceptionHuh;

		while (w.length() != 0) {
			if(w.endsWith("atient") && nextLetter.equals("")){
				myPho.add(0,"jɑ̃");
				myPho.add(0,"s");
				myPho.add(0, "a");
				nextLetter = String.valueOf(w.charAt(w.length()-6)); 
				w = w.substring(0, (w.length() - 6));
				continue;
			}
			else if(w.endsWith("aient") && nextLetter.equals("")){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			}
			else if(w.endsWith("èrent") && nextLetter.equals("")){
				myPho.add(0, "eʁ");
				nextLetter = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			} 
			else if(w.endsWith("ants") && nextLetter.equals("")){
				myPho.add(0, "ɑ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-4)); 
				w = w.substring(0, (w.length() - 4));
				continue;
			}
			else if(w.endsWith("eaux") && nextLetter.equals("")){
				myPho.add(0, "o");
				nextLetter = String.valueOf(w.charAt(w.length()-4)); 
				w = w.substring(0, (w.length() - 4));
				continue;
			}
			else if(w.endsWith("ment")){
				if(nextLetter.equals("")) {
					myPho.add(0, "ɑ̃");
					myPho.add(0, "m");
					nextLetter = String.valueOf(w.charAt(w.length()-4)); 
					w = w.substring(0, (w.length() - 4));
					continue;
				}
				else {myPho.add(0, "t");
				myPho.add(0, "ɑ̃");
				myPho.add(0, "m");
				nextLetter = String.valueOf(w.charAt(w.length()-4)); 
				w = w.substring(0, (w.length() - 4));
				continue;
				}
			}
			else if(w.endsWith("ble") && nextLetter.equals("")){
				myPho.add(0, "l");
				myPho.add(0, "b");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ets") && nextLetter.equals("")){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.equals("tes")){
				myPho.add(0, "e");
				myPho.add(0, "t");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("tes") && nextLetter.equals("")){
				myPho.add(0, "t");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ait") && nextLetter.equals("")){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("aux") && nextLetter.equals("")){
				myPho.add(0, "o");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("est") && nextLetter.equals("")){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			} 
			else if(w.endsWith("res") && nextLetter.equals("")){
				myPho.add(0, "R");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("cce")){
				myPho.add(0, "ɛ");
				myPho.add(0, "ks");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ail") && nextLetter.equals("")){
				myPho.add(0, "j");
				myPho.add(0, "a");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ll")) {
				if("aeouy".contains("" + w.charAt(w.length() - 3))) {
					myPho.add(0, "l");
					nextLetter = String.valueOf(w.charAt(w.length()-2)); 
					w = w.substring(0, (w.length() - 2));
					continue;
				}
				else if(w.endsWith("ill")) {
					myPho.add(0, "j");
					myPho.add(0, "i");
					nextLetter = String.valueOf(w.charAt(w.length()-3)); 
					w = w.substring(0, (w.length() - 3));
					continue;
				}
			}
			else if((w.endsWith("ont") ||
					w.endsWith("ond")) && nextLetter.equals("")){
				myPho.add(0, "ɔ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if((w.endsWith("ant") || 
					w.endsWith("ent") ||
					w.endsWith("and") ||
					w.endsWith("anc")) && nextLetter.equals("")){
				myPho.add(0, "ɑ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if((w.endsWith("eut") || 
					w.endsWith("eux")) && nextLetter.equals("")){
				myPho.add(0, "ø");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("out")){
				myPho.add(0, "u");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ais")){
				myPho.add(0, "ɛ");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("tte")){
				myPho.add(0, "t");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("che")){
				myPho.add(0, "ʃ");
				nextLetter = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ch")){
				myPho.add(0, "ʃ");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			} 
			else if((w.endsWith("œuv"))){
				myPho.add(0, "v");
				myPho.add(0, "œ");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if((w.endsWith("œu"))){
				myPho.add(0, "œ");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("œ") && (nextLetter.equals("d")))){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			
			else if((w.endsWith("œs"))){
				myPho.add(0, "z");
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("œi")){
				myPho.add(0, "e");
				myPho.add(0, "o");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ou")){
				myPho.add(0, "u");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ck")){
				myPho.add(0, "k");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			} 
			else if(w.endsWith("ho")){
				myPho.add(0, "ɔ");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("eu")){
				myPho.add(0, "ø");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("en")){
				myPho.add(0, "ɑ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			} 
			else if(w.endsWith("in")){
				myPho.add(0, "ɛ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ie")){
				myPho.add(0, "i");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("gn")){
				myPho.add(0, "ŋ");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ge") || w.endsWith("gi")){
				myPho.add(0, "ʒ");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if (w.equals("es")) {
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("es") ||
					w.endsWith("er") ||
					w.endsWith("et") ||
					w.endsWith("ed") ||
					w.endsWith("ée") ||
					w.endsWith("êt") ||
					w.endsWith("ai") ||
					w.endsWith("ez")) && (nextLetter.equals(""))){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("qu")){
				myPho.add(0, "k");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("ss") || 
					w.endsWith("sc"))){
				myPho.add(0, "s");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ff")){
				myPho.add(0, "f");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("oi")){
				myPho.add(0, "wa");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ce") && (! nextLetter.equals(""))){
				myPho.add(0, "ə");
				myPho.add(0, "s");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ce") && nextLetter.equals("")){
				myPho.add(0, "s");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.equals("ce")){
				myPho.add(0, "ə");
				myPho.add(0, "s");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("nn")){
				myPho.add(0, "n");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("tt")){
				myPho.add(0, "t");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("cc")){
				if(nextLetter.equals("e")) myPho.add(0, "ks");
				else {
				myPho.add(0, "k");
				}
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("bb")){
				myPho.add(0, "b");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("mm")){
				myPho.add(0, "m");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if (w.endsWith("an")){
				myPho.add(0, "ɑ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("on") ||
					w.endsWith("om")){
				myPho.add(0, "ɔ̃");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ll")){
				myPho.add(0, "j");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("rr")){
				myPho.add(0, "R");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("re")){
				myPho.add(0, "ə");
				myPho.add(0, "R");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("pp")){
				myPho.add(0, "p");
				nextLetter = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("a") || 
					w.endsWith("à") || 
					w.endsWith("â")){
				myPho.add(0, "a");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("é")){
				myPho.add(0, "e");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("e") && (nextLetter.equals(""))){
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("e") && (! nextLetter.equals(""))){
				if(w.length() == 1) {////if silent, ment... if not silent, still within word
					myPho.add(0, "ɛ");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				} else {
					myPho.add(0, "ə");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));	
				}
			}

			else if(w.endsWith("î") || 
					w.endsWith("i") ||
					w.endsWith("ï")) {
				myPho.add(0, "i");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if((w.endsWith("o") ||
					w.endsWith("ô") )){
				myPho.add(0, "o");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("u") ||
					w.endsWith("ù") ||
					w.endsWith("ü") ||
					w.endsWith("û")){
				myPho.add(0, "y");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("f")){
				myPho.add(0, "f");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("l")){
				myPho.add(0, "l");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("p")){
				myPho.add(0, "p");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("y")){
				myPho.add(0, "i");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("s") && (! nextLetter.equals(""))){
				if((w.length()==1)|| (! "aeiou".contains(nextLetter))){
					myPho.add(0, "s");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
				else { 
					myPho.add(0, "z");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
			}
			else if(w.endsWith("s") && nextLetter.equals("")){
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			} 
			else if(w.endsWith("œ")){
				myPho.add(0, "œ");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("r")){
				myPho.add(0, "R");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("b") && (! nextLetter.equals(""))){
				myPho.add(0, "b");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("c") && (! nextLetter.equals(""))){
				if (nextLetter.equals("i")) myPho.add(0, "s");
				else {
					myPho.add(0, "s");
				}
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
				
			}
			else if(w.endsWith("ç")){
				myPho.add(0, "s");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("d") && (! nextLetter.equals(""))){
				myPho.add(0, "d");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("d") && nextLetter.equals("")){
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("j")){
				myPho.add(0, "ʒ");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("k")){
				myPho.add(0, "k");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("g")){
				if(nextLetter.equals("e") ||
						nextLetter.equals("i")) {
					myPho.add(0, "ʒ");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
				else { myPho.add(0, "g");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
				}
			}
			else if(w.endsWith("m") && (! nextLetter.equals(""))){
				myPho.add(0, "m");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("m") && nextLetter.equals("")){
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("n") && (! nextLetter.equals(""))){
				myPho.add(0, "n");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("n") && nextLetter.equals("")){
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if (w.endsWith("t")){
				if (nextLetter.equals("")) {
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));
					continue;
				}
				else {
					myPho.add(0, "t");
					nextLetter = String.valueOf(w.charAt(w.length()-1)); 
					w = w.substring(0, (w.length() - 1));	
				}
			}
			else if(w.endsWith("v")){
				myPho.add(0, "v");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("w")){
				myPho.add(0, "v");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("z")){
				myPho.add(0, "z");
				nextLetter = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}

			else return myPho;
		}

		return myPho;///////////
	}

	static ArrayList<String> isException(String w, ArrayList<String> myPho){
		if(w.equals("bacille"))
			return arrayToArrayList(new String[] {"b", "a", "s"});
		else if(w.equals("billevesées"))
			return arrayToArrayList(new String[] {"b", "i", "l" ,"v", "s", "e"});
		else if(w.equals("billion"))
			return arrayToArrayList(new String[] {"b", "i", "l" ,"j", "ɔ̃"});
		else if(w.equals("capillaire"))
			return arrayToArrayList(new String[] {"k", "a", "p" ,"i", "l", "ɛ", "R"});
		else if(w.equals("codicille"))
			return arrayToArrayList(new String[] {"k", "ɔ", "d" ,"i", "s", "i", "l"});
		else if(w.equals("distiller"))
			return arrayToArrayList(new String[] {"d", "i", "s" ,"t", "i", "l", "e"});
		else if(w.equals("fibrille"))
			return arrayToArrayList(new String[] {"f", "i", "b" ,"R", "i", "l"});
		else if(w.equals("krill"))
			return arrayToArrayList(new String[] {"k", "R", "i" ,"l"});
		else if(w.equals("lille"))
			return arrayToArrayList(new String[] {"l", "i" ,"l"});
		else if(w.equals("mille"))
			return arrayToArrayList(new String[] {"m", "i", "l"});
		else if(w.equals("milli"))
			return arrayToArrayList(new String[] {"m", "i", "l", "i"});
		else if(w.equals("milliard"))
			return arrayToArrayList(new String[] {"m", "i", "l" ,"j", "a", "R"});
		else if(w.equals("million"))
			return arrayToArrayList(new String[] {"m", "i", "l" ,"j", "ɔ̃"});
		else if(w.equals("osciller"))
			return arrayToArrayList(new String[] {"ɔ", "s", "i" ,"l", "e"});
		else if(w.equals("pupille"))
			return arrayToArrayList(new String[] {"p", "y", "p" ,"i", "j"});
		else if(w.equals("scille"))
			return arrayToArrayList(new String[] {"s", "i" ,"l"});
		else if(w.equals("tranquille"))
			return arrayToArrayList(new String[] {"t", "R", "ɑ̃" ,"k", "i", "l"});
		else if(w.equals("ville"))
			return arrayToArrayList(new String[] {"v","i", "l"});
		else if(w.equals("mlle"))
			return arrayToArrayList(new String[] {"m", "a", "d" ,"m", "wa", "s", "ɛ", "l"});
		else return null;

	}

	/**
	 * Converts an array of strings to an ArrayList of strings
	 * @param w
	 * @return
	 */
	static ArrayList<String> arrayToArrayList(String[] i){
		ArrayList<String> rv = new ArrayList<>();
		for(String x : i) {
			if (! x.equals("")) {
				rv.add(x);
			}
		}
		return rv;
	}





}



