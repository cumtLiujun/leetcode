import java.util.HashMap;
import java.util.HashSet;

class FindRepeatNumber_3 {

    //    本题 可以直接使用set的方法，思路相同但是map繁琐
    @Deprecated
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int item : nums) {
            if (map.get(item) == null) {
                map.put(item, 1);
            } else {
                res = item;
                break;
            }
        }
        return res;
    }

    public int findRepeatNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }

        return -1;
    }

    /**
     * 交换位置，数组元素的 索引 和 值 是 一对多 的关系，后面在出现则为重复数字
     */

    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (i == nums[i]) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i]) return nums[i];
//            交换，一直到索引下标 等于该值
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }

        return -1;
    }
}


class search_53 {
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        if (map.containsKey(target)) return map.get(target);
        return 0;
    }

    // 二分法 查找 target的位置,等号存在时 寻找target最大index+1
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }

    //    排序数组中的搜索，优先使用双指针和二分查找
    @Deprecated
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return nums[i] - 1;
        }
        return nums[nums.length - 1] + 1;
    }

    public int missingNumber1(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        search_53 search = new search_53();
        int[] nums = {5, 6, 6, 8, 8, 10};
        System.out.println(search.helper(nums, 8));
    }

}

/**
 * 根据题目描述，可知道数据具有“从上到下递增、从左到右递增” 的特点
 * 类似于 二叉搜索树 ，即对于每个元素，其左分支元素更小、右分支元素更大。因此，通过从 “根节点” 开始搜索
 */
class findNumberIn2DArray_4 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, cols = matrix[0].length;
        int row = 0, col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     *
     *当 nums[m] > nums[j]nums[m]>nums[j] 时： m 一定在 左排序数组 中，即旋转点 xx 一定在 [m + 1, j][m+1,j] 闭区间内，因此执行 i = m + 1i=m+1；
     * 当 nums[m] < nums[j]nums[m]<nums[j] 时： m 一定在 右排序数组 中，即旋转点 xx 一定在[i, m][i,m] 闭区间内，因此执行 j = mj=m；
     * 当 nums[m] = nums[j]nums[m]=nums[j] 时： 无法判断 m 在哪个排序数组中，即无法判断旋转点 xx 在 [i, m][i,m] 还是 [m + 1, j][m+1,j] 区间中。
     * 解决方案： 执行 j = j - 1 缩小判断范围,这里可以直接进行线性方法进行查找，不需要再进行二分查找；
     *
     */
    public int minArray(int[] numbers) {

        int i = 0, j = numbers.length-1;
        while (i < j) {
            int m = (i + j) / 2;
            if (numbers[m] < numbers[j]) j = m;
            else if (numbers[m] > numbers[j]) i = m + 1;
            else j--;
        }
        return numbers[i];

    }

    public static void main(String[] args) {
        int[][] test = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 1;
        findNumberIn2DArray_4 findNumberIn2DArray4 = new findNumberIn2DArray_4();

        System.out.println(findNumberIn2DArray4.findNumberIn2DArray(test, target));

    }
}



