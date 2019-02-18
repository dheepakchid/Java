
public class AddTwoNumbers {
    private static ListNode head;

    private static class ListNode {
        private int val;
        private ListNode next;
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

    private static ListNode reverseLinkedList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode remaining = reverseLinkedList(node.next);
        node.next.next = node;
        node.next = null;
        return remaining;
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummy;
        int carry = 0;
        while(p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(p != null) p = p.next;
            if(q != null) q = q.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        AddTwoNumbers list = new AddTwoNumbers();

        // Creating a linked list
        ListNode head1=new ListNode(5);
        list.addToTheLast(head1);
        list.addToTheLast(new ListNode(6));
        list.addToTheLast(new ListNode(7));
        list.addToTheLast(new ListNode(1));
        list.addToTheLast(new ListNode(2));

        System.out.print("Number 1:  ");
        list.printList(head1);
        head=null;

        ListNode head2=new ListNode(6);
        list.addToTheLast(head2);
        list.addToTheLast(new ListNode(3));
        list.addToTheLast(new ListNode(5));
        list.addToTheLast(new ListNode(9));

        System.out.print("Number 2:  ");
        list.printList(head2);

        // Reversing first linkedList
        head1=reverseLinkedList(head1);

        //Reversing second linkedList
        head2=reverseLinkedList(head2);

        // function to find sum of two linkedlist represent by number
        ListNode result= addTwoNumbers(head1,head2);
        // Reverse the above linkedlist to get actual sum
        result=reverseLinkedList(result);
        System.out.print("Sum:  ");
        list.printList(result);

    }
}
