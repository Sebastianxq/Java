import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Author: Seabass, Sebastian Quinones
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment 2 (Lab 2, part one)
//Purpose: To further strengthen our ability to use 2d arrays and allow us to start building confidence when working with ragged arrays
//Date Last Modified: 9/21/15

public class calories2 {
	public static int counter = 0;
	
	public static void outputNumbers(){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\caloriesLog2.txt"));
			//Do something about this garbage not ending
			while(scnr.hasNextInt()){
				counter++;
				System.out.print(scnr.nextInt() + " ");
				//System.out.println("counter is at" + counter);
			}
		}
		catch (FileNotFoundException e){
			System.out.println("File Missing");
		}
	}
	
	//method to input the values into an array
	public static void getCalorieLog(int[][] xArray){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\caloriesLog2.txt"));
		
			for(int i = 0; scnr.hasNextLine() && i < xArray.length; i++){
			        String line = scnr.nextLine();
			        //String def works, just need to parse it correctly
			        //System.out.println("The temp scnr line read: " + line);
			        String[] strArray = line.split(" ");
			        //System.out.println("Length: " + strArray.length);
			       // for (int z = 0; z < strArray.length; z++){
			        //	System.out.println(strArray[z]);
			        //}
			        xArray[i] = new int[strArray.length];
			        for(int j = 0; j < strArray.length; j++){
			            //Correct Check
			        	//System.out.println("j: " + j + " Print: " + strArray[j]);
			        	xArray[i][j] = Integer.parseInt(strArray[j]);
			
			        }
			    }
		}
		catch(FileNotFoundException e){
			System.out.println("File isn't where you said it was.");
		}
	}

	public static void getDailyAvg(int[][] food){
		int sumCal = 0;
		int j = 0;
		for (int i =0; i<food.length; i++){
			for (j = 0; j<food[i].length; j++){
				sumCal += food[i][j];
			}
			System.out.println("The number of calories on day " + (i+1) +" is " + (sumCal/j) );
			sumCal = 0;
		}
	
	}
	
	public static void getMealAvg(int[][] food){
			int avgMealCal = 0;
			int j = 0;
			Integer s = null;
			for ( j = 0; j<food[j].length; j++){
				for (int i=0; i<food.length; i++){
					//my problem is probably the empty space in the array
					
					if (j< food[j].length ){
					avgMealCal += food[i][j];
					}
					else{
						System.out.println("Wow");
					}
				}
			}
				//avgMealCal = (avgMealCal/i);
				//System.out.println("The avg number of calories per meal " + (j+1) +" is " + avgMealCal);
				//avgMealCal = 0;
			//}
			
			int i = 0;
			int x = 0;
			while( i < food.length )
			{
			  if( x < food[i].length )
			  {
			    avgMealCal += food[i][x];
			    System.out.println("The avg number of calories per meal " + (x+1) +" is " + avgMealCal);
			  }

			  ++i;
			}
	}
	
	public static void main(String[] args) {
		//outputNumbers();
		int[][] calorieLog = new int[7][];
		
		getCalorieLog(calorieLog);
		
		getDailyAvg(calorieLog);
		
		getMealAvg(calorieLog);
	}

}
