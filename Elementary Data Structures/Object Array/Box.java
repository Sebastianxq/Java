public class Box {
	//Box Dimensions
	double Length = 0;
	double Width = 0;
	double Height = 0;
	double Volume = 0;
	Box() {

	}
	Box(double newLength, double newWidth, double newHeight) {

		Length = newLength;
		Width = newWidth;
		Height = newHeight;
		Volume = Length*Width*Height;
	}
	double getVolume() {
		
		return Volume;
	}
	 boolean fitsInBox(Basketball b) {
		 if (b.getDiameter() > Length || b.getDiameter() > Width || b.getDiameter() > Height){
			 return false;
		 }
		 else{
			 return true;
		 }
	}
	 
	 double emptySpace (Basketball b){
		 if (Volume-b.Volume < 0){
			 return -1.0;
		 }
		 else{
			 return (Volume - b.Volume);
		 }
	 }

}

