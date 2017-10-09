package euler;

import java.math.BigDecimal;
import util.Result;

public class Euler {

    private Euler() {}; // Static functions

    public static Result getNthPrimeSimple(int n) {
        long startTime= System.nanoTime();
        long startMemory= Runtime.getRuntime().freeMemory();
        int currentPrime= 2;
        int primesFound= 1;
        do {
            boolean nextPrimeFound= false;

            do {
                int i=2;
                currentPrime++;
                boolean foundDivisor= false;
                while(i<currentPrime) {
                    if (currentPrime % i == 0) {
                        foundDivisor= true;
                        break;
                    }
                    i++;
                }
                if (!foundDivisor) {
                    nextPrimeFound= true;
                    primesFound++;
                }
            } while (!nextPrimeFound);

        } while (primesFound < n);
        return new Result(currentPrime, System.nanoTime()-startTime, startMemory-Runtime.getRuntime().freeMemory());
    }

    public static Result getNthPrime(int n) {
        long startTime= System.nanoTime();
        long startMemory= Runtime.getRuntime().freeMemory();

        // initialize
        int primesFound= 1;
        long currentPrime= 2;
        Result[] results= new Result[n];
        results[0]= new Result(2, System.nanoTime()-startTime, startMemory-Runtime.getRuntime().freeMemory());

        do {
            boolean nextPrimeFound= false;

            do {
                int i=0;
                currentPrime++;
                boolean foundDivisor= false;
                long checkUpto = (long)Math.floor(Math.sqrt(currentPrime));
                while(results[i].getResult() <= checkUpto) {
                    if (currentPrime % results[i++].getResult() == 0) {
                        foundDivisor= true;
                        break;
                    }
                }
                if (!foundDivisor) {
                    nextPrimeFound= true;
                    results[primesFound]= new Result(currentPrime, System.nanoTime()-startTime, startMemory-Runtime.getRuntime().freeMemory());
                    primesFound++;
                }
            } while (!nextPrimeFound);

        } while (primesFound < n);

        for (int i=0; i<n; i++) {
//            System.out.printf("%7d:%15d:%,15d,%,15d\n",i, results[i].getResult(), results[i].getTimeToCompute(), results[i].getMemoryFootprint());
        }
        return results[n-1];
    }

    public static long getLargeSum() {
        BigDecimal l= new BigDecimal("37107287533902102798797998220837590246510135740250");
        System.out.println(l.toString());
        return 0L;
    }

    public static void solveNthPrime() {
        int n=10000001;
        Result result= Euler.getNthPrime(n);
        System.out.printf("%dth prime : %d, time:%,d est_memory: %,d%n",n, result.getResult(), result.getTimeToCompute(), result.getMemoryFootprint());
    }

    public static void solveNthPrimeSimple() {
        int n=100001;
        Result result= Euler.getNthPrimeSimple(n);
        System.out.printf("%dth prime : %d, time:%,d est_memory: %,d%n",n, result.getResult(), result.getTimeToCompute(), result.getMemoryFootprint());
    }

    public static void main(String[] args) {
        System.out.printf("Free Memory: %,d; Max Memory: %,d%n",Runtime.getRuntime().freeMemory(), Runtime.getRuntime().maxMemory());
        solveNthPrime();                          // 007
        //solveNthPrimeSimple();                         // 007
        //getLargeSum();                              // 013
    }

}
