//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 6
//Purpose of program: learn how to calculate runtimes and further emphasize the subject of optimization and using the right tool for the right job
//Date last modified:10/20/15

import java.util.Scanner;


public class Fibo {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);  
		System.out.println("Give a number for the fibonacci method B)");
		int num = scnr.nextInt();

		long realStartFibo = System.nanoTime();
		interativeFibo(num);
		long processTimeFibo = System.nanoTime()-realStartFibo;
		System.out.println("This process took " + processTimeFibo + " nanoseconds");

		System.out.println("");

		System.out.println("The fibonacci number found through recursion " + recursiveFibo(num));
		long realStart2 = System.nanoTime();
		recursiveFibo(num);
		long processTimeFibo2 = System.nanoTime()-realStart2;
		System.out.println("This process took " + processTimeFibo2 + " nanoseconds");

	}
	//Fibonacci is the number found by adding the past 2 numbers
	public static void interativeFibo(int n){
		int fibNum = 0;
		int fibNum2 = 1;
		int actualFib = 0;
		for(int i=0; i < n; i++) {
			int temp = fibNum;
			fibNum = fibNum2;
			fibNum2 = temp + fibNum2;
		}
		System.out.println("The fibonacci number found through iteration is " +fibNum);
	}

	public static int recursiveFibo (int num){
		if (num <= 1){
			return num;
		}
		else{
			return recursiveFibo(num-1)+recursiveFibo(num-2);
		}
	}
}
