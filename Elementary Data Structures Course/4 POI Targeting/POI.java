
public class POI {
	//These have to be private eventually tho
	 long POIID;
	 String name;
	 int threatLevel;
	public POI nextNode; 
	
	 POI(){
		
	}
	POI (long newPOIID, String newName, int newThreatLevel){
		POIID = newPOIID;
		name = newName;
		threatLevel = newThreatLevel;
	}
}
