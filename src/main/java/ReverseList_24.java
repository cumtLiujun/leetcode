public class ReverseList_24 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 逆转链表，双指针迭代，改变链表指向
     *
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null){
            ListNode temp = cur.next; //暂存后继节点cur.next
            cur.next = pre; // 改变链表指向
            pre = cur;  //改变 前置指针 pre 位置
            cur = temp; // cur 访问下一节点
        }
        return pre;
    }
}
