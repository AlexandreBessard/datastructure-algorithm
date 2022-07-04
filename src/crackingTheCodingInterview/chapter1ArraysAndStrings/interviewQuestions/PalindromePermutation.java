package crackingTheCodingInterview.chapter1ArraysAndStrings.interviewQuestions;

/*
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
 */
public class PalindromePermutation {

    public static void main(String[] args) {
        String s = "Tact Cao";
        var obj = new PalindromePermutation();
        //System.out.println(obj.isPermutationOfPalindrome(s));
        System.out.println(obj.isPermutationOfPalindromeOptmized(s));
    }

    /*
    O(n) time where length is the length of the string.
     */
    public boolean isPermutationOfPalindrome(String phrase) {
        return buildCharFrequencyTable(phrase);
        //Optimization
        //return checkMaxOneOdd(table);
    }
    //Optimized solution 3:
    public boolean isPermutationOfPalindromeOptmized(String phrase) {
        int bitVector = createBitVector(phrase);
        return bitVector == 0 || checkExactlyOneBitSet(bitVector);
    }
    //Check exactly one bit is set
    private boolean checkExactlyOneBitSet(int bitVector) {
        return (bitVector & (bitVector - 1)) == 0;
    }

    //Create bit vector for the string. Each letter with value i.th toggle the ith bit
    private int createBitVector(String phrase) {
        int bitVector = 0;
        for(char c : phrase.toCharArray()) {
            // x is -1 if not letter between a and z included
            int x = getCharNumber(c);
            bitVector = toggle(bitVector, x);
        }
        return bitVector;
    }
    //Toggle the i.th bit in the integer
    private int toggle(int bitVector, int index) {
        if(index < 0) return bitVector;
        /*
        Shift operator
        shift to the left bt the number of places given by the second operand.
        For example 5 << 3: What happens in this case - Every bit in the binary
        representation of the integer 5 is shifted by 3 positions to the left.
        All the places on the left are padded by zeros. That is:
        00000101  (5) becomes:
        00101000
         */
        int mask = 1 << index;
        if((bitVector & mask) == 0) {
            /*
            results in 1 when at least one the compared bits is 1 (or both)
            otherwise, results is 0.
             */
            bitVector |= mask;
        } else {
            // ~ means bit negation, takes every single bit of the number and flips its value.
            // 0 becomes 1 and vice versa

            /*
            & compare all the bits, set 1 only when the two compared bits are both equal to 1.
            For example: 1010 & 1100 would result in 1000 as the first bit from the left is the only
            one where both operands contain 1.
             */
            //x = x & 5 equivalent to &=
            bitVector &= ~mask;
        }
        return bitVector;
    }

    /* Check that no more than one character has an odd count */
    private boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for(int count: table) {
            if(count % 2 == 1) {
                if(foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }

    private int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if(a <= val && val <= z) {
            return (val - a);
        }
        return -1;
    }

    /* Count how many times each character appears */
    private boolean buildCharFrequencyTable(String phrase) {
        int countOdd = 0;
        //size of 26
        int[] table = new int[Character.getNumericValue('z')
                - Character.getNumericValue('a') + 1];
        for(char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if(x != -1) {
                table[x]++;
                //1 % 2 == 1
                if(table[x] % 2 == 1) {
                    countOdd++;
                } else {
                    countOdd--;
                }
            }
        }
        return countOdd <= 1;
    }




}
