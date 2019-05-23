//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 7
//Purpose of program: Learn how to use the bubble and selection sort methods in a completely realistic scenario and also reinforce our knowledge of runtimes
//Date last modified:10/26/15

public class Runner2 {

	//This class is used to compare runtime
	
	public static void main(String[] args) {
		// Do we create the giant cube thing in here?
		//I can go one deeper actually
		
		Cube[] runTime = Runner1.createCubes(10000);
		//cubeArray is what i wanna use tho
		//Maybe try milli?
		//Better but ill leave the nano code in just in case idk
		long startRunner = System.currentTimeMillis();
		Runner1.bubbleSort(runTime);
		long endRunner = System.currentTimeMillis();
		System.out.println("The time it took to finish sorting using selection sort is " + (endRunner-startRunner));
		
		long startRunner2 = System.currentTimeMillis();
		Runner1.selectionSort(runTime);
		long endRunner2 = System.currentTimeMillis()-startRunner2;
		System.out.println("The time it took to finish sorting using selection sort is " + endRunner2);
		
		//Same as above but in nanoseconds 
		/*long startRunner = System.nanoTime();
		Runner1.bubbleSort(runTime);
		long endRunner = System.nanoTime()-startRunner;
		System.out.println("The time it took to finish sorting using selection sort is " + endRunner);*/
		
		/*long startRunner2 = System.nanoTime();
		Runner1.selectionSort(runTime);
		long endRunner2 = System.nanoTime()-startRunner2;
		System.out.println("The time it took to finish sorting using selection sort is " + endRunner2);*/

	}

}
