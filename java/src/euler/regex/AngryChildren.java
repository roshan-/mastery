package euler.regex;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "AngryChildren.txt");
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
			int numCandyBags= in.nextInt();in.nextLine();
			dbg("inputSize="+numCandyBags);
			int numChildren= in.nextInt();
			int[] numCandiesInBags= new int[numCandyBags];
			//########################## Your Algorithm goes in here###########################
			for (int i=0; i<numCandyBags; i++) {
				in.nextLine();
				numCandiesInBags[i]= in.nextInt();
			}
			Arrays.sort(numCandiesInBags);
			int unfairIndex= numCandiesInBags[numChildren-1]-numCandiesInBags[0];
			for (int j=1; j<numCandyBags-numChildren; j++) {
				int compUnfairIndex= numCandiesInBags[j+numChildren-1]-numCandiesInBags[j];
				if (compUnfairIndex < unfairIndex) {
					unfairIndex= compUnfairIndex;
				}
			}
			System.out.println(unfairIndex);
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
