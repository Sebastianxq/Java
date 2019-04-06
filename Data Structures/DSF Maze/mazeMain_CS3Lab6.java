/************************************************************
 * Author: Sebastian Quinones
 * Date Last Modified: 04/03/2017
 * Purpose: To understand the properties of a disjoint set and understand how the 
 * different methods of union (standard, by height, by size and with compression)
 *  affect the efficiency of merging sets.
 */
import java.util.*;
public class main {

	public static void createMaze(maze Maze,dsf dsfMaze, int nSize, int unionType){
		Random rand = new Random();
		int totalSets = nSize*nSize;

		//Repeats until there is no longer multiple sets
		while(totalSets>1){
			//RNGs for x location, y location and wallSelection
			int x = rand.nextInt(nSize);
			int y = rand.nextInt(nSize);
			int wallChoice = rand.nextInt(2)+1;

			int numCell = x+nSize*y; //Creates the first cell's location
			int CellToMerge = 0;     //Instantiates the second cell's location
			//StdDraw.text(x+.5,y+.5,Integer.toString(x+nSize*y)); 

			//Conditional statement for wall removal
			if (wallChoice == 1){

				CellToMerge = x+nSize*(y+1); //creates the second cell's location

				//Conditional Statement that prevents out of bounds and prevents repeated insertions
				if ((CellToMerge<nSize*nSize) && !dsfMaze.inSameSet(numCell, CellToMerge)){

					//If wall is removed, continue with union
					if (!Maze.remove_wall(x,y,'U')){

						if (unionType == 1){
							dsfMaze.union(numCell, CellToMerge); 
						}
						else if (unionType == 2)
							dsfMaze.union_C(numCell, CellToMerge); 
						else if (unionType == 3)
							dsfMaze.unionByHeight(numCell, CellToMerge);
						else if (unionType == 4)
							dsfMaze.unionBySize(numCell, CellToMerge);
						else if (unionType == 5) 
							dsfMaze.unionBySize_C(numCell, CellToMerge); 
						totalSets--;
					}
				}

			}
			else{
				CellToMerge = (x+1)+nSize*y; 
				if ((CellToMerge<nSize*nSize) && (!dsfMaze.inSameSet(numCell, CellToMerge))){
					if (!Maze.remove_wall(x,y,'R')){

						if (unionType == 1){
							dsfMaze.union(numCell, CellToMerge); 
						}
						else if (unionType == 2)
							dsfMaze.union_C(numCell, CellToMerge); 
						else if (unionType == 3)
							dsfMaze.unionByHeight(numCell, CellToMerge);
						else if (unionType == 4)
							dsfMaze.unionBySize(numCell, CellToMerge);
						else if (unionType == 5) 
							dsfMaze.unionBySize_C(numCell, CellToMerge); 
						totalSets--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);

			//N selection and input corrrections
			System.out.println("What n would you like the maze to be? (nxn maze)");
			int n = sc.nextInt();
			if (n<=0){
				System.out.print("your n value cannot be less than one, defaulting size to one. ");
				n=1;
			}
			System.out.println("What type of union would you like to do?");
			System.out.println("1.Union");
			System.out.println("2.) Union With Compression");
			System.out.println("3.)Union by Height");
			System.out.println("4.) Union By Size ");
			System.out.println("5.) Union By Size With Compression");

			//UnionType Selection and input corrections
			int unionType = sc.nextInt();
			if (unionType >5||unionType<1){
				System.out.println("Your union Selection was invalid so it will be defaulted to standard union");
				unionType = 1;
			}

			maze Maze = new maze(n);
			dsf dsfMaze = new dsf(n*n);


			dsfMaze.print();
			//long startTimeChain = System.currentTimeMillis();
			long startTimeCreate = System.currentTimeMillis();
			createMaze(Maze,dsfMaze,n, unionType);
			long endTimeCreate =System.currentTimeMillis();
			long durationCreate =endTimeCreate-startTimeCreate;
			dsfMaze.print();
			Maze.draw();
			System.out.println("The number of find calls is "+ dsfMaze.numFindCalls()+" and took "+durationCreate+" milliseconds");
		}
		catch (InputMismatchException a) {
			System.out.print("You entered an incorrect input, please restart");
		}
	}

}