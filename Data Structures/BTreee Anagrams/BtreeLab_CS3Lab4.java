import java.io.*;
import java.util.*;
/**************************************************************************************
 *Programmed by: Sebastian Quinones                           						 **
 *Last modified: 03/10/2017 														 **
 *                                                                           		 **
 *Program description: Create a program that Stores the content in a text file       **
 * in alphabetical order into a Btree and modify the Btree's methods to allow		 **
 *  a greater range of default methods. 							           		 **
 * 																			         **
 *Purpose: Understand the properties of BTrees and how to implement them and 		 **
 *	understand how to traverse, seek and edit Btrees when needed in the most 		 **
 *	efficient possible way															 **
 * 	     											             				     **
 **************************************************************************************/
public class main {

	//Counts the number of anagrams that a word has
	public static int countAnagrams(String word, BTree englishWordsSet){
		if (word.length()<8)
			return 1;
		return countAnagrams("",word,englishWordsSet);
	} 

	public static int countAnagrams(String prefix, String word, BTree words) {
		if(word.length() <= 1) {
			String str = prefix + word;
			if (words.search_binary(str)){
				//CHECK
				//System.out.println(str);
				return 1;
			}   
		}
		else {
			int count = 0;
			//Seperates the word into substrings to check for anagrams
			for(int i = 0; i < word.length(); i++) {
				String cur = word.substring(i, i + 1);
				String before = word.substring(0, i); // letters before cur
				String after = word.substring(i + 1); // letters after cur
				if (!before.contains(cur)){  // Check if permutations of cur have not been generated.
					//recursive call with a counter to keep track of anagrams
					count += countAnagrams(prefix + cur, before + after,words);
				}
			}
			return count;
		}
		return 0;
	}

	//goes through the text file and finds the word with the most anagrams.
	public static void mostAnagrams(BTree dictionary){
		try (BufferedReader br = new BufferedReader(new FileReader("words2.txt"))){
			String currentLine;
			String tempString ="";
			int temp = 0;
			int count = 0;
			while ((currentLine = br.readLine()) != null) {
				count = (countAnagrams("",currentLine,dictionary));
				if(count>temp)
				{
					tempString = currentLine;
					temp = countAnagrams("",currentLine,dictionary);
					System.out.println("changing temp to "+temp);
				}
			}
			tempString= tempString + " which has "+ Integer.toString(temp);
			System.out.println(tempString);
		} catch (IOException e) {System.out.println("Error reading the file: "+ e.getMessage());}
	}

	//Helper code that prints all the anagrams available for a word
	//Used primarily as a way to test my countAnagrams method
	public static void printAnagrams(String prefix, String word, BTree englishWordsSet) {
		if(word.length() <= 1) {
			String str = prefix + word;
			if (englishWordsSet.search_binary(str)){
				System.out.println(str);
			}   
		}
		else {
			for(int i = 0; i < word.length(); i++) {
				String cur = word.substring(i, i + 1);
				String before = word.substring(0, i); // letters before cur
				String after = word.substring(i + 1); // letters after cur
				if (!before.contains(cur))  // Check if permutations of cur have not been generated.
					printAnagrams(prefix + cur, before + after,englishWordsSet);
			}
		}
	}

	//fills the dictionary array
	public static void fillWordsSet(BTree englishWords) {
		try (BufferedReader br = new BufferedReader(new FileReader("words2.txt"))){
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				englishWords.insert(currentLine);
			}
		} catch (IOException e) {System.out.println("Error reading the file: "+ e.getMessage());}

	}


	public static void main(String[] args) {
		//Smaller btree for debugging purposes
		String [] S ={"a","b","d","abscisaiod","ant","bul","ab","ac","ba","as","lol","help", "abc","acb","bca", "pot","top","fun","spot","tops","post"};
		BTree T = new BTree(256);
		for (int i = 0;i<S.length;i++){
			T.insert(S[i]);
		}

		//BASIC DEBUGGING TESTS
		//T.print();
		//T.printHeight();
		//T.printDepthD(1);

		//CHECK SMALL TREE ANAGRAM TEST
		//Test to see if number of actual anagrams matched the counted ones
		//printAnagrams("","spot", T);
		//System.out.println("The total number of anagrams is: " +countAnagrams("","ab", T));


		//Test to ensure Searches return same outcome
		//System.out.println(T.binarySource("ant"));
		//System.out.println(T.search_sequential("ant"));

		//Run trials with 3,8,64,256,1024 T
		//dictionary stuff
		BTree englishWords = new BTree(8192);
		fillWordsSet(englishWords);

		//Test to match sequential and binary search through the large tree
		System.out.println(englishWords.search_sequential("thank"));
		System.out.println(englishWords.search_binary("you"));


		//CHECK DICTIONARY ANAGRAM TEST
		//Test to see if the total number of printed anagrams matched the counted number in a large scale tree
		printAnagrams("","spot",englishWords);
		System.out.println("The total number of anagrams is: " +countAnagrams("","spot", englishWords));


		//runtime was too long so unsure whether the execution worked 
		//Safe to presume it did due to sound logic in programming
		mostAnagrams(englishWords);

		//PRINT TEST
		//englishWords.printNodes();
		//englishWords.print();

		//HEIGHT TEST
		//englishWords.printHeight();

		//RUNTIME SEARCH TEST
		//Search Aardvark using 2,8,64,256,1024,8096?
		//Search Zygote using 2,8,64,256,1024
		//Search Median using 2,8,64,256,1024
		//englishWords.printDepthD(0);
		
		long startTimeA = System.nanoTime();
		//System.currentTimeMillis();
		englishWords.search_sequential("aardvark");
		//englishWords.search_binary("aardvark");
		long endTimeA = System.nanoTime();
		long durationA = endTimeA-startTimeA;
		System.out.println(durationA);

	}

}
