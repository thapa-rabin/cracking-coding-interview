/*
 * Problem 1.5: One Away
 * There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * EXAMPLE
 * pale,ple --> true
 * pales,pale --> true
 * pale,bale --> true
 * pale,bake --> false
 */
class Solution {
    /*
     * Solution 1: Using int array
     */
    static boolean isOneEditAway(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;

        int N = 26; // considering lowercase alphabets only
        int[] checklist = new int[N];

        for(char x : s.toCharArray()) checklist[x - 'a']++;
        for(char y : t.toCharArray()) checklist[y - 'a']--;

        int nonZeroCounter = 0;
        int productOfNonZeros = 1;
        for(int c : checklist) {
            if(c != 0) {
                nonZeroCounter++;
                productOfNonZeros *= c;
            }
        }

        if(nonZeroCounter == 0 // if strings are same
                    || (nonZeroCounter == 1 && Math.abs(productOfNonZeros) == 1) // if longer string is shorter string plus one char
                    || (nonZeroCounter == 2 && productOfNonZeros == -1)) { // if equal length strings are off by one char
            return true;
        }
        else return false;
    }
}