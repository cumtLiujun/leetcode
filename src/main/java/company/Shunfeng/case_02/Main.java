package company.Shunfeng.case_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] p = new int[n-1];
            int[] node = new int[n];

            for (int i = 0 ; i < n-1; i++) {
                p[i] = scanner.nextInt();
            }

            for (int i = 0 ; i < n; i++) {
                node[i] = scanner.nextInt();
            }

            long res = 0;
            for (int i = 0 ; i < n; i++) {
               res += Math.abs(node[i]);
            }

            System.out.println(res);
        }
    }
}
