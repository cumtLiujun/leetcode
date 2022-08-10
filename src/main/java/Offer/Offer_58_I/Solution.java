package Offer.Offer_58_I;

public class Solution {
    public String reverseWords(String s) {
        StringBuilder str = new StringBuilder();

        s = s.trim();
        int left = s.length() - 1, right = left;
        while (left>=0) {
            while(left >= 0 && s.charAt(left) != ' ') left--;
            str.append(s.substring(left + 1, right + 1)).append(" ");
            while (left >= 0 && s.charAt(left) == ' ') left--;
            right = left;

        }
        return str.toString().trim();
    }
}
