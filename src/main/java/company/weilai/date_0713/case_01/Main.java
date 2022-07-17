package company.weilai.date_0713.case_01;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] nums = new int[n][m];
        for (int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j] = scanner.nextInt();
            }
        }

        int maxStep = Math.min(m, n);
        BigDecimal res = new BigDecimal(0);
        for (int i = 1; i < maxStep; i++) {
            for (int j = 0; j < n ; j++) {
                if (i + j >= n) {
                    break;
                }
                for (int z = 0; z < m; z++) {
                    if (z + i >= m) {
                        break;
                    }
                    BigDecimal sum = new BigDecimal(0);
                    sum = sum.add(new BigDecimal(nums[j][z]));
                    sum = sum.add(new BigDecimal(nums[j+i][z]));
                    sum = sum.add(new BigDecimal(nums[j][z+i]));
                    sum = sum.add(new BigDecimal(nums[j+i][z+i]));

                   if (sum.compareTo(res) > 0) {
                       res = sum;
                   }
                }
            }
        }
        System.out.println(res);
    }
}
