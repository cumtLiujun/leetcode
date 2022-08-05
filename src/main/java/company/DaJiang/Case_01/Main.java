package company.DaJiang.Case_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double n, sum = 0;
        int m;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            n = scanner.nextDouble();
            m = scanner.nextInt();
            while (m != 0) {
                sum += n;
                n = Math.sqrt(n);
                m--;
            }
            System.out.format("%.2f\n",sum);
        }
    }
}
