/*******************************
 * Author:Sebastian Quinones
 * Date Due: 04/27/17
 * Purpose: To understand how dynamic programming can accurately and 
 *  effectively increase the productivity of a program and understand
 *  how the algorithm behind editDistance can have an actual real
 *  life application
 */
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class main {
	
	//Imports the values from the excel sheet
	public static int[][] importExcelNumbers() throws IOException{
		int[][] sequence = new int[21][21];
		FileInputStream file = new FileInputStream(new File("blosum62.xlsx"));

		//OBject that holds the reference to excel file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		//First sheet of the excel file
		XSSFSheet sheet = workbook.getSheetAt(0);

		//Iterate through each rows
		Iterator<Row> rowIterator = sheet.iterator();
		int i = 0,j = 0;
		while (rowIterator.hasNext())
		{
			j=0;
			Row row = rowIterator.next();
			//For each row, iterate through all the columns
			Iterator<Cell> cellIterator = row.cellIterator();

			//Iterates through the excel sheet and fills in the 2d array
			while (cellIterator.hasNext()) 
			{
				Cell cell = cellIterator.next();
				//Check the cell type and format accordingly
				switch (cell.getCellType()) 
				{
				
				case Cell.CELL_TYPE_NUMERIC:
					// System.out.print(cell.getNumericCellValue() + "\t"+" i is "+i+" and j is "+j+ " ");
					if(j<21 && i<21)
						sequence[i][j] = (int)cell.getNumericCellValue();
					j++;
					break;
				}
			}
			i++;
		}
		file.close();
		
		//print2d(sequence);
		return sequence;
	}

	//Prints contents from a 2d array, in order. Used for debugging purposes
	public static void print2d(int[][] ar){
		for (int i=0;i<ar.length;i++){
			for (int j=0;j<ar.length;j++){
				System.out.print(ar[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	
	//Fills an array with the sequences from the text file
	public static void fillSequences(String[] sequences) {
		try (BufferedReader br = new BufferedReader(new FileReader("proteinSequences.txt"))){
			String currentLine;
			int i=0;
			while ((currentLine = br.readLine()) != null) {
				//System.out.println(currentLine);
				sequences[i] = currentLine;
				i++;
			}
			//return sequences;
		} catch (IOException e) {System.out.println("Error reading the file: "+ e.getMessage());}

	}

	public static void userDistanceInput(int[][]blosum,String userSequence,String[] sequences){
		int temp = 0;
		String tempString = "";
		for (int i=0;i<sequences.length-1;i++){
			for (int j=0;j<sequences.length-1;j++){
				//System.out.println(sequences[i]+" and j is "+sequences[j]+" j is "+j+" <="+sequences.length);
				int newEditDistance=editDistance(blosum,sequences[i],sequences[j]);
				if (newEditDistance>temp){
					temp = newEditDistance;
					tempString = sequences[j];
				}
			}
		}
		System.out.println(tempString +" with a value of "+temp);
	}
	//Outputs the best match into a text file I guess
	public static void bestMatchOutput(String[] sequences, int[][]blosum){
		try{ 
			PrintWriter writer = new PrintWriter("results.txt", "UTF-8");
			for (int i=0;i<sequences.length;i++){
				int temp = 0;
				String tempString = "";
				for (int j=0;j<sequences.length;j++){
					//System.out.println(sequences[i]+" and j is "+sequences[j]+" j is "+j+" <="+sequences.length);
					int newEditDistance=editDistance(blosum,sequences[i],sequences[j]);
					if (newEditDistance>temp){
						temp = newEditDistance;
						tempString = sequences[j];
					}
				}
				writer.println(tempString +" with a value of "+temp);
			}
			writer.close();
		} catch (IOException e) {
			System.out.println("An input/output error happened");
		}
	}

	
	public static int cost (int[][] blosum, int i, int j){
		//lets try it with just the locations since thats all i can really do right now lmao smh
		//System.out.println("the value is "+blosum[i][j]);
		if (i<21&&j<21)
			return blosum[i][j];
		else
			//returns -1 if the array is out of bounds
			return -1;
	}
	
	
	public static int editDistance(int[][] blosum, String s1, String s2){
		int[][] d = new int[s1.length()+1][s2.length()+1];
		for (int i=0;i<=s1.length();i++){
			d[i][0] = i; //deletion
		}
		for (int j=0;j<=s2.length();j++)
			d[0][j] = j; //insertion
		for (int j=0;j<s2.length();j++){
			for (int i=0;i<s1.length();i++){
				if (s1.charAt(i)== s2.charAt(j)) //matchCase
					d[i+1][j+1] = d[i][j]+cost(blosum,i,j); 
				
				else {
					//Original formula
					//d[i+1][j+1] = 1+Math.max(d[i][j+1],Math.max(d[i+1][j], d[i][j]));

					//deletion equal to -3
					if (Math.max(d[i][j+1],Math.max(d[i+1][j], d[i][j])) == d[i+1][j])
						//d[i+1][j+1] = d[i+1][j]+1;
						d[i+1][j+1] = d[i+1][j]-3;

					//insertion equal to -3
					else if(Math.max(d[i][j+1],Math.max(d[i+1][j], d[i][j])) == d[i][j+1])
						//d[i+1][j+1] = d[i][j+1]+1;
						d[i+1][j+1] = d[i][j+1]-3;

					//replacement/match case??
					else {
						//Original
						//d[i+1][j+1] = 1+d[i][j];
						//System.out.println("got here"+" with a cost of "+cost(blosum,s1.charAt(i),s2.charAt(j),i,j));
						d[i+1][j+1] = cost(blosum, i,j)+d[i][j];
					}

				}
			}
		}
		return d[s1.length()][s2.length()];
	}


	public static void main(String[] args) {
		//Creates and fills in the string array
		try {
			Scanner sc = new Scanner(System.in);
			String[] proteinSequences = new String[755];
			int[][] chartValues = importExcelNumbers();
			System.out.println("Please select an option:");
			System.out.println("1.)Output a text file with each of protein Sequence for a best fit");
			System.out.println("2.)Input your own sequence and display it?");
			int choice = sc.nextInt();
			switch (choice){
			case(1):
			//System.out.println(chartValues.length+" "+chartValues[1].length);
			fillSequences(proteinSequences);
			bestMatchOutput(proteinSequences,chartValues);
			break;
			case(2): //Insert the option to input a string and find the best match
				System.out.println("Please input a string");
				String userSequence = sc.next();
				System.out.println("Your sequence was "+userSequence);
				fillSequences(proteinSequences);
				userDistanceInput(chartValues,userSequence,proteinSequences);
				break;
			
			default:System.out.println("That was an incorrect input, please restart");
			break;
			}



		} catch (IOException e) {
			System.out.println("There was a file input error");
		}

	}

}
