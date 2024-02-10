/*
 * Problem 1.4: Palindrome Permutation
 * Given a string, write a function to check if it is a permutaion of a palindrome. A palindrome is a word or phrase that is the same
 * forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class Solution {
    /*
     * Solution 1: Using boolean array
     * An int array can also be used to keep counts. If we do that, we need to check later if each count is odd or enen.
     */
    static boolean checkPalindromePermutation(String str) {
        int N = 26; // considering only lowercase alphabets
        boolean[] checklist = new boolean[N];
        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (index >= 0 && index < N) {
                checklist[index] = !checklist[index];
            }
        } 

        int trueCounts = 0;
        for(int i = 0; i < N; i++) {
            if(checklist[i]) trueCounts++;
            if(trueCounts > 1) return false;
        }
        return true;
    }
}