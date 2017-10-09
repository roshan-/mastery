package euler.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BusStation {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "BusStation.txt");
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
			long sum= 0;
			int maxGroupSize= 0;
			Deque<Long> factors= new LinkedList<Long>();
			Deque<Long> mirrorFactors= new LinkedList<Long>();
			long[] groups= new long[inputSize];
			//########################## Your Algorithm goes in here###########################
			for (int i=0; i<inputSize; i++) {
				int currGroup= in.nextInt();
				if (currGroup>maxGroupSize) {
					maxGroupSize= currGroup;
				}
				sum+=currGroup;
				groups[i]=currGroup;
			}
			dbg("sum="+sum);
			dbg("maxGroupSize="+maxGroupSize);
			//find factors
			int upto= (int)Math.floor(Math.sqrt(sum));
			for (long factor=1;factor<=upto;factor++) {
				if (sum%factor==0) {
					if (factor>=maxGroupSize) {
						if (doesBusFitGroups(inputSize,
								groups, factor)) factors.add(factor);
					}
					long mirrorFactor= sum/factor;
					if ((mirrorFactor != factor) && doesBusFitGroups(inputSize, groups, mirrorFactor)) {
						mirrorFactors.add(sum/factor);
					}
				}
			}
			for (Long factor : factors) {
				System.out.print(factor+" ");
			}
			int size= mirrorFactors.size();
			for (int l=0;l<size;l++) {
				System.out.print(mirrorFactors.removeLast()+" ");
			}
			//#################################################################################
			in.close();
			if (local) {
				fs.close();
			}
		//######################################################### End Algorithm
		}
		private boolean doesBusFitGroups(int inputSize, long[] groups, long i) {
			boolean perfectFit= true;
			long emptySeats= i;
			for (int j=0; j<inputSize;j++) {
				emptySeats= emptySeats-groups[j];
				if (emptySeats==0) emptySeats= i; // new bus
				else if (emptySeats<0) {
					perfectFit= false;
					break;
				}
			}
			return perfectFit;
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
