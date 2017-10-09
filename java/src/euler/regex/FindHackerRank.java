package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindHackerRank {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileInputStream hackerRankInput;
		try {
			hackerRankInput = new FileInputStream("FindHackerRank.txt");
			Scanner in= new Scanner(hackerRankInput);
			int inputSize= in.nextInt();
			in.nextLine();
			for (int i=0;i<inputSize;i++) {
				String currLine= in.nextLine();

				boolean begin= currLine.matches("^hackerrank.*");
				boolean end= currLine.matches(".*hackerrank$");
				int out=begin?end?0:1:end?2:-1;
				System.out.println(out);
			}
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
