<h2>Objective:</h2>
The goal of this assignment is to practice arrays of objects.

<h2>Assignment:</h2>
The client will provide data in the form of a text file. Some lines at the
beginning will contain three numbers separated by spaces representing the width, height,
and length of the available boxes in the inventory. That is, these lines will provide the
box types. The rest of the lines will contain only one number in each line that represents
the radius of a basketball.  <br> <br> <br>
 
Your task is to assign the smallest box that can fit a basketball
inside it. The word “smallest” refers to a comparison in terms of the volume of the boxes.
Your program must output the following information. <br> 
 <ol>
 <li> For each of the basketballs, provide the most suitable box size (that is, the size of the smallest box that can fit the basketball). If there is no such box, print “Box not available for this basketball”. </li>
 <li> For each of the basketballs, provide the volume of the selected box type, the volume of the basketball and the volume of the empty space inside the box after placing the basketball. If your answer was “Box not available for this basketball” then just provide the volume of the basketball. </li>
 <li> How many basketballs were you able to fit in the available box types?  </li>
 <li> Provide a list containing the radius of each of the basketballs that cannot fit in an available box.  </li>
 <li> Provide a list of box sizes that were not used at all. </li>
</ol>

<h2>Requirements:</h2>
<ol>
 <li>You must write and use two classes: Box and Basketball. They should be
written in two java files: Box.java and Basketball.java. The Box class
will contain the status of the box type (width, height, and length) and other
necessary methods. Similarly, the Basketball class will contain the radius of a
basketball and other necessary methods. </li>
<li> You must create all the Box and Basketball objects in a separate class named
MainProg.java that contains the main method. Your program must create
and use an array of Box objects and an array of Basketball objects containing
the box types and basketball information provided in the input file. </li>
<li> You are not allowed to write code to compute the volume of the box in the
MainProg.java file. You must write the code to compute the volume of a box
in the Box.java file.  </li>
 </ol

The Box class must contain at least the following
methods:<br>
 <ul>
 <li>double getVolume() : The method will return the volume of the
box. </li>
 <li> boolean fitsInBox(Basketball b) : The method will return
true if the basketball object b fits inside the box, otherwise it will return
false. Caution: You will need to compare the diameter, not the radius, of
the basketball with the width, height, and length of the box. </li>
 <li>  double emptySpace(Basketball b) : The method will return
the volume of the empty space in the box after putting the basketball b
inside it. If the basketball does not fit, the method will return the exact
volume of the box since the basketball cannot occupy any space of the
box.  </li>
 </ul>

<h2>Source</h2>
Hossain, S. (2015). Assignment #3. El Paso, Texas: Utep, CS2401.
