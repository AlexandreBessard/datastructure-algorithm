package leetcode.datastructure.binarysearch.template1;

//https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
public class SqrtX {

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(10));
    }

    /*
    Time complexity: O(logN)
    Space complexity: O(1)
     */
    public int mySqrt(int x) {
        if(x < 2) return x;
        int left = 2, right = x / 2;
        long num;
        int pivot;
        while(left <= right) {
            pivot = left + (right - left) / 2;
            num = (long)pivot * pivot;
            if (num > x) right = pivot - 1;
            else if (num < x) left = pivot + 1;
            else return pivot;
        }
        return right;
    }
}
