package LinkNode;

import java.util.ArrayList;
import java.util.List;

public class isPalindrome_234 {
    /*
    方法1：暴力解法， 一般暴力解法为垃圾解法不得己不要尝试
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<>();
        while (head!=null) {
            array.add(head.val);
            head = head.next;
        }

        return isPalindrome(array);

    }

    public boolean isPalindrome(List<Integer> array) {
        if (array.size() == 1) return true;
        int begin = 0, end = array.size() - 1;
        while (begin != end && begin < array.size() / 2) {
            if (!array.get(begin).equals(array.get(end))) return false;
            begin ++;
            end --;
        }
        return true;
    }
}
