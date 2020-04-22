import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

//Author: Seabass, Sebastian Quinones
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Lab 3
//Purpose: Entertain the Sadist who control this lab's curriculum
//But really just to allow us a greater understanding of objects and their properties.
//Date Last Modified: 9/27/15

public class MainProg {
	//LAb Requirements
	/*• For each of the basketballs, provide the most suitable box size (that is, the size of
		the smallest box that can fit the basketball). If there is no such box, print “Box not
		available for this basketball”.
	  • For each of the basketballs, provide the volume of the selected box type, the
		volume of the basketball and the volume of the empty space inside the box after
		placing the basketball. If your answer was “Box not available for this basketball”
		then just provide the volume of the basketball.
	  • How many basketballs were you able to fit in the available box types?
	  • Provide a list containing the radius of each of the basketballs that cannot fit in an
		available box.
	  • Provide a list of box sizes that were not used at all.
	*/
	
	//Probably good ideas for each of the bullet points
	//1.) Almost done
	//2.) Part of part one
	//3.) Accidentally did this while doing a check lol
	//4.) List should currently only return 1 thing
	//5.) I have no idea how to do that lol

	static int numOfBoxes = 0;
	static int numBB = 0;
	static int counter = 0;
	//creates values for the ints above
	
	public static void createArrays(){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\shippingDim.txt"));

			File file = new File("C:\\Users\\squin_000\\Desktop\\shippingDim.txt");
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			int numLines = lineNumberReader.getLineNumber();
			//Check to see if the num lines is right
			System.out.println(numLines);

			for(int i = 0; i < numLines; i++){
				String line = scnr.nextLine();
				String[] lineArray = line.split(" ");

				//shows that the array is working as it should
				if (lineArray.length > 1){
					numOfBoxes++;
					//A check that i dont need rn
					System.out.println("The num of  boxes is currently "+ numOfBoxes);

				}
				if (lineArray.length == 1 ){
					numBB++;
					//Same as above, a check not needed
					System.out.println("The num of bb is currently " + numBB);
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File isn't where you said it was.");
		}

		catch (Exception d){
			System.out.println("Something went wrong! Other than a missing file exception :(");
		}
	}
	
	public static void fillArrays(Box[] boxArray, Basketball[] bbArray){

		//Just a random idea in here but when im doing the for loop input values
		//Find a way to do something like box[0].length = lienArray[0];
		//Can i create a for loop at the end that just dumps all the areas of the arrays that i want?

		//UPDATE: apparently i can, this method is done :-)
		try {
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\shippingDim.txt"));

			File file = new File("C:\\Users\\squin_000\\Desktop\\shippingDim.txt");
			LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
			lineNumberReader.skip(Long.MAX_VALUE);
			int numLines = lineNumberReader.getLineNumber();
			int j = 0;
			for(int i = 0; i < numLines+1; i++){
				String line = scnr.nextLine();
				//System.out.println("The first line is"+ line);
				String[] lineArray = line.split(" ");
				//System.out.println("The value in the line array is "+ lineArray[0]);

				if (lineArray.length > 1){
					boxArray[i] = new Box(Double.parseDouble(lineArray[0]),Double.parseDouble(lineArray[1]),Double.parseDouble(lineArray[2]));
				}
				//
				if (lineArray.length == 1){
					bbArray[j] = new Basketball(Double.parseDouble(lineArray[0]));
					//System.out.println(j);
					j++;
				}
			}


		}
		catch (FileNotFoundException e){
			System.out.println("File not found yo");
		}
		catch (IOException i){
			System.out.println("whatever an io exception is, you have it");
		}
		catch (NullPointerException N){
			System.out.println("Usually what happens");
		}

	}
	
	public static void findSuitibleBox(Basketball[] bbArray, Box[] boxArray){
		for (int n = 0; n<boxArray.length;n++){
			System.out.println("All the box heights in the suitible box loop are " +boxArray[n].Height + "(but outside any loop)");
		}
		for(int i = 0; i < bbArray.length; i++){
			
			//After intensive training, its nothing wrong with the actual arrays.
			/*for (int x = 0; x<boxArray.length; x++){
				System.out.println("All the box heights are displayed " +boxArray[x].Width);
			}*/
			Box smallestBox = boxArray[0];
			
			//Had a problem with the diameter that i didnt notice before
			//Also didnt notice that alot of these basketballs are FUCKIN HUGE
			//System.out.println("The fuck diamter ids right ehre" + bbArray[i].Diameter);
			
			//System.out.println("The radius of the basketball will be" + bbArray[i].Radius);
			for(int j = 0; j < boxArray.length; j++)
			{
				if (boxArray[j].fitsInBox(bbArray[i]) == true)
				{
					double smallestBBArea = boxArray[0].emptySpace(bbArray[i]);
					System.out.println("the length of this dumb box is" + boxArray[5].Length); 
					System.out.println("THe test value for box is" + boxArray[5].Volume);
					System.out.println("This value should be negative" + boxArray[5].emptySpace(bbArray[0]));
					double tempBBArea = boxArray[j].emptySpace(bbArray[i]);
					
					if ( smallestBBArea > tempBBArea ){
						smallestBox = boxArray[j];
						boxArray[j] = smallestBox;
						System.out.println("The basketball with a radius of "+ bbArray[i].Radius+ "fits in box "+ (j+1));
						System.out.println("Remaining Volume: "+ boxArray[j].emptySpace(bbArray[i]));
						
					}
					
					else if (smallestBBArea == tempBBArea){
						System.out.println("The current radius is "+ bbArray[i].Radius);
						System.out.println("The basketball with a radius of "+ bbArray[i].Radius + "fits in box "+ (j+1));
						System.out.println(" ");
						
					}
					else if (smallestBBArea < tempBBArea) {
						counter++;
						System.out.println("The current radius is "+ bbArray[i].Radius);
						System.out.println("Box Volume: " +boxArray[0].Volume +" Basketball Volume: "+ bbArray[i].Volume);
						System.out.println("Remaining Volume: "+ boxArray[0].emptySpace(bbArray[i]));
						System.out.println(" ");
					}
					Box currentBox = smallestBox;
					System.out.println("The current radius is "+ bbArray[i].Radius);
					System.out.println(" ");
				}
				else {
					//System.out.println("Basketball "+ bbArray[i].Radius + " did not fit in " + (j+1));
					
				}
			}
		}
	}
	
	//I actually dont need this, as its part two of the method up on top
	public static void unfitBasketballs(Box[] boxArray, Basketball[] bbArray){
	}

	public static void main(String[] args) {
		int[][] a = new int[5][];
		for (int i = 0; i< a.length;i++){
			a[i] = new int[i+1];
		}
		for (int j = 0; j<a.length;j++){
			System.out.println(a[j].length);
		}
		System.out.println(a[1]);
		//Doesnt actually create arrays but creates the length for the two arrays
		createArrays();

		//CHanges the length because programming is dumb
		Box[] boxArray = new Box[numOfBoxes];

		//For some reason it counts 15 instead of 16. O well
		Basketball[] BBArray = new Basketball[numBB+1];

		//PRINT STATEMENT CHECKS
		//System.out.println(numOfBoxes + " and " + numBB);
		//System.out.println("The length of the basketball array is "+ BBArray.length);
		//System.out.println("the length of the arrays are " + boxArray.length + " "+BBArray.length);

		fillArrays(boxArray, BBArray);

		//Check to see if the box was filled in appropriately
		//They are as of now, which means i essed up somewhere in the findSuitable Method
		for (int i = 0;i<boxArray.length;i++){
			System.out.println("All the box heights are displayed " +boxArray[i].Width);
		}

		//Check to see if the basketball array was actually filled correctly
		//for (int i = 0;i < BBArray.length;i++){
		//System.out.println("The radius of the basketball is "+ BBArray[i].Radius);
		//}

		//This is probably a needed test but i just wanted to make sure it was working idk maaannnnn
		//System.out.println("The volume in the first box is " + boxArray[0].getVolume());
		//System.out.println(BBArray[0].getVolume());
		
		//Suppose to find the suitible box but you know how that shit go
		findSuitibleBox(BBArray,boxArray);
		System.out.println(counter);
		
		//Save this for later
		//unfitBasketballs(boxArray,BBArray);
	}

}


