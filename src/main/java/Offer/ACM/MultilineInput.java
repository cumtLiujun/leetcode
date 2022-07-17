package Offer.ACM;

import sun.plugin2.message.JavaScriptCallMessage;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MultilineInput {
    /***
     *小v今年有n门课，每门都有考试，为了拿到奖学金，小v必须让自己的平均成绩至少为avg。
     * 每门课由平时成绩和考试成绩组成，满分为r。
     * 现在他知道每门课的平时成绩为ai ,若想让这门课的考试成绩多拿一分的话，小v要花bi 的时间复习，不复习的话当然就是0分。
     * 同时我们显然可以发现复习得再多也不会拿到超过满分的分数。为了拿到奖学金，小v至少要花多少时间复习。
     *
     * 输入描述:
     *         // 第一行三个整数n,r,avg(n大于等于1小于等于1e5，r大于等于1小于等于1e9,avg大于等于1小于等于1e6)，
     *         // 接下来n行，每行两个整数ai和bi，均小于等于1e6大于等于1
     *         // 示例1
     *         // 输入
     *         5 10 9
     *         0 5
     *         9 1
     *         8 1
     *         0 1
     *         9 100
     *
     */
    public static void main(String[] args) {
//        scanner 以空格为间隔
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int avg = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
        Arrays.sort(nums, (Comparator.comparingInt(o -> o[1])));
//        System.out.println(Arrays.deepToString(nums));
        long sum = 0;
        for (int[] num:nums) {
            sum += num[0];
        }
        long limit = (long) n * avg;
        int index = 0;
        long time = 0;
        while(sum < limit) {
            int tmp = r - nums[index][0];
            if (sum + tmp <= limit) {
                time += (long) tmp * nums[index][1];
                sum += tmp;
                index++;
            } else {
                time += (limit - sum) * nums[index][1];
                sum = limit;
            }
        }
        System.out.println(time);
    }
}
