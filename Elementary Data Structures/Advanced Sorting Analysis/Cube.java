
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
