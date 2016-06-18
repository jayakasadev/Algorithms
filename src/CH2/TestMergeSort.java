package CH2;

import Util.RandomIntArray;

/**
 * Class to test MergeSort
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestMergeSort {
    public static void main(String[] args){
        int[] arr = RandomIntArray.randomArray(10);
        double runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");
        /*
        for(int a : arr){
            System.out.println(a);
        }
        */

        arr = RandomIntArray.randomArray(100);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");

        arr = RandomIntArray.randomArray(1000);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");

        arr = RandomIntArray.randomArray(10000);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");

        arr = RandomIntArray.randomArray(100000);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");

        arr = RandomIntArray.randomArray(1000000);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");

        arr = RandomIntArray.randomArray(10000000);
        runtime = MergeSort.MergeSort(arr, 0, arr.length-1);
        System.out.println("Took " + runtime + " seconds to sort input of " + arr.length + " elements.");
    }
}
