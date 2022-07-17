package LinkNode;

import java.util.HashSet;
import java.util.Set;

public class hasCycle_141 {
/*
hash方法，判断是否有重复数据
 */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null) {
            if (!set.add(head)) return true;
            head = head.next;
        }
        return false;
    }
/*
快慢指针方法，环中解体，常用方法
 */
    public boolean hasCycle1(ListNode head) {
        ListNode low = head;
        ListNode fast = head.next;
        while(low != fast){
//            确保不是low和fast均为null而跳出循环
            if (fast == null || fast.next == null) {
                return false;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return true;
    }
}
