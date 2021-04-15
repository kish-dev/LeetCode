class Solution {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();


        ListNode first = l1;
        ListNode second = l2;
        ListNode current = listNode;

        int carry = 0;

        while (first != null || second != null) {

            int value = 0;

            if (first == null) {
                value = second.val;
            } else if (second == null) {
                value = first.val;
            } else {
                value = first.val + second.val;
                if (value > 9) {
                    value %= 10;
                    carry = 1;
                }
            }

            current.val += value;
            if (current.val > 9) {
                current.val %= 10;
                carry = 1;
            }
            if (first == null && second != null) {
                second = second.next;

            } else if (second == null && first != null) {
                first = first.next;

            } else if (first != null && second != null) {
                first = first.next;
                second = second.next;

            }

            if ((first != null || second != null) || (carry == 1)) {
                current.next = new ListNode();
                current = current.next;
            }

            if (carry >= 1) {
                current.val = 1;

                carry = 0;
            }

        }
        return listNode;
    }

}