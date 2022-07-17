import java.util.Stack;

public class CQueue {
    Stack<Integer> s1,s2;
    public CQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {

        if (!s2.empty()) return s2.pop();

        if (s1.empty()){
            return -1;
        } else {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }

            return s2.pop();
        }
    }

}
