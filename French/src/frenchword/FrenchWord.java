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
		if(w.equals("accueilli"))
			System.out.println("Llama");
		ArrayList<String> myPho = new ArrayList<String>();
		String endHuh = "";
		ArrayList<String> exceptionHuh = isException(w, myPho);
		if(exceptionHuh != null) return exceptionHuh;

		while (w.length() != 0) {
			if(w.endsWith("atient") && endHuh.equals("")){
				myPho.add(0,"jɑ̃");
				myPho.add(0,"s");
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-6)); 
				w = w.substring(0, (w.length() - 6));
				continue;
			}
			else if(w.endsWith("aient") && endHuh.equals("")){
				myPho.add(0, "e");
				endHuh = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			}
			else if(w.endsWith("èrent") && endHuh.equals("")){
				myPho.add(0, "eʁ");
				endHuh = String.valueOf(w.charAt(w.length()-5)); 
				w = w.substring(0, (w.length() - 5));
				continue;
			} 
			else if(w.endsWith("ants") && endHuh.equals("")){
				myPho.add(0, "ɑ̃");
				endHuh = String.valueOf(w.charAt(w.length()-4)); 
				w = w.substring(0, (w.length() - 4));
				continue;
			}
			else if(w.endsWith("ment") && endHuh.equals("")){
				myPho.add(0, "ɑ̃");
				endHuh = String.valueOf(w.charAt(w.length()-4)); 
				w = w.substring(0, (w.length() - 4));
				continue;
			}
			else if(w.endsWith("ble") && endHuh.equals("")){
				myPho.add(0, "l");
				myPho.add(0, "b");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ait") && endHuh.equals("")){
				myPho.add(0, "e");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("aux") && endHuh.equals("")){
				myPho.add(0, "o");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("est") && endHuh.equals("")){
				myPho.add(0, "e");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			} 
			else if(w.endsWith("ail") && endHuh.equals("")){
				myPho.add(0, "j");
				myPho.add(0, "a");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if(w.endsWith("ll")) {
				if("aeouy".contains("" + w.charAt(w.length() - 3))) {
					myPho.add(0, "l");
					endHuh = String.valueOf(w.charAt(w.length()-2)); 
					w = w.substring(0, (w.length() - 2));
					continue;
				}
				else if(w.endsWith("ill")) {
					myPho.add(0, "j");
					myPho.add(0, "i");
					endHuh = String.valueOf(w.charAt(w.length()-3)); 
					w = w.substring(0, (w.length() - 3));
					continue;
				}
			}
			else if((w.endsWith("ont") ||
					w.endsWith("ond")) && endHuh.equals("")){
				myPho.add(0, "ɔ̃");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if((w.endsWith("ant") || 
					w.endsWith("ent") ||
					w.endsWith("and") ||
					w.endsWith("anc")) && endHuh.equals("")){
				myPho.add(0, "ɑ̃");
				endHuh = String.valueOf(w.charAt(w.length()-3)); 
				w = w.substring(0, (w.length() - 3));
				continue;
			}
			else if((w.endsWith("eut") || 
					w.endsWith("eux")) && endHuh.equals("")){
				myPho.add(0, "ø");
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
			else if(w.endsWith("ck")){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			} 
			else if(w.endsWith("ho")){
				myPho.add(0, "ɔ");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("eu")){
				myPho.add(0, "ø");
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
			else if(w.endsWith("gn")){
				myPho.add(0, "ŋ");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ge") || w.endsWith("gi")){
				myPho.add(0, "ʒ");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if (w.equals("es")) {
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
					w.endsWith("ai") ||
					w.endsWith("ez")) && (endHuh.equals(""))){
				myPho.add(0, "e");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("qu")){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if((w.endsWith("ss") || 
					w.endsWith("sc"))){
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ff")){
				myPho.add(0, "f");
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
			else if(w.endsWith("ce") && (! endHuh.equals(""))){
				myPho.add(0, "ə");
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ce") && endHuh.equals("")){
				myPho.add(0, "s");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.equals("ce")){
				myPho.add(0, "ə");
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
			else if(w.endsWith("tt")){
				myPho.add(0, "t");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("cc")){
				myPho.add(0, "k");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("bb")){
				myPho.add(0, "b");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("mm")){
				myPho.add(0, "m");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if (w.endsWith("an")){
				myPho.add(0, "ɑ̃");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("on") ||
					w.endsWith("om")){
				myPho.add(0, "ɔ̃");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("ll")){
				myPho.add(0, "j");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("rr")){
				myPho.add(0, "R");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("re")){
				myPho.add(0, "ə");
				myPho.add(0, "R");
				endHuh = String.valueOf(w.charAt(w.length()-2)); 
				w = w.substring(0, (w.length() - 2));
				continue;
			}
			else if(w.endsWith("pp")){
				myPho.add(0, "p");
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

			else if(w.endsWith("e") && (endHuh.equals(""))){
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("é")){
				myPho.add(0, "e");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("e") && (! endHuh.equals(""))){
				if(.endHuh..)////if silent, ment... if not silent, still within word
				myPho.add(0, "ɛ");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("î") || 
					w.endsWith("i") ||
					w.endsWith("ï")) {
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
			else if(w.endsWith("y")){
				myPho.add(0, "i");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("s") && (! endHuh.equals(""))){
				if((w.length()==1)|| (! "aeiou".contains(endHuh))){
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
			else if(w.endsWith("s") && endHuh.equals("")){
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("r")){
				myPho.add(0, "R");
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
			else if(w.endsWith("ç")){
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
			else if(w.endsWith("d") && endHuh.equals("")){
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("j")){
				myPho.add(0, "ʒ");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("k")){
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
			else if(w.endsWith("m") && endHuh.equals("")){
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
			else if(w.endsWith("n") && endHuh.equals("")){
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
			else if(w.endsWith("v")){
				myPho.add(0, "v");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("w")){
				myPho.add(0, "v");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
				w = w.substring(0, (w.length() - 1));
				continue;
			}
			else if(w.endsWith("z")){
				myPho.add(0, "z");
				endHuh = String.valueOf(w.charAt(w.length()-1)); 
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



