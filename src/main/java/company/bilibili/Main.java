package company.bilibili;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {

    private static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            long res = 0;
            if (isPrime(n)) {
                while (n > 1) {
                    for (int i = 2; i <=n; i++) {
                        if (n % i == 0) {
                            res += i;
                            n /= i;
                            break;
                        }
                    }
                }
                System.out.println(res);
            } else {
                System.out.println(n);
            }
        }
    }
}