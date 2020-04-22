import java.util.Scanner;

//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 8
//Purpose of program: Learn how to use the insertion and merge sort methods in a completely realistic scenario and also reinforce our knowledge of runtimes
//Date last modified:11/08/15

public class Runner1 {

	//All the code is basically the same as lab7 
	//But pls dont dock points bc of that :-(
	public static void main(String[] args) {
		//Creates and prints original array
		Scanner scnr = new Scanner(System.in);  
		System.out.println("Give a integer that will represent the size of the array");
		int num = scnr.nextInt();
		Cube[] cubeArray = createCubes(num);
		printCubes(cubeArray);
		System.out.println("");

		//Idk why i need another method but maybe ill learn why this week :-)
		//I.e why did i need a method to create it?
		Cube[] copiedCubes = copyArrays(cubeArray);

		//INSERTION Sort
		System.out.println("The list below is sorted using the insertion sort method");
		insertionSort(cubeArray);
		printCubes(cubeArray);
		System.out.println("");
		
		System.out.println("The array that needs to be sorted is");
		printCubes(copiedCubes);
		System.out.println("");

		//Merge Sort
		System.out.println("The list below is sorted using the merge sort method");
		//mergeSort(copiedCubes);
		MergeSort(copiedCubes, 0, copiedCubes.length-1);
		printCubes(copiedCubes);

		scnr.close();
	}

	public static void insertionSort(Cube[] cubeArray){
		int j; // the number of items sorted
		Cube insertee; // the item to be inserted
		int i;
		for (i = 1; i < cubeArray.length; i++){
			insertee = cubeArray[i];
			for(j = i - 1; (j >= 0) && ( insertee.Height < cubeArray[j].Height); j--){
				cubeArray[ j+1 ] = cubeArray[ j ];
			}
			cubeArray[j+1] = insertee;
		} 
	}

	static public void Merge(Cube [] genericCubes, int left, int mid, int right)
    {
	  //This is where all the sorting goes on
      Cube [] temp = new Cube[genericCubes.length];
      int i;
      int leftEnd;
      int numElements;
      int tempPos;
  
      //Creates the left max and yah know, other things
      leftEnd = (mid - 1);
      tempPos = left;
      numElements = (right - left + 1);
  
      while ((left <= leftEnd) && (mid <= right))
      {
          if (genericCubes[left].Height <= genericCubes[mid].Height )
              temp[tempPos++] = genericCubes[left++];
          else
              temp[tempPos++] = genericCubes[mid++];
      }
  
      while (left <= leftEnd)
          temp[tempPos++] = genericCubes[left++];

      while (mid <= right)
          temp[tempPos++] = genericCubes[mid++];

      //fills in the original array with the sorted values for that current array size
      for (i = 0; i < numElements; i++)
      {
          genericCubes[right] = temp[right];
          right--;
      }
  }

  static public void MergeSort(Cube [] numbers, int left, int right)
  {
	  //This is where all the division goes on
    int mid;
  
    if (right > left)
    {
   
      mid = (right + left) / 2;
      //recursive calls
      MergeSort(numbers, left, mid);
      MergeSort(numbers, (mid + 1), right);
  
      Merge(numbers, left, (mid+1), right);
    }
  }
	
	
	
	//Attempt number 1 didnt do so hot smh
/*	public static Cube[] mergeSort(Cube[] funFunFun){
		int arraySize = funFunFun.length;
		//BAse
		if (arraySize <= 1){
			return funFunFun;
		}
		else{
			int mid = arraySize/2;
			Cube[] firstHalf = new Cube[mid];
			Cube[] secondHalf = new Cube[arraySize - mid];
			
			//first Half put into a temp
			for (int i = 0; i< mid; i++){
				firstHalf[i] = funFunFun[i];
			}
			
			//Second put into a temp
			for (int i = mid; i < arraySize; i++){
				secondHalf[i - mid] = funFunFun[i];
			}
			return merge(mergeSort(firstHalf), mergeSort(secondHalf));
		}
		//return funFunFun;
	}
	public static Cube[] merge (Cube first[], Cube second[]) {
		System.out.println("Array length is as follows respectively " + first.length + ", "+ second.length);
		Cube NewSort[] = new Cube[first.length + second.length];
		System.out.println(NewSort.length + " is newSort");
		for (int i = 0; i < NewSort.length - 1; i++){
			
			System.out.println("The i is " + i);
			if (first[i].Height < second[i].Height){
				NewSort[i] = first[i];
			}
			else if (first[i].Height == second[i].Height){
				NewSort[i] = first[i];
				NewSort[i+1] = second[i];
				i++;
			}
			else{
				NewSort[i] = second[i];
			}
		}
		return NewSort;
	}*/

	/*{	int size = num.length;  // size of array holding the numbers to be sorted
	if (size <= 1)  // base step 
	{   return num;
	}
	else  // recursive step
	{   int mid = size / 2;
	int firstHalf[] = new int[mid];
	int secondHalf[] = new int[size - mid];
	// Copy first half of the array
	for (int i = 0; i < mid; i++)
	{	firstHalf[i] = num[i];
	}
	// Copy second half of the array
	for (int i = mid; i < size; i++)
	{	secondHalf[i - mid] = num[i];
	}	     
	return merge(mergeSort(firstHalf), mergeSort(secondHalf));
	}*/


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
