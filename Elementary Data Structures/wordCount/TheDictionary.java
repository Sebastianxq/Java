import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;


public class TheDictionary {

	//Oh my dis tew much

	public static HashMap<Character, HashSet<String>> hashMapDict = new HashMap<Character, HashSet<String>>();

	public static void createGiantHashSet (HashSet<String> h){
		Scanner fileScnr;
		try {
			fileScnr = new Scanner(new File("C:\\Users\\squin_000\\Desktop\\dict.txt"));
			while (fileScnr.hasNext()){
				//It does something
				//System.out.println(fileScnr.next());
				h.add(fileScnr.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void createSeperateHashsets (HashSet<String> giantSet,HashSet<String> setA,HashSet<String> setB,HashSet<String> setC,HashSet<String> setD,
			HashSet<String> setE,HashSet<String> setF,HashSet<String> setG,HashSet<String> setH,HashSet<String> setI,HashSet<String> setJ,
			HashSet<String> setK,HashSet<String> setL,HashSet<String> setM,HashSet<String> setN,HashSet<String> setO,HashSet<String> setP,
			HashSet<String> setQ,HashSet<String> setR,HashSet<String> setS,HashSet<String> setT,HashSet<String> setU,HashSet<String> setV,
			HashSet<String> setW,HashSet<String> setX,HashSet<String> setY,HashSet<String> setZ){

		for (Iterator it=giantSet.iterator(); it.hasNext(); ){
			String temp = (String) it.next();
			if (temp.startsWith("a")){
				setA.add(temp);
			}
			if(temp.startsWith("b")){
				setB.add(temp);
			}
			if (temp.startsWith("c")){
				setC.add(temp);
			}
			if(temp.startsWith("d")){
				setD.add(temp);
			}
			if (temp.startsWith("e")){
				setE.add(temp);
			}
			if(temp.startsWith("f")){
				setF.add(temp);
			}
			if (temp.startsWith("g")){
				setG.add(temp);
			}
			if(temp.startsWith("h")){
				setH.add(temp);
			}
			if (temp.startsWith("i")){
				setI.add(temp);
			}
			if(temp.startsWith("j")){
				setJ.add(temp);
			}
			if (temp.startsWith("k")){
				setK.add(temp);
			}
			if(temp.startsWith("l")){
				setL.add(temp);
			}
			if (temp.startsWith("m")){
				setM.add(temp);
			}
			if(temp.startsWith("n")){
				setN.add(temp);
			}
			if (temp.startsWith("o")){
				setO.add(temp);
			}
			if(temp.startsWith("p")){
				setP.add(temp);
			}
			if (temp.startsWith("q")){
				setQ.add(temp);
			}
			if(temp.startsWith("r")){
				setR.add(temp);
			}
			if (temp.startsWith("s")){
				setS.add(temp);
			}
			if(temp.startsWith("t")){
				setT.add(temp);
			}
			if (temp.startsWith("u")){
				setU.add(temp);
			}
			if(temp.startsWith("v")){
				setV.add(temp);
			}
			if (temp.startsWith("w")){
				setW.add(temp);
			}
			if(temp.startsWith("x")){
				setX.add(temp);
			}
			if (temp.startsWith("y")){
				setY.add(temp);
			}
			if(temp.startsWith("z")){
				setZ.add(temp);
			}
		}
	}


	public static boolean checkWords(String novelWord, HashMap<Character, HashSet<String>> Dic){
		if (novelWord.length()==0){
			return false;
		}

		char firstChar = novelWord.charAt(0);
		if (hashMapDict.containsKey(firstChar)==false){
		      return false;
		    }

		HashSet theHashSetWithFirstChar = hashMapDict.get(firstChar);
		return theHashSetWithFirstChar.contains(novelWord);
	}


	public static void createDictionary() {
		//instantiates the dictionaries undivided hashset
		HashSet<String> hashSetAllWords = new HashSet<String>();
		createGiantHashSet(hashSetAllWords);
		System.out.println(hashSetAllWords.size());

		//Instantiates all the subsets of words
		//Really tediously mind you
		HashSet<String> setA = new HashSet<String>(); HashSet<String> setB = new HashSet<String>();
		HashSet<String> setC = new HashSet<String>(); HashSet<String> setD = new HashSet<String>();
		HashSet<String> setE = new HashSet<String>(); HashSet<String> setF = new HashSet<String>();
		HashSet<String> setG = new HashSet<String>(); HashSet<String> setH = new HashSet<String>();
		HashSet<String> setI = new HashSet<String>(); HashSet<String> setJ = new HashSet<String>();
		HashSet<String> setK = new HashSet<String>(); HashSet<String> setL = new HashSet<String>();
		HashSet<String> setM = new HashSet<String>(); HashSet<String> setN = new HashSet<String>();
		HashSet<String> setO = new HashSet<String>(); HashSet<String> setP = new HashSet<String>();
		HashSet<String> setQ = new HashSet<String>(); HashSet<String> setR = new HashSet<String>();
		HashSet<String> setS = new HashSet<String>(); HashSet<String> setT = new HashSet<String>();
		HashSet<String> setU = new HashSet<String>(); HashSet<String> setV = new HashSet<String>();
		HashSet<String> setW = new HashSet<String>(); HashSet<String> setX = new HashSet<String>();
		HashSet<String> setY = new HashSet<String>(); HashSet<String> setZ = new HashSet<String>();

		//Creates the alphabetical hashsets
		createSeperateHashsets( hashSetAllWords, setA, setB, setC, setD, setE, setF, setG, setH, setI, setJ,setK, setL, setM, setN, setO, setP,
				setQ, setR, setS, setT, setU, setV, setW, setX, setY, setZ);

		//Puts the hashsets in the hashmap
		hashMapDict.put('a', setA); hashMapDict.put('b', setB); hashMapDict.put('c', setC); 
		hashMapDict.put('d', setD); hashMapDict.put('e', setE); hashMapDict.put('f', setF);
		hashMapDict.put('g', setG); hashMapDict.put('h', setH); hashMapDict.put('i', setI);
		hashMapDict.put('j', setJ); hashMapDict.put('k', setK); hashMapDict.put('l', setL);
		hashMapDict.put('m', setM); hashMapDict.put('n', setN); hashMapDict.put('o', setO);
		hashMapDict.put('p', setP); hashMapDict.put('q', setQ); hashMapDict.put('r', setR);
		hashMapDict.put('s', setS); hashMapDict.put('t', setT); hashMapDict.put('u', setU);
		hashMapDict.put('v', setV); hashMapDict.put('w', setW); hashMapDict.put('x', setX);
		hashMapDict.put('y', setY); hashMapDict.put('z', setZ);
	}

}
