package topAmazonQuestions.topAmazonQuestions2.highFrequency;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-total-strength-of-wizards/
public class SumOfTotalStrengthOfWizards {

    /*
    Explanation:
    https://leetcode.com/problems/sum-of-total-strength-of-wizards/discuss/2061787/Amazon-Online-Assessment
    */
    public static void main(String[] args) {
        int[] strength = {1,3,1,2};
        var obj = new SumOfTotalStrengthOfWizards();
        System.out.println(obj.totalStrength(strength));
    }

    public int totalStrength(int[] strength) {
        long mod = 1000000007, res = 0;
        int n = strength.length;
        long[] leftsum = new long[n + 1], rightsum = new long[n + 1];
        long[] leftmul = new long[n + 1], rightmul = new long[n + 1];
        Stack<Integer> asc = new Stack<>();
        for(int i = 0; i < n; i++) {
            //Prefix sum
            leftsum[i + 1] = (leftsum[i] + strength[i]) % mod;
            //Prefix multiple
            leftmul[i + 1] = (leftmul[i] + (long)(i + 1) * strength[i]) % mod;
        }
        for(int i = n - 1; i >= 0; i--) {
            rightsum[i] = (rightsum[i + 1] + strength[i]) % mod;
            rightmul[i] = (rightmul[i + 1] + (long)(n - i) * strength[i]) % mod;
        }
        // j is the exclusive right index
        for (int j = 0; j <= n; j++) {
            while (!asc.empty() && (j == n || strength[asc.peek()] >= strength[j])) {
                int k = asc.pop();
                int i = asc.empty() ? 0 : asc.peek() + 1;
                long left = (mod + leftmul[k + 1] - leftmul[i] - (i * (leftsum[k + 1] - leftsum[i])) % mod) % mod;
                long right = (mod + rightmul[k + 1] - rightmul[j] - ((n - j) * (rightsum[k + 1] - rightsum[j])) % mod) % mod;
                long sum = (left * (j - k) + right * (k - i + 1)) % mod;
                res = (res + sum * strength[k]) % mod;
            }
            asc.push(j);
        }
        return (int)res;
    }
}
