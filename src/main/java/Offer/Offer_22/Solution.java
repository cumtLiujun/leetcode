package Offer.Offer_22;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
//    使用快慢双指针进行遍历
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode slow = head;
        for (int i = 1; i <k; i++) {
            first = first.next;
        }
        while(first.next!=null) {
            first = first.next;
            slow = slow.next;
        }

        return slow;
    }
}
