import java.util.ArrayList;

//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 9
//Purpose of program: Learn possible real life applications to newly found data types and further solidify the difference between data structures
// such as array and hashmaps
//Date last modified:11/12/15

public class SummaryGen {
	
	/*
	   1.) Number of unique words found in a Shakespeare’s novel/drama
	   Return the arrayList length from Novel.java
	   
	   2.) Number of unique words in a Shakespeare’s novel/drama found in the dictionary
	   Do the match thing in the tutorial.java
	   
	   3.) Number of unique words in a Shakespeare’s novel/drama not found in the
		   dictionary
	   Same thing but the reverse
	   
	   4.) An alphabetic list of all unique words in a Shakespeare’s novel/drama.
	       Each line of the list must be in format X\tY\tMessage, where Y is the number of times
		   word X is found in the novel/drama for which this summary is being generated. If
		   a word X is found in the dictionary, Message must be Art spoken ever
		   and anon! If the word is not found in the dictionary, the Message field for
		   that X should be Ne'er spoken ever!
	 */	
	
	//to compare the words, add them in a hashset 
			//The final size is the toal number of unique words
			//In said hashset the key is the letter the word starts with
	

	public static void main(String[] args) {
		ArrayList<String> hamletWords = new ArrayList<String>;
		Novel hamlet = new Novel("C:\\Users\\squin_000\\Desktop\\hamlet.txt", hamletWords);
	}

}
