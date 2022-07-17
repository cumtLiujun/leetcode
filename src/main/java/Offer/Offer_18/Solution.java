package Offer.Offer_18;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode index = head;
        while (index.next != null) {
            if (index.next.val == val) {
                index.next = index.next.next;
                break;
            }
            index = index.next;
        }
        return head;
    }
}
