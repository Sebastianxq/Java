import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

public class ComputeSha1 {

	/**
	 * Given an username and a hash
	 * Brute Force a password
	 * password can be random characters between 1-10 length
	 * Variable length but set to 5 due to processor limitations
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static void findSha() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		String[] username = new String[10];
		String[] confirmedHash = new String[10];

		//imports information from the randPwd File
		try (BufferedReader test = new BufferedReader(new FileReader("myRandPwdFile.txt")))
		{
			String read  = null;
			test.readLine();
			int currLine = 0;
			//Splits info from the file into the respective array
			while ((read = test.readLine()) != null) {
				String[] splited = read.split("\\s+");
				String str;
				for (int i = 0; i<splited.length; i++) {
					str = splited[i];
					if (str.charAt(str.length() - 1) == ',') {
						str = str.substring(0, str.length()-1);
						if (i==0) {
							username[currLine] = str;
						}
					}
					else {
						confirmedHash[currLine] = str;
					}
				}
				currLine++;
			}
			//Sets a domain for all possible characters, along with the min and max potential password length
			String domain = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890_$#-~";
			int lo=1;
			int hi=6;
			//Call create up until the limit of length is reached
			for(int i=lo;i<=hi;i++)
			{
				int len=i;
				String str ="";
				boolean[] included = new boolean[domain.length()];
				create(0,domain,included,str,len, confirmedHash,username);
			}
		}

	}

	//Creates all possible variants recursively 
	//Also checks hashes and matches correct ones with respective usernames
	static void create(int i,String domain,boolean[] included,String str,int len, String[] confirmedHash, String[] username) throws NoSuchAlgorithmException, IOException
	{
		if(i==(len))
		{
			String potentialHash = sha1Hash(str);
			for (int j=0;j<confirmedHash.length;j++) {
				if (potentialHash.equals(confirmedHash[j]))
					System.out.println(str+ " is the pw for user "+ username[j]);
			}
			return;
		}
		for(int j=0;j<domain.length();j++)
		{
			if(included[j])
				continue;
			else
			{
				included[j]=true;
				str+=domain.charAt(j);
				create(i+1,domain,included,str,len, confirmedHash,username);
				included[j]=false;
				str = str.substring(0, str.length() - 1);
			}
		}
	}

	/**
	 * Given an username, salt and the corresponding encryption,
	 * this method confirms the password by probing with each word from
	 * the dictionary
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws NoSuchAlgorithmException 
	 * 
	 */
	public static void dictionaryAttack() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		//Initializes arrays, later used to computer passwords
		String[] dictionary = new String[109583];
		String[] salt = new String[10];
		boolean[] foundPassword = new boolean[10];
		String[] confirmedPassword = new String[10];
		String[] username = new String[10];
		String[] confirmedHash = new String[10];

		//Stores dicitonary into array
		try (BufferedReader dict = new BufferedReader(new FileReader("wordsEn.txt")))
		{
			int count = 0;
			String currLine;
			while ((currLine = dict.readLine()) != null) {
				dictionary[count] = currLine;
				count++;
			}
		}

		//Stores info from the Dictionary Password file
		try (BufferedReader test = new BufferedReader(new FileReader("myDictPwdFile.txt")))
		{
			String read  = null;
			test.readLine();
			int currLine = 0;
			while ((read = test.readLine()) != null) {
				String[] splited = read.split("\\s+");
				String str;
				for (int i = 0; i<splited.length; i++) {
					str = splited[i];
					if (str.charAt(str.length() - 1) == ',') {
						str = str.substring(0, str.length()-1);
						if (i==0) {
							username[currLine] = str;
						}
						else {
							salt[currLine] = str;
						}
					}
					else {
						confirmedHash[currLine] = str;
					}
				}
				currLine++;
			}
			//COmpares each of the username's known passwords to a dictionary hash and sets a match if found
			for (int i=0;i<username.length;i++) {
				//System.out.println("Test for "+username[i]+" "+confirmedHash[i]+" "+salt[i]);
				for (int j=0;j<dictionary.length;j++) {
					String dictAndSalt = dictionary[j]+salt[i];
					String dictionaryHash = sha1Hash(dictAndSalt);
					if (dictionaryHash.equals(confirmedHash[i]))
					{
						foundPassword[i] = true;
						confirmedPassword[i] = dictionary[j];
					}
				}
			}
			//Prints out all matches
			for (int i = 0;i<10;i++) {
				System.out.println("The password for account "+username[i]+" is "+confirmedPassword[i]);
			}
		}
	}

	//Stores all possible combinations of 2 lowercase letters
	public static void usernameCrack() {
		String[] possiblePasswords = new String[676];
		int position = 0;
		for (int i = 97;i<123;i++) {
			for (int j = 97;j<123;j++) {
				String firstLetter = Character.toString((char) i);
				String secondLetter = Character.toString((char) j);
				//System.out.println("Test for: "+ firstLetter+secondLetter);
				possiblePasswords[position] = firstLetter + secondLetter;
				position++;
			}
		}
	}

	//Computes the sha1hash
	public static String sha1Hash(String input) throws NoSuchAlgorithmException, IOException {
		//System asks for input and then automatically hashes in SHA1 I guess
		MessageDigest hash = MessageDigest.getInstance("SHA1");
		hash.update(input.getBytes());
		byte[] digest = hash.digest(); 
		//System.out.println(DatatypeConverter.printHexBinary(digest).toLowerCase());
		return DatatypeConverter.printHexBinary(digest).toLowerCase();
	}

	public static void main(String[] args) throws Exception {
		//Checks hash with dictionary and stores correct password
		dictionaryAttack();

		//Stores all possible combinations and could eventually use those to login through bruteforce
		usernameCrack();

		//Randomly generates passwords and attempts to get the correct hash
		findSha();
	}
}
