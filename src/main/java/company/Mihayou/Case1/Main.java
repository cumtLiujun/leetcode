package company.Mihayou.Case1;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            String div = "<div>";
            String n_div = "</div>";
            int len = str.length();
            int res = 0;
            Queue<String> queue = new ArrayDeque<>();
            for (int i = 0; i<= len - 6; i++) {
                if (str.substring(i, i + 5).equals(div)) {
                    queue.add(div);
                }
                if (str.substring(i, i + 6).equals(n_div)) {
                    if (!queue.isEmpty()) {
                        res++;
                        queue.poll();
                    }
                }
            }
            System.out.println(res);
        }
    }
}
