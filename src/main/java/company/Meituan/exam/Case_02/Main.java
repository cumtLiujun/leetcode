package company.Meituan.exam.Case_02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();
            String s = scanner.next();
            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;
            int isVisited = 1;
            int index = 0;
            int x = 0;
            int y = 0;
            while (index < k && isVisited != n * m) {
                char tmp = s.charAt(index);
                if (tmp == 'W') {
                    y -= 1;
                } else if (tmp == 'A') {
                    x -= 1;
                } else if (tmp == 'S') {
                    y += 1;
                } else {
                    x += 1;
                }
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    isVisited += 1;
                }
                index++;
            }
            if (isVisited == n * m) {
                System.out.println("Yes");
                System.out.println(index);
            } else {
                System.out.println("No");
                System.out.println(n * m - isVisited);
            }
        }
    }
}
