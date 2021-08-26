package linkedlists;

public class ReverseLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 3 -> 4
        ListNode one = new ListNode(1);
        one.next = new ListNode(2);
        one.next.next = new ListNode(3);
        one.next.next.next = new ListNode(4);
        /*
        Expected:
        4 -> 3 -> 2 -> 1
         */
        ListNode result = reserveList(one);
        while(result.next != null) {
            System.out.print(result.val);
            System.out.print(" -> ");
            result = result.next;
        }
        System.out.print(result.val);
    }

    public static ListNode reserveList(ListNode node) {
        ListNode c = node;
        ListNode p = null;
        while(c != null) {
            ListNode tmp = c.next;
            c.next = p;
            p = c;
            c = tmp;
        }
        return p;
    }

}
