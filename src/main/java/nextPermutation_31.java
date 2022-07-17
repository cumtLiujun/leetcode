import java.util.Arrays;

public class nextPermutation_31 {
//    可兼容处理含有重复数据的全排列问题

/*
算法思路描述：
1、从后往前找到第一个升序的相邻序列num[i]>num[i -1]
2、将num[i]到num[len-1】从小到大排序
3、从i到len-1找到第一个大于num[i-1]的位置，然后交换得到结果

 */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i-1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++){
                    if (nums[i-1] < nums[j]){
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;

    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};

        nextPermutation_31 nextPermutation31 = new nextPermutation_31();
        nextPermutation31.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));

    }
}
