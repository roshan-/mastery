package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SayHi {
	public static void main(String[] args) throws FileNotFoundException {
		Solution s= new Solution(true, true, "SayHi.txt");
		SayHi t= new SayHi();
		if (t.scratchpad(false)) s.run();
	}
	private boolean scratchpad(boolean detour) {
		if (!detour) return true;
		System.out.println("hi bite draft relax similarly".matches("[Hh][Ii] [^Dd].*"));
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
			for (int i=0;i<numLines;i++) {
				String currline= in.nextLine();
				dbg(currline);
				if (currline.matches("[Hh][Ii] [^Dd].*")) {
					System.out.println(currline);
				}
			}
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
