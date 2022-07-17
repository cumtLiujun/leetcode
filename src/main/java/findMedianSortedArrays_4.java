public class findMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int left = (len1 + len2 + 1) / 2;
        int right = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, left) +
                getKth(nums1, 0, len1 - 1, nums2, 0, len2 - 1, right)) / 2;

    }

    //    递归终止条件， k = 1, 或者其中某一数组剩余length= 0；
    private double getKth(int[] num1, int begin1, int end1, int[] num2, int begin2, int end2, int k) {
        int len1 = end1 - begin1 + 1;
        int len2 = end2 - begin2 + 1;
//        保持 num1的长度为最大
        if (len1 < len2) return getKth(num2, begin2, end2, num1, begin1, end1, k);

//        终止条件
        if (len2 == 0) {
            return num1[begin1 + k - 1];
        }

        if (k == 1) {
            return Math.min(num1[begin1], num2[begin2]);
        }


//        开始移动位置, 最大到某一位置结束
        int i = begin1 + Math.min(len1, k / 2) - 1;
        int j = begin2 + Math.min(len2, k / 2) - 1;

        if (num1[i] < num2[j]) {
            return getKth(num1, i + 1, end1, num2, begin2, end2, k - (i - begin1 + 1));
        } else {
            return getKth(num1, begin1, end1, num2, j + 1, end2, k - (j - begin2 + 1));
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        findMedianSortedArrays_4 findMedianSortedArrays4 = new findMedianSortedArrays_4();
        System.out.println(findMedianSortedArrays4.findMedianSortedArrays(nums1, nums2));

    }
}
