import java.util.*;
public class main {

	//Creates a linked list with a item value between 0 and m
	public static iNode createList(int n, int m){
		//create list here using an rng
		iNode newList = new iNode(null);
		Random randomGenerator = new Random();
		for (int i = 0; i<n;i++){
			newList = new iNode(randomGenerator.nextInt(m), newList);
		}
		return newList;

	}

	public static iNode mergeSort(iNode llist) {
		//base case
		if(llist == null || llist.next == null) {
			return llist; 
		}
		//sets the middle node for the first half
		iNode middle = findMiddle(llist);
		//sets the middle node for the next half
		iNode sHalf = middle.next; 
		//Separates the list
		middle.next = null;

		//recursive call
		return merge(mergeSort(llist),mergeSort(sHalf));
	}

	//merges both lists
	public static iNode merge(iNode left, iNode right) {
		iNode current;
		iNode temp = new iNode(null);
		current = temp;
		while(left !=null && right!= null) {
			if(left.item <= right.item) { 
				current.next = left; 
				left = left.next; 
			}
			else { 
				current.next = right; 
				right = right.next; 
			}
			current = current.next;
		}
		if (left == null){
			current.next = right;
		}
		else{
			current.next = left;
		}
		return temp.next;
	}

	//finds the middle to continue the division in the recursive call
	public static iNode findMiddle(iNode current) {
		//Base case
		if(current == null) { 
			return current;
		}

		iNode slow; 
		iNode fast = current; 
		slow = fast;
		//finds the middle by having fast increment at double the speed of slow
		//ends when fast reaches the end and slow reached the middle
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next; 
			fast = fast.next.next;
		}
		return slow;
	}


	//Iterative mergesort source from Olac Fuentes,  revisions unfinished
	public static void iterativeMerge(iNode A, int first, int last){
		// Preconditions: A[first ... mid] and A[mid+1 ... last] are sorted
		// Postcondition: A[first ... last] is sorted 

		//Take in a list and work the magic from there?
		int [] temp = new int[last-first+1];
		iNode iNodeTemp = new iNode(null);
		if (first<last){
			int i1 = first;

			int mid = (first+last)/2;
			int i2 = mid+1;

			//for(int i=0;i< temp.length;i++){
			/*for (;A!=null;A=A.next){
					iNodeTemp = A;
					for (;A!=null; A=A.next){
						if (A.item>iNodeTemp.item){
							A.item = iNodeTemp.item;
						}
					}
				}*/
			for (int i=0;i<last-first+1;i++){
				if (i1>mid){
					//temp[i]= A[i2];
					//temp(A[i2],temp);
					//Create some list add here
					i2++;
				}				
				else 
					if (i2>last){
						//temp[i]= A[i1];
						//list add here
						i1++;
					}
					else
						//if (A[i1]<A[i2]){
						//temp[i]= A[i1];
						//list add here
						i1++;
			}
			//else{
			//temp[i]= A[i2];
			//list add here
			i2++;
		}
	}

	//Part 2 of the nonrecursive mergesort using stacks
	public static void iterativeMergesort(iNode A, int length){
		Stack<mergeSortRecord> stack=new Stack();
		mergeSortRecord m = new mergeSortRecord(false,0,length);
		stack.push(m);
		while (!stack.empty()){
			//Debugging code 
			//System.out.println("Stack size is: " + stack.size());
			//System.out.print("Top of stack is: ");
			stack.peek().print();

			m=stack.pop();
			//m.print(); for debugging purposes
			if (m.getsorted()){//If first and second halves of array have been sorted, merge them
				//turn a into a link list
				iterativeMerge(A,m.getfirst(),m.getlast());
			}
			else{
				if (m.getfirst()<m.getlast()){
					int mid = (m.getfirst()+m.getlast())/2;
					stack.push(new mergeSortRecord(true,m.getfirst(),m.getlast()));
					stack.push(new mergeSortRecord(false,m.getfirst(),mid));
					stack.push(new mergeSortRecord(false,mid+1,m.getlast()));
				}
			}
			System.out.print("Current array is: ");
			printList(A); //for debugging purposes	
			System.out.println();
		}
	}

	//prints the contents of a a listmainList
	public static void printList(iNode x){
		for(;x!=null;x=x.next)
			System.out.print(x.item+" ");
		System.out.println();
	}

	public static void main(String[] args) {
		try{
		System.out.println("What size would you like the linked list to be?");
		Scanner scnr = new Scanner(System.in);
		int length = scnr.nextInt();
		System.out.println("What size do you want m to be?");
		int item = scnr.nextInt();
		iNode mainList = createList(length,item);
		System.out.println("The list before sorting is:");
		printList(mainList);

		System.out.println("The list after sorting is:");
		mainList = mergeSort(mainList);
		printList(mainList);
		}

		catch(InputMismatchException e){
			System.out.println("Your input was not an integer, please restart the program");
		}
	}

}
