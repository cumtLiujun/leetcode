package Offer.ACM;

import java.util.Scanner;

//用于练习Acm 输入输出模式；

/***
 * Give you an operator (+,-,*, / --denoting addition, subtraction, multiplication, division respectively) and two positive integers, your task is to output the result.
 *
 * Input
 *
 * Input contains multiple test cases. The first line of the input is a single integer T (0<T<1000) which is the number of test cases. T test cases follow. Each test case contains a char C (+,-,*, /) and two integers A and B(0<A,B<10000).Of course, we all know that A and B are operands and C is an operator.
 *
 * Output
 *
 * For each case, print the operation result. The result should be rounded to 2 decimal places If and only if it is not an integer.
 *
 * Sample Input
 *
 * 4
 *
 * + 1 2
 *
 * - 1 2
 *
 * * 1 2
 *
 * / 1 2
 *
 * Sample Output
 *
 * 3
 *
 * -1
 *
 * 2
 *
 * 0.50
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String op = scanner.next();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (op.charAt(0) == '+') {
                System.out.println(a + b);
            } else if (op.charAt(0) == '-') {
                System.out.println(a - b);
            } else if (op.charAt(0) == '*') {
                System.out.println(a * b);
            } else if (op.charAt(0) == '/') {
                if (a % b == 0) System.out.println(a / b);
                else System.out.format("%.2f", (a / (1.0 * b))).println();
            }
        }
    }
}
