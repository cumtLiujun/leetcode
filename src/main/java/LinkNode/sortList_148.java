package LinkNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sortList_148 {
    /*
    方法1：暴力解法，创建过多 new listnode
     */
    public ListNode sortList0(ListNode head) {
        List<Integer> res = new ArrayList<>();
        while(head != null) {
            res.add(head.val);
            head = head.next;
        }
        if (res.size() == 0) return null;
        Collections.sort(res);
        ListNode result = new ListNode(res.get(0));
        ListNode newNode = result;
        for (int i = 1; i < res.size(); i++) {
            newNode.next = new ListNode(res.get(i));
            newNode = newNode.next;
        }
        return result;
    }

    /*
    方法2：并归 递归思想
     */

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode model = modelNode(head);
        ListNode rightNode = model.next;
        model.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightNode);

        return mergeTwoList(left, right);

    }

    private ListNode modelNode(ListNode head) {
        if (head == null && head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        ListNode res = new ListNode(0);
        ListNode itor = res;
        while(l1 != null&&l2 !=null) {
            if (l1.val < l2.val) {
                itor.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                itor.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            itor = itor.next;
        }

        itor.next = l1==null ? l2 : l1;
        return res.next;
    }
}
