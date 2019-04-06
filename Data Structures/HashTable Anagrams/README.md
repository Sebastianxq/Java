<h2>Introduction</h2>
	Lab 5 asked us to store the entire content of the dictionary once again, except in a hashTable this time around. To store the word, we had to first sort the word and create a “key” in which we would be able to access anagrams relevant to the word. We had to also create two separate hashTables, one that had more than one sorted word in an array location (using linked list to separate them inside the location) and another that used linear proving to place the anagram group.

<h2>Proposed Solution Design & Implementation</h2>
Insertions through Hashing- Convert a string into an array of characters and set each slot to correspond to a power of 26 while having each letter correspond to their respective letter in the alphabet (assuming ‘a’ is 0, “be” would be 1*26^1+4*26^0) and then hash into a position using the length of the array to create a new value. Check collisions by first seeing if the spot is null, or already has the Sorted String and then inserting depending on the outcome of the checks 
Insertions through linear probing- Like the above method except instead of adding on to a linked list, iterate down the array until an empty array or string match is found.
Find Related Anagrams- Hash the String into a value and then search for the match in the hashtable. If a match is found, iterate through a temporary variable that is equal to the anagrams list and output the result.
Find Most Anagrams- Iterate through the entire list, using two loops with regular hashing and two loops with linear probing. The user must iterate through the hashed locations, counting each anagram list length related to a sorted string and storing the highest value into a variable that is outputted at the end

<h2>Experimental Results</h2>
Searching the hashtable generally resulted in very fast and accurate searches. The fastest search trial I had was actually an outlier in the linear probing algorithm, an outlier that repeated itself more than once when the experiment was ran under different  constraints. I can only conclude that this specific value led the algorithm to more effectively hash into the location it was searching for, resulting in a much faster search result.
 
Analyzing runtimes led me to conclude that linear probing, at least in this instance, has a “sweet spot” of data that results in faster load times that any of the spots around it.



With a larger initial size, the creation of the hashtable decreased in runtime with a larger size. This can be due to more accurate and reliable hashing happening at larger values, i.e words with lengths longer than 6. 
 
<h2>Conclusion</h2>
In conclusion, Hashtables carry their own benefits and drawbacks. Although at first a seemingly resource consuming and confusing data structure, they can definitely have their benefits if used in the correct scenario and can even be modified (as seen with linear probing) To speed up certain processes while slowing down others, allowing for a very dynamic and resourceful structure.

