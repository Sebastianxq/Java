import java.util.*;

/**************************************************************************************
 *Programmed by: Sebastian Quinones                           						 **
 *Last modified: 02/8/2017 															 **
 *                                                                           		 **
 *Program description: Create a program that allows users to input variables related **
 * to algorithm analysis and receive the end result, be it input size, 				 **
 * execution time or even runtime                                                    **
 * 																			         **
 *Purpose: Better how the algorithms work when by programming it inside and out		 **
 *     and putting the methods through a variety of different and unique tests		 **
 * 	     											             				     **
 **************************************************************************************/

public class main {
	//Calculates Tn1 when all other variables are given
	public static void Tn1Finder(int n0, int n1, double Tn0, int FnChoice){
		//creates variables and changes variable types for easier conversion later on
		double solution, calcn0, calcn1, dn0, dn1;
		dn0 = (double)n0;
		dn1 = (double)n1;
		
		//Creates calculations based off the user's selected running time
		switch (FnChoice){
		case 1:
			//LogN Case
			calcn0 = Math.log(dn0)/Math.log(2);
			calcn1 = Math.log(dn1)/Math.log(2);
			solution = (calcn1/calcn0)*Tn0;
			System.out.println("If a O(logn) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		case 2:
			//N Case
			solution = ((double)(dn1/dn0))*Tn0;
			System.out.println("If a O(n) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		case 3:
			//N*logN Case
			calcn0 = Math.log(dn0)/Math.log(2);
			calcn1 = Math.log(dn1)/Math.log(2);
			solution = ((calcn1*n1)/(calcn0*n0))*Tn0;
			System.out.println("If a O(nlogn) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		case 4:
			//N^2 Case
			solution = ((double)(Math.pow(n1, 2)/Math.pow(n0, 2)))*Tn0;
			System.out.println("If a O(n^2) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		case 5:
			//N^3 Case
			solution = ((double)(Math.pow(n1, 3)/Math.pow(n0, 3)))*Tn0;
			System.out.println("If a O(n^3) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		case 6:
			//2^N Case
			solution = ((double)(Math.pow(2, n1)/Math.pow(2, n0)))*Tn0;
			System.out.println("If a O(2^n) method takes "+ Tn0+ " second(s) to run for an input of size "+n0+" it will take "
					+ solution+ " second(s) to run for an input that is of size "+n1);
			break;
		default:
			System.out.println("That was not a valid option, please restart");
			break;
		}
	}

	//Calculates n1 when every other variable is given
	public static void n1Finder(int n0, double Tn0, double Tn1, int FnChoice){
		double calcn0, logPower, logTn, n0Pow;
		int solution;
		
		//Selects calculations based off user's Big-O choice
		//Cast on the final solution to round off to a whole number
		switch (FnChoice){
		case 1:
			//LogN Case
			calcn0 = Math.log(n0)/Math.log(2);
			logPower = ((Tn1/Tn0)*calcn0);
			solution = (int)Math.pow(2, logPower);
			System.out.println("If a O(log n) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		case 2:
			//N Case
			solution = (int)(Tn1/Tn0)* n0;
			System.out.println("If a O(n) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		case 3:
			//NlogN case
			solution = 0;
			n0Pow = Math.pow(n0, n0);
			calcn0 = Math.log(n0Pow)/Math.log(2);
			//Adds 1 to "N1" until it surpasses the number it needs to
			while (solution <= (Math.pow(2,((Tn1)/(Tn0)*calcn0)))){
				solution++;
			}
			//Then subtracts 1 to find the highest N1 possible
			solution--;
			System.out.println("If a O(NLogN) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		case 4:
			//n^2 case
			solution = (int) Math.sqrt((Tn1/Tn0)*Math.pow(n0, 2));
			System.out.println("If a O(N^2) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		case 5:
			//n^3 case
			solution = (int) Math.pow(((Tn1/Tn0)*Math.pow(n0, 2)),(1/3));
			System.out.println("If a O(N^3) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		case 6:
			//2^n case
			calcn0 = Math.log(n0)/Math.log(2);
			logTn = Math.log(Tn1/Tn0)/Math.log(2);
			solution = (int) (logTn + Math.log(calcn0));
			System.out.println("If a O(2^N) method takes "+Tn0+" seconds to run for an input of size "+
					n0+ " the largest problem it can solve in "+Tn1+ " seconds is " +solution);
			break;
		default:
			System.out.println("That was not a valid option, please restart");
			break;
		}
	}

	public static void fnFinder(int n0, int n1, double Tn0, double Tn1){
		//Creates variables and proper conversions to use later in this method
		double nCalc = (double)n0/n1;
		double TnCalc = Tn0/Tn1;
		double TnPow = Math.pow(TnCalc,  TnCalc);
		//LogN Case
		if (nCalc == (Math.log(TnCalc)/Math.log(2))){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(logN)");
		}
		//N Case
		else if (nCalc == TnCalc){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(N)");
		}
		//NLogN Case
		else if (nCalc == (Math.log(TnPow)/Math.log(2)) ){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(NLogN)");
		}
		//N^2 Case
		else if (nCalc == Math.pow(TnCalc, 2)){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(N^2)");
		}
		//N^3 Case
		else if (nCalc == Math.pow(TnCalc, 3)){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(N^3)");
		}
		//2^N Case
		else if (nCalc == Math.pow(2, TnCalc)){
			System.out.println("If a method takes "+Tn0+" second(s) to run for an input of size "+n0+" and "+
					Tn1+ " second(s) for an input of size "+n1+ " its running time is O(2^N)");
		}
		else{
			System.out.println("That combination of values was not a running time recognized, please try again");
		}
	}

	//Employs master method to find the running time
	public static void masterfnFinder(int a, int b, int k){
		double power;
		//if A < B^K
		if (a < (int)Math.pow(b, k)){
			System.out.println("A recursive program with running time described by recurrent T(n) = "+a+"T(n/"+b+") +" +" n^"+k+" and has a running time of "
					+" T(n) = O(n^"+k+")");
		}
		//if A == B^K
		else if (a == (int)Math.pow(b, k)){
			System.out.println("A recursive program with running time described by recurrent T(n) = "+a+"T(n/"+b+") +" +" n^"+k+" and has a running time of "
					+" T(n) = O(n^"+k+"*logn)");
		}
		//If A > B^K
		else{
			power = (Math.log((a))/Math.log((b)));
			System.out.println("A recursive program with running time described by recurrent T(n) = "+a+"T(n/"+b+") +" +" n^"+k+" and has a running time of "
					+" T(n) = O(n^"+power+")");
		}
	}

	//Asks the user for the Fn and then returns a value relevant that other methods use to correctly employ running time
	public static int selectFn(){
		Scanner scnr = new Scanner(System.in);
		int choice;
		System.out.print("Select the f(n) "+System.lineSeparator()
		+"1.) log n"
		+System.lineSeparator()
		+"2.) n"
		+System.lineSeparator()
		+"3.) n*log n"+
		System.lineSeparator()
		+"4.) n^2"
		+System.lineSeparator()
		+"5.) n^3"
		+System.lineSeparator()
		+"6.) 2^n");
		choice = scnr.nextInt();
		System.out.println("selection: "+ choice);
		return choice;
	}

	public static void main(String[] args) {
		//Try and Catch put in place to account for Input Mismatches
		try{
			int option;
			int n0 = 0, n1 = 0, fn = 0, a = 0, b = 0, k = 0;
			double Tn0 = 0, Tn1 = 0;
			Scanner scnr = new Scanner(System.in);

			
			
			System.out.print("Please select an option "
					+System.lineSeparator()
					+"NOTE: Please give your T(n) times in seconds"
					+System.lineSeparator()
					+ "1.) Given n0, n1, T(n0), and f(n), computer T(n1)"
					+System.lineSeparator()
					+ "2.) Given n0, Tn(n0), Tn(1) and f(n) find n1"
					+System.lineSeparator()
					+ "3.) Given n0, n1, T(n0), and T(n1), find f(n)"
					+System.lineSeparator()
					+ "4.) Given a, b, and k, find f(n)"
					+System.lineSeparator()
					+ "5.) Quit"
					+System.lineSeparator());
			option = scnr.nextInt();
			//Runs the appropriate method based on the users selection
			switch (option){
			case 1:
				System.out.println("Selection: "+ option);
				System.out.println("Enter the values for n0, n1, T(n0) "+
						"(In that order please)");
				n0 = scnr.nextInt();
				n1 = scnr.nextInt();
				Tn0 = scnr.nextDouble();
				fn = selectFn();
				Tn1Finder(n0,n1,Tn0,fn);
				break;
			case 2:
				System.out.println("Selection: "+ option);
				System.out.println("Enter the values for n0, T(n0), T(n1) "+
						"(In that order please)");
				n0 = scnr.nextInt();
				Tn0 = scnr.nextDouble();
				Tn1 = scnr.nextDouble();
				fn = selectFn();
				n1Finder(n0, Tn0, Tn1, fn);
				break;
			case 3:
				System.out.println("Selection: "+ option);
				System.out.println("Please enter the values for n0,n1,Tn0,and Tn1 "+
						"(In that order please)");
				n0 = scnr.nextInt();
				n1 = scnr.nextInt();
				Tn0 = scnr.nextDouble();
				Tn1 = scnr.nextDouble();
				fnFinder(n0,n1,Tn0,Tn1);
				break;
			case 4:
				System.out.println("Selection: "+ option);
				System.out.println("Enter the values for A, B and K, respectively");
				a = scnr.nextInt();
				b = scnr.nextInt();
				k = scnr.nextInt();
				masterfnFinder(a,b,k);
				break;
			case 5:
				System.out.println("Selection: "+ option);
				System.out.println("See ya next time!");
				break;
			default:
				System.out.println("Selection: "+ option);
				System.out.println("You selected an option that was not available, please restart");
			}
		}
		catch (InputMismatchException e){
			System.out.println("There was an error in your selection, please restart the program");
		}

	}

}
