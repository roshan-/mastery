package hrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class DnaHealth {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner  in    = new Scanner(System.in);
        boolean local=true;
        if (local) {
            in = new Scanner(new FileReader("input/dnaHealth_input13.txt"));
        } else {
            in = new Scanner(System.in);
        }
        int      n     = in.nextInt();
        String[] genes = new String[n];
        for(int genes_i=0; genes_i < n; genes_i++){
            genes[genes_i] = in.next();
        }
        long[] health = new long[n];
        for(int health_i=0; health_i < n; health_i++){
            health[health_i] = in.nextInt();
        }
        int s = in.nextInt();
        long maxHealthyScore=0L;
        long minHealthyScore=999999999L;
        for(int a0 = 0; a0 < s; a0++){
            int first = in.nextInt();
            int last = in.nextInt();
            String d = in.next();

            int currentHealthyScore=0;
            int currentCharacter = 0;
            while (currentCharacter < d.length()) {
                for (int validGeneIndex = first; validGeneIndex <= last; validGeneIndex++) {
                    String currentMatch = genes[validGeneIndex];
                    if ((currentCharacter+currentMatch.length())<=d.length() && d.substring(currentCharacter, currentCharacter+currentMatch.length()).equals(currentMatch)) {
                        currentHealthyScore += health[validGeneIndex];
                    }
                }
                currentCharacter++;
            }
            //System.out.println(currentHealthyScore);
            if (currentHealthyScore > maxHealthyScore) maxHealthyScore=currentHealthyScore;
            if (currentHealthyScore < minHealthyScore) minHealthyScore=currentHealthyScore;
        }
        System.out.println(minHealthyScore + " " + maxHealthyScore);
        in.close();
    }
}
