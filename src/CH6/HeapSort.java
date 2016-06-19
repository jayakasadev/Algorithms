package CH6;

import Util.StopwatchCPU;
import com.sun.javaws.exceptions.InvalidArgumentException;

/**
 * Class Defines the HeapSort Protocol
 *
 * @author Jaya Kasa
 * @version 1.0
 */
public class HeapSort {
    private int[] input = null;
    private int heapsize = 0;
    public HeapSort(int[] input, int heapsize){
        this.input = input;
        this.heapsize = heapsize;
    }

    /**
     * Method for sorting an array into increasing order via HeapSort
     * T(n) = O(n) + n*lgn = O(nlgn)
     *
     * @return
     */
    public double HeapSort(){
        StopwatchCPU cpu = new StopwatchCPU();
        MaxHeap();
        for(int a = input.length-1; a > 0; a--){
            int temp = input[a];
            input[a] = input[0];
            input[0] = temp;
            heapsize -=1;
            MaxHeapify(0);
        }
        return cpu.elapsedTime();
    }

    /**
     * Method for building a max heap of an array from the bottom up.
     *
     * When called on a node of height, h, runtime is O(h)
     * This is because height = lgn, and at a height of h, there are at most Math.ceil(n/(2^(h+1))) nodes.
     * After a little fancy math, as seen in Introduction to Algorithms by Cormen on page 159, we see than runtime of this method is O(n) and not O(nlgn) as one would suspect.
     *
     */
    public void MaxHeap(){
        //StopwatchCPU cpu = new StopwatchCPU();
        //System.out.println(input.length + " " + ((input.length-1)/2));
        for(int a = ((input.length-1)/2); a > -1; a--){
            MaxHeapify(a);//runtime varies by height --> 2^h = n --> lgn=h
        }
        //return cpu.elapsedTime();
    }

    /**
     * Method to max-heapify an array
     * T(n) = T(2n/3) + 10 = O(lgn) using Master's Theorem
     * A node's subtree has at most 2n/3 nodes. This occurs when one level is exactly half full.
     * Ex: for a 23 element tree, the root at 0, has 15 elements on the left, and 7 on the right. Meaning it has just under 2/3 of the nodes on the left.
     * Ex: for a 11 element tree, the root at 0, has 7 elements on the left and 3 on the right. Meaning it has just under 2/3 of the nodes on the left.
     * During exploration, you will go down one level at a time and examine each of the nodes along the way until you find a suitable place to put the newly inserted node
     * to maintain the max heap property.
     * At best you will examine only n/3 nodes.
     *
     * @param index
     * @return runtime of algorithm
     */
    private void MaxHeapify(int index){
        //StopwatchCPU cpu = new StopwatchCPU();
        int left = 2*index + 1;
        int right = left + 1;
        //System.out.println(index + " " + left + " " + right);
        int largest = 0;
        if(left <= heapsize && (input[index] < input[left]))//had to add the condition right <= heapsize to prevent an index out of bounds exception
            largest = left;
        else
            largest = index;
        if(right <= heapsize && input[right] > input[largest])
                largest = right;
        if(largest != index){
            int temp = input[index];
            input[index] = input[largest];
            input[largest] = temp;
            MaxHeapify(largest);
        }
        //return cpu.elapsedTime();
    }

    /**
     * Method for getting the maximum element in a heap.
     *
     * @param input
     * @return
     */
    public int HeapMax(){
        return input[0];
    }

    /**
     * Method for extracting the maximum element from a max heap.
     * After extracting the max element, the heap size is reduced by 1
     * T(n) = 4 + O(lgn) = O(lgn)
     *
     * @return
     * @throws IllegalArgumentException
     */
    public int ExtractMax() throws Exception {
        if(heapsize < 0){
            throw new IllegalArgumentException("HeapUnderFlow");
        }
        int max = input[0];
        input[0] = input[heapsize];
        heapsize-= 1;
        MaxHeapify(0);
        return max;
    }

    /**
     * Method to increase the key of the given key at index i.
     * Runs in O(lgn) because you only traverse up a tree level by level from the given index.
     * So at height h, you only do h iterations up to the root, given lgn = h.
     *
     * T(n) = 4 + h = 4 + lgn = O(lgn)
     *
     * @param index
     * @param key
     * @throws IllegalArgumentException
     */
    public void HeapIncreaseKey(int index, int key) throws IllegalArgumentException{
        if(index >= input.length){
            throw new IllegalArgumentException("Index is out of bounds");
        }
        if(key < input[index]){
            throw new IllegalArgumentException("New Key is smaller than the current key at index " + index);
        }
        input[index] = key;
        int parent = (index-1)/2;
        while(index > 0 && input[parent] < input[index]){
            int temp = input[parent];
            input[parent] = input[index];
            input[index] = temp;
            parent = (index-1)/2;
        }
    }

    public void MaxHeapInsert(int key) throws IndexOutOfBoundsException{
        if(heapsize + 1 >= input.length){
            throw new IndexOutOfBoundsException("Array is full");
        }
        heapsize += 1;
        input[heapsize] = -1 * Math.abs(input[heapsize] * key);
        HeapIncreaseKey(heapsize, key);
    }
}
