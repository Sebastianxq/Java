
public class CubeNode {
	
	//Probably wont be needing this
	CubeNode head;
	double Length;
	double Width;
	double Height;
	
	//Actually they technically say i only need to create a linked list so cant i just use this?
	//LinkedList<CUbeNode> linkedlist = new LinkedList<CubeNode>();
	//I.e a linked list with generics that has a chance of making my life a whole lot easier.
	//LinkedList<String> linkedlist = new LinkedList<String>();
	
	
	public CubeNode(){
		
	}
	
	public CubeNode(double newLength,double newWidth,double newHeight) {
		head = null;
		Length = newLength;
		Width = newWidth;
		Height = newHeight;
	}
	
	public int Volume(int Length, int Width, int Height){
		return Length*Width*Height;
	}
	

}
