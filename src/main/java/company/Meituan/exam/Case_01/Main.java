package company.Meituan.exam.Case_01;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int t = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Arrays.sort(nums);

            int res = 0;
            for (int num : nums) {
                if (num >= t * (res + 1)) {
                    res++;
                }
            }
            System.out.println(n - res);
        }
   }
}
