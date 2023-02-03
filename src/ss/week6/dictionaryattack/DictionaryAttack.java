package ss.week6.dictionaryattack;

import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;


public class DictionaryAttack {
	private Map<String, String> passwordMap = new HashMap<>();
	private Map<String, String> hashDictionary = new HashMap<>();

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename the full path to the file
	 */
	public void readPasswords(String filename) throws IOException{
		String thisLine = null;

//		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while ((thisLine = br.readLine()) != null) {
				String [] splitted = thisLine.split(": ");
				if (splitted.length == 2){
					passwordMap.put(splitted[0], splitted[1]);
				}
			}
//		} catch(IOException e) {
//			e.printStackTrace();
//		}

	}

	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password String
	 * @return MD5 hash of given password
	 */
	public String getPasswordHash(String password) {
		MessageDigest md = null;

		try{
			md = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		return Hex.encodeHexString(md.digest(password.getBytes()));
//		byte[] bytesOfMessage = password.getBytes("UTF-8");
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		byte[] theMD5digest = md.digest(bytesOfMessage);
//		String result = Hex.encodeHexString(theMD5digest);
//		return result;
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {

        for (Map.Entry entry: passwordMap.entrySet()){
			if (entry.getKey().equals(user) && entry.getValue().equals(getPasswordHash(password))){
				return true;
			}
		}
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary (full path)
	 */
	public void addToHashDictionary(String filename) throws IOException {
		String thisLine = "";

		BufferedReader br = new BufferedReader(new FileReader(filename));
		while ((thisLine = br.readLine()) != null) {
			//String [] splitted = thisLine.split(": ");

				hashDictionary.put(getPasswordHash(thisLine), thisLine);

		}

    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		for (Map.Entry entry1: passwordMap.entrySet()){
//			for (Map.Entry entry2: hashDictionary.entrySet()){
//				if (entry1.getValue().equals(entry2.getKey())){
//					System.out.println(entry1.getKey() + " " + entry1.getValue());
//					System.out.println(entry2.getKey() + " " + entry2.getValue());
//				}
//			}
			if (hashDictionary.containsKey(entry1.getValue())){
				//if (entry1.getValue().equals(hashDictionary.get(entry1.getValue()))){
					System.out.println(entry1.getKey() + ": " + hashDictionary.get(entry1.getValue()));
				//}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		DictionaryAttack da = new DictionaryAttack();

			da.addToHashDictionary("./src/ss/week6/test/CustomPassword.txt");




			da.readPasswords("./src/ss/week6/test/LeakedPasswords.txt");



		// To implement
		da.doDictionaryAttack();
		//System.out.println(da.passwordMap.toString());
		//System.out.println(da.hashDictionary.toString());
	}

}
