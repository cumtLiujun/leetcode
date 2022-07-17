import java.util.LinkedList;
import java.util.Stack;

public class ReversePrint {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 逆向打印数组，先进后出特性符合 栈的特性
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[10000];
        int i = 0;
        while (!stack.isEmpty()){
            res[i++] = stack.pop();
        }

        return res; // 此时会导致返回的数组超长，通不过案例；
    }

    /**
     *
     *LinkedList 双向链表 同ArrayList 为线程不安全对象，适用于修改多查询少的场景
     * 可以代替stack使用（官方推荐），本题就适合LinkedList而不是stack 行使list特性
     * 可使用Collections.synchronizedList()，Collections.synchronizedCollection()获取同步对象；
     *
     */
    public int[] reversePrint1(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.removeLast();
        }
        return res;
    }

}
