public class search_33 {

    /*
    二分搜索有两种模板：
    if ( left < right )时，缩减范围用left = mid + 1和right = mid
        right边界始终维护语义nums[right] >= target（以普通二分搜索举例），这条语义通过检测if ( nums[mid] >= target )来实现，
        所以right = mid而非right = mid - 1
        循环退出后需要检测right维护的语义是否正确，即if ( nums[right] >= target )，因为right的位置可能一直没动处于右边界且该位置
        从未被检测过语义，因为我们设置的循环条件是if ( left < right )，如果设置成if ( left <= right )的话，最后left == right == mid
        可能致死循环
    if ( left <= right)时，缩减范围用left = mid + 1和right = mid - 1
        中间直接检测if ( nums[mid] == target ) return mid，如果从未执行该语句而推出循环则说明未搜索到target
        条件检测用if ( left <= right )从而可以检测右边界的语义，从而就应该使用right = mid- 1而非right = mid
     */


    /*
    搜索旋转排序数组：
    1、旋转数组将整个数组分为两个不同的有序序列
    2、二分查找时，判断有序片段
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
//            开始判断有序片段
            if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        search_33 search33 = new search_33();
        int[] nums = {1,3};
        int target = 3;
        System.out.println(search33.search(nums, target));
    }
}
