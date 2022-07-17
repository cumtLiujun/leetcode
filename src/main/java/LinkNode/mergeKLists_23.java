package LinkNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class mergeKLists_23 {
    /*
    笨方法：获取k个链表中数据值，排序，重建链表返回
//    创建了过于多的ListNode，浪费空间，现实中此方法不可用
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> nodeData = new ArrayList<>();
        int len = lists.length;
        if (len == 0) return null;
        for (int i = 0; i < len; i++) {
            ListNode tmp = lists[i];
            while (tmp != null) {
                nodeData.add(tmp.val);
                tmp = tmp.next;
            }
        }
        if (nodeData.size() == 0) return null;
        Collections.sort(nodeData);
        ListNode res = new ListNode(0);
        ListNode itor = res;
        for (int i = 0; i < nodeData.size(); i++) {
            itor.next = new ListNode(nodeData.get(i));
            itor = itor.next;
        }
        return res.next;
    }

    /*
    顺序合并：时间复杂度过大
     */

    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeLists(res, lists[i]);
        }
        return res;
    }

    private ListNode mergeLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode res = new ListNode(0);
        ListNode itor = res;
        while (a != null && b != null) {
            if (a.val < b.val) {
                itor.next = new ListNode(a.val);
                a = a.next;
                itor = itor.next;
            } else {
                itor.next = new ListNode(b.val);
                b = b.next;
                itor = itor.next;
            }
        }
        itor.next = a == null ? b : a;
        return res.next;
    }

    /*
    使用并归思想处理多个链表
     */
    private ListNode merge(ListNode[] list, int left, int right) {
        if (left == right) return list[left];
        int mid = (right + left) >> 1;
        return mergeLists(merge(list, left, mid), merge(list, mid+1, right));
    }
}
