package company.Mihayou.Case_03;

import java.util.*;

public class Main {

    static void res(Map<Integer, List<Integer>> map, int root, int[] degree, int[] visited) {
        if (degree[root] == 1) {
            return;
        }
        int p_color = visited[root];
        List<Integer> childs = map.get(root);
        for (int i : childs) {
            if (visited[i] != 0) {
                continue;
            }
            visited[i] = (++ p_color -1) % 3 + 1;
            res(map, i, degree, visited);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            int[] visited = new int[n+1];
            int[] degree = new int[n+1];
            for (int i = 0; i < n-1; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                degree[from]++;
                degree[to]++;
                List<Integer> fromList = map.getOrDefault(from, new ArrayList<>());
                fromList.add(to);
                map.put(from,fromList);
                List<Integer> toList = map.getOrDefault(to, new ArrayList<>());
                fromList.add(from);
                map.put(to,toList);
            }
            int root = 0;
            for (int i = 1; i<=n;i++) {
                if (degree[i]>1){
                    root = i;
                    break;
                }
            }
            visited[root] = 1;
            res(map, root, degree, visited);
            for (int i = 1 ;i <= n; i++){
                switch (visited[i]) {
                    case 1:{

                    }
                }
            }
        }
    }
}
