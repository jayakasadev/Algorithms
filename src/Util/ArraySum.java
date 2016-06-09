package Util;

/**
 * Class to get the sum of an array
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class ArraySum {
    public static int sum(int[] in, int start, int finish){
        int sum = 0;
        for(;start <= finish; start++){
            sum += in[start];
        }
        return sum;
    }
}
