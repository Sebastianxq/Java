import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 9
//Purpose of program: Learn possible real life applications to newly found data types and further solidify the difference between data structures
// such as array and hashmaps
//Date last modified:11/16/15

public class SummaryGen {
	

	public static void main(String[] args) {
		
		//creates the stupid dictionary
		TheDictionary.createDictionary();
		
		//Imports each text file (once wink wink nudge nudge)
		//Then commands the other 2 files to work their magic
		//Takes a absurd amount of time to finish tho so i probably goofed somewhere
		ArrayList<String> hamletWords = new ArrayList<String>();
		Novel hamlet = new Novel("C:\\Users\\squin_000\\Desktop\\hamlet.txt", hamletWords);
		hamlet.fillArray("C:\\Users\\squin_000\\Desktop\\hamlet.txt", hamletWords);
		Novel.createFile("hamlet",hamlet, hamletWords);
		
		ArrayList<String> juliusCaesarWords = new ArrayList<String>();
		Novel juliusCaesar = new Novel("C:\\Users\\squin_000\\Desktop\\juliusCaesar.txt", juliusCaesarWords);
		juliusCaesar.fillArray("C:\\Users\\squin_000\\Desktop\\juliusCaesar.txt", juliusCaesarWords);
		Novel.createFile("juliusCaesar", juliusCaesar, juliusCaesarWords);
	
		ArrayList<String> kingLearWords = new ArrayList<String>();
		Novel kingLear = new Novel("C:\\Users\\squin_000\\Desktop\\kingLear.txt", kingLearWords);
		kingLear.fillArray("C:\\Users\\squin_000\\Desktop\\kingLear.txt", kingLearWords);
		Novel.createFile("kingLear", kingLear, kingLearWords);
		
		ArrayList<String> macbethWords = new ArrayList<String>();
		Novel macbeth = new Novel("C:\\Users\\squin_000\\Desktop\\macbeth.txt", macbethWords);
		macbeth.fillArray("C:\\Users\\squin_000\\Desktop\\macbeth.txt", macbethWords);
		Novel.createFile("macbeth",macbeth, macbethWords);
		
		ArrayList<String> othelloWords = new ArrayList<String>();
		Novel othello = new Novel("C:\\Users\\squin_000\\Desktop\\othello.txt", othelloWords);
		othello.fillArray("C:\\Users\\squin_000\\Desktop\\othello.txt", othelloWords);
		Novel.createFile("othello",othello, othelloWords);
		
	}

}
