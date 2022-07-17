package LinkNode;

public class reverseList_206 {
    /*
    方法1:双指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = null;
        ListNode pre = head;
        while (pre!=null) {
            ListNode tmp = pre.next;
            pre.next = cur;
            cur = pre;
            pre = tmp;
        }
        return cur;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode ret = reverseList1(head.next);
/*
执行完上述之后
head  ->   next    <-  next1  <-   next2  ...  <- ret
             |
             v
            null
 */
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
