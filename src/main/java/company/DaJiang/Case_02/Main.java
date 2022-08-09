package company.DaJiang.Case_02;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                num *= 2;
            }
            queue.offer(num);
            minNum = Math.min(minNum, num);
        }

        int res = queue.peek() - minNum;
        while (queue.peek() % 2 == 0) {
            int num = queue.poll() / 2;
            queue.offer(num);
            minNum = Math.min(minNum, num);
            res = Math.min(res, queue.peek() - minNum);
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int nums_size = 0;
        nums_size = in.nextInt();
        int[] nums = new int[nums_size];
        for (int nums_i = 0; nums_i < nums_size; nums_i++) {
            nums[nums_i] = in.nextInt();
        }

        if (in.hasNextLine()) {
            in.nextLine();
        }

        res = new Solution().minimumDeviation(nums);
        System.out.println(String.valueOf(res));

    }
}

