import java.util.Arrays;

/**
 * ~「找到 nums1 中最接近 nums2[i] 的值」，这个值可能在二分查找过程中的 mid-1/mid/mid+1 中出现，为了不侵入二分查找，可以转化为「找到 nums1 中大于等于 nums2[i] 的最小下标 j」，那么该值可能在 j（j < n） 或 j-1（j > 0）
 * ~ 遍历过程中使用了取模操作，可能会导致最终 sum < max，因此结果要使用 (sum - max + mod) % mod 的形式
 */
public class MinAbsoluteSumDiff {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int mod = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1,0, rec,0, n);
        Arrays.sort(rec);
        int sum = 0, max =0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                max = Math.max(max, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                max = Math.max(max, diff - (nums2[i] - rec[j - 1]));
            }

        }
        return (sum - max + mod) % mod;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length -1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void main(String[] args) {

    }

}
