package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GemStones {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "GemStones.txt");
		boolean canContinueAfterExperiment= fork(experimentBeforeRun);
		if (canContinueAfterExperiment) s.run();
	}
	private static boolean fork(boolean experimentBeforeRun) {
		if (!experimentBeforeRun) return true;
		return false;
	}

//#############################################################################################################
	public static class Solution {
		//#################### Any sub-classes go in here .........
		//################### End Private Classes
		public void run() throws IOException {
			Scanner in= initialize();
			int numLines= in.nextInt();in.nextLine();
			dbg("inputSize="+numLines);
			//########################## Your Algorithm goes in here###########################
			boolean[][] elementMap= new boolean[26][numLines];
			for(int i=0; i<numLines;i++) {
				char[] currRock= in.nextLine().toCharArray();
				for (int j=0; j<currRock.length; j++) {
					int elementIndex= currRock[j]-'a';
					elementMap[elementIndex][i]= true;
				}
			}
			int numGemElements= 0;
			for (int j=0;j<26;j++) {
				boolean gemElement= true;
				for (int i=0; i<numLines; i++) {
					if (!elementMap[j][i]) {
						gemElement= false;
						break;
					}
				}
				if (gemElement) numGemElements++;
			}
			System.out.println(numGemElements);
			//#################################################################################
			in.close();
			if (local) {
				fs.close();
			}
		//######################################################### End Algorithm
		}


		private boolean local= false;
		private boolean debug= false;
		private String input= "Testing.txt";
		private FileInputStream fs;

		private void dbg(String s) {
			if (debug) System.out.println(s);
		}

		public Solution () {

		}
		public Solution(boolean debug, String input) {
			this.local= true;
			this.debug= debug;
			this.input= input;
		}

		private Scanner initialize() throws FileNotFoundException{
			if (!local) {
				return new Scanner(System.in);
			} else {
				fs= new FileInputStream(input);
				return new Scanner(fs);
			}
		}
		public static void main(String[] args) throws IOException {
			Solution s= new Solution();
			s.run();
		}
	}
//#################################################################################################################

}
