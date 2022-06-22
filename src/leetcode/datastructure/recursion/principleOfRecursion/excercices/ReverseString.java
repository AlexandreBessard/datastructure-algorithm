package leetcode.datastructure.recursion.principleOfRecursion.excercices;

//https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1440/
public class ReverseString {

    public static void main(String[] args) {
        char[] c = {'H', 'e', 'l', 'l', 'o'};
        //new ReverseString().reverseString(c);
        System.out.println("Before => " + c);
        new ReverseString().reverseStringRecursively(c);
        System.out.println("After => " + c);
        for(char c1 : c) {
            System.out.print(c1 + ", ");
        }
    }

    /*
    Approach 2: Two Pointers, Iteration, \mathcal{O}(1)O(1) Space
     */
    //With O(1) extra memory (2 pointers)
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        System.out.println(s);
    }

    //Or using recursion
    public void reverseStringRecursively(char[] c) {
        reverse(0, c.length - 1, c);
    }

    private void reverse(int left, int right, char[]c ){
        if(left >= right) return;
        reverse(left + 1, right - 1, c);
        char tmp = c[left];
        c[left] = c[right];
        c[right] = tmp;
    }



}

