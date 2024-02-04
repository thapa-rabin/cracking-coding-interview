/*
 * Problem 1.1 - Is Unique: 
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
 public class Solution {
    /*
     * Solution 1: Using an array of boolean values
     * Time Complexity: O(n) where n is length of the string. 
     *                  Can also argue as O(1) or O(c) or O(min(c,n)) where c is size of character set
     * Space Complexity: O(1) or O(c) 
     */
    public boolean isUniqueChars(String str) {
        // This solution assumes input string contains character among 128 ASCII characters
        int N = 128;
        boolean [] char_set = new boolean[N];

        if(str.length() > N) {
            return false;
        }

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if(char_set[index]) { // if true, char already found 
                return false;
            }
            char_set[index] = true;
        }
        return true;
    }

    /*
     * Solution 2: Using bit vector
     * This reduces space complexity by a factor of 8
     */
    public boolean isUniqueCharsUsingBits(String str) {
        int bitVector = 0;

        for(int i = 0; i < str.length() ;  i++) {
            int val = 1 << str.charAt(i);
            if((bitVector & val) > 0) { // happens when char is repeated
                return false;
            }
            // else track the char in bit vector
            bitVector += bitVector | 1 << str.charAt(i);

        }
        return true;
    }
  
    /*
     * If no additional data structures are allowed, we could
     * i. Loop through each char in the string comparing it to all chars afterwards. Time Complexity O(n^2).
     * ii. Sort the string and iterate to check if any pair of adjacent chars are same. Time Complexity O(nlogn).
     *     But some sorting algorithm (ex: Merge sort) uses additional space
     */


 }
