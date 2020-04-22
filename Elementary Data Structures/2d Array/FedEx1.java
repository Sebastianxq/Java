import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class FedEx1 {
	//Current Plans for lab 1
	// For Part one, create a function in which the input would be a text file.
	//FInish the rest of the lab
	
	//Class variables for across the board or something idk
	public static int counter = 0;
	//public static double boxVolume =  0;
	
	public static void volume(double[] boxLength, double[] boxWidth, double[] boxHeight){
		//create a for loop to calculate the volume of each and the use this in the other methods somehow. idk man
		//Actually maybe I can create an array of box volumes? :-)
		
		for (int i =0; i<boxLength.length; i++){
			System.out.println("The volume in box " + (i+1) +" is " + (boxLength[i] * boxWidth[i] * boxHeight[i]) );
		}
		
	}
	
	public static void totalVolume(double[] boxLength, double[] boxWidth, double[] boxHeight){
		double totalVol = 0;
		
		for (int i =0; i<boxLength.length; i++){
			totalVol += boxLength[i] * boxWidth[i] * boxHeight[i];
		}
		System.out.println("The total volume is " + totalVol);
	}
	
	public static void largestDimension(double[] boxLength, double[] boxWidth, double[] boxHeight){
		double biggestBox = boxLength[0] * boxWidth[0] * boxHeight[0];
		
		for (int i =0; i<boxLength.length; i++){
			if (biggestBox < (boxLength[i] * boxWidth[i] * boxHeight[i])){
				
				biggestBox = (boxLength[i] * boxWidth[i] * boxHeight[i]);
				
				System.out.println("The length of the biggets box is "+ boxLength[i]);
				System.out.println("The Width of the biggets box is "+ boxWidth[i]);
				System.out.println("The Height of the biggets box is "+boxHeight[i]);
			}
		}
		
		System.out.println("The largest volume in your set of boxes is " + biggestBox);
		
	}
	
	public static void smallestDimension(double[] boxLength, double[] boxWidth, double[] boxHeight){
		double smallestBox = boxLength[0] * boxWidth[0] * boxHeight[0];
		
		for (int i =0; i<boxLength.length; i++){
			if (smallestBox > (boxLength[i] * boxWidth[i] * boxHeight[i])){
				
				smallestBox = (boxLength[i] * boxWidth[i] * boxHeight[i]);
				
				System.out.println("The length of the smallest box is "+ boxLength[i]);
				System.out.println("The Width of the smallest box is "+ boxWidth[i]);
				System.out.println("The Height of the smallest box is "+boxHeight[i]);
			}
		}
		System.out.println("The smallest volume in your set of boxes is " + smallestBox);
	}
	
	public static void outputNumbers(){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\info.txt"));
			//Do something about this garbage not ending
			while(scnr.hasNextDouble()){
				counter++;
				System.out.print(scnr.nextDouble() + " ");
				//System.out.println("counter is at" + counter);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File Missing");
		}
	}
	
	public static void fillBoxDimensions(double[] xArray, double[] yArray, double[] zArray){
		try{
		
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\info.txt"));
			for (int i = 0; i<xArray.length; i++){
				xArray[i] = scnr.nextDouble();
			}
			for (int i = 0; i<yArray.length; i++){
				yArray[i] = scnr.nextDouble();
			}
			for (int i = 0; i<zArray.length; i++){
				zArray[i] = scnr.nextDouble();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found, you goof");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		//Finds the number of items then converts it into number of boxes for the arraymlength
		outputNumbers();
		int numBoxes = (counter/3);
		
		//Instantiates the array's length
		//System.out.println(numBoxes + " is the number of boxes in the text file");
		double[] boxLength = new double[numBoxes];
		double[] boxWidth = new double[numBoxes];
		double[] boxHeight = new double[numBoxes];
		
		//fills the boxes with the appropriate values
		fillBoxDimensions(boxLength,boxWidth,boxHeight);
		
		//check for the boxes and their values
		//for (int i = 0;i<boxLength.length; i++){
		//	System.out.println(i);
		//	System.out.println("The values in the length array are as follows: " + boxLength[i]);
		//	System.out.println("The values in the width array are as follows: " + boxWidth[i]);
		//	System.out.println("The values in the height array are as follows: " + boxHeight[i]);
		//}
		
		//Calculates and then displays the volume
		volume(boxLength,boxWidth,boxHeight);
		
		//Calculates volume of all the boxes combined into some sort of horrific abomination
		totalVolume(boxLength,boxWidth,boxHeight);
		
		//I like big boxes and I cannot lie
		largestDimension(boxLength,boxWidth,boxHeight);
		
		//Its whats on the inside that counts
		smallestDimension(boxLength,boxWidth,boxHeight);
		
	
		
	}

}
