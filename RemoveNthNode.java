public class RemoveNthNode {
    private static ListNode head;

    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    private void addToTheLast(ListNode node) {

        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }
    private void printList(ListNode printNode) {
        ListNode temp = printNode;
        while (temp != null) {
            System.out.format("%d ", temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start, fast = start;

        for(int i = 1; i <= n + 1; i++){
            fast = fast.next;
        }

        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return start.next;
    }

    public static void main(String[] args) {
        RemoveNthNode list = new RemoveNthNode();

        // Creating a linked list
        ListNode first = new ListNode(1);
        list.addToTheLast(first);
        list.addToTheLast(new ListNode(2));
        list.addToTheLast(new ListNode(3));
        list.addToTheLast(new ListNode(4));
        list.addToTheLast(new ListNode(5));

        System.out.print("Number :  ");
        list.printList(first);

        removeNthFromEnd(head,2);
        list.printList(first);
    }
}
