<h1>NOTE: This program requires the jexcel api in order to run correctly.</h1>

<h2>Introduction</h2>
	Lab 8 asked us to take in a chart from excel containing a prebuild 2d array of values and compare every string in a separate text file using the in class editDistance algorithm showed then display the maximum distance matching string for each string in the file. The second part asked us to do the same thing, except allow the user to enter a string and then display its maximum match found in the given text file
  
<h2>Proposed Solution Design & Implementation</h2>
editDistance- Use the same algorithm given in class but instead of the generic 1 for each insertion, deletion, and replacement/match, insert a -3 for each insertion and deletion and then create a “cost” method for replacement/match cases that finds the corresponding replacement/match value from the 2d array created from the spreadsheet.
Cost- Find the corresponding cell by matching the characters to their specific row and column and then returning the value.
BestMatchOutput-Use a nested for loop that compares each editDistance value and stores the highest value, and related string, into a temp value that is later written into a new text file named “result”.
UserBestMatch- Store the string given by the user into a string and then compare the editDistance values of that with every other string in the text file

<h2>Experimental Results</h2>
While my program runs without runtime errors, I was unable to create my cost method the way I first believed I would be able to create it, resulting in a plethora of what I can only assume is incorrect or, in my best-case scenario, cleverly chosen string inputs. For just about all my strings, the resulting value was “77”, which I do believe is caused by a problem with reading the correct cell in replacements/match cases.
 
I also believe however that, if the excel list was correctly inputted, the other methods would perform correctly. All incorrect input or files were also correctly accounted for, resulting in a displayed error message for any incorrect IO parameter that I threw at it.
Conclusion
In conclusion, calculating matches between strings can definitely be done efficiently and reliably with the use of dynamic programming. In the case of this lab, dynamic programming is, in my opinion, the only way to really go about to since by using dynamic programming methods, and correct outputs, one would only need to run this code once for each of their data sets before getting the results they would need. Allowing them to move on to different, and potentially bigger steps in their big data processing

