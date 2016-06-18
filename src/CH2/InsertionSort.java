package CH2;

import Util.StopwatchCPU;

/**
 * Class defines the InsesrtionSort protocol
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class InsertionSort {

    /**
     * Static method defines the insertion sort protocol.
     * This method sorts in place which means that as long as you use a pass by reference system for arrays,
     * you will not have to return anything
     * This method is great for really small input.
     * //TODO append the output for the test classes to the test classes
     *
     * T(n) = n(2n+3) = 2n^2+6n
     * Worst Case: O(n^2)
     * Best Case: O(n)
     *
     * @param input
     */
    public static void sort(int[] input){
        for(int a = 1; a < input.length; a++){
            int key = input[a];
            int i = a-1;
            while(i >= 0 && input[i] > key){
                input[i+1] = input[i];
                i = i-1;
            }
            input[i+1] = key;
        }
    }

    static double testSort(int[] input){
        StopwatchCPU cpu = new StopwatchCPU();
        sort(input);
        return cpu.elapsedTime();
    }
}
