package Offer.Offer_40;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(x-> -x));


        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            int top = queue.peek();
            System.out.println(top);
            if (arr[k] < top){
                queue.poll();
                queue.offer(arr[k]);
            }
        }

        return queue.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {2,2,6,1,9,8,3,0,7,4};
        int k = 3;
        PriorityQueue<int []> queue = new PriorityQueue<int[]>(k, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] -o1[0];
            }
        });

        for (int i = 0; i < k; i++) {
            int[] temp = {nums[i], i};
            queue.offer(temp);
        }

        for (int i = k; i < nums.length; i++) {
            int top = queue.peek()[0];
            if (nums[i] < top) {
                queue.poll();
                int[] temp = {nums[i], i};
                queue.offer(temp);
            }
        }

        System.out.println(queue.peek()[1]);
    }
}
