
<h2>Introduction</h2>
	Lab 4 asked us to augment the standard BTree class to accept strings and then build a Btree that contained all the words from the dictionary. After that, we were tasked with creating multiple algorithms that showed our effective understanding of the data structure. These algorithms asked us to display the number of anagrams with each word, display the word with the most anagrams, along with the anagrams themselves and then display how long the process took.

<h2>Proposed Solution Design & Implementation</h2>
Augment BTree to take in strings- Swap out the original integer array with a string array.
Build BTree(t) to contain all the dictionary words- Use a buffered reader to go through the text file, breaking on each space, until there is no other word in the file.
Find Anagrams for each word- Source code given, recursively break each word, and then combine the different combinations of prefixes and suffix; these combinations are later checked with the contain method to see if they are in the given BTree.
Sequential Search- Much like the print method, go through the entire array sequentially except instead of printing each key found, compare each key with the given String “k”. If K is found, print a confirmation and if not, do nothing.
Binary Search- Much like sequential search except instead of sequentially going through the BTree, check the middle element in a loop and keep going until the element is found or the first position placeholder is greater than or equal to the last position placeholder.
CountAnagrams- Source code given, instead of printing the anagrams, add a counter that iterates each time a word comes out true and return that value, along with the original word, to the user
MostAnagrams- Exactly like count anagrams except instead of returning each Anagram, have temporary variables that stores both the number of anagrams and the word that contains the most number of anagrams and then, after searching the entire tree, return that temporary variable.
<h2>Experimental Results</h2>
For my experiments, I decided to test the efficiency of my program by manipulating the “t” variable of the BTree and the word that I was searching for. My searches did not print any variables but rather, returned a Boolean that could be stored in a variable or used for conditional statements, which I believed was the best way to go about creating an output for the search in the BTree. I used three words: Aardvark, Median and Zygote. I chose these words due to their general placement in the dictionary (beginning, middle and end) which I felt would give me the most accurate result when testing the runtime of my program. I also decided to use the values 3, 8, 64, 256, 1024, and 8192 for my t value to view the changes in runtime that they had in both searches.
 
 
<h2>Conclusion</h2>
From the information gathered with my runtime examinations, I believe that while sequential search will roughly perform the same as binary when it comes to smaller values and perhaps even beat binary searches when the item is closer to the beginning, assuming there is a lot of distance between the median and the beginning of the data structure, binary search is a more universal and versatile search ideology that allows for a more efficient and better rounded program when it comes to retrieving information from a sorted list. Especially if the list is a BTree! Lastly, I can infer from this lab that BTree, while at first incredibly complicated and a pain to use, allow greater efficiency if the user can sort their data.
