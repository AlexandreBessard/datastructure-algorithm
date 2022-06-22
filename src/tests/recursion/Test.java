package tests.recursion;

public class Test {

    public static void main(String[] args) {
        reverseString("ALEX");
        String s = new String("TEST");
        System.out.println(s.substring(1));
    }

    //Using recursion
    static void reverseString(String s) {
        reverse(0, s.toCharArray());
    }
    private static void reverse(int index, char[] c) {
        if(index >= c.length) return;
        reverse(index + 1, c);
        System.out.println(c[index]);
    }

}
