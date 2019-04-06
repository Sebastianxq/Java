import java.util.Arrays;

public class linearProbing{	   
	//Instantiates and fills the Hashtable
	private linearSortedStringNode [] H;	
	public linearProbing(int n){	   
		H = new linearSortedStringNode[n];     
		for(int i=0;i<n;i++)         
			H[i] = null;   }

	//Sorts the word based on the character value (i.e alphabetical)
	public String sort(String word){
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		String sortedString = new String(charArray);
		return sortedString; 
	}

	//Obtains the value of the string after sorting (for hashing into the table)
	public int stringValue(String key){
		char[] charArray = key.toCharArray();
		int sum = 0;
		int unicodeValue = 0;
		for (int i = 0;i<charArray.length;i++){
			unicodeValue = ((int)charArray[i]-97);
			sum += Math.abs((unicodeValue*Math.pow(26, (charArray.length-(i+1)))));
		}
		return sum;
	}

	//Computes the load factor of the list
	public double loadFactor(){
		double load = 0;
		for (int i =0;i<H.length;i++){
			if(H[i] != null)
				load++;
		}
		load = load/H.length;
		return load;
	}

	//Resizes the array to double it's original size when called
	//WHEN IM HASHING AFTER THE INSERTION IM HASHING INTO A COMPLETELY DIFFERENT FIELD
	private linearSortedStringNode[]  resize(linearSortedStringNode[] oldNodes) {
		linearSortedStringNode[] newArray = new linearSortedStringNode[2*oldNodes.length];
		linearSortedStringNode[] test = new linearSortedStringNode[2*oldNodes.length];
		
		System.arraycopy(newArray,0,oldNodes,0,oldNodes.length); 
		System.arraycopy(oldNodes,0,test,0,oldNodes.length); 
		/*(Object src,  int srcPos, Object dest,int destPos,int length)*/
		//System.out.println("The original length is  " + oldNodes.length + " "); 
		oldNodes = newArray;
		//System.out.println("The new length is  " + oldNodes.length + " "); 
		return oldNodes;
		//return newArray;
	}
	
	//Inserts a new key into the Hashtable
	public static int resized=1;
	public void insert(String key){
		String sortedKey = sort(key);
		int pos = stringValue(sortedKey)%(H.length/resized);
		double loadFactor = loadFactor();
		//System.out.println("alwasy dividing by  "+(H.length/resized));
		if (loadFactor>=.75){ //If list is >= 75% filled, double the length
			H=resize(H);
			resized = resized*2;
		}
		for (int i = 0;i<H.length;i++){
			//System.out.println("pos is fucki "+pos);
			pos = (pos+i)%(H.length/resized);

			//Inserts a key into the position if there is no collision
			if(H[pos] == null){
				H[pos] = new linearSortedStringNode(sortedKey,H[pos]);
				H[pos].anagrams = new linearStringNode(key,H[pos].anagrams);
				break; //Stops the loop after insertion
			}
			//Inserts a string in the already found SortedString anagram location
			else if(H[pos].SortedString.equals(sortedKey)){
					H[pos].anagrams = new linearStringNode(key,H[pos].anagrams);
					break;
				}
		}

	}

	//Prints all the sorted items in a list, leaves the empty slots blank
	public void printAllSorts(){
		for (int i = 0;i<H.length;i++){
			System.out.print("for position "+i+" ");
			System.out.print(H[i].SortedString+" ");
		}
		System.out.println(" ");
	}

	//prints all the anagrams of the given word
	public void printRelatedAnagrams(String key){
		String sortedKey = sort(key);
		int pos = stringValue(sortedKey)%H.length;
		System.out.println("The anagrams of " + key + " are "); 
		for (int i = 0;i<H.length;i++){
			pos = (pos+i)%H.length;
			if (H[pos] != null){
				if (H[pos].SortedString.equals(sortedKey)){
					for (linearStringNode temp = H[pos].anagrams; temp!=null;temp = temp.next){
						System.out.print(temp.word+" ");
					}
					break;
				}
			}
		}
	}

	//Finds the anagram group with the most anagrams and returns a word from the group
	//Also returns a print statement listing the number of the anagrams and a word in the group
	public String mostAnagrams(){
		int most = 0;
		String mostWord ="";
		for (int i = 0;i<H.length;i++){
			int tempMost = 0;
			if (H[i] != null){
				for (linearStringNode wordTemp = H[i].anagrams; wordTemp!=null; wordTemp = wordTemp.next){
					tempMost++;
				}
				if (tempMost>most){
					//System.out.println("most was "+most+" and is now "+tempMost);
					most = tempMost;
					mostWord = H[i].anagrams.word;
				}
			}

		}
		System.out.println(mostWord+" has the most anagrams at "+ most+" total anagrams");
		return mostWord;
	}
}
