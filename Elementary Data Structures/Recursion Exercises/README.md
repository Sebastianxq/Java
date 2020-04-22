<h2> Part I:</h2>
Ruler of the world: In countries like the United States that still use the
traditional English system of measurement, each inch on a ruler is marked off into
fractions using tick marks that look like this:
The tallest tick mark falls at the center dividing into halves, two shorter tick marks
indicate the quarter divisions, and even shorter ones are used to mark the eighths and
sixteenths and so on. Write a recursive method with the following header.
static void DrawRuler(double x, double y,
double w, double h, double minH)
The method is given the coordinate of the lower left corner of the rectangle (x,y), the
width w, and the height h in which to estimate the ruler ticks. For simplicity, assume that
y is always equal to 0 and the width w spans in x-axis and the height h spans in ydirection.
The function must print the position of each vertical tick along the rectangle's
bottom edge as well as the height of the tick. Note that you do not have to draw the
ruler; instead you only have to print the positions of the ticks and their heights on
the terminal. Observe that the middlemost tick mark is centered and is as tall as the
rectangle height. Each smaller tick mark is half the height of the next larger one. Once the
tick marks become sufficiently small (smaller than minH), the recursion terminates.
When you will demo the program, you must change the arguments (except for the second
parameter which is always 0) of the first DrawRuler caller.


<h2>Part II: </h2>
The persistent monkey: A monkey, climbing up a greased pole, ascends 10 ft.
in 10 minutes and slips down 3 ft. in alternate 10 minutes while resting. If the pole is x ft.
high, how long will it take him to reach the top? Write a recursive function that will solve
this problem. Important items to keep in consideration are as follows.
<ol>
  <li>The monkey does not slip down anymore when he reaches the top of the pole.</li>
  <li>The monkey is able to climb up one foot per minute but needs to rest after climbing every 10 feet. </li>
 </ol>


<h2>Part III: </h2>
Write two recursive methods to convert between decimal and binary numbers. 
<ol>
<li>The first method should take in a decimal number (i.e., an int) as a
parameter, and return the binary representation of the given decimal number (i.e., a String
  of 1s and 0s representing the corresponding binary number).</li>

<li> The second method should
take in a String representing a binary number (with '0' and '1' characters), and return the
corresponding decimal number. Assume that all the numbers under consideration are
positive.</li>
</ol>


<h2>Source</h2>
Hossain, S. (2015). Assignment #5. El Paso, Texas: Utep, CS2401.
