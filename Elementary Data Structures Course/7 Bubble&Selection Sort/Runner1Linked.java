import java.util.LinkedList;
import java.util.Scanner;


public class Runner1Linked {

	public static void main(String[] args) {
		//Can just use the preset linked list bc loopholes or something i guess
		LinkedList<CubeNode> linkedList = new LinkedList<CubeNode>();
		//Create a for loop or something that adds in a new object to the end
		
		Scanner scnr = new Scanner(System.in);  
		System.out.println("Give a integer that will represent the size of the array");
		int num = scnr.nextInt();
		
		linkedList = createCubes(num);
		System.out.println(linkedList);

	}
	
	public static LinkedList createCubes(int num){
		
	}
}
