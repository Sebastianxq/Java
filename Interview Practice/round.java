/*
* Prompt found on geekforgeeks.com, solution created by myself
* Given N inputs, round to the nearest 10
* Inputs assumed to be positive integers and less that 2^64-1
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class round {
    public static long roundNum(long x){
        long remainder = x%10;
        if (remainder <5){
	        x-=remainder;
	        }
	        
        else{
	        x=x-remainder+10;
	        }
	    return x;
    }
	public static void main (String[] args) {
		Scanner scnr = new Scanner(System.in);
		int total = scnr.nextInt();
		for(int i =0;i<total;i++){
		    long num = scnr.nextLong();
		   	System.out.print(round(num)+"\n");
		}
	}
}
