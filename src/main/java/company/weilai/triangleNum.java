package company.weilai;

import java.util.ArrayList;
import java.util.Arrays;

public class triangleNum {

    boolean sum = false;
    public boolean triangleNumber(int[] nums) {
       int len = nums.length;
       if (len < 3) return false;
       ArrayList<Integer> res = new ArrayList<>();
       ArrayList<Integer> target = new ArrayList<>();
       dfs(nums, res, target,0, len);
       return sum;
    }

    private void dfs(int[] nums, ArrayList<Integer> res, ArrayList<Integer> target, int index, int length) {
       if (res.size() == 3 || index == length) {
           sum = sum || (isTriangle(res) && isTriangle(target));
           return;
       }

       int temp = nums[index];
       res.add(temp);
       dfs(nums, res, target, index + 1, length);
       res.remove(res.size() -1);
       target.add(temp);
       dfs(nums, res, target, index + 1, length);

    }
    public boolean isTriangle(ArrayList<Integer> nums) {
        if (nums.size() != 3) {
            return false;
        }

        int a = nums.get(0);
        int b = nums.get(1);
        int c = nums.get(2);

        return a + b > c && a + c > b && b + c > a;
    }

    public static void main(String[] args) {
        triangleNum triangleNum  = new triangleNum();
        int num = 3;
        for (int i = 0; i < num; i++) {
            int[] nums = new int[6];
            Arrays.fill(nums, i+1);
            System.out.println("数组是："+ Arrays.toString(nums)+" 是否构成两个三角形："+triangleNum.triangleNumber(nums));
        }

    }

}


