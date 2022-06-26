package topAmazonQuestions.topAmazonQuestions2.highFrequency;

//https://leetcode.com/problems/flip-string-to-monotone-increasing/
public class FlipStringToMonotoneIncreasing {

    public static void main(String[] args) {
        String s = "010110";
        String s1 = "00011000";
        String s2 = "00110";
        var obj = new FlipStringToMonotoneIncreasing();
        //System.out.println(obj.minFlipsMonoIncrImpl1(s2));
        System.out.println(obj.minFlipsTest(s2));
    }

    /*
    Solution:
    https://leetcode.com/problems/flip-string-to-monotone-increasing/solution/
    Just for better understanding

    At each index i, you want to find out how many 1 is on the left of the index i,
    and how many 0 is on the right of index i. This is the total number you have to
    flip to make the string monotone, at anchor index=i , is number of 1 on the left
    plus number of zero on the right for index i. You find all the flips needed at each index i and get the minimum.
     */
    public  int minFlipsTest(String s) {
        int N = s.length();
        int[] oneBefore = new int[N];
        int[] zeroAfter = new int[N];
        //start at 1 because i=0, nothing is on the left
        for (int i = 1; i < N; ++i)
            oneBefore[i] = oneBefore[i-1] +
                    (s.charAt(i-1) == '1' ? 1 : 0);
        // you start at N-2 because at i=N-1, nothing is on the right so count is 0.
        for(int i=N-2;i>=0;i--)
            zeroAfter[i] = zeroAfter[i+1] +
                    (s.charAt(i+1) == '0' ? 1 : 0);
        int ans = Integer.MAX_VALUE;
        //   the reason you dont have to flip at index j
        //   but only before and after j is because it will
        //   work no matter if S.charAt(j)==0 or 1.
        for(int j = 0; j < N; j++) {
            ans = Math.min(ans, oneBefore[j] + zeroAfter[j]);
        }
        return ans;
    }


    public int minFlipsMonoIncrImpl1(String s) {
        int N = s.length();
        int[] P = new int[N + 1];
        for(int i = 0; i < N; i++) {
            P[i + 1] = P[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j <= N; j++) {
            //We want to evaluate
            //j having 0 zero
            //j having 1 zero
            //j having 2 zeros
            //j having 3 zeros and so on...
            ans = Math.min(ans, P[j] + (N-j)-(P[N]-P[j]));
        }
        return ans;
    }


}
