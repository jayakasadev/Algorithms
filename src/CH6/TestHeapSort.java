package CH6;

import Util.RandomIntArray;
import Util.StopwatchCPU;

/**
 * Class to test HeapSort
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class TestHeapSort {
    public static void main(String[] args){
        int[] input = RandomIntArray.randomArray(10);
        //int[] input = {16, 4, 10, 14, 7, 9, 3, 2 ,8, 1};
        /*
        System.out.println("MAxHEap");
        HeapSort.MaxHeap(input);
        for(int x : input){
            System.out.println(x);
        }
        System.out.println();
        */

        HeapSort heapSort = new HeapSort(input, input.length-1);
        double runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        //for(int x : input){
        //    System.out.println(x);
        //}

        input = RandomIntArray.randomArray(100);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(100);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(1000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(10000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(100000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(1000000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(10000000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        input = RandomIntArray.randomArray(100000000);
        heapSort = new HeapSort(input, input.length-1);
        runtime = heapSort.HeapSort();
        System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");

        //input = RandomIntArray.randomArray(1000000000);
        //runtime = HeapSort.HeapSort(input);
        //System.out.println("Took " + runtime + " seconds to BuildMaxHeap " + input.length + " elements");


        System.out.println("#################Testing MaxHeap properties#################");
        input = RandomIntArray.randomArray(10);
        heapSort = new HeapSort(input, input.length-1);
        StopwatchCPU cpu = new StopwatchCPU();
        heapSort.MaxHeap();
        System.out.println("MaxHeap took " + cpu.elapsedTime() + " seconds.");
        for(int x : input){
            System.out.println(x);
        }
        //System.out.println("Extracting Max");
        try {
            int a = 0;
            while(a < input.length){
                a++;
                System.out.println("Extracting Max" + heapSort.ExtractMax());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(int x : input){
            System.out.println(x);
        }

        input = RandomIntArray.randomArray(10);
        heapSort = new HeapSort(input, input.length-2);
        cpu = new StopwatchCPU();
        heapSort.MaxHeap();
        System.out.println("MaxHeap took " + cpu.elapsedTime() + " seconds.");
        for(int x : input){
            System.out.println(x);
        }
        heapSort.MaxHeapInsert(12);
        System.out.println("MaxHeapInsert took " + cpu.elapsedTime() + " seconds.");
        for(int x : input){
            System.out.println(x);
        }
        heapSort.HeapSort();
        System.out.println("HeapSort took " + cpu.elapsedTime() + " seconds.");
        for(int x : input){
            System.out.println(x);
        }
    }
}
