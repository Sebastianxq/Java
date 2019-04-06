<h2>Introduction</h2>
	Lab 3 asked us to create 3 different methods, one that received the length of a linked list and the maximum possible value for the items in the linked list, one that recursively sorted the linked list and lastly: a method that implemented a non-recursive Mergesort that used stacks as a substitute for recursion

<h2>Proposed Solution Design & Implementation</h2>
CreateList- Allow users to input a size “n” and a max value “m” using scanners and then using a method to instantiate the list with the randomized values. The method will have a for loop that will run until it creates a list of size “n” and will uses a generator that has a limit of “m”.
Recursive Mergesort – Create a recursive method with the basic framework similar to the average Mergesort source except allow an additional method to find the middle of the list?
Non-Recursive Mergesort – Modify the code given by Professor Fuentes to adapt to a linked list instead of arrays.

<h2>Experimental Results</h2>
Although unable to finish the Mergesort method, I could create a method to create the list and a method that sorted it recursively. To test my method, I decided to input random variables and of course, incorrect inputs to make sure my error handling was working correctly. My list inputs varied from 5 variables of value less that 5 but greater than 0 to 100 variable of sizes less than 1000 and greater than 0. Each test ran correctly, besides a small bug where a lack of space when giving very large list sizes due to the fact that my program printed every item on one list.

<h2>Conclusion</h2>
In conclusion, the creation, and properties of linked lists, while at first a bit confusing, are nothing that cannot be understood when correct implementation is practiced. I also believe the same ideology carries for stacks, even though I was not able to deduce the correct way to implement them in this lab.
