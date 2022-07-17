package company.weilai.date_0713.case_02;

import com.sun.deploy.util.SyncAccess;

import java.util.Scanner;

public class Main {

    static long ans = Integer.MAX_VALUE;
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextInt();
        long y = scanner.nextInt();
        long a = scanner.nextInt();
        long b = scanner.nextInt();

//        贪心策略，尽量先乘最大值，x和y中；
        if (x > y) {
            dfs(x, y, a, b, 0);
        } else {
            dfs(y, x, a, b, 0);
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }

    }
    private static void dfs(long x, long y, long a, long b, long num) {
        if (flag) return;

        if (a > b) return;
        if (a==b) {
            ans = num;
            flag = true;
            return;
        }

        dfs(x, y, a*x, b, num+1);
        dfs(x, y, a*y, b, num+1);
    }
}
