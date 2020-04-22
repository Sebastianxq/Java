
public class POIList {
	//Instantiates the head as the first/last person in the list
	//Probably last as the current plan is to create the damn list backwards.
	//Currently generic names until i figure out how to get the name into it
	//POI head  = new POI(1,"generic",1);
	POI head = new POI();
	private int listCount;
	
	public POIList(){
		head = new POI();
		listCount = 0;
	}
	//This is where all 7 methods go :(
	//Asides from the quit thingy
	//Eventually it'll be fixed
	/*void add(Object data){
		POI temp = new POI(data);
		POI current = head;
		
		while POIList(current.getNext()  != null){
			current = current.getNext();
		}
		current.setNext(temp);
		listCount++;
	}*/
	
//	void PrintList(){
//		POI i = head;
//		while (i!=null){
//			System.out.println("The information for all the jerks is below");
//			System.out.println(i.name);
//			System.out.println(i.POIID);
//			System.out.println(i.threatLevel);
//			System.out.println(i.nextNode);
//			i=i.nextNode;
//			
//		}
//	}
	
	void findPerson(){
		//Definitely do an if for whether they'll be searching for name or id
		//Or have two different functions for searching thru name or ID
	}
	
	//Check slides for the answer
	POI insert(POI head, POI insertee, int index){
		if (head==null)
			return insertee;
		if (index==0){
			insertee.nextNode=head;
			return insertee;
		}
		POI temp=head;
		POI prev=null;
		int i=0;
		while (temp!=null){
			if (i==index){
				prev.nextNode=insertee;
				insertee.nextNode=temp;
				return head;
			}
			prev = temp;
			temp = temp.nextNode;
			i++;
		}
		if (temp==null && index==i){
			prev.nextNode = insertee;
		}else{
			System.out.println("Index was not found. Returning the previous head.");
		}
		return head;
	}
	
	void swapPeople(){
		
	}
	
	void removePerson(){
		
	}
	
	void removeThreatLevels(){
		
	}
	
	void createFile(){
		
	}
}
