//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 5
//Purpose of program: learn how to recursively predict the time needed for a monkey to climb a cool pole
//Date last modified:10/13/15

public class ClimbingMonkey {
	//Initalizes the totalTime variable
	static double totalTime;
	public static void main(String[] args) {
		double PHeight = 100.0;
		System.out.println("Pole height: "+PHeight+ " feet");
		System.out.println("Climbing time: "+climbTime(PHeight)+ " minutes");
	}

	//Method for moving the monkey up the pole (not an euphemism)
	static double climbTime(double poleHeight){
		double tempHeight = poleHeight;

		//Base Case
		//MAMA I THINK I GOT IT
		if (poleHeight <= 10)
			//Adds the remaining time based on the pole's remaining length
			return poleHeight;

		return climbTime(tempHeight-7) + 20;
	}

}
