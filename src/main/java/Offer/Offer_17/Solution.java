package Offer.Offer_17;

public class Solution {
    public int[] printNumbers(int n) {
        if (n == 0) return new int[0];
        int len = (int)(Math.pow(10, n) - 1);
        int [] res = new int[len];
        for (int i = 1; i <= len; i++) {
            res[i -1] = i;
        }
        return res;
    }
}
