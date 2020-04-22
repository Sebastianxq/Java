//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 5
//Purpose of program: learn how to recursively change a integer to it's binary form and vice versa
//Date last modified:10/13/15

public class Conversions {
	
	public static void main(String[] args) {
		int THENUMBER = 10;
		System.out.println("Binary of "+THENUMBER+" is "+
				PositiveIntegerToBinary(THENUMBER));
		
		System.out.println(" ");
		//But how to convert it into a string?
		String THEBINNUMBER
		= "1110";
		System.out.println("The Integer form of "+THEBINNUMBER+" is "+
				BinaryToInteger(THEBINNUMBER));
	}
	
	static String PositiveIntegerToBinary(int i){
		//String number  = "";
		String baseNum = "";
		if (i==0){
			System.out.println("The recursion is done or whatever");
			//return baseNum;
		}
		else{// (i>0) {
			
			 //woah mama, would a string builder be the way to go
		      StringBuilder builder = new StringBuilder();
		      builder.append(i%2);
		      
		      //This integer to string part isnt really needed
		      //keep the line until i finish tho
		      //builder.append(Integer.toString(i%2));
		      System.out.println("The string builder should read " +builder.toString());
		      baseNum = builder.toString();
		      builder.append(baseNum);
		      PositiveIntegerToBinary(i/2);
		      System.out.print(i%2 + " ");
		      
		     
		      //Does it but seperately smh
		     // number = number + Integer.toString(i%2);
		      //System.out.println("The value of number is "+ number);
		      
		      //Idea 1
		      //Append the ints to the string (BUT THATS WHAT I DID)
		      
		      //IDea 2
		      //Use string == 0 as a base case???
		    }
	
		return baseNum;
	}
	
	static int BinaryToInteger(String b){
		 int num = b.length();
		    if (num == 0) {
		    return 0;
		    }
		    String now = b.substring(0,1);
		    String later = b.substring(1);
		    return Integer.parseInt(now) * (int)Math.pow(2, num-1) + BinaryToInteger(later);     
		  }
	}

