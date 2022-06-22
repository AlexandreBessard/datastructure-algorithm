package tests.bitwise;

public class BitShifting {

    /*
    n & 1 will do a binary comparison between n, and 1 which is 00000000000000000000000000000001 in binary.
    As such, it will return 00000000000000000000000000000001 when n ends in a 1 (positive odd or negative even number)
    and 00000000000000000000000000000000 otherwise.
     */
    public static void main(String[] args) {

        for(int n = 0; n < 10; n++) {
            //Pair
            if(n % 2 == 0) {
                System.out.println("Value : "  + n + ", => " + (n&1));
            }
            //Impair
            //Positive odd or negative even number
            else {
                System.out.println("Value : "  + n + ", => " + (n&1));
            }
        }

    }




}

