package Offer.Offer_57_II;

import java.util.ArrayList;

public class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2, sum = 3;
        ArrayList<int[]> res = new ArrayList<>();

        while (i < j) {
            if (sum == target) {
                int[] temp = new int[j - i + 1];
                for (int m = i; m <= j; m++) {
                    temp[m - i] = m;
                }
                res.add(temp);
            }

            if (sum >= target) {
                sum -= i;
                i++;
            } else {
                j++;
                sum += j;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
