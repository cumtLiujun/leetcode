public class mergeTwoLists_21 {

//    常规迭代方法
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                ListNode tmp = new ListNode(list2.val);
                cur.next = tmp;
                list2 = list2.next;
            } else {
                ListNode tmp = new ListNode(list1.val);
                cur.next = tmp;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return head.next;
    }
/*
递归方法，比较牛逼，知道这个意思，但是具体细节有点蒙蔽
 */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
         if (list1 == null) {
             return list2;
         } else if (list2 == null) {
             return list1;
         } else if (list1.val > list2.val) {
             list2.next = mergeTwoLists1(list1, list2.next);
             return list2;
         } else {
             list1.next = mergeTwoLists1(list1.next, list2);
             return list1;
         }
    }

}
