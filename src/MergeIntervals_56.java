import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {

    public static void main(String[] args) {
        int[][] arr = new int[][] {{1, 3}, {0, 2}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++) {
            int lo = intervals[i][0];
            int hi = intervals[i][1];
            int last = list.size() - 1;

            if(lo <= list.get(last)[1]) {
                list.get(last)[1] = Math.max(hi, list.get(last)[1]);
            } else {
                list.add(new int[] {lo, hi});
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
