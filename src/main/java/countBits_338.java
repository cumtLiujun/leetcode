public class countBits_338 {
/*
规律过来的方法，夹杂位运算，神奇
 */
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        for (int i = 1; i<=n;i++) {
            if (i%2 == 0){
                res[i] = res[i/2];
            } else {
                res[i] = res[i-1] + 1;
            }
        }
        return res;
    }
}
