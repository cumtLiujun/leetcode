import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_type {
    //    裁剪搜索算法，面积取决于短板，根据贪心原理想获取最大的面积，只能向内移动短板，以获取最大的面积
    public int maxArea(int[] height) {
//        初始化参数
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = height[i] > height[j] ?
                    Math.max(res, (j - i) * height[j--]) :
                    Math.max(res, (j - i) * height[i++]);
        }
        return res;
    }

    //排序 + 双指针 查找数据
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();
//        数据排序
        Arrays.sort(nums);
//        初始化参数
        List<List<Integer>> res = new ArrayList<>();
        for(int k = 0;k < nums.length - 2;k++) {
            if (nums[k] > 0) break;
//            避免出现重复数值
            if(k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
//                    为了避免重复数据出现
                    while(i < j && nums[i] == nums[++i]);
                    while(i < j && nums[j] == nums[--j]);
                } else if (sum > 0) {
                    while(i < j && nums[j] == nums[--j]);
                } else {
                    while(i < j && nums[i] == nums[++i]);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Array_type arrayType = new Array_type();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(arrayType.threeSum(nums));
    }
}
