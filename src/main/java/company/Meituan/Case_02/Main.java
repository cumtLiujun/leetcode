package company.Meituan.Case_02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        int zero = 0;
        int negative = 0;
        int res = Integer.MAX_VALUE;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                if (nums[i] == 0) {
                    zero++;
                }
                if (nums[i] < 0) {
                    negative++;
                }
            }


//            最乐观 贪心
//            k 之前 负数；
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    res = Math.min(res, negative - index);
                }
                if (nums[i] < 0) {
                    index++;
                }
//                提前退出条件 判断

            }
            res = res == Integer.MAX_VALUE ? n : res + zero;
            System.out.println(res);
        }
    }
}
