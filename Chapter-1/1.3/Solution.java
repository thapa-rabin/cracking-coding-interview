/*
 * Problem 1.3: URLify
 * Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end 
 * to hold the additional characters, and that you are given the "true" length of the string. 
 * (Note: If implementing in Java, please use a character array so that you can perform this operation in place.)
 * EXAMPLE
 * Input: "Mr  John Smith     ", 13
 * Output: "Mr%20John%20Smith"
 */

 // Clarification is needed: If there multiple consecutive blank spaces, are all the spaces in that stretch
 // replaced by only one '%20'?


 class Solution {
    /*
     * Solution 1: 
     * This works only for Test cases with no leading blanks in char array. 
     * Input string can have multiple consecutive blank spaces (stretch). Each stretch replaced by '%20'
     * 
     */
    static void urlify(char[] chars, int trueLength) {

        int numOfBlanks = countBlanks(chars);

        int outputLength = trueLength + 2 * numOfBlanks;
        chars[outputLength] = '\0';
        int j = chars.length - 1;
        while(chars[j] == ' ' || chars[j] == 0) {
            j--;
        }
        for(int i = outputLength-1; i >= 0; i--) {
            if(chars[j] == ' ') {
                j--;
                while (chars[j] == ' ') {
                    j--;
                }

                chars[i] = '0';
                chars[--i] = '2';
                chars[--i] = '%';
            }
            else {
                chars[i] = chars[j];
                j--;
            }
            
        }
    }

    // Helper function for Solution 1
    // counts stretches of white spaces (includes spaces following non-blank characters only)
    private static int countBlanks(char[] chars) {
        int count = 0;
        char previousChar = 0;

        for(int i = 0; i < chars.length; i++) {
            if(previousChar == ' ' && (chars[i] != ' ' && chars[i] != 0)) {
                count++;
            }
            previousChar = chars[i];
        }
        return count;
    }

    /*
     * Solution 2:
     * Applicable to single spaces between non-blank characters.
     * This is not exactly as per the book. My understanding of the problem might be different - this solution seems to work.
     * Each blank space is replaced by '%20'.
     */
    static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                spaceCount++;
            }
        }

        int index = trueLength + 2 * spaceCount;
        if(trueLength < str.length) str[index] = '\0';

        for(int i = str.length-1; i >= 0; i--) {
            if(str[i] == 0) {} // this is an extra condition resulted by appending null characters (0) to str in Test class
            else if(str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            }
            else {
                str[index - 1] = str[i];
                index--;
            }
        }


    }
    
 }