/*************************************************************************
Code to generate and draw a maze to be used as starting point for lab 6
Some code borrowed from http://introcs.cs.princeton.edu and 
Programmed by Olac Fuentes
Last modified March 23, 2017
 **************************************************************************/
import java.util.*;
public class maze {
	private int N;                  // dimension of maze
	private boolean[][] v_wall;     
	private boolean[][] h_wall;

	public maze(int N) {
		this.N = N;
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N);
		init();
	}

	private void init() {
		// initialze all walls as present
		// Vertical wall v_wall[x][y] separates cells (x + N*y) and (x + N*y + 1)
		// Horizontal wall h_wall[x][y] separates cells (x + N*y) and (x + N*(y + 1))

		h_wall = new boolean[N][N-1];        
		v_wall = new boolean[N-1][N];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < N-1; j++)
				v_wall[j][i] = h_wall[i][j] = true;
	}
	//Should I modify to return a boolean
	//And then based on that boolean, if a wall is removed then union?
	//ORIGINAL
	/*public void remove_wall(int x, int y, char d){
    // Notice x is the column and y is the row (opposite of usual indexing)
      if ((d=='U') && (y<N-1)) //Do not remove walls at the top
 	      h_wall[x][y] = false;
	   if ((d=='R') && (x<N-1)) //Do not remove rightmost walls
	      v_wall[x][y] = false;
	 }*/
	public boolean remove_wall(int x, int y, char d){
		// Notice x is the column and y is the row (opposite of usual indexing)
		if ((d=='U') && (y<N-1)){ //Do not remove walls at the top
			h_wall[x][y] = false;
			return false;
		}
		if ((d=='R') && (x<N-1)) {//Do not remove rightmost walls
			v_wall[x][y] = false;
			return false;
		}
		return true;
	}

	public void printCellNumbers() { 
		StdDraw.setPenColor(StdDraw.BLUE);
		for (int x = 0; x < N; x++){
			for (int y = 0; y < N; y++){
				//Use this to connect the dsf with the maze???
				StdDraw.text(x+.5,y+.5,Integer.toString(x+N*y));    
			}
		}
		StdDraw.show(0);
	} 


	public void draw() {
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledCircle(.5, .5, 0.375);
		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.filledCircle(N-0.5, N-0.5, 0.375);

		//Draw Periphery. 
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(0, 0, N, 0); 
		StdDraw.line(N, 0, N, N); 
		StdDraw.line(N, N, 0, N);          
		StdDraw.line(0, N, 0, 0); 

		// Draw remaining walls
		for (int x = 0; x < N; x++)
			for (int y = 0; y < N-1; y++)
				if (h_wall[x][y]) StdDraw.line(x, y+1, x+1, y+1);      
		for (int x = 0; x < N-1; x++)
			for (int y = 0; y < N; y++)
				if (v_wall[x][y]) StdDraw.line(x+1, y, x+1, y+1);
		StdDraw.show(0);
	}

}