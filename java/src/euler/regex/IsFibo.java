package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class IsFibo {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "IsFibo.txt");
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
			int numLines= in.nextInt();
			dbg("inputSize="+numLines);
			long[] fibos= new long[1000000];
			fibos[0]= 0;
			fibos[1]= 1;
			long maxFibo= 1L;
			int maxFiboIndex= 1;
			//########################## Your Algorithm goes in here###########################
			for (int i=0; i<numLines; i++) {
				in.nextLine();
				long n= in.nextLong();
				if (n>maxFibo) {
					while (n>maxFibo) {
						maxFibo= fibos[maxFiboIndex]+fibos[maxFiboIndex-1];
						fibos[maxFiboIndex+1]= maxFibo;
						maxFiboIndex++;
						if (n==maxFibo) {
							System.out.println("IsFibo");
						}
					}
					if (n<maxFibo) {
						System.out.println("IsNotFibo");
					}
					//fill fibos till n
				} else {
					if (Arrays.binarySearch(fibos, 0, maxFiboIndex+1, n)>=0) {
						System.out.println("IsFibo");
					} else {
						System.out.println("IsNotFibo");
					}
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
