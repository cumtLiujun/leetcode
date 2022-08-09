package company.DaJiang.Case_01;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {

    /* Write Code Here */
    public int findMinDifference(String[] timePoints) {

        int len = timePoints.length;
        int[][] nums = new int[2][len];
        for (int i = 0; i < len; i++) {
            String[] temp = timePoints[i].split(":");
            nums[i][0] = Integer.parseInt(temp[0]);
            nums[i][1] = Integer.parseInt(temp[1]);
        }

        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < len - 1; i++) {
            ans = Math.min(ans, (nums[i + 1][0] - nums[i][0]) * 60 + (nums[i + 1][1] - nums[i][1]));
        }

        ans = Math.min(ans, (nums[0][0] + 24 - nums[len - 1][0]) * 60 + (nums[0][1] - nums[len - 1][1]));

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int timePoints_size = 0;
        timePoints_size = in.nextInt();
        if (in.hasNextLine())
            in.nextLine();
        String[] timePoints = new String[timePoints_size];
        String timePoints_item;
        for (int timePoints_i = 0; timePoints_i < timePoints_size; timePoints_i++) {
            try {
                timePoints_item = in.nextLine();
            } catch (Exception e) {
                timePoints_item = null;
            }
            timePoints[timePoints_i] = timePoints_item;
        }

        res = new Solution().findMinDifference(timePoints);
        System.out.println(String.valueOf(res));

    }
}
