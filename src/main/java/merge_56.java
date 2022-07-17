import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class merge_56 {

    /*
    方法1：暴力方法，排序 + 记录取值
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        List<int[]> res = new ArrayList<>();
//        排序,自定义排序函数
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        int min = intervals[0][0];
        int max = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            // System.out.println(i);
            if (min <= intervals[i][0] && max >= intervals[i][0]) {
                max = Math.max(max, intervals[i][1]);
            } else {
                res.add(new int[] {min, max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        res.add(new int[] {min, max});
        return res.toArray(new int[res.size()][]);
    }
}
