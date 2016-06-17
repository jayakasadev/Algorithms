package CH4;

import Util.RandomIntArray;
import Util.StopwatchCPU;

public class MaximumSubArrayTest {

    public static void main(String[] args) {
        StopwatchCPU cpu = new StopwatchCPU();
        int[] in1 = {1, 2, 3, -4, 5};
        int[] in2 = {1, 2, 3, -4, -2, 5};
        int[] in3 = {1, 2, 3, -4, -2, 5, 8, 112, -244, 19, -12, -1, -4, -5, -3, -1000, -10, 1001, 2};
        int[] in4 = {-1, -2, -3, -4, -2, -5, -8, -112, -244, -19, -12, -1, -4, -5, -3, -1000, -10, -1001, -2};

        //BruteForce Test
        System.out.println("Expected Start:0 Finish:4 Sum: 7");
        System.out.println(MaximumSubArray.BruteForce(in1));

        System.out.println("Expected Start:0 Finish:2 Sum: 6");
        System.out.println(MaximumSubArray.BruteForce(in2));

        System.out.println("Expected Start:17 Finish:18 Sum: 1003");
        System.out.println(MaximumSubArray.BruteForce(in3));

        System.out.println("Expected Start:-1 Finish:-1 Sum: 0");
        System.out.println(MaximumSubArray.BruteForce(in4));

        //Recursive Test
        System.out.println("\n\nExpected Start:0 Finish:4 Sum: 7");
        System.out.println(MaximumSubArray.Recursive(in1, 0, in1.length-1));

        System.out.println("Expected Start:0 Finish:2 Sum: 6");
        System.out.println(MaximumSubArray.Recursive(in2, 0, in2.length-1));

        System.out.println("Expected Start:17 Finish:18 Sum: 1003");
        System.out.println(MaximumSubArray.Recursive(in3, 0, in3.length-1));

        System.out.println("Expected Start:-1 Finish:-1 Sum: 0");
        System.out.println(MaximumSubArray.Recursive(in4, 0, in4.length-1));

        //linear test
        System.out.println("\n\nExpected Start:0 Finish:4 Sum: 7");
        System.out.println(MaximumSubArray.Linear(in1));

        System.out.println("Expected Start:0 Finish:2 Sum: 6");
        System.out.println(MaximumSubArray.Linear(in2));

        System.out.println("Expected Start:17 Finish:18 Sum: 1003");
        System.out.println(MaximumSubArray.Linear(in3));

        System.out.println("Expected Start:-1 Finish:-1 Sum: 0");
        System.out.println(MaximumSubArray.Linear(in4));


        //largetest
        System.out.println("\nCreating a large array of 100,000 random positive and negative elements");
        int[] largetest = RandomIntArray.randomArray(100000);
        System.out.println("\n--->BruteForce");
        System.out.println(MaximumSubArray.BruteForce(largetest));
        System.out.println("\n--->Recursive");
        System.out.println(MaximumSubArray.Recursive(largetest, 0, largetest.length-1));
        System.out.println("\n--->Linear");
        System.out.println(MaximumSubArray.Linear(largetest));

        System.out.println("This Entire Thing took: " + cpu.elapsedTime() + " seconds.");
    }
}
