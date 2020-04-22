import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

//Author: Seabass, Sebastian Quinones
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Lab 4
//Purpose: Learn how to implement linked list and allow users to creatively design a primitive UI
//Date Last Modified: 

//CUrrent tasks
/*Operation 1. Print the linked list content on the terminal (ID, name, and threat
level of the people in a sequence they appear in the linked list)
Operation 2. Search for a person in the linked list with ID or name
Operation 3. Insert a new person in a particular location index
Operation 4. Swap two people in two specific location indices
Operation 5. Remove a record containing a specific ID
Operation 6. Remove all records with a certain thread level
Operation 7. Write the content of the linked list in an output file that has the
same format as the input file.
Operation 8. Quit program.*/

/*Current Ideas
1.) Pretty simple so theres not much to this one. Creating the list is harder
2.)Take an input from the user and try to match while searching thru list
3.) We did a method similar to this already
4.) Similar to 3 i guess
5.) Did a method already, just have the user input a parameter
6.) Match just like two, but this will probably end up being disasterous
7.)Uhhh
8.) Duhhhh


*/

public class AnalyzePOI {
	//C:\\Users\\squin_000\\Desktop\\PersonsOfInterest.txt
	
	//Its actually probably better if i make a method to create the linked list
	public static void createList(POIList linkList){
		//There's going to be an initial prompt that asks for the user to give up 
		//The filename. So something like the below statement
		//Use a while statement with if statements in it for the continuous input
		//BUt do i REALLY have to do that for each possible input?

		//Maybe sort all the value into a temp 2d array and then move?
		//IS it possible to just use scanner.nextline for each of the parameters? finna find out
		//Maybe i could even just seperate it into 3 different arrays of type long, int and string?
		Scanner scnr = new Scanner (System.in);
		System.out.println("What is the full address of the file you'd like to import?");
		String newPOIFile =  scnr.nextLine();
		File inputFile = new File(newPOIFile);
		try{
			Scanner fileScnr = new Scanner (inputFile);
			
			//Check to see if it actually imported what i needed
			//int numLine = 0; 
			long tempId = 0;
			String tempName = " ";
			//String tempLName = " ";
			int tempLevel = 0;
			POI head = new POI();
			int index = 0;
			while(fileScnr.hasNextLine()){
				index++;
				//System.out.println("The value of index is " + index);
				tempId = fileScnr.nextLong();
				System.out.println(tempId);
				fileScnr.nextLine();
				tempName = fileScnr.nextLine();
				System.out.println(tempName);
				tempLevel = fileScnr.nextInt();
				System.out.println(tempLevel);
				//Why is this needed? If at all.
				//fileScnr.nextLine();
				
				POI current = new POI(tempId , tempName , tempLevel);
				//Check to see if current is created throughout the whole thing
				//System.out.println("Current's ID is " + current.POIID);
				linkList.insert(head,current,index);
				//linkList.insertEnd(current);

			} 
			
			//linkList.PrintList();
			//}

		}

		catch (FileNotFoundException e){ 
			System.out.println("The file entered was not found");
		}
	}
	
	public static void main(String[] args) {
		//So holy shit things have escalated
		//Only for the importation of the file and the creation of the list
		POIList linkList = new POIList();
		createList(linkList);
		//linkList.PrintList();
		
		Scanner scnr = new Scanner (System.in);
		//System.out.println("Type in one of the following numbers correlating to the wanted method ");
		int choice =  scnr.nextInt();
		
		//Finish later tho
		switch (choice){
		case 1:
			System.out.println("");
		case 2:
		
		case 3:
			
		case 4:
			
		case 5:
		
		case 6:
			
		case 7:
			
		case 8:
			
		}
		//Switch statements because i like procrastenating the important part
		
		//Use a switch statement to determine which action the user wants to do?
		
		

	}

}
