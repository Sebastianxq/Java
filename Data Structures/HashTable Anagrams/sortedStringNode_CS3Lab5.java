public class sortedStringNode {	    
     public String SortedString;    
     public sortedStringNode next;    
     public StringNode anagrams;   	

     public sortedStringNode(String S, sortedStringNode n){                        
           SortedString = S;      
           next = n;      
           anagrams = null;
           }
}
