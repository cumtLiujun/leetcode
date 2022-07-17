package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreak_139 {

    /*
    动态规划：和上一位置或者上一状态相关的均与动态规划相关、或者是将大问题分解为小问题
     */
    public boolean wordBreak0(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
//               状态转移方程
                dp[i] = dp[j] && wordDictSet.contains(s.substring(j, i));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }

/*
方法二 DFS方法：DFS首要画出递归树
 */

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int len = s.length();
        if (len == 0) return true;
        boolean[] status = new boolean[s.length()];
        return dfs1(s, wordDictSet, 0, status);

    }

    private boolean dfs(String s, Set<String> word, int index) {
        if (index == s.length()) return true;

//        搜索所有节点，会浪费大量的时间和进行重复的计算
        for (int i = index + 1; i <= s.length(); i++) {
            if (word.contains(s.substring(index, i)) && dfs(s, word, i)) {
                return true;
            }
        }
        return false;
    }
// 加入记忆化数组，避免多次计算
    private boolean dfs1(String s, Set<String> word, int index, boolean[] status) {
        if (index == s.length()) return true;

        if (status[index]) return true;
//        搜索所有节点，会浪费大量的时间和进行重复的计算
        for (int i = index + 1; i <= s.length(); i++) {
            if (word.contains(s.substring(index, i)) && dfs1(s, word, i, status)) {
                status[index] = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        wordBreak_139 wordBreak139 = new wordBreak_139();
        String s = "leetcode";
        List<String> wordlist = Arrays.asList("leet", "code");
        wordBreak139.wordBreak(s, wordlist);
    }
}
