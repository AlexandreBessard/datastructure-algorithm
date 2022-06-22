package leetcode.datastructure.dynamicProgramming.IntroToDynamicProgramming.excercices;

//https://leetcode.com/explore/learn/card/dynamic-programming/631/strategy-for-solving-dp-problems/4041/
public class NthTribonacciNumber {

    /*
    Example.
    index 3: 0 + 0 + 1
    index 4: 0 + 1 + 1
    index5: 1 + 1 + 2
    {0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504, 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744, 755476, 1389537, 2555757, 4700770, 8646064, ...}
     */
    public static void main(String[] args) {
        /*  n=4 --> 4
            n = 5 --> 7
            n = 6 --> 13
         */
        //Output 4
        System.out.println(new NthTribonacciNumber().tribonacci(4));


    }

    private int n = 38;
    public int[] nums = new int[n];

    NthTribonacciNumber() {
        nums[1] = 1;
        nums[2] = 1;
        for(int i = 3; i < this.n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i + 3];
        }
    }

    public int tribonacci(int n) {
        return this.nums[n];
    }


    /*public int tribonacci(int n) {
        if (n < 3) return n == 0 ? 0 : 1;

        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

     */

}
