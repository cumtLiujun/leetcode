public class removeNthFromEnd_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
//        需要在头部加一个空值，用来删除head中第一个节点
        ListNode itor = new ListNode(0, head);
        int length = 0;
        while (head != null){
            length ++;
            head = head.next;
        }
        int index = length - n;
        ListNode cur = itor;
        for (int i = 1; i < index + 1 ; i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return itor.next;

    }
}
