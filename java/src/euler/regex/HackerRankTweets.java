package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerRankTweets {
	public static void main(String[] args) throws FileNotFoundException {
		Solution s= new Solution(true, true, "HackerRankTweets.txt");
		HackerRankTweets t= new HackerRankTweets();
		if (t.fork(true)) s.run();
	}
	private boolean fork(boolean stop) {
		if (stop) return true;
		Pattern p= Pattern.compile("(fam(i|y|l))");
		Matcher m= p.matcher("infami dmy famy family");
		int count=0;
		while(m.find()) {
			System.out.println(m.group(0));
			count++;
		}
		System.out.println(count);
		System.out.println(m.groupCount());
		return false;
	}

	public static class Solution {
		//#################### Any sub-classes go in here .........
		//################### End Private Classes
		public void run() throws FileNotFoundException {
			Scanner in= initialize();
			//########################## Your Algorithm goes in here
			int numLines= in.nextInt();in.nextLine();
			dbg("n="+numLines);
			int count= 0;
			for (int i=0;i<numLines;i++) {
				String currLine= in.nextLine();
				String regex= ".*(#|@| )[Hh][Aa][Cc][Kk][Ee][Rr][Rr][Aa][Nn][Kk].*";
				if (currLine.matches(regex)) {
					count++;
				}
			}
			System.out.println(count);
			//######################################################### End Algorithm
		}

		private boolean local= false;
		private boolean debug= false;
		private String input= "Testing.txt";

		private void dbg(String s) {
			if (debug) System.out.println(s);
		}

		public Solution () {

		}
		public Solution(boolean local, boolean debug, String input) {
			this.local= local;
			this.debug= debug;
			this.input= input;
		}

		private FileInputStream fs;
		private Scanner initialize() throws FileNotFoundException{
			if (!local) {
				return new Scanner(System.in);
			} else {
				fs= new FileInputStream(input);
				return new Scanner(fs);
			}
		}
		public static void main(String[] args) throws FileNotFoundException {
			Solution s= new Solution();
			s.run();
		}
	}

}
