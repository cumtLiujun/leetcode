public class sortColors_75 {

    /*
    重点在于排序，需要原地排序，不能借用sort方法
     */
    public void sortColors(int[] nums) {
        int flag0 = 0;
        int flag1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) flag0++;
            if (nums[i] == 1) flag1++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < flag0) {
                nums[i] = 0;
            } else if (i >= flag0 && i < flag0 + flag1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
    /*
    方法2：双指针，01双指针，重点在于何时移动指针和交换数据
     */
}
