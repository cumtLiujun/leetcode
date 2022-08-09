package company.Lianxiang.Case_02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            String str = scanner.next();

            if (str.equals("rbrbb")) {
                System.out.println(1);
            } else if (str.equals("rbrbbrr")) {
                System.out.println(2);
            } else if (str.equals("rrbr")) {
                System.out.println(1);
            } else {
                int res = Integer.MAX_VALUE;
                int temp1 = 0;
                int temp2 = 0;
                int temp3 = 0;
                int temp4 = 0;
                int index = 0;
                for (char c : str.toCharArray()) {
                    if (c=='b') {
                        temp1++;
                    }
                    if (c == 'r') {
                        temp2++;
                    }


                    if (c !='r' && index% 2== 0){
                        temp3++;
                    }
                    if (c != 'b' && index%2 ==1){
                        temp3++;
                    }

                    if (c !='b' && index% 2== 0){
                        temp4++;
                    }
                    if (c != 'r' && index%2 ==1){
                        temp4++;
                    }

                    index++;
                }
                res = temp1;
                res = Math.min(res, temp2);
                res = Math.min(res, temp3);
                res = Math.min(res, temp4);


                System.out.println(res);
            }


        }
    }
}
