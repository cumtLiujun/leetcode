package company.Meituan.Case_03;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext()) {
            int ans = Integer.MAX_VALUE;
            n = scanner.nextInt();
            int[] positive = new int[n];
            int[] negative = new int[n];

//            全部数据
            Map<Integer, Integer> total = new HashMap<>();
//            正面向上数据
            Map<Integer, Integer> nums = new HashMap<>();

            for (int i = 0; i < n; i++) {
                positive[i] = scanner.nextInt();
                total.put(positive[i], total.getOrDefault(positive[i], 0) + 1);
                nums.put(positive[i], total.getOrDefault(positive[i], 0) + 1);
            }

            for (int i = 0; i < n; i++) {
                negative[i] = scanner.nextInt();
                total.put(negative[i], total.getOrDefault(negative[i], 0) + 1);
            }
//            对nums根据value排序
            nums.values().stream().sorted().collect(Collectors.toList());

            for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
                if (entry.getValue() > (n + 1) / 2) {
                    ans = 0;
                    break;
                } else {
                    if (total.getOrDefault(entry.getKey(),0)  > (n + 1) / 2) {
                        ans = Math.min(total.get(entry.getKey())  - entry.getValue(), ans);
                        break;
                    }
                }
            }
            ans = ans == Integer.MAX_VALUE ? -1 : ans;
            System.out.println(ans);
        }
    }
}
