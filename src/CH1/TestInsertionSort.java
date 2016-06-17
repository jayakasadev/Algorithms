package CH1;

import Util.RandomIntArray;

/**
 * Class tests InsertionSort class
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestInsertionSort {
   public static void main(String[] args){
       InsertionSort insertionSort = new InsertionSort();
       int[] input = RandomIntArray.randomArray(10);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);
       for(int x: input){
           System.out.print(x+"\t");
       }

       input = RandomIntArray.randomArray(100);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);

       input = RandomIntArray.randomArray(1000);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);

       input = RandomIntArray.randomArray(10000);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);

       input = RandomIntArray.randomArray(100000);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);

       input = RandomIntArray.randomArray(1000000);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);

       input = RandomIntArray.randomArray(10000000);
       InsertionSort.testSort(insertionSort, input);
       System.out.println(insertionSort);
   }
}
