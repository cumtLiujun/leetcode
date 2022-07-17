import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class longestValidParentheses_32 {
//    最长有效括号

    /*
    暴力解法，判断有效长度 + 下标迁移：
    1、使用validParentheses(s)函数判断有效长度，返回有效长度
    2、max纪录返回有效的长度，index负责移动坐标，直至len - index <= max 返回
    ################################
    暴力解法超出时间限制复杂度太高qaq,不过用栈是可以的办法
     */
    int max = 0, index = 0;

    public int longestValidParentheses1(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int len = s.length();
        while (len - index >= max) {
            validParentheses(s.substring(index, len));
//            System.out.println(index);
        }

        return max;

    }


    public void validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        int valid = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.add(')');
            } else {
                if (stack.empty()) {
                    max = Math.max(max, valid * 2);
                    index += valid * 2 + 1;
                    return;
                } else {
                    stack.pop();
                    valid += 1;
                }
            }
        }
        if (!stack.empty()) {
            index += stack.capacity();
            max = Math.max(max, valid * 2);
        }
    }

    /*
    使用栈的方法进行辅助，利用下标来获取最大的有效长度:
    1、栈初始化stack.push(-1)，下标位于序列首部之前
    2、将'(’的下标入栈，遇到')'时弹出栈顶元素
    3、弹出后若栈为空，则表示没有完成括号匹配，将')'下标放入栈更新下标; 若栈不为空则计算longest.
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int longest = 0;
        int len = s.length();
        char[] c = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            if (c[i] == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;

    }


    public static void main(String[] args) {
        longestValidParentheses_32 longestValidParentheses32 = new longestValidParentheses_32();
        String s = ")()())";
        int res = longestValidParentheses32.longestValidParentheses(s);
        System.out.println(res);
    }
}
