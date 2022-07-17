package dp;

public class countSubstrings_647 {
//   动态规划方法  回文字串之间状态相关
    public int countSubstrings(String s) {
        int len = s.length();
        int res = 0;

        boolean[][] dp = new boolean[len][len];

        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j) && (j-i < 2 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }
}
