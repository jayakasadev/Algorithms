package CH2;

import Util.StopwatchCPU;

/**
 * Class implements the Merge Sort protocol
 * Runs in place
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class MergeSort {

    private MergeSort(){}

    public static double MergeSort(int[] input, int left, int right){
        StopwatchCPU cpu = new StopwatchCPU();
        //System.out.println("left " + left + " right " + right);
        int middle = (right+left)/2;
        if(left < right) {
            MergeSort(input, left, middle);
            MergeSort(input, middle + 1, right);
            Merge(input, left, middle+1, right);
        }
        return cpu.elapsedTime();
    }

    /**
     * Method to merge subarrays
     * T(n) = 12.5n + 9 = O(n)
     *
     * @param input
     * @param left
     * @param middle
     * @param right
     */
    private static void Merge(int[] input, int left, int middle, int right){
        /*
        System.out.println("\nMerging left" + left + " middle " + middle + " right " + right);
        for(int x : input){
            System.out.println(x);
        }
        System.out.println();
        */
        int n1 = middle - left;
        int n2 = right - middle + 1;
        int[] L = new int[n1];
        int[] R = new int[n2];
        int temp = left;
        for(int a = 0; a < n1; a++){
            L[a] = input[temp];
            temp++;
        }
        temp = middle;
        for(int a = 0; a < n2; a++){
            R[a] = input[temp];
            temp++;
        }
        int ln = 0;
        int rn = 0;
        int a = left;
        for(;a <= right; a++){
            //System.out.println(a + " " + ln + " " + rn);
            //System.out.println(L[ln] + " " + R[rn]);
            if(ln == n1) break;
            if(rn == n2) break;
            if(L[ln] < R[rn]){
                temp = L[ln];
                ln++;
            }
            else{
                temp = R[rn];
                rn++;
            }
            input[a] = temp;
        }
        while(ln < n1){
            input[a] = L[ln];
            ln++;
            a++;
        }
        while(rn < n2){
            input[a] = R[rn];
            rn++;
            a++;
        }
    }
}
