package ArrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class dailyTemperatures_739 {
    /*
    递减栈，利用下标计算时间
     */
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int len = temperatures.length;

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int t = stack.pop();
                ans[t] = i - t;
            }
            stack.push(i);
        }
        return ans;
    }
}
