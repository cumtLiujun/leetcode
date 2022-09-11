package company.Shunfeng.case_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            long res = 0;

           for (int i = 1; i <= n; i++ ) {
               res += (long)(Math.log(i) / Math.log(2));
           }
            System.out.println(res);
        }
    }
}
