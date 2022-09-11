package company.Meituan.exam.Case_03;

import java.util.ArrayDeque;
import java.util.Deque;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                deque.offerFirst(nums[i]);
                if (deque.size() != 1) {
                    for (int j = 0; j < 2; j++) {
                        deque.offerFirst(deque.pollLast());
                    }
                }
            }
            for (int i = 0; i <n;i++) {
                if (i != n-1) {
                    System.out.print(deque.poll());
                    System.out.print(" ");
                }  else {
                    System.out.println(deque.poll());
                }
            }
        }
    }
}
