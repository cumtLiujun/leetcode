package Backpack;

public class canPartition_416 {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
         if ((sum & 1) == 1) {
             return false;
         }
         int target = sum / 2;
         boolean[][] db = new boolean[len][target + 1];

         db[0][0] = true;
         if (nums[0] <= target) {
             db[0][nums[0]] = true;
         }
         for (int i = 1; i < len; i++) {
             for (int j = 0; j<= target; j++) {
                 db[i][j] = db[i-1][j];
                 if (nums[i] <= j) {
                     db[i][j] = db[i-1][j] || db[i - 1][j - nums[i]];
                 }
             }
             if (db[i][target]) {
                 return true;
             }
         }
        return db[len - 1][target];
    }
}
