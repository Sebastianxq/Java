import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FedEx2 {
	public static int counter = 0;
	
	public static void volume(double[][] box){
		
		for (int i =0; i<box[0].length; i++){
			System.out.println("The volume in box " + (i+1) +" is " + (box[0][i]*box[1][i]*box[2][i]) );
		}
	}

	public static void totalVolume(double[][] box){
		double totalVol = 0;
		
		for (int i =0; i<box[0].length; i++){
			totalVol += box[0][i] * box[1][i] * box[2][i];
		}
		System.out.println("The total volume is " + totalVol);
	
	}

	public static void largestDimension(double[][] box){
		double biggestBox = box[0][0];
		
		for (int i =0; i<box[0].length; i++){
			if (biggestBox < (box[0][i] * box[1][i] * box[2][i])){
				
				biggestBox = (box[0][i] * box[1][i] * box[2][i]);
				System.out.println("The length of the biggets box is "+ box[0][i]);
				System.out.println("The Width of the biggets box is "+ box[1][i]);
				System.out.println("The Height of the biggets box is "+box[2][i]);
				
			}
		}
		System.out.println("The largest volume in the set of boxes is " + biggestBox);
	}

	public static void smallestDimension(double[][] box){
		double smallestBox = box[0][0];
		
		for (int i =0; i<box[0].length; i++){
			if (smallestBox > (box[0][i] * box[1][i] * box[2][i])){
				
				smallestBox = (box[0][i] * box[1][i] * box[2][i]);
				//System.out.println("The length of the smallest box is "+ box[0][i]);
				//System.out.println("The Width of the smallest box is "+ box[1][i]);
				//System.out.println("The Height of the smallest box is "+box[2][i]);
				
			}
		}
		System.out.println("The smallest volume in the set of boxes is " + smallestBox);
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
	
	public static void fillBoxDimensions(double[][] xArray){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\info.txt"));
			while (scnr.hasNextDouble()){
			for (int i = 0; i<xArray.length; i++){
				
				for (int j = 0; j<xArray[i].length;j++){
					xArray[i][j] = scnr.nextDouble();
				}
			}
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
		
		double[][] boxDimensions = new double[3][numBoxes];
		//try{
		//Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\info.txt"));
		//for(int i = 0; i < 2; i++)
		//    for(int j = 0; j < numBoxes; j++)
	//	          boxDimensions[i][j] = scnr.nextDouble();
		//}
		//catch(FileNotFoundException e){
		//	System.out.println("FIle not found");
		//}
		
		//Works finally, fills out the areas in the 2d array
		fillBoxDimensions(boxDimensions);
		
		//Test to see if the array is actually filled out
		//System.out.println("The box dimensions in the first area is " + boxDimensions[0][0]);
	
		//works now
		volume(boxDimensions);
		
		//works too :-)
		totalVolume(boxDimensions);
		
		largestDimension(boxDimensions);
		
		smallestDimension(boxDimensions);
	}	
}
