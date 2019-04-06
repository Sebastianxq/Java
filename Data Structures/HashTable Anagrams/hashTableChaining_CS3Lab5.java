import java.util.Arrays;

public class hashTableChaining{	 
	//Initializes the hashTable
	private sortedStringNode [] H;	
	public hashTableChaining(int n){	   
		H = new sortedStringNode[n];     
		for(int i=0;i<n;i++)         
			H[i] = null;   }

	//Sorts the word based on it's ASCII value (alphabetically sorted)
	public String sort(String word){
		char[] charArray = word.toCharArray();
		Arrays.sort(charArray);
		String sortedString = new String(charArray);
		return sortedString; 
	}

	//COnverts the given string into a value that is to be used in the insertion method
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


	//Inserts a given string into the hashTable
	public void insert(String key){
		String sortedKey = sort(key);
		int pos = stringValue(sortedKey)%H.length;

		//If no collision is found then input sortedString and the string
		if (H[pos] == null){
			H[pos] = new sortedStringNode(sortedKey,H[pos]);
			H[pos].anagrams = new StringNode(key,H[pos].anagrams);

		}
		else {
			for (sortedStringNode temp = H[pos]; temp!=null;temp = temp.next){

				//If the SortedString is found, only insert the anagram
				if(temp.SortedString.equals(sortedKey)){
					temp.anagrams = new StringNode(key,temp.anagrams);
					break; //Stops the loop after an insertion
				}
				//If the sortedString list does not contain the sortedString, insert it and the anagram
				else if(temp.next == null){
					H[pos] = new sortedStringNode(sortedKey,H[pos]);
					H[pos].anagrams = new StringNode(key,H[pos].anagrams);
					break; //Stops the loop after insertion
				}
			}
		}

	}

	//Prints all the sorted items in a list, leaves the empty slots blank
	//Used for debugging purposes
	public void printAllSorts(){
		for (int i = 0;i<H.length;i++){
			for (sortedStringNode temp = H[i]; temp!=null;temp = temp.next){
				System.out.print("for position "+i+" ");
				System.out.print(temp.SortedString+" ");

			}
			System.out.println(" ");
		}
	}

	//Prints every sortedString in a string's location 
	//Used for debugging purposes
	public void printAllSortsInString(String key){
		String sortedKey = sort(key);
		int pos = stringValue(sortedKey)%H.length;
		for (sortedStringNode temp = H[pos]; temp!=null;temp = temp.next){
			//System.out.print("for position "+i+" ");
			System.out.print(temp.SortedString+" ");

		}
		System.out.println(" ");
	}


	//Prints every anagram stored in the list
	//Used for debugging purposes
	public void printAllAnagrams(){
		int nodeNum = 0;
		for (int i = 0;i<H.length;i++){
			System.out.print("in " + i + " " );
			for (sortedStringNode temp = H[i]; temp!=null;temp = temp.next){
				System.out.print("IN NODE " + nodeNum + ": " );
				for (StringNode temp2 = temp.anagrams; temp2!=null;temp2 = temp2.next){
					//System.out.print("for position "+i+" ");
					System.out.print(temp2.word+" ");
				}
				nodeNum++;
			}
			nodeNum = 0;
			System.out.println(" ");
		}
	}

	//prints all the anagrams of the given word
	public void printRelatedAnagrams(String key){
		String sortedKey = sort(key);
		int pos = stringValue(sortedKey)%H.length;
		System.out.println("The anagrams of " + key + " are "); 
		for (sortedStringNode temp = H[pos]; temp!=null;temp = temp.next){
			for (StringNode temp2 = temp.anagrams; temp2!=null;temp2 = temp2.next){
				if (temp.SortedString.equals(sortedKey)){
					System.out.print(temp2.word+" ");
				}
			}
		}
	}

	//Returns a string from the group with the most anagrams
	public String mostAnagrams(){
		int most = 0;
		String mostWord ="";
		for (int i = 0;i<H.length;i++){
			for (sortedStringNode sortTemp = H[i]; sortTemp!=null;sortTemp = sortTemp.next){
				int tempMost = 0;
				for (StringNode wordTemp = sortTemp.anagrams; wordTemp!=null;wordTemp = wordTemp.next){
					tempMost++;
				}
				if (tempMost>most){
					//System.out.println("most was "+most +" and is now "+tempMost);
					most = tempMost;
					mostWord = sortTemp.anagrams.word;
				}

			}
		}
		System.out.println(mostWord+" has the most anagrams at "+ most+" total anagrams");
		return mostWord;
	}
}
