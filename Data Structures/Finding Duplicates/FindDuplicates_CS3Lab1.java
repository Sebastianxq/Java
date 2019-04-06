package lab1_2017Spring;
import java.util.*;
/**************************************************************************************
 *Programmed by: Sebastian Quinones                           						 **
 *Last modified: 01/27/2017 												
 *                                                                           		 **
 *Program description: Create a program that allows the user to create an array of   **
 * 		their desired size and input a random value with a limit of their choosing,  **
 * 		then searches for duplicates using 4 different algorithms            		 **
 * 																			         **
 *Purpose: Understand how different sorting methods affect the Big O notation of	 **
 *           a program and refresh students understanding in sorting methods		 **
 *			 and efficiently checking arrays										 **
 * 	     											             				     **
 **************************************************************************************/

public class main {

	//Method that prints the array values
	public static void printArray(int[] regular, int[]bubble, int[]merge, int[] bool){
		for(int i = 0;i<regular.length;i++){
			System.out.println("The value of index "+ i+ " in the Regular array is "+ regular[i]);
		}
		System.out.println(" ");
		for(int i = 0;i<bubble.length;i++){
			System.out.println("The value of index "+ i+ " in the Bubblesort array is "+ bubble[i]);
		}
		System.out.println(" ");
		for(int i = 0;i<merge.length;i++){
			System.out.println("The value of index "+ i+ " in the Mergesort array is "+ merge[i]);
		}
		System.out.println(" ");
		for(int i = 0;i<merge.length;i++){
			System.out.println("The value of index "+ i+ " in the Boolean array is "+ bool[i]);
		}
	}

	//Source code given that checks for duplicate numbers in an array
	//duplicate source code given in prompt
	public static boolean hasDuplicates(int []A){
		boolean duplicates = false;
		for (int i = 0; i<A.length;i++){
			for (int j=0;j<A.length;j++){
				if (A[i]==A[j] && i!=j){
					duplicates = true;
				}
			}
		}
		return duplicates;
	}

	//Enhanced code that searches for duplicates without checking the same spot twice
	//Checks every element in the array once with each other
	public static boolean improvedHasDuplicates(int []A){
		boolean duplicates = false;
		for (int i = 0; i<A.length-1;i++){
			for (int j=i+1;j<A.length;j++){
				if (A[i]==A[j] && i!=j){
					duplicates = true;
				}
			}
		}
		return duplicates;
	}

	//Searches for duplicates in an already sorted array
	//goes through a sorted array once and returns true if duplicates are spotted
	public static boolean sortedHasDuplicates(int []A){
		boolean duplicates = false;
		for (int i = 0; i<A.length-1; i++){
			//checks value with next closest value to determine if there are duplicates
			if (A[i] == A[i+1]){
				duplicates = true;
			}
		}
		return duplicates;
	}

	//Creates a boolean array where each slot represents a value in the original unsorted array
	//True means there is more than one of that value found in the array
	//Also prints out a list of duplicates at the end
	public static void booleanArrayCheck(int[] A, int max){
		boolean[] S = new boolean[max];
		for (int i = 0; i<A.length;i++){
			//Check to stop values from being reset if they were already found as a duplicate
			if (S[A[i]] != true){
				S[A[i]] = false;
			}
			for (int j=i+1;j<A.length;j++){
				if (A[i]==A[j] && i!=j){
					S[A[i]] = true;
				}

			}
		}

		//Prints out list of numbers that were found more than once in the array
		System.out.println("The boolean array has been instantiated");
		System.out.println("The following is a list of numbers that were duplicated in the array:");
		for (int i = 0;i<max;i++){
			if (S[i] == true){
				System.out.print(i+ " ");
			}
		}
	}

	//Bubblesort method that sorts the numbers in the array in ascending order
	//Bubblesort method to sort the numbers in the array in ascending order
	public static boolean bubbleSortDuplicates(int[] A){
		boolean duplicates = false;
		int length = A.length;  
		int temp = 0;  
		for(int i=0; i < length; i++){  
			for(int j=1; j < (length-i); j++){  
				if(A[j-1] > A[j]){  
					//swaps elements  
					temp = A[j-1];  
					A[j-1] = A[j];  
					A[j] = temp;  
				}  

			}  
		}
		return duplicates;
	}  

	//Mergesort to sort the numbers in the array in ascending order
	//First part of the algorithm that performs the recursive calls
	//recursively places the arrray's value in order
	public static void mergeSort(int[] A) {
		//base case
		if (A.length > 1) {
			//split array into two halves
			int[] left = leftArray(A);
			int[] right = rightArray(A);

			//Sorts the two halves recursively
			mergeSort(left);
			mergeSort(right);

			//merge the two arrays back together
			merge(A, left, right);


		}
	}

	//fills in left array
	//Returns the first half of the given array.
	public static int[] leftArray(int[] array) {
		int size1 = array.length / 2;
		int[] left = new int[size1];

		for (int i = 0; i < size1; i++) {
			left[i] = array[i];
		}
		return left;
	}

	//fills in right array
	// Returns the second half of the given array.
	public static int[] rightArray(int[] array) {
		int size1 = array.length / 2;
		int size2 = array.length - size1;
		int[] right = new int[size2];

		for (int i = 0; i < size2; i++) {
			right[i] = array[i + size1];
		}
		return right;
	}

	//Combines sorted arrays back together
	//Merge both sides and then check for duplicates
	public static void merge(int[] combined, int[] left, int[] right) {
		//left and right array indexes
		int leftIndex = 0;
		int rightIndex = 0;

		//Fills in the original array with sorted values
		for (int i = 0; i < combined.length; i++) {
			if (rightIndex >= right.length || (leftIndex < left.length && 
					left[leftIndex] <= right[rightIndex])) {
				//adds from the left array
				combined[i] = left[leftIndex];
				leftIndex++;
			} 
			else {
				//adds from the right array
				combined[i] = right[rightIndex];
				rightIndex++;
			}
		}
	}

	public static void main(String[] args) {
		try{
			//Allows user to set up the array size and max number
			//Also instantiates the arrays that are to be sorted, scanners to read inputs
			System.out.println("What size would you like the array to be (input an integer)");
			Scanner scnr =new Scanner(System.in);
			int size = scnr.nextInt();
			int[] unsortedArray = new int[size];
			int[] unsortedBubble = new int[size];
			int[] unsortedMerge = new int[size];
			int[] unsortedBool = new int[size];
			System.out.println("What would you like the maximun possible value to be? (input an integer)");
			int max = scnr.nextInt();

			//Sets up the RNG and fills the array with random values
			Random rand = new Random();
			for (int i=0;i<size-1;i++){
				unsortedArray[i] = rand.nextInt(max);
				unsortedBubble[i] = rand.nextInt(max);
				unsortedMerge[i] = rand.nextInt(max);
				unsortedBool[i] = rand.nextInt(max);
			}
			//Displays values in all 3 arrays before being any of them are manipulated
			printArray(unsortedArray,unsortedBubble, unsortedMerge, unsortedBool);
			System.out.println(" ");

			//Checks to see if there are duplicates in the unsorted array
			System.out.println("The unsorted array has duplicates: "+ improvedHasDuplicates(unsortedArray));

			//Sorts the array with Bubblesort then checks for duplicates
			bubbleSortDuplicates(unsortedBubble);
			System.out.println("There are duplicates in the bubblesorted array: " + sortedHasDuplicates(unsortedBubble));

			//Sorts the array with Mergesort then checks for duplicates
			mergeSort(unsortedMerge);
			System.out.println("There are duplicates in the Mergesorted array: " + sortedHasDuplicates(unsortedMerge));

			//Creates a boolean array to check for duplicates
			System.out.println(" ");
			booleanArrayCheck(unsortedBool, max);

			//Runtime Stuff
			/*long startTime = System.nanoTime();
			long sMilli = System.currentTimeMillis();
			hasDuplicates(unsortedArray);
			long endTime = System.nanoTime();
			long eMilli = System.currentTimeMillis();
			long total = startTime-endTime;
			long totalMilli = sMilli-eMilli;
			System.out.println("Total time for the regular duplicate method was"+ total+ "nanoseconds and "+totalMilli+ " milliseconds" );

			startTime = System.nanoTime();
			improvedHasDuplicates(unsortedArray);
			endTime = System.nanoTime();
			total = startTime-endTime;
			System.out.println("Total time for the enhanced duplicate method was"+ total);

			startTime = System.nanoTime();
			sortedHasDuplicates(unsortedBubble);
			endTime = System.nanoTime();
			total = startTime-endTime;
			System.out.println("Total time for bubblesort was"+ total);

			startTime = System.nanoTime();
			sortedHasDuplicates(unsortedMerge);
			endTime = System.nanoTime();
			total = startTime-endTime;
			System.out.println("Total time for mergesort was"+ total);

			startTime = System.nanoTime();
			booleanArrayCheck(unsortedBool, max);
			endTime = System.nanoTime();
			total = startTime-endTime;
			System.out.println("Total time for the boolean check method was"+ total);*/

		}
		catch (InputMismatchException e){
			System.out.println("That was not an integer, please restart the program");
		}
	}
}

