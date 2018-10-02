/*************************************
 ** Basic Disjoint set forest        **
 ** Programmed by Olac Fuentes       **
 ** Last modified  March 21, 2017    **
 **************************************/

//import java.io.*;
public class dsf{	

	private int[] S; 
	private static int numFindCalls = 0;

	public dsf(int n){ //Initialize disjoint set forest with n elements. Each element is a root
		S = new int[n];
		for(int i=0;i<n;i++)
			S[i] = -1;
	}   

	public dsf(int [] A){ //Initialize disjoint set forest copying its elements from an array A
		S = new int[A.length];
		for(int i=0;i<S.length;i++)
			S[i] = A[i];
	}   

	public int find(int i){ // Returns the root of the set element i belongs to
		if(S[i]<0)
			return i;
		numFindCalls++;
		return find(S[i]);   
	}    

	public int find_c(int i){ // Returns the root of the set element i belongs to
		if(S[i]<0)
			return i;
		numFindCalls++;
		return S[i] = find_c(S[i]);   
	}    
	
	//Standard Union
	public void union(int i, int j){ // Returns the root of the set element i belongs to
		int ri = find(i);
		int rj = find(j);
		S[rj] = ri;   
		
		//Debugging code; to see if number of calls is increasing
		//System.out.println(numFindCalls+" is the num calls in the method");
	}  

	//Standard union that used path compression in it's find method
	public void union_C(int i, int j){ // Returns the root of the set element i belongs to
		int ri = find_c(i); 
		int rj = find_c(j);
		S[rj] = ri;
		
	}
	
	//Unions sets based off height. Smaller height joints larger height
	public void unionByHeight(int i, int j){ // Returns the root of the set element i belongs to
		int ri = find(i);
		int rj = find(j);
		
		if (ri==rj) { //If heights are equal
			return;
		}
		
		if (S[ri]>S[rj]){//root of i points to root of j
			S[ri] = rj;

		}
		else{//root of j points to root of i
			if (S[ri] <S[rj])
				S[rj] = ri;
			if (S[ri] == S[rj]){
				S[rj] = ri;
				S[ri]--;
			}
		}
	}  
	
	//Unions based off how many nodes exist in a set.
	public void unionBySize(int i, int j){
		int ri = find(i);
		int rj = find(j);
		if (ri==rj) return; //If same root do nothing
		
		else if (S[ri]>S[rj]){ //Make i point to j 
			int sizeSmaller = S[ri];
			S[ri] = rj;
			S[rj] += sizeSmaller;
		}
		else{ //Make j point to i
			int sizeSmaller = S[rj];
			S[rj] = ri;
			S[ri] += sizeSmaller;
		}
	}  
	
	//Union based off number of nodes with path compression added
	public void unionBySize_C(int i, int j){
		int ri = find_c(i);
		int rj = find_c(j);
		if (ri==rj) return;
		if (S[ri]>S[rj]){
			int sizeSmaller = S[ri];
			S[ri] = rj;
			S[rj] += sizeSmaller;
		}
		else{
			int sizeSmaller = S[rj];
			S[rj] = ri;
			S[ri] += sizeSmaller;
		}  
	}  

	//Returns whether or not the two items are in the same set
	public boolean inSameSet(int i, int j){ 
		return find(i) == find(j);   
	}      
	
	//Returns the number of find calls
	public int numFindCalls(){
		return numFindCalls;
	}

	//Prints all the values in the DSF
	public void print(){
		for(int i=0;i<S.length;i++)  
			System.out.print(S[i]+" ");
		System.out.println();
	}   
}