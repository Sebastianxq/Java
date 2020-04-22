//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 7
//Purpose of program: Learn how to use the bubble and selection sort methods in a completely realistic scenario and also reinforce our knowledge of runtimes
//Date last modified:10/22/15

public class Cube {
	
	double Length = 0;
	double Width = 0;
	double Height = 0;
	double Volume = 0;
	
	Cube(){
		
	}
	
	Cube(double newLength, double newWidth, double newHeight){
		Length = newLength;
		Width = newWidth;
		Height = newHeight;
		Volume = Length*Width*Height;
	}
	
	double returnVol(){
		return Volume;
	}
}
