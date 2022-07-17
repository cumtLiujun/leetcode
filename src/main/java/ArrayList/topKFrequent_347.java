package ArrayList;

import java.util.*;

public class topKFrequent_347 {
    public int[] topKFrequent0(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        默认为小顶堆, 排序根据map的key值进行排序
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(key);
            } else if (map.get(priorityQueue.peek()) < map.get(key)) {
                priorityQueue.remove();
                priorityQueue.offer(key);
            }
        }
        int []res = new int[k];
        int i = 0;
        while (!priorityQueue.isEmpty()){
           res[i++] = priorityQueue.remove();
        }
        return res;
    }

//    计数排序方法；
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }


        List<Integer> res = new ArrayList<>();
        List[] list = new List[nums.length + 1];

        for (Integer key :map.keySet()) {
            Integer value = map.get(key);
            if (list[value] == null) list[value] = new ArrayList<>();
            list[value].add(key);
        }

        for (int i = nums.length; i >=0 ; i--) {
            if (list[i] != null && res.size() < k) {
                res.addAll(list[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
