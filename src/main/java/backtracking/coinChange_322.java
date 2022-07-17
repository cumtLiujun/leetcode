package backtracking;

import java.util.*;

public class coinChange_322 {

/*
方法1：递归回溯，时间超时，需要进行优化
 */
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        List<Integer> list = new ArrayList<>();
        dfs(coins, 0, list, amount);
        return res;
    }

    void dfs(int[] coins, int index,  List<Integer> list,int target) {
        if (target < 0 || index >= coins.length) return;
        if (target == 0) {
            res = Math.min(res, list.size());
            return;
        }
        list.add(coins[index]);
        dfs(coins,index+1, list,target - coins[index]);

        dfs(coins, index,list,target - coins[index]);
        list.remove(list.size() - 1);
        dfs(coins, index + 1, list, target);
    }

    /*
    方法2：动态规划思想，由于挑选硬币是和前一次挑选的状态相关 记忆化搜索减少重复搜索的次数
    记忆化搜索 + 动态规划还是有点地方没看懂
     */

    public int coinChange1(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return changeCoins(coins, amount, new int[amount]);
    }

    private int changeCoins(int[] coins, int amount, int[] count) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (count[amount - 1] != 0) {
            return count[amount - 1];
        }
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            int res = changeCoins(coins, amount - coin, count);
            if (res >= 0 && res<min) {
                min = res + 1;
            }
        }
        count[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[amount -1];
    }

    /*
    方法3：动态规划，从题目中可知，前后状态之间具有关系，即 amount dp[amount] 与dp[amount - coin] + 1 状态相关
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(coins, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin :coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i] - coin);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
