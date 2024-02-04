/*
 * Problem 1.1 - Is Unique: 
 * Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?
 */
 public class Solution {
    /*
     * Solution 1
     * Time Complexity: O(n) where n is length of the string. 
     *                  Can also argue as O(1) or O(c) or O(min(c,n)) where c is size of character set
     * Space Complexity: O(1) or O(c) 
     */
    public boolean checkUnique(String str) {
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
 }