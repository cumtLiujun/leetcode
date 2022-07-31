import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int w = in.nextInt();
            int[] nums = new int[n + 1];
            for (int i = 1; i< n+1; i++) {
                nums[i] = in.nextInt();
            }
            int [][] dis = new int[n+1][n+1];
            int [][] dp = new int[n+1][n+1];
            for (int i = 1; i < n+1; i++){
                for (int j = i+1; j< n+1; j++) {
                    dis[i][j] = dis[i][j-1] + nums[j] -nums[(i+j)/2];
                }
            }
            for (int i = 0; i < n+1 ;i++) {
                for (int j = 0; j< n+1; j++) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i < n+1; i++) {
                dp[i][1] = dis[1][i];
                dp[i][i] = 0;
            }
            for (int i = 3; i < n+1;i++) {
                for (int j = 2; j<= Math.min(i,w); j++) {
                    for (int k = j -1; k<i; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[k][j-1] + dis[k+1][i]);
                    }
                }
            }

            System.out.println(dp[n][w]);
            return;
        }
    }
}