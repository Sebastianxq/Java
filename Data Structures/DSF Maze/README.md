<h2>Introduction</h2>
	Lab 6 asked us to create a maze whose walls were randomly removed with correlation to a disjoint set forest (for example a maze of with 4 cells would be paired with a dsf of 4 positions and, with every random removal of a wall, would combine each of the sets until only a singular set remained.) It also asked us to create a variety of standard union operations, with and without compression, and then analyze the efficiency of said operations

<h2>Proposed Solution Design & Implementation</h2>
Wall Removal- Create 3 random variables, 2 that are in correlation with the x and y location of the cell and 1 to decide whether an upper or a right wall will be removed.
Union (General)- Once a wall removal is guaranteed to happen, combine the 2 aforementioned sets together.
UnionByHeight- Check to see if RI is less than or greater than RJ. Point roots respectively and if they are equal, point J to I and decrement I by 1.
UnionBySize- Check to see if RI is less than or greater than RJ. Point roots respectively and add the two values to whichever point becomes the new root (I.e if S[2] is -2 and S[3] is -3 point S[2] to S[3] and make S[3] = -3+-2)

<h2>Experimental Results</h2>
After running various test, I came to the conclusion that many of the union variations ran roughly similar to each other.  In the chart below, I compared the time it took to create each of the mazes when given different N sizes, I excluded the time it took to draw the maze due to the fact that I felt the constant increase in number of cells drawn would interfere with determining which union size would provide better outcomes. As seen below, however, the methods ran similar to each other with the exception of Union by height and Union by size, which ran remarkably lower than the other 3 methods. Which is to be expected in my opinion as regular union is rather inefficient and any union that uses compression will result in more resources being used initially to allocate locations.
 
Much to my surprise, the Union, and Union with path compression, ended up receiving many more calls than any of the other union methods when at larger numbers and remainded relatively consistent with each other at lower numbers (N values less than 16). Although I am not surprised that Union by Height and Union by size did so well.

<h2>Conclusion</h2>
In conclusion, while difficult to actually visualize, the benefits of certain union methods do come with drawbacks every now and again, although the drawbacks are really only seen when dealing with much larger inputs than what one would usually consider a feasible input, at least for recreative reasons (like building a maze). 

