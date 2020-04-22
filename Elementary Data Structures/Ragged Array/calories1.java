import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Author: Seabass, Sebastian Quinones
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment 2 (Lab 2, part one)
//Purpose: To further strengthen our ability to use 2d arrays and allow us to start building confidence when working with ragged arrays
//Date Last Modified: 9/21/15

public class calories1 {
	//As is tradition
	public static int counter = 0;
	
	//Calculates the total number of calories per day
	public static void totalDailyCalories(int[][] food){
		int sumCal = 0;
		for (int i =0; i<food.length; i++){
			for (int j = 0; j<food[0].length; j++){
				sumCal += food[i][j];
			}
			System.out.println("The number of calories on day " + (i+1) +" is " + sumCal );
			sumCal = 0;
		}
	
	}
	
	//calculates the avg number of calories consumed per day
	public static void avgCalories(int[][] food){
		int avgWeeklyCal = 0;
		for (int i =0; i<food.length; i++){
			for (int j = 0; j<food[0].length; j++){
			avgWeeklyCal += food[i][j];
			}
		}
		avgWeeklyCal = (avgWeeklyCal/7);
		System.out.println("The avg number of calories per day is " + avgWeeklyCal);
	}
	
	//calculates the average number of calories eaten per meal
	public static void avgMealCalories(int[][] food){
		int avgMealCal = 0;
		for (int j = 0; j<food[0].length; j++){
			for (int i =0; i<food.length; i++){
			avgMealCal += food[i][j];
		}
			avgMealCal = (avgMealCal/7);
			System.out.println("The avg number of calories per meal " + (j+1) +" is " + avgMealCal);
			avgMealCal = 0;
		}
	}
	
	//calculates the highest number of calories eaten in a day across the entire week
	public static void maxDailyCalories(int[][] food){
		int sumCal = 0;
		int maxDay = 0;
		for (int i =0; i<food.length; i++){
			for (int j = 0; j<food[0].length; j++){
				sumCal += food[i][j];
			}
			if (maxDay < sumCal){
				maxDay = sumCal;
			}
			sumCal = 0;
		}
		System.out.println("The highest number of cals consumed in a day is " + maxDay );
	}
	
	//Finds biggest meal in each respective time of column or whatever
	public static void maxMealCalories(int[][] food){
		int maxBreakfast = food[0][0];
		int maxLunch = food[0][1];
		int maxDinner = food[0][2];
		for (int i = 0; i<food.length; i++){
			if (maxBreakfast < food[i][0]){
				maxBreakfast = food[i][0];
			}
			if (maxLunch < food[i][1]){
				maxLunch = food[i][1];
			}
			if (maxDinner < food[i][2]){
				maxDinner = food[i][2];
			}
		}
		
		//Make all this one print statement bc it looks cluttered af in the console
		System.out.println("The highest amount of calories for Breakfast is " + maxBreakfast);
		System.out.println("The highest amount of calories for Lunch is " + maxLunch);
		System.out.println("The highest amount of calories for Dinner is " + maxDinner);
	}
	
	//method check to see if all the values are displayed properly
	public static void outputNumbers(){
		try{
			Scanner scnr = new Scanner(new File("C:\\Users\\sxquinones\\Desktop\\calorieLog.txt"));
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
			Scanner scnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\caloriesLog.txt"));
			while (scnr.hasNextInt()){
				for (int i = 0; i<xArray.length; i++){

					for (int j = 0; j<xArray[i].length;j++){
						xArray[i][j] = scnr.nextInt();
					}
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File isn't where you said it was.");
		}
	}
	
	public static void main(String[] args) {
		//as of now it doesnt need to run like it did in the past lab
		//I wont question it tbh
		//outputNumbers();
		
		//Creates the 2d array and fills in the values 
		int[][] mealLog = new int [7][3];
		getCalorieLog(mealLog);
		
		//Chances are this is working alright
		//System.out.println("the first number is " + mealLog[0][0]);
		
		//outputs the total calories per day.
		totalDailyCalories(mealLog);
		
		//finds the avg cal per day
		avgCalories(mealLog);
		
		//i dont even know anymore man
		//It somehow works tho B)
		avgMealCalories(mealLog);
		
		//Should be working. 
		maxDailyCalories(mealLog);
		
		//Hoping and praying and hoping
		maxMealCalories(mealLog);
	}

}

