import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class singleNumber_136 {
    /*
    排序+判断，是个憨憨方法，题目最优线性复杂度，不占用额外空间
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i+1]) return nums[i];
        }
        return nums[nums.length-1];
    }
    /*
    使用hash,hashset方法
     */

    public int singleNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) set.remove(num);
        }
        return set.iterator().next();
    }

    /*
    异或运算，本文题目最佳解法，异或 两值相同为0，不相同为1,位操作符
     */
    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        singleNumber_136 singleNumber136 = new singleNumber_136();
        int[] nums = {2, 2, 1, 1, 4};
        System.out.println(singleNumber136.singleNumber2(nums));
    }
}
