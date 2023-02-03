package ss.week6;

import java.util.Scanner;

public class Words {
	
	private static final String END_WORD = "end";

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while (run){
			System.out.print("Line (or \"end\"): ");
			String input = scan.nextLine();
			String [] splitted = input.split(" ");
			if (splitted.length == 1 && splitted[0].equals("end")){
				System.out.println("End of programme");
				run = false;
			}
			else{
				int index = 1;
				for (String word: splitted){
					System.out.println("Word " + index + ": " + word);
					index ++;
				}
			}
		}
	}
}
