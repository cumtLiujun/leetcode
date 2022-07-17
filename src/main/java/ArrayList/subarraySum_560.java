package ArrayList;

import java.util.HashMap;

public class subarraySum_560 {

    /*
    ！、暴力破解， 枚举所有的状态找出和为k的数组
     */
    public int subarraySum1(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int sum = 0;
            for (int j = i; j > 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    /*
    2、前缀和方法，对每一个成员找出值等于k-nums[i]的前缀和
    pre[i]−pre[j−1]==k
    pre[j−1]==pre[i]−k
    找到含有多少个pre[j-1]
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
//      初始化添加前缀和为0的数据
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1 );
        }
        return count;
    }

}
