import java.util.*;
import java.io.*;
public class Novel{

	/*1.) Number of unique words found in a Shakespeare’s novel/drama
	   Return the arrayList length from Novel.java

	   2.) Number of unique words in a Shakespeare’s novel/drama found in the dictionary
	   Do the match thing in the tutorial.java

	   3.) Number of unique words in a Shakespeare’s novel/drama not found in the
		   dictionary
	   Same thing but the reverse*/


	//Instantiates the ArrayList that holds all the novel's words
	private ArrayList<String> novelList = new ArrayList<String>();
	String fileName;

	Novel(){

	}

	Novel(String newfileName, ArrayList<String> newNovelList){

		fileName = newfileName; 
		novelList = newNovelList;

	}
	
	public static void fillArray (String fileName, ArrayList<String> novelList){
		Scanner fileScnr;
		try {
			fileScnr = new Scanner(new File(fileName));
			while (fileScnr.hasNext()){
				//It does something
				novelList.add(fileScnr.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int returnTotalWords(ArrayList<String> novelList) {
		return novelList.size();
	}

	public static int returnUniqueWords(ArrayList<String> novelList){
		String temp = "";
		int index = 0;
		for (int i = 0; i<novelList.size()-1;i++){
			temp = novelList.get(i);
			if (TheDictionary.checkWords(temp, TheDictionary.hashMapDict)){
				index++;
			}
			else{
			}
		}
		return index;
	}

	public static void createFile(String getName, Novel book, ArrayList<String> bookWords){
		PrintWriter writer;
		try {
			writer = new PrintWriter(getName+"_summ.txt", "UTF-8");
			writer.println("The total number of words in the novel is " + bookWords.size());
			writer.println("The total number of unique words is " + book.returnUniqueWords(bookWords));
			writer.println("The total number of words that are not unique is " + (bookWords.size()-book.returnUniqueWords(bookWords)));
			for (String key : bookWords) {
				String temp = "";
				if (TheDictionary.checkWords(key, TheDictionary.hashMapDict)){
					temp = "Art spoken ever and anon!";
				}
				else{
					temp = "Ne'er spoken ever!";
				}
					writer.println(key + ", " + Collections.frequency(bookWords, key) + " "+ temp);
			}

			writer.close();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void wordFrequency(ArrayList<String> noveList){

	}



	//Idk how this got here but i dont want to mess with it
	private static char[] charAt(int i) {
		// TODO Auto-generated method stub
		return null;
	}
}

