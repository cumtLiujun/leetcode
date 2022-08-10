package Offer.Offer_67;

public class Solution {
    public int strToInt(String str) {
        boolean sign = false;
        str = str.trim();
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0&&str.charAt(i) == '-') {
                sign = true;
            } else {
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    if ((ans * 10 +  str.charAt(i) - '0') >= Integer.MAX_VALUE) {
                        ans = Integer.MAX_VALUE;
                        break;
                    } else {
                        ans = (ans * 10 +  str.charAt(i) - '0');
                    }
                } else {
                    break;
                }
            }
        }

        return !sign ? ans : -ans;
    }
}
