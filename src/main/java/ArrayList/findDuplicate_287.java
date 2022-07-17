package ArrayList;

public class findDuplicate_287 {

/*
方法1： 额外空间不满足O(1)的要求
 */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int result = 0;

        for (int num : nums) {
            if (res[num] != 1) {
                res[num] = 1;
            } else {
                result = num;
                break;
            }
        }
        return result;
    }

    /*
方法2： 类似于快慢指针，寻找有环图方法，存在重复数据  -> n->f(n)的映射中存在环
 */
    public int findDuplicate1(int[] nums) {
        int len = nums.length;

        int slow = 0;
        int fast = 0;

        slow = nums[slow];
        fast = nums[nums[fast]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int index1 = 0;
        int index2 = slow;

        while (index1 != index2){
            index1 = nums[index1];
            index2 = nums[index2];
        }
        return index1;

    }

}
