<h2>Introduction</h2>
	Lab 1 asked us to compare elements in a user designed array using a variety of different methods. The prompt also implied that our programming must be “robust” and allow users to select their own values for array length and the maximum integer allowed in the array, handle errors efficiently and effectively, and minimize code within the main method in the class.

<h2>Proposed Solution Design & Implementation</h2>
	User Input- My proposed solution for user input was printing a statement asking the user individual questions for the size and upper limit of the integers and have a scanner take in the integer the user inputs and store it into a variable. I did also add a mismatch exception handler in case the user types in something that is not an integer.
	Enhancing the given Algorithm- This problem took me quite a while to figure out but I came to the realization that if the nested loop starts at i+1, then the redundancy from checking each pair of elements twice would be removed.
	Bubblesort Algorithm- Much like any other Bubblesort algorithm, I will advance through the unsorted array and used a temporary integer to store values while swapping the values between positions in the array
Mergesort Algorithm-  Use a main “Mergesort” method that recursively separates elements into two arrays, filled the two arrays in two separate methods and then merged them back together in a final method called “merge”.
	Checking sorted arrays for duplicates- To check a sorted array for duplicates, I created a loop that ended on m-1 where m is the array of the length and had a check that compared each element, A[i], with every element after it, A[i+1], and returned true if any duplicates were found.
	Boolean Array Check- Create an array that is the size of the largest integer value that can exist in the array and then fill it out by using a nested loop, marking true for values that appear more than once. Afterwards, run one final loop on the Boolean array and return “true” if any of the Booleans in the array are “true”.
I should also note that I did include a portion that created 4 different arrays with the parameters given by the user and ran each test in one go, allowing the user to see the results of each of the prompts the lab required us to do.

<h2>Experimental Results</h2>
I initially ran a couple of tests before calculating runtimes to make sure my code was functioning correctly and could handle all errors correctly. Since the lab only requires two integer inputs I attempted to input a non-integer into both prompts and was met with an error message. I also typed in a number that exceeded the limit for integers and was once again met with an error message. To test whether my sorting methods and duplicate checking methods did what they were programmed to do, I ran test with integers of various sizes and with array sizes ranging from 1-5000.
 
 
 
 
 
Although most my calculated graphs look identical in shape, the actual data behind it varied drastically when compared to each other. When runtimes were finished, on average, the improved duplicate check method, unsurprisingly, performed better than the regular method. Likewise, the sorted checks performed better than the previous two and Mergesort performed the best out of all the methods. The Boolean array method performed the worst out of all the checking methods, which once again is unsurprising considering the amount of comparisons and print statements that the method executed. Also, seen in the graphs, I ran 2 studies using Max integer values that were either the length of the array or half of the length of the array. Although the discrepancies between the two can be summed up to naturally different cpu loads 

Big O Notations are as Follows:
1.)	Regular Duplicate Check: O(n^2)
2.)	Improved Duplicate Check: O(n^2)
3.)	Bubblesort Duplicate Check: O(n^2)
4.)	Mergesort Duplicate Check: O(Log(n))
5.)	Boolean Duplicate Check: O(n^2)

<h2>Conclusion</h2>
 What I learned while performing this lab is how important an efficiently written program can help with its performance. And sometimes what may at the time seem like an improvement in efficiency, such as the Boolean array check, may end up backfiring and use up more resources than its predecessors. I also learned that more positive results do not always mean a larger workload. As seen in my graphs, the two-different test that I ran resulted in nearly identical results, although they different radically with the number of duplicates present in each test.
