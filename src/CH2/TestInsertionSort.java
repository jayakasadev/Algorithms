package CH2;

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
       double runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 10 + " elements.");

       input = RandomIntArray.randomArray(100);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 100 + " elements.");

       input = RandomIntArray.randomArray(1000);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 1000 + " elements.");

       input = RandomIntArray.randomArray(10000);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 10000 + " elements.");

       input = RandomIntArray.randomArray(100000);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 100000 + " elements.");

       input = RandomIntArray.randomArray(1000000);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 1000000 + " elements.");
       /*
       input = RandomIntArray.randomArray(10000000);
       runtime = InsertionSort.testSort(input);
       System.out.println("Took " + runtime + " seconds to sort input of " + 10000000 + " elements.");
       */
   }
}
