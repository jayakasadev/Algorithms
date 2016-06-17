package CH4;

import Util.StopwatchCPU;

/**
 * Class helps you find the subarray with the largest sum for a given array
 * @author Jaya Kasa
 * @version 1.0
 */
public class MaximumSubArray {
    private int start;
    private int finish;
    private int sum;
    private double time;

    private MaximumSubArray(int start, int finish, int sum, double time){
        this.start = start;
        this.finish = finish;
        this.sum = sum;
        this.time = time;
    }

    private MaximumSubArray(int start, int finish, int sum){
        this.start = start;
        this.finish = finish;
        this.sum = sum;
    }

    private MaximumSubArray(MaximumSubArray msa, double time){
        this.start = msa.getStart();
        this.finish = msa.getFinish();
        this.sum = msa.getSum();
        this.time = time;
    }

    /**
     * Brute Force Method for finding the maximum subarray
     *
     * @param input
     * @return MaximumSubArray object describing the maximum subarray
     */
    public static MaximumSubArray BruteForce(int[] input){
        //System.out.println("BruteForce");
        StopwatchCPU cpu = new StopwatchCPU();
        int sum = input[0] + input[1];
        int start = 0;
        int finish = 1;

        for(int i = 0; i < input.length-1; i++){
            int temp = input[i]+input[i+1];
            //System.out.println("i = " + i + " temp = " + temp);
            int j;
            for(j = i+2; j < input.length; j++){
                temp += input[j];
                //System.out.println("j = " + j + " temp = " + temp);
                //System.out.println("sum = " + sum);
                if(temp > sum){
                    sum = temp;
                    start = i;
                    finish = j;
                }
            }
            //in case the last 2 elements are larger
            if(temp > sum){
                sum = temp;
                start = i;
                finish = j;
            }
        }
        //System.out.println("In Method: Start: " + start + " Finish: " + finish + " Sum: " + sum);
        if(sum < 0){
            return new MaximumSubArray(-1, -1, 0, cpu.elapsedTime());
        }
        return new MaximumSubArray(start, finish, sum, cpu.elapsedTime());
    }

    /**
     * Recursive Method for finding the maximum subarray
     *
     * @param input
     * @return MaximumSubArray object describing the maximum subarray
     */
    public static MaximumSubArray Recursive(int[] input, int low, int high){
        StopwatchCPU cpu = new StopwatchCPU();
        //base case
        if(high == low)
            return new MaximumSubArray(low, high, input[low]);
        int mid = ((low+high)/2);
        //left subarray
        MaximumSubArray leftmsa = Recursive(input, low, mid);
        //right subarray
        MaximumSubArray rightmsa = Recursive(input, mid+1, high);
        //crossing point subarray for a given midpoint
        //at the lowest level, this is the line that sums the two elements together to get the code going
        MaximumSubArray midmsa = CrossingMidpoint(input, low, mid, high);
        //System.out.println("## Left " + leftmsa.getSum() + " Mid  = " + midmsa.getSum() + " Right " + rightmsa.getSum() + "##\n");

        if(leftmsa.getSum() > rightmsa.getSum() && leftmsa.getSum() > midmsa.getSum()){
            if(leftmsa.getSum() < 0){
                return new MaximumSubArray(-1, -1, 0, cpu.elapsedTime());
            }
            return new MaximumSubArray(leftmsa, cpu.elapsedTime());
        }
        else if(rightmsa.getSum() > leftmsa.getSum() && rightmsa.getSum() > midmsa.getSum()){
            if(rightmsa.getSum() < 0){
                return new MaximumSubArray(-1, -1, 0, cpu.elapsedTime());
            }
            return new MaximumSubArray(rightmsa, cpu.elapsedTime());
        }
        if(midmsa.getSum() < 0){
            return new MaximumSubArray(-1, -1, 0, cpu.elapsedTime());
        }
        return new MaximumSubArray(midmsa, cpu.elapsedTime());
    }

    /**
     * Method for getting the sum of the midpoint
     * @param input
     * @param low
     * @param mid
     * @param high
     * @return
     */
    public static MaximumSubArray CrossingMidpoint(int[] input, int low, int mid, int high){
        StopwatchCPU cpu = new StopwatchCPU();
        int left=mid;
        int right = mid+1;
        int sum = 0;
        int leftsum = input[mid];
        int rightsum = input[mid+1];
        //System.out.println("mid: " + mid + " low " + low + " high " + high);
        for(int a = mid; a >= low; a--){
            //System.out.println("a = " + a + " sum = " + sum + " leftsum = " + leftsum);
            sum += input[a];
            //System.out.println("a = " + a + " sum = " + sum + " leftsum = " + leftsum + "\n");
            if(sum > leftsum){
                leftsum = sum;
                left = a;
            }
        }
        sum=0;
        for(int a = mid+1; a <= high; a++){
            //System.out.println("a = " + a + " sum = " + sum + " righttsum = " + rightsum);
            sum += input[a];
            //System.out.println("a = " + a + " sum = " + sum + " righttsum = " + rightsum + "\n");
            if(sum > rightsum){
                rightsum = sum;
                right = a;
            }
        }
        //System.out.println("left " + left + " right " + right);
        return new MaximumSubArray(left, right, leftsum+rightsum, cpu.elapsedTime());
    }

    /**
     * Linear Method for finding the maximum subarray
     *
     * @param input
     * @return
     */
    public static MaximumSubArray Linear(int[] input){
        //needs debugging
        StopwatchCPU cpu = new StopwatchCPU();
        int sum = 0;
        int start = -1;
        int finish = -1;
        int temp = 0;
        for(int a = 0; a < input.length; a++){
            //System.out.println("-->\ttemp = " + temp + " sum = " + sum + " input[a] = " + input[a] + " a = " + a + " start = " + start + " finish = " + finish);
            int curr = input[a];
            temp = Math.max(curr, temp + curr);
            if(temp > sum){
                sum = temp;
                finish = a;
            }
            //System.out.println("<--\ttemp = " + temp + " sum = " + sum + " input[a] = " + input[a] + " a = " + a + " start = " + start + " finish = " + finish +"\n");
        }
        temp = sum;
        start = finish;
        while(temp > 0){
            temp -= input[start];
            if(temp > 0){
                start--;
            }
        }

        return new MaximumSubArray(start, finish, sum, cpu.elapsedTime());
    }

    int getSum(){
        return sum;
    }

    int getStart(){
        return start;
    }

    int getFinish(){
        return finish;
    }

    @Override
    public String toString() {
        return "Start: " + start + " Finish: " + finish + " Sum: " + sum + "\nTook " + time + " seconds.";
    }
}