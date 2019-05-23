public class Basketball {
	//BB dimensions
	double Radius = 0;
	double Volume = 0;
	double Diameter = Radius*2;
	//
	Basketball() {

	}
	Basketball(double newRadius) {
		Radius = newRadius;
		Volume = Radius*Radius*22/7;
		Diameter = Radius*2;
	}
	
	double getDiameter(){
	 return Radius*2;
	}
	
	double getVolume() {
		return Radius * Radius * 3.14159;
		//return Volume;
	}

}
