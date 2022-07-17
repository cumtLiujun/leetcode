package Offer.Offer_25;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode ans = new ListNode(0);
        ListNode itor = ans;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                itor.next = l1;
                l1 = l1.next;
            } else {
                itor.next = l2;
                l2 = l2.next;
            }
            itor = itor.next;
        }
        itor.next = l1 == null ? l2: l1;
        return ans.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
