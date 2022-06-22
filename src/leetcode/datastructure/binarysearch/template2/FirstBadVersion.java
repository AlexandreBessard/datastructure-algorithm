package leetcode.datastructure.binarysearch.template2;

//https://leetcode.com/explore/learn/card/binary-search/126/template-ii/947/
public class FirstBadVersion {

    public static void main(String[] args) {
        //Output: 5
        System.out.println(new FirstBadVersion().firstBadVersion(6));
    }

    //true if bad version
    private boolean isBadVersion(int n) {
        int badVersion = 5;
        return n >= badVersion;
    }

    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
