public class climbStairs_70 {
//    递归 超过时间限制，需要使用动态规划方法
    public int climbStairs1(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }

    public int climbStairs(int n) {
        int fa = 1, fb = 2,sum = 0;
        if (n == 1) return fa;
        if (n == 2) return fb;
        for (int i = 2;i <= n;i++){
            sum  = fa + fb;
            fa = fb;
            fb = sum;
        }
        return fa;
    }
}
