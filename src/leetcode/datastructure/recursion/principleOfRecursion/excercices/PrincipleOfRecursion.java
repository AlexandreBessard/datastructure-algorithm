package leetcode.datastructure.recursion.principleOfRecursion.excercices;

//https://leetcode.com/explore/featured/card/recursion-i/250/principle-of-recursion/1439/
public class PrincipleOfRecursion {


    public static void main(String[] args) {
        printStringInReverseOrder("TEST");
    }

    static void printStringInReverseOrder(String s) {
        reverseOrder(0, s.toCharArray());
    }

    private static void reverseOrder(int index, char[] c) {
        if(c == null || index >= c.length) return;
        reverseOrder(index + 1, c);
        System.out.println(c[index]);
    }


}
