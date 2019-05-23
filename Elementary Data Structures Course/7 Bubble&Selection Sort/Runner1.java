import java.util.Scanner;

//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 7
//Purpose of program: Learn how to use the bubble and selection sort methods in a completely realistic scenario and also reinforce our knowledge of runtimes
//Date last modified:10/26/15


public class Runner1 {

	/*This class is used to do the following
	bubble sort
	selection sort
	method that creates an array of cubes who's size is based on the user's input
	And I guess the cube's lwh is also randomly generated here
	 */	

	/*Can I round the numbers to the nearest hundreth? All these numbers are sensory overload
	If so, then Math.round(x * 100.0) / 100.0;
	
	Is there a different way to do the copy cubes thing and if not why do i need a whole method for it?
	
	How do i do runner2? :-(*/

	public static void main(String[] args) {
		//Creates and prints original array
		Scanner scnr = new Scanner(System.in);  
		System.out.println("Give a integer that will represent the size of the array");
		int num = scnr.nextInt();
		Cube[] cubeArray = createCubes(num);
		printCubes(cubeArray);
		System.out.println("");

		//Bubble Sort
		System.out.println("The list below is sorted using the bubble sort method");
		bubbleSort(cubeArray);
		printCubes(cubeArray);
		System.out.println("");

		//Idk why i need another method but maybe ill learn why this week :-)
		//I.e why did i need a method to create it?
		Cube[] copiedCubes = copyArrays(cubeArray);
		printCubes(copiedCubes);
		System.out.println("");

		//Selection Sort
		System.out.println("The list below is sorted using the selection sort method");
		selectionSort(copiedCubes);
		printCubes(copiedCubes);
		
		scnr.close();
	}

	public static void bubbleSort(Cube[] cubeArray){
		int n = cubeArray.length;
		Cube temp;
		for (int i = 0;i<n;i++){
			for (int j = 1; j< (n-i); j++){
				if (cubeArray[j-1].Volume > cubeArray[j].Volume){
					temp = cubeArray[j-1];
					cubeArray[j-1] = cubeArray[j];
					cubeArray[j] = temp;
				}
			}
		}
	}
	//This is used as an example ^^
	/*public void bubbleSort(int[] intArray){	
		int	n	=	intArray.length;	
		int	temp	=	0;																
		for(int	i=0;	i	<	n;	i++){	
			for(int	j=1;	j	<	(n-i);	j++){				
				if(intArray[j-1]	>	intArray[j]){	
					//swap	the	elements!	
					temp	=	intArray[j-1];	
					intArray[j-1]	=	intArray[j];	
					intArray[j]	=	temp;	
				}																																
			}	
		}	
	}*/

	public static void selectionSort(Cube[] funFunFun){
		for( int i = 0; i<funFunFun.length-1;i++){
			int minIndex = i;
			for (int j = i+1; j<funFunFun.length;j++){
				if (funFunFun[minIndex].Volume > funFunFun[j].Volume){
					minIndex = j;
				}
			}
			if (minIndex != i){
				Cube temp = funFunFun[i];
				funFunFun[i] = funFunFun[minIndex];
				funFunFun[minIndex] = temp;
			}
		}
	}
	//Also used as an example lmaooo
	/*public static void selectionSort(int[] x) {
		for (int i=0; i<x.length-1; i++) {
			int minIndex = i; // Index of smallest remaining value.
			for (int j=i+1; j<x.length; j++) {
				if (x[minIndex] > x[j]) {
					minIndex = j; // Remember index of new minimum
				}
			}
			if (minIndex != i) {
				//Exchange current element with smallest remaining.
				int temp = x[i];
				x[i] = x[minIndex];
				x[minIndex] = temp;
			}
		}
	} */

	public static Cube[] copyArrays(Cube[] cubes){
		//One method that i saw online but wont work because idk
		//Cube[] newCubes = new Cube[1];
		//System.arraycopy( cubes, 0, newCubes, 0, cubes.length );

		Cube[] newCubes = cubes.clone();
		return newCubes;
	}

	public static void printCubes(Cube[] cubes){
		for (int i = 0;i<cubes.length;i++){
			System.out.println("The Length, Width, height and volume of cube " + (i+1) + " is "+ cubes[i].Length + ", " +cubes[i].Width + ", " + cubes[i].Height
					+ ", " + cubes[i].Volume);
		}
	}

	public static Cube[] createCubes(int num){
		Cube[] cubeArray = new Cube[num];
		System.out.println("The cube array has "+ cubeArray.length+ " elements");
		for (int i = 0; i< num;i++){
			double temp = Math.random()*100;
			System.out.println(temp);
			cubeArray[i] = new Cube(temp,temp,temp);
		}
		return cubeArray;
	}
}
