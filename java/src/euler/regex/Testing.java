package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Testing {
	public static void main(String[] args) throws FileNotFoundException {
		Solution s= new Solution(true, true, "inRegexUsUk.txt");
		Testing t= new Testing();
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
		public static class Triple {
			Pattern pattern;
			String word;
			int count= 0;

			Triple(String word, Pattern p) {
				this.pattern= p;
				this.word= word;
			}
		}
		public void run() throws FileNotFoundException {
			Scanner in= initialize();
			//########################## Your Algorithm goes in here
			// Get all lines
			int inputSize= in.nextInt();
			in.nextLine();
			if (debug) System.out.println("Number of Lines=" + inputSize);
			List<String> lines= new ArrayList<String>();
			for (int i=0;i<inputSize;i++) {
				lines.add(in.nextLine());
			}

			// Get all words
			List<Triple> words= new ArrayList<Triple>();
			int wordCount= in.nextInt();
			in.nextLine();
			for(int i=0;i<wordCount;i++) {
				String currWord= in.nextLine();
				String regex= "(" + currWord.substring(0, currWord.length()-2)+"(ze|se))";
				dbg("Regex="+regex);
				Pattern p= Pattern.compile(regex);
				Triple t= new Triple(currWord, p);
				words.add(t);
			}

			in.close();
			// Analyze
			for (Triple t : words) {
				int matches= 0;
				for (String line : lines) {
					dbg("line="+line);
					Matcher m= t.pattern.matcher(line);
					while(m.find()) {
						matches++;
					}
				}
				System.out.println(matches);
				t.count= matches;
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
