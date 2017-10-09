package nirvana.training.istreet.regex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MaximizingXOR {
	public static void main(String[] args) throws IOException {
		boolean experimentBeforeRun= false;
		boolean debug= true;
		Solution s= new Solution(debug, "MaximizingXOR.txt");
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
		public static class FastBit {
			private static final int FAST_BIT_VALUES= 65;
			private static final long[] zeroBits= new long[FAST_BIT_VALUES];
			private static final long[] oneBits= new long[FAST_BIT_VALUES];
			private static void init()
			{
				long fill= 1L;
				for (int i=1; i<FAST_BIT_VALUES; i++) {
					zeroBits[i]= fill;
					fill = fill<<1;
				}
				fill= 0xFFFFFFFFFFFFFFFFL;
				oneBits[0]= fill;
				fill= fill<<1;
				for (int i=1; i<FAST_BIT_VALUES; i++) {
					oneBits[i]= fill;
					fill= (fill<<1) + 0x01;
				}
			}
			public static long getLong(int kthBit) {
				return zeroBits[kthBit];
			}

			public static boolean isKthBitSet(long l, int k) {
				return (l & zeroBits[k]) != 0;
			}

			public static long setKthBit(long l, int k) {
				return l | zeroBits[k];
			}

			public static long unsetKthBit(long l, int k) {
				return l & oneBits[k];
			}
		}
		//################### End Private Classes
		// = floor(log2(n))
		public void run() throws IOException {
			FastBit.init();
			Scanner in= initialize();
			int min= in.nextInt();in.nextLine();
			dbg("l="+min);
			int max= in.nextInt();
			dbg("r="+max);
			int maxBits= (int)Math.ceil(Math.log(max)/Math.log(2));
			//########################## Your Algorithm goes in here###########################
			long high= max;
			long low= min;
			// Invariants:
			// a<b;
			// if you set a bit (increase it's value), it should be below r
			// if you unset a bit (decrease it's value), it should be above l
			for (int i=maxBits;i>=0;i--) {
				if (FastBit.isKthBitSet(low, i) && FastBit.unsetKthBit(high, i)>=min) {
					high= FastBit.unsetKthBit(high, i);
				} else if (FastBit.setKthBit(high, i)<=max) {
					high= FastBit.setKthBit(high, i);
				} else if (!FastBit.isKthBitSet(high, i) && FastBit.setKthBit(low, i)<=max) {
					low= FastBit.setKthBit(low, i);
				}
				if (low>high) {
					long temp= high;
					high= low;
					low= temp;
				}
			}
			dbg("low="+low+"; high="+high);
			System.out.println(low^high);


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
