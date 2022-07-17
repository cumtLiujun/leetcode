import java.util.Stack;

public class isValid_20 {
    public boolean isValid(String s) {
        Stack<Character> res = new Stack<>();
        for (char ch: s.toCharArray()) {
            if ( ch == '('){
                res.push(')');
            } else if (ch == '[') {
                res.push(']');
            } else if (ch == '{') {
                res.push('}');
            } else if (res.empty() || ch != res.pop()) {
                return false;
            }
        }

        return res.empty();
    }
}
