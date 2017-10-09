package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FillingJars {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "FillingJars.txt");
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
			long numJars= in.nextLong();
			dbg("inputSize="+numJars);
			//########################## Your Algorithm goes in here###########################
			//#################################################################################
			long numOps= in.nextLong();
			dbg("numOps="+numOps);
			long totCandies= 0;
			for (long i=0; i<numOps; i++) {
				in.nextLine();
				long startIndex= in.nextInt();
				long endIndex= in.nextInt();
				if (startIndex>endIndex) {
					long temp= endIndex;
					endIndex= startIndex;
					startIndex= temp;
				}
				long add= in.nextInt();
				dbg(startIndex + " " + endIndex + " " + add);
				totCandies += (endIndex-startIndex+1)*add;
			}
			System.out.println(totCandies/numJars);
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
