
<h2>Objective: </h2>
The goal of this assignment is to practice sorting algorithms.

<h2>Assignment:</h2>
In this assignment you will be implementing versions of two sorting
algorithms. You will use them to sort an array of objects representing cubes. 

<ol>
  <li>Your first step is to implement a class called Cube that has three double variables to store the
      length, width, and height of the cube. </li>
  <li>Then, write a method that calculates the volume of the Cube as a member of the class. </li>
  <li>Next, you should write a method in a class named Runner1 that will generate a random list of Cubes for testing. The method should         take in a number representing the size of the list, and return an array of that many Cubes. 
  <li>Each Cube should have a randomly generated length, width, and height between 0 and 100. </li>
  <li> Implement another method in Runner1 to print out your array of cubes. You should print a line for each cube listing the length,            width, and height and then the volume.</li>
  <li>As another preliminary step, implement a method CopyArray in Runner1 that creates a new array of cubes with identical values of a         given one.</li>
  <li>Now, write two methods inside Runner1, one named BubbleSort and the other named SelectionSort. Use parameters as you think                  appropriate.  Note that both BubbleSort and SelectionSort must sort the cubes in the input array in ascending order of the volumes        of the cubes.</li>
  <li> Demonstrate that your code works by generating a random list of 20 cubes (in an array), printing out the list before you sort it,          and then printing out the list again after it is sorted using BubbleSort. For an identical list of 20 cubes (copied right after the        generation of the array that was given to BubbleSort as an input), show the list before and after the use of the SelectionSort            method.</li>
  <li>Write a class named Runner2 that will test the speed of your BubbleSort and
      SelectionSort methods by recording the time needed to sort a list of 10000
      cubes. </li>
</ol>

<h2>Source</h2>
Hossain, S. (2015). Assignment #7. El Paso, Texas: Utep, CS2401.
