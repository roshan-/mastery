package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AlmostSortedInterval {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "AlmostSortedInterval-2.txt");
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
			int nums[]= new int[inputSize];
			dbg("inputSize="+inputSize);
			long sortIntervals= 0;
			int consecutiveAscendingNumbers= 0;
			for (int i=0;i<inputSize;i++) {
				nums[i]= in.nextInt();
				if (i>0 && nums[i]<nums[i-1]) {
					sortIntervals += (consecutiveAscendingNumbers*(consecutiveAscendingNumbers+1))>>1;
				consecutiveAscendingNumbers= 1;
				} else {
					consecutiveAscendingNumbers++;
				}
			}
			sortIntervals += (consecutiveAscendingNumbers*(consecutiveAscendingNumbers+1))>>1;
			System.out.println(sortIntervals);
			//########################## Your Algorithm goes in here###########################
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
