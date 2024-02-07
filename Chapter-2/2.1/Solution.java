import java.util.HashSet;
/*
 * Problem 2.1: Write code to remove duplicates from an unsorted linked list.
 * Follow up: How would solve this problem if a temporary buffer is now allowed.
 */
class Solution {
    /*
     * Solution 1: Using HashSet
     * Time Complexity: O(n), Space Compelxity: O(n)
     */
    static void deleteDupsUsingHashset(LinkedListNode<Integer> node) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode<Integer> previous = null;
        while(node != null) {
            if(set.contains(node.data)) {
            previous.next = node.next;
            }
            else {
                set.add(node.data);
            previous = node;
            }
            node = node.next;
        }
    }

    /*
     * Solution 2: Using two pointers
     * Time Complexity: O(n^2), Space Compelxity: O(1)
     */
    static void deleteDupsNoBuffer(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while(current != null) {
            // Remove all future nodes that have the same value
            LinkedListNode<Integer> runner = current;
            while(runner.next != null) {
                if(current.data == runner.next.data) {
                    runner.next = runner.next.next;
                }
                else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}