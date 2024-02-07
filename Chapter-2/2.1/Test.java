import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Checking method deleteDupsUsingHashset
        System.out.println("For Solution 1 -");
        checkSolution(1, 
                        scanFile(new File("TestCases.txt")), 
                        scanFile(new File("TestResults.txt"))
                    );
        
        // Checking method deleteDupsNoBuffer
        System.out.println("For Solution 2 -");
        checkSolution(2, 
                        scanFile(new File("TestCases.txt")), 
                        scanFile(new File("TestResults.txt"))
                    );
    }

    static void checkSolution(int solutionNum, ArrayList<String> test, ArrayList<String> result) {
        if(test.size() == result.size()) {
            String answer = null;
            switch (solutionNum) {
                case 1:
                    for(int i = 0; i < test.size(); i++) {
                        System.out.print("Checking Test Case " + (i+1) + ":");

                        String[] testArray = test.get(i).split(",");
                        LinkedListNode<Integer> node = null;
                        node = populateLinkedList(testArray);

                        // deleting duplicates with deleteDupsUsingHashset 
                        Solution.deleteDupsUsingHashset(node);
                        answer = printLinkedList(node);
                        System.out.println(result.get(i).equalsIgnoreCase(answer) ? "Correct!" : "Incorrect!");
                    }
                    break;
                case 2:
                    for(int i = 0; i < test.size(); i++) {
                        System.out.print("Checking Test Case " + (i+1) + ":");

                        String[] testArray = test.get(i).split(",");
                        LinkedListNode<Integer> node = null;
                        node = populateLinkedList(testArray);

                        // deleting duplicates with deleteDupsNoBuffer 
                        Solution.deleteDupsNoBuffer(node);
                        answer = printLinkedList(node);
                        System.out.println(result.get(i).equalsIgnoreCase(answer) ? "Correct!" : "Incorrect!");
                    }
                    break;
                default:
                    break;
            }  
        }
    }

    // reads TestCases and TestResults files
    private static ArrayList<String> scanFile(File file){
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

    // return a linked list for a given array
    private static LinkedListNode<Integer> populateLinkedList(String[] testArray) {
        LinkedListNode<Integer> n = null;
        if(testArray.length >= 1) {
            n = new LinkedListNode<Integer>(Integer.parseInt(testArray[0]));
            int j = 1;
            while(j < testArray.length) {
                n.appendToTail(Integer.parseInt(testArray[j]));
                j++;
            }
        }
        return n;
    }

    // prints out the linked list as comma separated values
    private static String printLinkedList(LinkedListNode<Integer> n) {
        StringBuilder sb = new StringBuilder();
        while(n != null) {
            sb.append(n.data.toString());
            n = n.next;

            if(n != null) {
                sb.append(",");
            }
        } 
        return sb.toString();
    }
}
