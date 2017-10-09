package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class UtopianTree {
	public static void main(String[] args) throws IOException {
		UtopianTree t= new UtopianTree();
		t.run();
	}
	private void run() throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "UtopianTree.txt");
		boolean canContinueAfterExperiment= fork(experimentBeforeRun);
		if (canContinueAfterExperiment) s.run();

	}
	private boolean fork(boolean experimentBeforeRun) {
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
			//########################## Your Algorithm goes in here###########################
			long[] growthList= new long[61];
			growthList[0]= 1L;
			int maxGrowthCalculated= 1;
			growthList[maxGrowthCalculated]= 2L;
			for (int i=0;i<numLines;i++) {
				in.nextLine();
				int currInput= in.nextInt();
				if (growthList[currInput]!=0) {
					System.out.println(growthList[currInput]);
				} else {
					long growth= growthList[maxGrowthCalculated];
					for (;maxGrowthCalculated<currInput;) {
						maxGrowthCalculated++;
						if (maxGrowthCalculated%2==1) {
							growth<<=1;
						} else {
							growth++;
						}
						// Cache results
						dbg("j="+maxGrowthCalculated+";growth="+growth);
						growthList[maxGrowthCalculated]= growth;
					}
					System.out.println(growth);
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
