package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ServiceLane {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "ServiceLane.txt");
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
			//########################## Prepare Input   ########################################
			int lengthOfFreeway= in.nextInt();
			int inputSize= in.nextInt();in.nextLine();
			dbg("inputSize="+inputSize);
			int width[]= new int[lengthOfFreeway];
			for (int i=0; i<lengthOfFreeway;i++) {
				width[i]= in.nextInt();
			}
			//########################## Your Algorithm goes in here###########################
			for (int i=0; i<inputSize; i++) {
				in.nextLine();
				int entrySegment= in.nextInt();
				int exitSegment= in.nextInt();
				int minimumWidth= 3;
				for (int j=entrySegment;j<=exitSegment;j++) {
					if (width[j]<minimumWidth) minimumWidth= width[j];
				}
				System.out.println(minimumWidth);

			}
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
