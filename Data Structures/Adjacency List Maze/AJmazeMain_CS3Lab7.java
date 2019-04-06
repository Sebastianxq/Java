/************************************************************
 * Author: Sebastian Quinones
 * Date Last Modified: 04/13/2017
 * Purpose: To understand how graphs are represented in a data structure
 * and better visualize how efficiency algorithms, like Breadth-first and Depth-first
 * traverse a data structure to find the best path.
 */
import java.util.*;
public class main {

	//Prints the adjacency list
	public static void printList (gNode[] adjacencyList){
		for (int i = 0;i<adjacencyList.length;i++){
			System.out.print(i+" - ");
			for (gNode temp = adjacencyList[i];temp!=null;temp=temp.next){
				System.out.print( temp.dest+"  ");
			}
			System.out.println(" ");
		}
	}

	//Prints and fills in the path obtained from one of the search algorithms
	public static void printPath(int[] adjacencyList, int n){
		StdDraw.setPenColor(StdDraw.ORANGE);
		for (int i=0;i<adjacencyList.length;i++){
			if (adjacencyList[i]>=0){
				System.out.print(adjacencyList[i]+" ");

				//Finds the location of the given value on the graphical maze and draws a orange circle in it
				int x = adjacencyList[i]%n;
				int y = (adjacencyList[i]-x)/n;
				StdDraw.filledCircle(x+.5, y+.5, 0.375);
			}
		}
	}

	//Standard Breadth first search algorithm
	public static int[] breadthFirstSearch(gNode[] g, int v){
		boolean[] visited = new boolean [g.length];
		for (int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		int[] path = new int[g.length];
		for (int i=0;i<path.length;i++){
			path[i] = -1;
		}
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(v);
		while(!Q.isEmpty()){
			int u = Q.remove();
			for (gNode t = g[u];t!=null;t=t.next){
				if (!visited[t.dest]){
					visited[t.dest] = true;
					path[t.dest] = u;
					Q.add(t.dest);
				}
			}
		}
		return path;
	}

	//Standard Depth first algorithm with stacks
	public static int[] StackDepthFirst(gNode[] adjacencyList, int vertex){
		Stack<Integer> DepthStack = new Stack<Integer>();
		boolean[] visited = new boolean [adjacencyList.length];
		for (int i=0;i<visited.length;i++){
			visited[i] = false;
		}
		int[] path = new int[adjacencyList.length];
		for (int i=0;i<path.length;i++){
			path[i] = -1;
		}
		visited[vertex] = true;
		DepthStack.push(vertex);
		while(!DepthStack.isEmpty()){
			int u = DepthStack.peek();
			DepthStack.pop();
			for (gNode t = adjacencyList[u];t!=null;t=t.next){
				//System.out.println("when will it end");
				if (!visited[t.dest]){
					visited[t.dest] = true;
					path[t.dest] = u;
					DepthStack.add(t.dest);
				}
			}
		}
		return path;	
	}

	//Standard Recursive Depth First algorithm
	static void RecursiveDepthFirst(gNode[] adjacencyList, int vertex, int n){
		StdDraw.setPenColor(StdDraw.ORANGE);
		boolean[] visited = new boolean [adjacencyList.length];
		int[] path = new int[adjacencyList.length];
		visited[vertex] = true;
		System.out.print(vertex+" ");
		for (gNode temp = adjacencyList[vertex];temp!=null;temp=temp.next){
			if (!visited[temp.dest]){
				//System.out.println("vertex is currently "+vertex);
				path[temp.dest] = vertex;
				int x = adjacencyList[vertex].dest%n;
				int y = (adjacencyList[vertex].dest-x)/n;
				StdDraw.filledCircle(x+.5, y+.5, 0.375);
				RecursiveDepthFirst(adjacencyList,temp.dest, n);
			}
		}
		//return path;
	}

	//Check to see if the selected cells are already in the same list
	public static boolean inSameSet(int numCell,int CellToMerge,gNode[] adjacencyList){
		for (gNode temp = adjacencyList[numCell];temp!=null;temp=temp.next){
			if (temp.dest==CellToMerge)
				return true;
		}
		return false;
	}

	//Creates the maze
	public static void createMaze(maze Maze,gNode[] adjacencyList, int nSize){
		//Initializes placeholder and verification variables
		Random rand = new Random();
		int totalSets = nSize*nSize;
		boolean[] checked = new boolean[totalSets];
		for (int i = 0;i< totalSets;i++){
			checked[i] = false;
		}

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

				//As long as the cell sizes fall in the given range, are not together, and havent been checked before, continue
				if ((CellToMerge<nSize*nSize) && !(inSameSet(numCell,CellToMerge,adjacencyList)) && !checked[numCell] ){

					//If wall is removed, add to the adjacency list
					if (!Maze.remove_wall(x,y,'U')){

						//Debugging code
						//System.out.println("removing upper walls and combining cells"+numCell+" and "+CellToMerge);
						adjacencyList[numCell]= new gNode(CellToMerge,adjacencyList[numCell]);
						checked[numCell]=true;
						totalSets--;
					}
				}

			}
			else{
				CellToMerge = (x+1)+nSize*y; 
				if ((CellToMerge<nSize*nSize) && !(inSameSet(numCell,CellToMerge,adjacencyList)) && !checked[numCell] ){
					if (!Maze.remove_wall(x,y,'R')){

						//Debugging Code
						//System.out.println("removing right wall and combining cells"+numCell+" and "+CellToMerge );

						adjacencyList[numCell]= new gNode(CellToMerge,adjacencyList[numCell]);
						checked[numCell]=true;
						totalSets--;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			//N selection and input questions and corrrections
			System.out.println("What n would you like the maze to be? (nxn maze)");
			int n =sc.nextInt();
			if (n<=0){
				System.out.print("your n value cannot be less than one, defaulting size to one. ");
				n=1;
			}
			System.out.println("What type of search algorithm would you like to use?");
			System.out.println("1. Breadth First Path");
			System.out.println("2. Depth First Path (using recursion)");
			System.out.println("3. Depth First Path(using stacks)");
			int pathFinder = sc.nextInt();

			//Initializes all the variables and structures needed
			gNode[] adjacencyList = new gNode[n*n];
			for (int i = 0;i<n;i++) 
				adjacencyList[i] = null;
			int[] breadthPath =new int[adjacencyList.length];
			int[] SPath = new int[adjacencyList.length];
			maze Maze = new maze(n);

			//fills adjacency list and creates maze, records the time it took as well
			long startTimeCreate = System.currentTimeMillis();
			createMaze(Maze,adjacencyList,n);
			long endTimeCreate =System.currentTimeMillis();
			long durationCreate =endTimeCreate-startTimeCreate;
			System.out.println("Took "+durationCreate+" milliseconds");

			//Prints adjacencyList for debugging purposes
			//printList(adjacencyList);

			//Selects which path finding algorithm will be used
			//Use 3,8,16,64,256,1024
			switch(pathFinder){
			case 1:
				System.out.println("Using breadth first search, the path is ");
				long startTimeDepth = System.nanoTime();
				breadthPath=breadthFirstSearch(adjacencyList,0);
				long endTimeDepth =System.nanoTime();
				long durationDepth =endTimeDepth-startTimeDepth;
				printPath(breadthPath,n);System.out.print(n*n-1);
				System.out.println(" ");
				System.out.println("Finding the path with BFS took "+durationDepth+" nanoseconds");
				Maze.draw();
				break;

			case 2:
				System.out.println("Using Recursive Depth first search, the path is ");
				long startTimeRecursive = System.currentTimeMillis();
				RecursiveDepthFirst(adjacencyList,0, n);
				long endTimeRecursive =System.currentTimeMillis();
				long durationRecursive =endTimeRecursive-startTimeRecursive;
				System.out.println(" ");
				System.out.println("Finding the path with Recursive DFS took "+durationRecursive+" milliseconds");
				Maze.draw();
				break;

			case 3:
				System.out.println("Using Stacks Depth first search, the path is ");
				long startTimeStack = System.nanoTime();
				SPath=StackDepthFirst(adjacencyList,0);
				long endTimeStack =System.nanoTime();
				long durationStack =endTimeStack-startTimeStack;
				printPath(SPath,n); System.out.print(n*n-1);
				System.out.println(" ");
				System.out.println("Finding the path using DFS with Stacks took "+durationStack+" nanoseconds");
				Maze.draw();
				break;

			default:
				Maze.draw();
				System.out.println("That was an invalid choice, please restart");
				break;
			}
		sc.close();
		}
		catch (InputMismatchException a) {
			System.out.print("You entered an incorrect input, please restart");
		}
	}

}