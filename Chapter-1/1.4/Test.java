import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Checking method checkPalindromePermutation
        System.out.println("For Solution 1 -");
        checkSolution(1, 
                        scanFile(new File("TestCases.txt")), 
                        scanFile(new File("TestResults.txt"))
                    );
    }

    public static void checkSolution(int solutionNum, ArrayList<String> test, ArrayList<String> result) {
        if(test.size() == result.size()) {
            String answer = null;
            switch (solutionNum) {
                case 1:
                    for(int i = 0; i < test.size(); i++) {
                        System.out.print("Checking Test Case " + (i+1) + ":");
                        answer = Solution.checkPalindromePermutation(test.get(i)) ? "True" : "False";
                        System.out.println(result.get(i).equalsIgnoreCase(answer) ? "Correct!" : "Incorrect!");
                    }
                    break;
                default:
                    break;
            }  
        }
    }

    // reads TestCases and TestResults files
    public static ArrayList<String> scanFile(File file){
        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                list.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.print("File Not Found!");
        }
        return list;
    }
}