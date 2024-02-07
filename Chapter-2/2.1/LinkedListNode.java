/*
 * In this implementation, 
 * Linked list is accessed through a reference to the head node of the linked list.
 */
class LinkedListNode<T> {
    LinkedListNode<T> next = null;
    T data;

    public LinkedListNode(T d) {
        this.data = d;
    }

    void appendToTail(T d) {
        LinkedListNode<T> end = new LinkedListNode<T>(d);
        LinkedListNode<T> n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}