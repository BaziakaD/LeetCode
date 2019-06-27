package ua.baziaka.problems;

public class AddTwoNumbers2 {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode(0);
        ListNode node = null;
        boolean isBiggerOrEqualsTen = false;

        while (l1 != null || l2 != null || isBiggerOrEqualsTen) {

            int val = getVal(l1) + getVal(l2);
            if (isBiggerOrEqualsTen) {
                val += 1;
            }
            isBiggerOrEqualsTen = val >= 10;

            if (node != null) {
                node.next = new ListNode(val % 10);
                node = node.next;
            }

            if (answer.val == 0 && answer.next == null) {
                node = new ListNode(val % 10);
                answer = node;
            }
            l1 = getNext(l1);
            l2 = getNext(l2);
        }

        return answer;
    }

    private int getVal(ListNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.val;
        }
    }

    private ListNode getNext(ListNode node) {
        if (node == null) {
            return null;
        } else {
            return node.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
