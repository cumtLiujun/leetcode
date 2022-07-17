package ArrayList;

import java.util.Arrays;

public class productExceptSelf_238 {

    /*
    不能除，则转化为乘法，上下三角
    原数组：       [1       2       3       4]
····左部分的乘积：   1       1      1*2    1*2*3
····右部分的乘积： 2*3*4    3*4      4      1
·····结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
     */
    public int[] productExceptSelf(int[] nums) {
        int len  = nums.length;

        int[] ans = new int[len];
        Arrays.fill(ans, 1);
        int p = 1, q = 1;
        for (int i = 0; i < len; i++) {
            ans[i] *= p;
            p *= nums[i];
        }
        for (int i = len -1; i >= 0; i--) {
            ans[i] *= q;
            q *= nums[i];
        }
        return ans;
    }
}
