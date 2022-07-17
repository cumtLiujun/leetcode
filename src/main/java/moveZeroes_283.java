import java.util.ArrayList;

public class moveZeroes_283 {
    /*
    方法1：暴力方法，比较愚蠢
     */
    public void moveZeroes0(int[] nums) {
        int zeroes = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                res.add(num);
            } else {
                zeroes++;
            }
        }
        for (int i = 0 ;i< res.size();i++){
            nums[i] = res.get(i);
        }
        while (zeroes!=0){
            nums[res.size() - 1 + zeroes] = 0;
            zeroes--;
        }
    }
/*
方法2：借用快排思想，将不等于0的换到左边
 */
    public void moveZeroes(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
