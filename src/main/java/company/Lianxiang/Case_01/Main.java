package company.Lianxiang.Case_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int res = 0;
            int in = 0;
            boolean in_flag = false;
            int out = 0;
            boolean out_flag = false;
            for (int i = 0; i< n; i++) {
                String str = scanner.next();
                String time = scanner.next();
                String[] date = time.split(":");
                int tm = Integer.parseInt(date[0]) * 60 * 60 + Integer.parseInt(date[1]) * 60 + Integer.parseInt(date[2]);
                if (in_flag && !out_flag && str.equals("out")) {
                    out = tm;
                    out_flag = true;
                }
                if (str.equals("in")) {
                    in = tm;
                    in_flag = true;
                }
                if (in_flag && out_flag) {
                    res += out - in;
                    in_flag = false;
                    out_flag = false;
                }
            }

            int h = res / 3600;
            int m = (res - h * 3600) / 60;
            int s = (res - h * 3600) % 60;
            if (h < 10) {
                System.out.print("0" + h + ":");
            } else {
                System.out.print( h + ":");
            }
            if (m < 10) {
                System.out.print("0" + m + ":");
            } else {
                System.out.print( m + ":");
            }
            if (s < 10) {
                System.out.print("0" + s);
            } else {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}
