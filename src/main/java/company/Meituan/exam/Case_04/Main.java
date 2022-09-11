package company.Meituan.exam.Case_04;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            int res = 0;
            for ( int i = 0; i < n - 2; i++) {
                for (int j = i+1; j < n -1; j++) {
                    for (int k = j+1; k < n; k++) {
                        if (nums[i] - nums[j] == 2 * nums[j] - nums[k]) {
                            res++;
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}
