<h2>Introduction</h2>
	Lab  7 asked us to repeat the DSF lab except this time, use an adjacency list representation of a graph to create the maze. We also had to find the path from the source to the destination and display the path to the user

<h2>Proposed Solution Design & Implementation</h2>
CreateMaze- Create a Boolean array that stores visited locations and only remove a wall if the cell hasn’t been visited, both items are not in the same set, and the number of the cell is a accepted value (i.e not too large and not too small);
DFS- Standard DFS, store locations in a stack and then pop the stack into an integer array when needed. Return the integer array once all values are checked.
Recursive DFS- Since returning is not a viable option, print the path inside the recursive method as it continues through the adjacency list
BFS- Similar to DFS, except use a queue to store the values instead of a stack. Return an integer array that holds the correct path

<h2>Experimental Results</h2>
Once Completed, I ran multiple different N values with all 3 of the path finding algorithms and compared each to each other. Below is a graph displaying the difference between DFS and BFS in runtime. As seen, the runtimes of each algorithm were relatively linear, although BFS had a slightly faster runtime (which for all intents and purposes is negligible in this lab as the difference is in nanoseconds and therefore imposible for any person to notice). 
 
Recursive DFS was purposely left out of the chart above due to the much larger runtimes that it had, so much larger in fact that I decided to change the time measurement from nanoseconds to milliseconds. As seen below, the runtime to find the path become basically exponential as the n size increased (to the point where it even ended up running out of memory at sizes larger than 1000!).
  
Lastly, I ran runtime comparisons to see how long it took to initially create the maze and the adjacency list. As seen below, the time it took to create the maze and it’s repective adjacency list was relatively linear, in milliseconds however. I should note that these runtimes were also much lower than they initially were with lab 6. Which I believe is caused by the fact that there are no recusive call in this method.
   
<h2>Conclusion</h2>
In conclusion, runtimes are heavily influenced by the number of recursive calls made, which, if left unchecked can overflow the system. In respect to graphs, they can easily be used to represent many graphical ideas and can be expressed in multiple different data structures as well. These data structures may also be used extremely efficiently in respect to traversing.
