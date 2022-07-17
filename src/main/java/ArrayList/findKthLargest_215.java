package ArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class findKthLargest_215 {

    /*
    方法1：  暴力方法，在不要求时间复杂度和空间复杂度的情况下，快速解题，但是不推荐使用
     */
    public int findKthLargest0(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len - k-1];
    }

    /*
    方法2： 优先队列，维护K个元素的最小堆
     */

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
//        优先队列
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(x -> x));

        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < len; i++) {
            Integer top = minHeap.peek();
            if (top < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.peek();
    }
}
