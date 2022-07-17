import java.util.Arrays;

public class majorityElement_169 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);

        int numElement = 1;
        int element = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (element == nums[i]) {
                numElement++;
            } else {
                if (numElement > nums.length/2) return element;
                numElement = 1;
                element = nums[i];
            }
        }
        return element;
    }
}
