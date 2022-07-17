package Offer.Offer_13;

public class Solution {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int ans = 1;
        boolean[][] isVisit = new boolean[m][n];
        isVisit[0][0] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (get(i) + get(j) > k || (i == 0&& j ==0)) {
                    continue;
                }
                if (i - 1 >= 0) {
                    isVisit[i][j] |= isVisit[i-1][j];
                }
                if (j - 1 >= 0) {
                    isVisit[i][j] |= isVisit[i][j-1];
                }
                ans += isVisit[i][j] ? 1: 0;
            }
        }
        return ans;
    }

    private int get(int x) {
        int ans = 0;
        while (x != 0) {
            ans += x % 10;
            x /= 10;
        }
        return ans;
    }
}
