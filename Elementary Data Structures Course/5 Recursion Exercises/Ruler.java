//Author: Sebastian Quinones       
//Professor: Mahmud Hossain
//TAs: Jose M. Perez, Jesus Medrano
//Assignment # 5
//Purpose of program: learn how to recursively create a ruler
//Date last modified:10/13/15

public class Ruler {

	public static void main(String[] args) {
		double X=0.0, Y=0.0, W=20.0, H=10.0, MINH=2.5;
		System.out.println("Ruler info:");
		System.out.println("\t(X, Y)=("+X+", "+Y+")");
		System.out.println("\tWidth="+W+", height="+H);
		System.out.println("\tSmallest allowed height="+MINH);
		DrawRuler(X, Y, W, H, MINH);
	}
	
	//X and y are the lower left coordinate
	//w is the width and H is the height
	//Once H becomes smaller than minH the program breaks
	// uhhhhhhhhhhhhhhhhhhhhhh
	static void DrawRuler(double x, double y, double w, double h, double minH){
		//This print will probably have to be in some typa if statement 
		//Apparently nah
		System.out.println("Tick: " + w + " Tick Height: " + h);
		    if (h / 2 >= minH) {
		        if (h != x) {
		        	//w-h/2
		            DrawRuler(x+h/2 , y, w-h/2, h/2, minH);
		        }
		        //w-h/2
		        DrawRuler(x-h/2, y, w-h/2, h/2, minH);
		    }
		   //
		    System.out.println("Tick: " + w + " Tick Height: " + h);
	}
	/*drawTicks(20, 20, 20);

	public static void drawTicks(double h, double tick, double pos) {

	    System.out.println("tick: " + tick + " pos: " + pos);

	    if (tick / 2 >= 2) {

	        if (tick != h) {
	            drawTicks(h, tick / 2, pos + tick / 2);
	        }

	        drawTicks(h, tick / 2, pos - tick / 2);
	    }

	}*/
}
