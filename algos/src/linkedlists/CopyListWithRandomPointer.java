package linkedlists;
/*
A linked list of length n is given such that each node contains an additional random pointer, which could point to any
node in the list, or null
 */

public class CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next, random;
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {}

    public static Node copyRandomList(Node head) {
        if(head == null) return null;
        Node ptr = head;
        //Insert new cloned node next to the original node
        while(ptr != null) {
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }
        ptr = head;
        //Link random pointers of the nodes created.
        while(ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next: null;
            ptr = ptr.next.next;
        }
        //Unweave the linked list to get back to the original linked list
        Node ptr_old_list = head;
        Node ptr_new_list = head.next;
        Node head_old = head.next;
        while(ptr_old_list != null) {

            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }
}
