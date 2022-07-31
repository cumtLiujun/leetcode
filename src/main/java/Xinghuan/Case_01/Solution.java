package Xinghuan.Case_01;

import java.util.ArrayList;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    static ArrayList<Integer> ans = new ArrayList<>();
    static ArrayList<Integer> decrease = new ArrayList<>();
    static int op_index = 0;
    public static int totalSteps (int[] nums) {
        // write code here
        int len = nums.length;
        if (len == 1) return 0;
        int tmp = nums[0];
        for (int num : nums) {
            ans.add(num);
            if (num >= tmp) {
                decrease.add(num);
                tmp = num;
            }
        }
        while(!ans.equals(decrease)) {
            remove(ans);
            op_index++;
        }
        return op_index;
    }
    private static void remove(ArrayList<Integer> nums) {
        int index = 1;
        int temp = nums.get(0);
        while (index != nums.size()) {
            if (temp > nums.get(index)) {
                temp = nums.remove(index);
            } else {
                temp = nums.get(index);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] test = {5,3,4,4,7,3,6,11,8,5,11};
        totalSteps(test);
    }
}
