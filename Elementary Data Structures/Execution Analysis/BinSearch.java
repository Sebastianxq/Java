//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 6
//Purpose of program: learn how to calculate runtimes and further emphasize the subject of optimization and using the right tool for the right job
//Date last modified:10/20/15

import java.util.Arrays;


public class BinSearch {

	public static void main(String[] args) {

		//Creates the array of random values, sorts them and then creates the search element 
		//Use 5 values: 10000, 40000, 160000, 640000, 1280000
		double[] largeArray = new double[40000];
		for (int i = 0;i<40000;i++){
			largeArray[i] = (Math.random());
		}
		Arrays.sort(largeArray);
		double searchElement = Math.random();
		
		
		//Creates the array that will store the runtime and then stores the runtimes
		long[] processAvg = new long[30];
		for (int i =0; i< 30;i++){
			long realStartInterative = System.nanoTime();
			System.out.println(interativeBinSearch(largeArray, searchElement));
			//System.out.println(recursiveBinSearch(largeArray, searchElement, largeArray.length-1 , 0));
			long processTimeInterative = System.nanoTime()-realStartInterative;
			processAvg[i] = processTimeInterative;
		}
		
		//Finds the avg runtime
		long avg = 0;
		for (int i =0; i<30;i++){
			avg +=processAvg[i];
		}
		avg = avg/30;
		System.out.println("The average amount of time in nano is "+ avg);
		
		//long realStartRecursive = System.nanoTime();
		//System.out.println(recursiveBinSearch(largeArray, searchElement, largeArray.length-1 , 0));
		//long processTimeRecursive = System.nanoTime()-realStartRecursive;
		//System.out.println("The time it took to go through the array through recursion is " + processTimeRecursive);

		//This is just a lame test because interative wasnt working
		//double[] smallArray = {1,2,3,4,5,6};
		//double findElement = 4;
		//System.out.println(interativeBinSearch(smallArray,findElement));
		//System.out.println(recursiveBinSearch(smallArray,findElement, smallArray.length-1,0));


	}
	//2 inputs, an array and a integer to find
	public static int interativeBinSearch(double[] newArray, double searchElement){
		int min = 0;
		int max = newArray.length - 1;

		while (min <= max) 
		{
			int middle = (min + max)/2;
			if (newArray[middle] == searchElement) {
				return middle;
			}
			else if (newArray[middle] < searchElement){
				min = middle + 1;
			}
			else max = middle - 1;
		}
		return -1;
	}

	public static int recursiveBinSearch (double[] newArray, double searchElement, int max, int min){
	
		int middle = (min + max)/2;
		if (min > max) { 
			return -1; 
		}
		if (newArray[middle] == searchElement){
			return middle;
		}
		else if (newArray[middle] < searchElement) {
			return recursiveBinSearch(newArray, searchElement, max, middle+1);
		}
		else {
			return recursiveBinSearch(newArray, searchElement, middle-1, min);
		}

	}
}
















/*int max = newArray.length-1;
int min = 0;
int middle = newArray.length/2;
//What do i set the condition as smh
while (max >= min){
	if(searchElement == newArray[middle]){
		System.out.println("The element was found in position "+ middle);
		return middle;
	}
	else if (searchElement < newArray[middle]) {
		//System.out.println("it wont end");
		max = middle - 1;
		middle = middle/2;
		//break;
	} 
	else {
		//System.out.println("uhh");
		min = middle + 1;
		middle = max+middle/2-1;
	}
}
System.out.println("This gay ass loop didnt even work");
return -1;*/