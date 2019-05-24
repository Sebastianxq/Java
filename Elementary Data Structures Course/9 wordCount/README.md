<h2>Objective:</h2>
The goal of this assignment is to practice java collections.

<h2>Assignment:</h2>
In this assignment, you will be using java Collections to practice some
popular data structures. Your task is to analyze five novels/dramas of Shakespeare. You
will basically help a linguist to identify the words that Shakespeare used but obsolete in
modern English language. The words of a modern dictionary are provided in the
dict.txt file. Each line in the file represents a word. There are five other files with
this assignment: hamlet.txt, juliuscaesar.txt, kinglear.txt,
macbeth.txt, and othello.txt. Each of these files contains all the words found in
a work of Shakespeare that is identified in the filename. For your convenience, each word
is listed in a separate line to make it easier to scan and read them. <br><br>

Your task is to generate
a summary that includes the following items for each of the Shakespeare’s novel/drama.
<ul>
<li>Number of unique words found in a Shakespeare’s novel/drama</li>
<li>Number of unique words in a Shakespeare’s novel/drama found in the dictionary</li>
<li>Number of unique words in a Shakespeare’s novel/drama not found in the dictionary</li>
<li>An alphabetic list of all unique words in a Shakespeare’s novel/drama. Each line
of the list must be in format X\tY\tMessage, where Y is the number of times
word X is found in the novel/drama for which this summary is being generated. If
a word X is found in the dictionary, Message must be Art spoken ever
and anon! If the word is not found in the dictionary, the Message field for
that X should be Ne'er spoken ever!
Your program must generate a summary for hamlet.txt in a file named
hamlet_summ.txt, juliuscaesar.txt in juliuscaesar_summ.txt, and
so and so forth.</li>
</ul>
<h2>Specifications:</h2>
The task can be solved in many ways but you have to make sure that you are using the
following specifications. When you are searching for a word in a dictionary, you cannot
do a linear search because that will make the whole task very time consuming. You will
need to make good use of some data structures to make your summary generation
program fast. Some of the following specifications will help you do that.
<ol>
<li>The name of the main program should be SummaryGen.java. Your program
must generate five summary files for all five Shakespeare novels/dramas in one
execution. </li>
<li> Immediately after reading a word from the dictionary file or from a novel/drama
file, convert all the letters of the word to lowercase for convenience. That is, in
the whole program, you do not have to deal with capitalizations because you
know that everything is in small letter.</li>
<li>Your program must read the dictionary file exactly once and store the content in a
private data variable of type HashMap<Character, HashSet> inside a
class named TheDictionary. Each key of the HashMap will map a
HashSet containing all the words starting with the key Character. The code
to read the dictionary and fill out the private HashMap must be inside the
TheDictionary class. You must use the TheDictionary class to check if a
word of any novel/drama exists in the dictionary. That is, you will write public
methods in TheDictionary to access the information kept in the HashMap.</li>
<li>The code to read a novel/drama file must be inside a class named Novel. The
Novel class must have a private data variable of ArrayList type to store all
the words of a Shakespeare’s novel/drama in a sequence they appear in the
corresponding file. The code to compute, generate, and write the summary of a
novel/drama must be written inside the Novel class. Clearly, a Novel object
will hold information about the content of a novel/drama and methods to generate
a summary.</li>
<li>The whole program must not read the dictionary file, or any of the novel/drama
files more than once. </li>
You are allowed to use the following java collections (available in java.util) for this
particular assignment: ArrayList, HashMap, HashSet, and LinkedList. You can
also use Java’s default Collection sorting algorithms.
  </ol>
<h2>Source</h2>
Hossain, S. (2015). Assignment #9. El Paso, Texas: Utep, CS2401.
