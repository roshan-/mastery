package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class GameOfRotation {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "GameOfRotation.txt");
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
			int inputSize= in.nextInt();in.nextLine();
			dbg("inputSize="+inputSize);
			//########################## Your Algorithm goes in here###########################
			long[] circList= new long[inputSize];
			long currPMEAN= 0;
			long sum= 0;
			for (int i=0; i<inputSize; i++) {
				long currValue= in.nextLong();
				circList[i]= currValue;
				currPMEAN = currPMEAN + currValue*(i+1);
				sum += currValue;
			}
			long maxPMEAN= currPMEAN;
			int peakIndex= 0;
			for (int i=0; i<inputSize; i++) {
				currPMEAN= currPMEAN - sum + circList[i]*(inputSize);
				if (currPMEAN > maxPMEAN) {
					maxPMEAN= currPMEAN;
					peakIndex= i;
				}
			}
			dbg("peakIndex="+peakIndex);
			System.out.println(maxPMEAN);

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
