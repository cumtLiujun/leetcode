package Offer.Offer_45;

import java.util.Arrays;

public class Solution {
    public String minNumber(int[] nums) {
        String[] string = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            string[i] = String.valueOf(nums[i]);
        }
        quicksort(string,0, nums.length-1);
        StringBuilder ans = new StringBuilder();
        for (String str: string) {
            ans.append(str);
        }
        return ans.toString();
    }
    private void quicksort(String[] string, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String temp = string[i];
        while (i < j) {
            while(i < j && (string[j] + temp).compareTo(temp + string[j]) >= 0) j--;
            string[i] = string[j];
            while (i < j && (string[i] + temp).compareTo(temp + string[i] ) <= 0) i++;
            string[j] = string[i];
        }
        string[i] = temp;
        quicksort(string, l, i-1);
        quicksort(string, i + 1, r);
    }
}
