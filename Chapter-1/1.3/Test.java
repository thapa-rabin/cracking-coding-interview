import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Checking method urlify
        System.out.println("For Solution 1 -");
        checkSolution(1, 
                        scanFile(new File("TestCases1.txt")), 
                        scanFile(new File("TestResults1.txt"))
                    );
        
        // Checking method replaceSpaces
        System.out.println("For Solution 2 -");
        checkSolution(2, 
                        scanFile(new File("TestCases2.txt")), 
                        scanFile(new File("TestResults2.txt"))
                    );

    }

    public static void checkSolution(int solutionNum, ArrayList<String> test, ArrayList<String> result) {
        if(test.size() == result.size()) {
            StringBuilder answer = null;
            switch (solutionNum) {
                case 1:
                    for(int i = 0; i < test.size(); i++) {
                        System.out.print("Checking Test Case " + (i+1) + ":");
                        String[] testParts = test.get(i).split(",");

                        // We would want to pass the input string to solution method as a char array
                        // with enough spaces, if required, to accomodate extra characters while white space with '%20'
                        // Maximum need for extra spaces will be when a character and white space occur alternatively in the input string
                        // That mean number of extra spaces required is roughly 2*floor(true_length/2)
                        String buffer = new String(new char[Integer.parseInt(testParts[1])]);
                        char[] charArrayWithBuffer = testParts[0].concat(buffer).toCharArray();

                        Solution.urlify(charArrayWithBuffer, Integer.parseInt(testParts[1]));
                        
                        answer = new StringBuilder();
                        int k = 0;
                        while(charArrayWithBuffer[k] != '\0') {
                            answer.append(charArrayWithBuffer[k]);
                            k++;
                        }

                        System.out.println(result.get(i).equalsIgnoreCase(answer.toString()) ? "Correct!" : "Incorrect!");

                    }
                    break;
                case 2:
                    for(int i = 0; i < test.size(); i++) {
                        System.out.print("Checking Test Case " + (i+1) + ":");
                        String[] testParts = test.get(i).split(",");

                        String buffer = new String(new char[Integer.parseInt(testParts[1])]);
                        char[] charArrayWithBuffer = testParts[0].concat(buffer).toCharArray();

                        Solution.replaceSpaces(charArrayWithBuffer, Integer.parseInt(testParts[1]));
                        
                        answer = new StringBuilder();
                        int k = 0;
                        while(charArrayWithBuffer[k] != '\0') {
                            answer.append(charArrayWithBuffer[k]);
                            k++;
                        }

                        System.out.println(result.get(i).equalsIgnoreCase(answer.toString()) ? "Correct!" : "Incorrect!");

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