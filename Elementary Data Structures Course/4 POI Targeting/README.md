<h2>Objective:</h2> The goal of this assignment is to practice linked list.

<h2>Assignment:</h2> 
Every three lines in the input file is reserved for the record of a person. These three lines
respectively represent long integer ID of a person, the name of the person, and an integer
ranging from 0 to 5 indicating the threat level posed by a person. The full connection is: Dan Carte -> Prio Notim -> Hons
Nohish -> Diran Egrac -> Osama Laden.


Your task is to read the file content, construct a singly linked list to store the records in a
sequence they appear in the file, and allow flexibility to the analysts so that she/he can
perform the following operations.
<table>
    <tr>
        <td>Operation 1. Print the linked list content on the terminal (ID, name, and threat
level of the people in a sequence they appear in the linked list) </td>
    </tr>
    <tr>
        <td>Operation 2. Search for a person in the linked list with ID or name </td>
    </tr>
    <tr>
        <td>Operation 3. Insert a new person in a particular location index </td>
    </tr>
    <tr>
        <td>Operation 4. Swap two people in two specific location indices</td>
    </tr>
    <tr>
        <td>Operation 5. Remove a record containing a specific ID</td>
    </tr>
    <tr>
        <td>Operation 6. Remove all records with a certain thread level</td>
    </tr>
    <tr>
        <td>Operation 7. Write the content of the linked list in an output file that has the
            same format as the input file.</td>
    </tr>
    <tr>
        <td>Operation 8. Quit program.</td>
    </tr>
 </table>


Your program must start by prompting the user to provide the filename of the input
connection profile. Then the program should load the information in a linked list and
prompt the user to perform one of the eight operations listed above.
Other requirements:
<ol>
  <li>You must write three classes: POI, POIList, and AnalyzePOI.</li>
  <li>POI.java: The POI class must hold the variables for the ID (long),
name (String), and threat level (int). All these variables must be
private. POI must also have a variable of POI type that can be used to
point to the next POI object. This variable should be public.</li>
  <li>POIList.java: Must contain a data variable named head of POI type,
which should contain the head address of the constructed linked list. Each
of the operations from 1 to 7 must be implemented in a method of this
class.</li>
<li>AnalyzePOI.java: This is the only class that will contain the main
method. This class will be responsible for prompting the user for the input
filename, creating the linked list (a POIList object), and prompting for
the seven listed operations. AnalyzePOI must call appropriate methods
associated with the POIList object to perform operations 1 to 6.
Prompts for operation specific-information must be implemented in the
POIList class.</li>
<li>As stated earlier, your program must start by prompting the user to provide the
filename of the input connection profile. You must handle the following
exceptions. </li>
  </ol>
  Do not quit the program if you have these exceptions, rather give an
error message and prompt the user again for a correct file.
<ul>
  <li>If an expected ID in the file is not a long integer</li>
<li>If threat level is not in integer</li>
<li>If threat level is not an integer between 0 to 5 (threat level can be 0, or 5,
or any integer between 0 and 5)</li>
</ul>
<h2>Source</h2>
Hossain, S. (2015). Assignment #2. El Paso, Texas: Utep, CS2401.
