package hrank;

import java.util.Scanner;

public class AppleAndOrange {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int leftHouse = in.nextInt();
        int rightHouse = in.nextInt();
        int appleTree = in.nextInt();
        int orangeTree = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int appleCount=0;
        while (m>0) {
            int appleFallPoint = in.nextInt();
            if ((appleTree + appleFallPoint >= leftHouse) && (appleTree + appleFallPoint <= rightHouse)) appleCount++;
            m--;
        }
        int orangeCount=0;
        while (n>0) {
            int orangeFallPoint = in.nextInt();
            if ((orangeTree + orangeFallPoint >= leftHouse) && (orangeTree + orangeFallPoint <= rightHouse)) orangeCount++;
            n--;
        }
        System.out.println(appleCount);
        System.out.println(orangeCount);
    }
}
