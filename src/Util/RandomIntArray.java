package Util;

import Util.StopwatchCPU;

import java.util.Random;

/**
 * Create an int[] with random + and - ints
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class RandomIntArray {
    public static int[] randomArray(int length){
        StopwatchCPU cpu = new StopwatchCPU();
        int[] out = new int[length];
        int a = 0;
        while(a < length){
            out[a] = new Random().nextInt(1000+1+1000)-1000;
            a++;
        }
        //System.out.println("Tf = " + Tf + " To = " + To);
        //System.out.println("Took " + cpu.elapsedTime() + " seconds to create an array of " + length + " elements.");
        return out;
    }
}
