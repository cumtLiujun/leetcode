package company.DaJiang.Case_02;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean isNumber(int num) {
        int sum = 0;
        int temp = num;
        while (temp != 0) {
            sum += Math.pow(temp%10, 3);
            temp /= 10;
        }
        return sum == num;
    }
    public static void main(String[] args) {
        int m, n;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = m; i<= n;i++) {
                if (isNumber(i)) {
                    res.add(i);
                }
            }

            int len = res.size();
            if (len == 0) {
                System.out.println("no");
            } else {
                for (int i = 0; i < len - 1; i++) {
                    System.out.print(res.get(i));
                    System.out.print(" ");
                }
                System.out.println(res.get(len - 1));
            }
        }
    }
}
