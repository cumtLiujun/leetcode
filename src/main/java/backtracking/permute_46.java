package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permute_46 {

    /*
    回溯思考：
    1、分支如何产生；
    2、题目需要的解在哪里？是在叶子结点、还是在非叶子结点、还是在从跟结点到叶子结点的路径？
    3、哪些搜索会产生不需要的解的？例如：产生重复是什么原因，如果在浅层就知道这个分支不能产生需要的结果，应该提前剪枝，剪枝的条件是什么，代码怎么写？
     */

/*
回溯方法1：在原有数组中交换排列
 */
    public List<List<Integer>> permute0(int[] nums) {
        int length = nums.length;
        List<Integer> output = new ArrayList<>();
//         Collections.swap算子 仅能 List 类型数据使用
        for (int num : nums) output.add(num);
        List<List<Integer>> res = new ArrayList<>();
        backtrace(length, res, output, 0);
        return res;
    }

    private void backtrace(int length, List<List<Integer>> res, List<Integer> nums, int index) {
//        递归的终止条件，已经排列完 n个数字
        if (index == length)
        {
//            不是直接add(nums),nums中存放的是引用，在递归回溯的过程中，会状态重置撤销，会直接影响res中存放的list的结果，
//            因此使用new ArrayList<>(nums)进行复制，即将list拍摄一个快照，避免影响
            res.add(new ArrayList<>(nums));
        }

        for (int i = index; i < length; i++) {
//           进行交换排列，动态维护数组
            Collections.swap(nums,index, i);
//            继续递归下一个数字
            backtrace(length, res, nums, index + 1);
//            回溯时撤销，原来位置的数字，以继续尝试其他位置数字
            Collections.swap(nums, index, i);
        }
    }

/*
回溯方法2： 使用list path 从nums 中添加数据
 */
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int len = nums.length;
    if (len == 0) return res;
    List<Integer> path = new ArrayList<>();
//    标记是否已经取过该值
    boolean[] flag = new boolean[len];
    backtrace(res, len, flag, path, nums);
    return res;

}

private void backtrace(List<List<Integer>> res, int len, boolean[] flag, List<Integer> path, int[] nums) {
    if (path.size() == len) {
        res.add(new ArrayList<>(path));
    }

    for (int i = 0; i < len; i++) {
        if (!flag[i]) {
            path.add(nums[i]);
            flag[i] = true;
            backtrace(res,len,flag,path,nums);
            flag[i] = false;
            path.remove(path.size()-1);
        }
    }
}

    public static void main(String[] args) {

    }
}
