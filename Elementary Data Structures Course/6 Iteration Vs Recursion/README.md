
<h2>Objective:</h2> The goal of this assignment is to practice implementing iterative and
recursive versions of different problems, and to learn about empirical performance testing
to compare the speed of different algorithms.

<h2>Assignment:</h2> Implement iterative and recursive versions of each of the problems
described below. Your goal is to determine an empirical estimate of the efficiency of
algorithms. To do this you need to be able to calculate the execution time of a method.
This can be done by using a system method to query the current system time before and
after executing the method; the time elapsed is the difference between the two. In Java
you can use the method call System.currentTimeMillis() to get the time in
milliseconds as a long. If the execution times are very small you can also use
System.nanoTime(). This method is not as accurate, but you can use it to get greater
precision if you are consistently seeing millisecond times of 0.

<h2>Compute the nth Fibonacci number</h2>

<dl>
<dt>Fibo.Java: <dt>
    <dd>1.) Fibo.java for both the iterative version and the recursive version.</dd>
    <dd>2.) Fibo.java must have (and you must use it) a method that computes the nth            Fibonacci number without recursion and returns the value.</dd>
    <dd>3.) Fibo.java must have (and you must use it) a method that computes the nth Fibonacci number using recursion and returns the value. </dd>
      <dd>4.) The program must report the time taken by the corresponding method for any n. </dd>
        <dd>5.) The program must report the time taken to compute the nth Fibonacci number for a range of n values. </dd>
      <dd>6.) Generate a plot in Excel showing the performance trend of the two methods, with n on the x-axis and the runtime on the y-axis. </dd>
        <dd>7.) Draw two lines, one for the iterative and the other for the recursive algorithm, on the same plot. </dd>
  </dl>
          
          
          
          
<h2>Implement binary search algorithm that works on a sorted array of doubles</h2>

<dl>
  <dt>BinSearch.java</dt>
  <dd> BinSearch.java for both the iterative and the recursive versions.</dd>
  <dd>BinSearch.java must have (and you must use it) a method that implements the iterative binary search algorithm and returns the location of an element in an array, or returns -1 if the element is not in the array.</dd>
    <dd>BinSearch.java must have (and you must use it) a method that implements the recursive binary search algorithm and returns the location of an element in an array, or returns -1 if the element is not in the array. </dd>
<dt>To get an accurate estimate of the time taken, you
  will need to generate a number of test cases and average the resulting times.
Suppose first that we aim to estimate the time taken for a list of 10000 numbers.
Here are the steps to perform: </dt>
<dd>- Generate a new array with 10000 elements, and initialize the elements to
random values using Math.random().</dd>
<dd>- Sort the array using Arrays.sort(). Remember that binary search works on
ordered arrays only.</dd>
<dd>- Select the value to search for by selecting a random index between 1 and
10000 and using that value (so you can be sure the value is in the array).
Again, select the random index using Math.random().</dd>
<dd>- Run iterative and recursive binary search for the same element on the
  sorted array, and record the elapsed time for each algorithm.</dd>
<dd>- Repeat the above steps at least 30 times using a for loop and calculate the
average time taken by each algorithm. This will be more accurate than
doing the test only once.</dd>
  
Now that you are able to test the performance of the iterative and recursive binary
search algorithms on arrays of 10000 elements, the next step is to test problems of
several different sizes to see how the runtime changes as the problem size
increases. 
<ol>
  <li>Repeat the experiment described above with 30 samples for arrays with
the following sizes: 10000, 40000, 160000, 640000, 1280000 (these number can
    vary based on the performance of your computer).</li>
  <li>Generate a plot in Excel showing the performance trend of the two methods, with the array size on the xaxis
    and the average runtime on the y-axis.</li>
  <li>Draw two lines, one for the iterative and the other for the recursive algorithm, on the same plot.</li>

<h2>Source</h2>
Hossain, S. (2015). Assignment #6. El Paso, Texas: Utep, CS2401.
