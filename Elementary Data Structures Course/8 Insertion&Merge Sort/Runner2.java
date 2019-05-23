
//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 8
//Purpose of program: Learn how to use the insertion and merge sort methods in a completely realistic scenario and also reinforce our knowledge of runtimes
//Date last modified:11/08/15

public class Runner2 {
	//This class is used to compare runtimes
		public static void main(String[] args) {
			// Do we create the giant cube thing in here?
			//Create the array locally
			//I can go one deeper actually
			Cube[] runTime = Runner1.createCubes(10000);
			//cubeArray is what i wanna use tho
			//Maybe try milli?
			//Better but ill leave the nano code in just in case idk
			long startRunner = System.currentTimeMillis();
			Runner1.insertionSort(runTime);
			long endRunner = System.currentTimeMillis()-startRunner;
			System.out.println("The time it took to finish sorting using selection sort is " + endRunner);
			
			long startRunner2 = System.currentTimeMillis();
			Runner1.MergeSort(runTime, 0, runTime.length-1);
			long endRunner2 = System.currentTimeMillis()-startRunner2;
			System.out.println("The time it took to finish sorting using Merge sort is " + endRunner2);
			

		}
}
