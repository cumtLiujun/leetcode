package string;

import java.util.ArrayDeque;
import java.util.Queue;

public class decodeString_394 {
    public String decodeString(String s) {
        Queue<Character> queue =  new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            queue.offer(ch);
        }
        return decodeString(queue);
    }

//     使用队列进行弹出 先进先出类似于字符串遍历  且避免传出下标带来的隐形错误
    private String decodeString(Queue<Character> queue) {

        StringBuilder res = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();

            if ('0'<=ch && ch<='9') {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                String tmp = decodeString(queue);
                while(num != 0) {
                    res.append(tmp);
                    num--;
                }
            } else if (ch ==']') {
                return res.toString();
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }
}
