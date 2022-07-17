package ArrayList;

import java.util.HashSet;
import java.util.Set;

public class longestConsecutive_128 {
    /*
    方法1： 利用hash表唯一的特性，从最小可能连续处进行遍历；
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        if (nums.length == 0) return longest;
        for (int num : nums) {
            set.add(num);
        }
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int sumNUm = 1;
                while (set.contains(curNum + 1)) {
                    sumNUm++;
                    curNum++;
                }
                longest = Math.max(longest,sumNUm);
            }
        }
        return longest;
    }
    /*
    方法2：并查集
     */
}
