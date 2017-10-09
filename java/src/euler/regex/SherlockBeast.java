package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SherlockBeast {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "SherlockBeast.txt");
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
			int inputSize= in.nextInt();
			dbg("inputSize="+inputSize);
			//########################## Your Algorithm goes in here###########################
			for (int i=0; i<inputSize; i++) {
				in.nextLine();
				int n= in.nextInt();
				int max5groups= n/3;
				int leftOvers= n%3;
				int max3groups= 0;
				while(leftOvers>0 && max5groups>0) {
					max5groups--;
					leftOvers+=3;
					max3groups+=leftOvers/5;
					leftOvers= leftOvers%5;
				}
				if (leftOvers>0) {
					System.out.println("-1");
				} else {
					for(int fives=0; fives<max5groups; fives++) System.out.print("555");
					for(int threes=0; threes<max3groups; threes++) System.out.print("33333");
					System.out.println();
				}
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
