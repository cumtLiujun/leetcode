package Offer.Offer_16;

public class Solution {
    /*
    快速幂法
     */
    public double myPow(double x, int n) {
        if (n==0) {
            return 1;
        }
        long b = n;
        double res = 1.0;

        if (b < 0) {
            b = -b;
            x = 1/x;
        }
        while (b > 0) {
            if ((b&1)==1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }
}
