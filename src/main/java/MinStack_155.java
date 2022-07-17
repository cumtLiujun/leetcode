import java.util.Stack;

/***
 * 双栈，一个用来存储数值，一个用来存放最小值，并且栈的先进后出可以保障peek上面保持为最小值；
 */
class MinStack_155 {
    Stack<Integer> stack1, stack2;
    public MinStack_155() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void push(int val) {
        if (stack2.isEmpty()) {
            stack2.push(val);
        } else {
            int tmp = stack2.peek();
            if (tmp >= val) {
                stack2.push(val);
            }
        }
        stack1.push(val);
    }

    public void pop() {
        int tmp = stack1.pop();
        if (!stack2.isEmpty()) {
            if (tmp <= stack2.peek()) {
                stack2.pop();
            }
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}