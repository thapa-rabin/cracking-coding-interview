import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 2) {
            // files for TestCases and ExpectedResults
            File testFile = new File(args[0]);
            File resultFile = new File(args[1]);

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
        else {
            System.out.println("Arguments Missing.");
        }
    }

    // checks answer against the provided result
    public static void checkSolution(String test, String result) {
        Solution solution = new Solution();
        String answer = solution.checkUnique(test) ? "True" : "False";
        System.out.println(result.equalsIgnoreCase(answer) ? "Correct!" : "Incorrect!");
    }
}