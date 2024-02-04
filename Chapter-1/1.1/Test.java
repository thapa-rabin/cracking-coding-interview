import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // files for TestCases and ExpectedResults
        File testFile = new File("TestCases.txt");
        File resultFile = new File("TestResults.txt");

        // surround with try to prevent resource leak
        try (Scanner scTest = new Scanner(testFile)) {
            try (Scanner scResult = new Scanner(resultFile)) {
                int testCounter = 0;

                while(scTest.hasNextLine() && scResult.hasNextLine()) {
                    String testStr = scTest.nextLine();
                    String resultStr = scResult.nextLine();

                    System.out.print("Checking Test Case " + ++testCounter + ":");
                    checkSolution(testStr, resultStr);
                }
            }
        }

    }

    // checks answer against the provided result
    public static void checkSolution(String test, String result) {
        Solution solution = new Solution();

        // Uncomment a method to test
        // Solution 1
        //String answer = solution.isUniqueChars(test) ? "True" : "False";
        // Solution 2
        String answer = solution.isUniqueChars(test) ? "True" : "False";

        System.out.println(result.equalsIgnoreCase(answer) ? "Correct!" : "Incorrect!");
    }
}