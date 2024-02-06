/*
 * Problem 1.2: Check Permutation
 * Given two strings, write a method to decide if one is the permutaion of the other.
 */
public class Solution {
    /*
    * Solution 1: Using array of boolean values
    * Case sensitive, white space character is significant
    * Time Complexity: O(n) where n is length of the string. 
    *                  Can also argue as O(1) or O(c) or O(min(c,n)) where c is size of character set
    * Space Complexity: O(1) or O(c) 
    */
    public boolean checkPermutationUsingBooleanArray(String s1, String s2) {
        if(s1.length() != s2.length()) { // Strings of unequal lengths cannot be permutaions of one another
            return false;
        }

        int N = 128; // 128 ASCII character set
        boolean[] checker = new boolean[N];

        for(int i = 0; i < s1.length(); i++) {
            checker[s1.charAt(i)]  = !checker[s1.charAt(i)];
            checker[s2.charAt(i)]  = !checker[s2.charAt(i)];
        }

        for(int i = 0; i < checker.length; i++) {
            if(checker[i])
                return false;
        }

        return true;
    }

    /*
     * Solution 2: Using Bit vector
     * Let's assume the string has only lowercase alphabets
     * Time Complexity: O(n) where n is length of the string. 
     *                  Can also argue as O(1) or O(c) or O(min(c,n)) where c is size of character set
     * Space Complexity: O(1) or O(c)
     */
    public boolean checkPermutationUsingBitVector(String s1, String s2) {
        if(s1.length() != s2.length()) { // Strings of unequal lengths cannot be permutaions of one another
            return false;
        }

        int bitVector = 0;
        for(int i = 0; i < s1.length(); i++) {
            int val = 1 << (s1.charAt(i) - 'a');
            val ^= 1 << (s2.charAt(i) - 'a');
            bitVector ^= val;
        }

        if(bitVector > 0) {
            return false;
        }

        return true;
    }

    /*
     * Solution 3: Using counter array
     * Case sensitive, white space character is significant
     * Previous solutions iterates over both strings completely. This might terminate early if strings are not each other's permutaion.
     * Time Complexity: O(n) where n is length of the string. 
     *                  Can also argue as O(1) or O(c) or O(min(c,n)) where c is size of character set
     * Space Complexity: O(1) or O(c)
     */
    public boolean checkPermutationUsingCounterArray(String s1, String s2) {
        if(s1.length() != s2.length()) { // Strings of unequal lengths cannot be permutaions of one another
            return false;
        }

        int N = 128; // 128 ASCII character set
        int[] checker = new int[N];

        for(int i = 0; i < s1.length(); i++) {
            checker[s1.charAt(i)]++;
        }

        for(int i = 0; i < s2.length(); i++) {
            checker[s2.charAt(i)]--;
            if(checker[s2.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // strings are of equal length, so if no neg values, no positive values either
    }
}
