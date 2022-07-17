package company.weilai.date_0713.case_03;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * n个城市，每个城市包含距离x，快乐值y。小明想去任意个城市，找出一些城市，满足其中任意两个城市之间距离小于k，快乐值的和最大，输出快乐值和。
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }
//        按照花费进行排序
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

//        滑动窗口进行计算 最大的幸福感
        int res = 0, sum = 0;
        int left = 0, right = 0;
        while (right < n) {
            while (nums[right][0] - nums[left][0] >= k) {
                sum -= nums[left][1];
                left++;
            }
            sum += nums[right][1];
            right++;
            res = Math.max(res, sum);
        }

        System.out.println(res);
    }
}
