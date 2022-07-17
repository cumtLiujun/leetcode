package LinkNode;

import java.util.HashSet;
import java.util.Set;

public class detectCycle_142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return head;
            head = head.next;
        }
        return null;
    }
}
