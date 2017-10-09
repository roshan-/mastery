package hrank;

import java.util.Scanner;

public class BigSort {
    private static int compare(String lhs, String rhs) {
       if (lhs.length() < rhs.length()) {
           return -1;
       } else if (lhs.length() > rhs.length()) {
           return 1;
       } else {
           int i=0;
           while (i<lhs.length() && lhs.charAt(i)==rhs.charAt(i)) i++;
           if (i==lhs.length()) return 0;
           if (lhs.charAt(i) < rhs.charAt(i)) return -1;
           else return 1;
       }
    }

    private static void quicksort(String[] a, int begin, int end) {
        if (begin >= end) return;
        String pivot = a[(begin+end)/2];

        int i=begin;
        int j=end;
        do {
            while (compare(pivot, a[i]) == 1) i++;
            while (compare(a[j], pivot) == 1) j--;
            if (i <= j) {
                String t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
                j--;
            }
        } while (i < j);
        if (j > begin) quicksort(a, begin, j);
        if (i < end) quicksort(a, i, end);

    }
    public static void sort(String[] a, int size) {
        quicksort(a, 0, size-1);
        for (int i=0; i<size; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size= in.nextInt();
        String[] a = new String[size];
        for (int i=0; i<size; i++) {
            a[i] = in.next();
        }
        sort(a, size);
    }

}
