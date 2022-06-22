package tests.bitwise;

public class BitwiseTests {

    public static void main(String[] args) {



        int x = 4;
        System.out.println(x >>= 1);
        System.out.println(x);

    }

    /*
    '<<' signed left shift
    Explanations:
    4 in binary is represented like that:
    16 | 8 | 4 | 2 | 1
    0    0   1   0   0   == 4
    '>> 1': signed right shift 1 time
    0 |  0 | 0 | 1 | 0   == 2
    '>> 2'; signed right shift 2 times
    0 | 0 |  0 | 0 | 1   == 1
     */


}
