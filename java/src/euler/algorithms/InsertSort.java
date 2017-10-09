package euler.algorithms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class InsertSort {
	public static void insertionSort(int[] ar) {
		int el= ar[ar.length-1];
		int curr=ar.length-1;
		for (;curr>0;curr--) {
			if (el>ar[curr-1]) {
				ar[curr]=el;
				printArray(ar);
				break;
			}
			else {
				ar[curr]=ar[curr-1];
				printArray(ar);
			}
		}
		if (curr==0){
			ar[curr]=el;
			printArray(ar);
		}
	}
	public static void printArray(int[] ar) {
		for (int n : ar) {
			System.out.print(n+" ");
		}
		System.out.println("");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			String s = "9B7D2C34A366BF890C730641E6CECF6F\n";
			FileOutputStream out= new FileOutputStream("out.txt");
			out.write(s.getBytes());
			out.close();
			FileInputStream data = new FileInputStream("in.txt");
			Scanner in= new Scanner(data);

			int n= in.nextInt();
			int[] ar= new int[n];
			for(int i=0;i<n;i++) {
				ar[i]= in.nextInt();
			}

			printArray(ar);
			insertionSort(ar);
			in.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
	}

}
