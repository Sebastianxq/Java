/********************************************************
 ** Simple Program to implement insertions              **
 ** and traversals on B-trees                           **
 ** This file includes basic operations on B-tree nodes **
 ** Programmed by Olac Fuentes                          **
 ** Last modified February 21, 2017                     **
 ** Report bugs to me                                   **
 *********************************************************/
public class BTreeNode{
	private int t;         // BTree parameter, each node has at least t-1 and at most 2t-1 keys
	public int n;          // Actual number of keys on the node
	public boolean isLeaf; // Boolean indicator 
	public String[] key;      // Keys stored in the node. They are sorted ion ascending order
	public BTreeNode[] c;  // Children of node. Keys in c[i] are less than key[i] (if it exists) 
	// and greater than key[i+1] if it exists

	public  BTreeNode(int t){  // Build empty node
		this.t = t;                   
		isLeaf = true;
		key = new String[2*t-1];   // Array sizes are set to maximum possible value
		c = new BTreeNode[2*t];
		n=0;	                  // Number of elements is zero, since node is empty
	}

	public boolean isFull(){
		return n==(2*t-1);
	}

	public void insert(String newKey){
		// Insert new key to current node
		// We make sure that the current node is not full by checking and
		// splitting if necessary before descending to node

		//System.out.println("inserting " + newKey); // Debugging code
		int i=n-1;
		if (isLeaf){
			while ((i>=0) && key[i].compareTo(newKey) > 0){
				key[i+1] = key[i];             
				i--;
			}
			n++;                    // Update number of keys in node
			key[i+1]=newKey;        // Insert new key
		}
		else{
			while ((i>=0) && key[i].compareTo(newKey) > 0){
				i--;
			}
			int insertChild = i+1;  // Subtree where new key must be inserted
			if (c[insertChild].isFull()){
				// The root of the subtree where new key will be inserted has to be split
				// We promote the median of that root to the current node and
				// update keys and references accordingly

				//DEBUGGING CODE FOR PRINTS
				//System.out.println("This is the full node we're going to break ");				
				//c[insertChild].printNodes();
				//System.out.println("going to promote " + c[insertChild].key[n-1]);
				n++;
				c[n]=c[n-1];
				for(int j = n-1;j>insertChild;j--){
					c[j] =c[j-1];
					key[j] = key[j-1];
				}
				key[insertChild]= c[insertChild].key[t-1];
				c[insertChild].n = t-1;

				BTreeNode newNode = new BTreeNode(t);
				for(int k=0;k<t-1;k++){
					newNode.c[k] = c[insertChild].c[k+t];
					newNode.key[k] = c[insertChild].key[k+t];
				}

				newNode.c[t-1] = c[insertChild].c[2*t-1];
				newNode.n=t-1;
				newNode.isLeaf = c[insertChild].isLeaf;
				c[insertChild+1]=newNode;

				if (key[insertChild].compareTo(newKey) > 0){
					c[insertChild].insert(newKey);					}
				else{
					c[insertChild+1].insert(newKey);				}
			}
			else
				c[insertChild].insert(newKey);  //No need to split node
		}
	}

	public void print(){
		//Prints all keys in the tree in ascending order
		if (isLeaf){
			for(int i =0; i<n;i++)
				System.out.print(key[i]+" ");
			System.out.println();
		}
		else{
			for(int i =0; i<n;i++){
				c[i].print();
				System.out.print(key[i]+" ");
			}
			c[n].print();
		}
	}


	public void printNodes(){
		//Prints all keys in the tree, node by node, using preorder
		//It also prints the indicator of whether a node is a leaf
		//Used mostly for debugging purposes
		for(int i =0; i<n;i++)
			System.out.print(key[i]+" ");
		System.out.println(isLeaf);
		if (!isLeaf){
			for(int i =0; i<=n;i++){
				c[i].printNodes();
			}
		}
	}

	public void printDepthD(int d){
		//Prints all keys in the tree in ascending order
		//Check to make sure d is decreasing
		if (d == 0 || isLeaf){
			for(int i =0; i<n;i++)
				System.out.print(key[i]+" ");
			System.out.println();
		}
		else{
			//check to make sure n is valid
			for(int i = 0; i<n;i++){
				c[i].printDepthD(d-1);
				System.out.print(key[i]+" ");
			}
			c[n].printDepthD(d-1);
		}
	}

	//Sequential search for String k
	boolean search_sequential(BTreeNode T, String k){
		int i = find_i_sequential(T,k);
		if ((i==T.n) || (T.key[i].compareTo(k) > 0)){
			if (T.isLeaf){
				return false;
			}
			else {     
				return search_sequential(T.c[i],k);
			}
		}
		return true; // k == T.key[i]
	}

	//finds the position of i, needed for child search or key confirmation
	int find_i_sequential(BTreeNode T,String k) {
		int i=0;
		while((i<T.n && T.key[i].compareTo(k) < 0)){
			i++;
		}
		return i;
	}

	//Search through tree in logarithmic time
	boolean search_binary(BTreeNode T, String k){
		int i = find_i_binary(k,T);
		if ((i==T.n)|| (T.key[i].compareTo(k) > 0)){
			if (T.isLeaf)
				return false;
			else         
				return search_binary(T.c[i],k);
		}
		return true; // k == T.key[i]
	}

	int find_i_binary(String k, BTreeNode t3){
		int low = 0;
		int high = t3.n-1;
		while (high >= low){
			int middle = (low+high)/2;
			if (t3.key[middle].equals(k)){
				return middle;
			}
			if (t3.key[middle].compareTo(k) < 0){
				low = middle+1;
			}
			if (t3.key[middle].compareTo(k) > 0){
				high = middle -1;
			}
		}
		return low;
	}

}