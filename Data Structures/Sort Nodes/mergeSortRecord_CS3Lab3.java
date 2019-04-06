/***************************************************************************************
************ Defines Objects to be used by the non-recursive Mergesort routine *********
************ Source Code created by Olac Fuentes                               *********
************ Last modified September 12, 2011                                  ********* 
****************************************************************************************/

import java.util.*;

public class mergeSortRecord{	
	private boolean sorted; //Indicates if the first and second half of the array have already been sorted 
	private int first;
	private int last;
	
	public mergeSortRecord(boolean s, int f, int l){
		sorted = s;
		first = f;
		last = l;
	}

	public int getfirst()   {
			return first;
	}
	
	public boolean getsorted()   {
			return sorted;
	}
	
	public int getlast()   {
			return last;
	}
	
	public void print(){
		System.out.println(sorted+" "+first+" "+last);
	}
}