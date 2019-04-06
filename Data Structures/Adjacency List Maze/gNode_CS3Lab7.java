
public class gNode{	    
     //public int src;
     public int dest;
     //public int cost; //dont think i need this rn
     public gNode next;  

     public gNode(int D, gNode n){      
           //src = S;      
           dest = D;
           next = n;   
     }
}
