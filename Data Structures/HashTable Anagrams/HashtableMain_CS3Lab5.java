/***************************************************
 * 
 * @author Sebastian Quinones
 * Date:3/22/2017
 * TASK: Create a Hashtable that stores words using the sorted version of the word as a key
 *  and then create various methods that implement this data structure efficiently
 *  PURPOSE: To understand how to use chaining in Hashtables efficiently and realize
 *  	the benefits and drawbacks that come with using a Hashtable rather than a 
 *  	different data structure, along with the pros and cons of Hashing Vs. Linear Probing
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {


	public static void fillWordsSet(hashTableChaining H) {
		try (BufferedReader br = new BufferedReader(new FileReader("words2.txt"))){
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.length()<8){
					//System.out.println(currentLine);
					H.insert(currentLine);
				}
			}
		} catch (IOException e) {System.out.println("Error reading the file: "+ e.getMessage());}

	}

	public static void fillLinearSet(linearProbing L) {
		try (BufferedReader br = new BufferedReader(new FileReader("words2.txt"))){
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.length()<8){
					//System.out.println(currentLine);
					L.insert(currentLine);
				}
			}
		} catch (IOException e) {System.out.println("Error reading the file: "+ e.getMessage());}

	}

	public static void main(String[] args) {
		/*
		 * SMALLER STRING LIST, USED FOR DEBUGGING WITH VARIOUS METHODS
		 */
		/*String [] S ={"a","b","d","abscisaiod","ant","bul","ab","ac","ba","as","lol","help", "abc","acb","bca", "pot","top","fun","spot","tops","post"};
		hashTableChaining T = new hashTableChaining(15);
		linearProbing LT = new linearProbing(15);
		for (int i = 0;i<S.length;i++){
			System.out.println("inserting "+ S[i]);
			T.insert(S[i]);
			LT.insert(S[i]);
		}
		//Test for all sorted words
		T.printAllSorts();
		
		//Test for all words
		T.printAllAnagrams();

		//Works
		T.printRelatedAnagrams("ab"); System.out.println(" ");
		T.printRelatedAnagrams("ab"); System.out.println(" ");

		//Works
		T.printRelatedAnagrams("pots"); System.out.println(" ");
		LT.printRelatedAnagrams("pots"); System.out.println(" ");

		////Prints the most number of anagrams and the list of anagrams as well
		//Tells user how many anagrams there are and list them too! wow!
		T.printRelatedAnagrams(T.mostAnagrams());
		LT.printRelatedAnagrams(LT.mostAnagrams());*/



		//Use Sizes 23,1234,2468,4096,8192,400000 For testing
		hashTableChaining hDictionary = new hashTableChaining(100);
		linearProbing lDictionary= new linearProbing(50000);

		//Calculates the time it takes to fill the dictionaries with chaining
		System.out.println("starting");
		long startTimeFill = System.currentTimeMillis();
		fillWordsSet(hDictionary);
		long endTimeFill = System.currentTimeMillis();
		long durationFill = endTimeFill-startTimeFill;
		System.out.println("took "+durationFill+" milliseconds to fill the Chaining Hashtable");
		System.out.println(" ");

		//Calculates the time it takes to fill the dictionaries with linear probing 
		System.out.println("starting");
		long startLineFill = System.currentTimeMillis();
		fillLinearSet(lDictionary);
		long endLineFill = System.currentTimeMillis();
		long durationLine = endLineFill-startLineFill;
		System.out.println("took "+durationLine+" milliseconds to fill the Linear Probe Hashtable");
		System.out.println(" ");

		/*//Prints all the anagrams of the given string
		hDictionary.printRelatedAnagrams("pots"); 
		System.out.println(" ");
		lDictionary.printRelatedAnagrams("pots"); System.out.println(" ");
		System.out.println(" ");*/


		//Finds the largest list of anagrams and lists them too
		//Gives the time it took to find as well
		//long startTimeChain = System.currentTimeMillis();
		long startTimeChain = System.currentTimeMillis();
		hDictionary.printRelatedAnagrams(hDictionary.mostAnagrams());
		long endTimeChain =System.currentTimeMillis();
		long durationChain = endTimeChain-startTimeChain;
		System.out.println(" ");
		System.out.println("took "+durationChain+" milliseconds to find the value with Chaining"); System.out.println(" ");

		long startTimeProbe = System.currentTimeMillis();
		lDictionary.printRelatedAnagrams(lDictionary.mostAnagrams());
		long endTimeProbe = System.currentTimeMillis();
		long durationProbe = endTimeProbe-startTimeProbe;
		System.out.println(" ");
		System.out.println("took "+durationProbe+" milliseconds to find the value with Linear Probing");
	}

}
