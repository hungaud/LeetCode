import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindPairGivenSum {

    public static void main(String[] args) {
        int[] arr = new int[] {90, 60, 30, -30};
        int target = 90;
        int[] result = findPair(arr, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    public static int[] findPair(int[] arr, int target) {
        if(arr == null || arr.length == 0) return new int[] {-1, -1};
        // key = number, value = index
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], new ArrayList<>());
            }
            map.get(arr[i]).add(i);
        }
        int[] result = new int[] {-1, -1};
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            int a = arr[i];
            int remaining = target - a - 30;
            if(map.containsKey(remaining)) {
                int currentMax = Math.max(a, remaining);
                if(currentMax > max) {
                    result[0] = map.get(a).get(0);
                    result[1] = a == remaining ? map.get(remaining).get(1) : map.get(remaining).get(0);
                    max = currentMax;
                }
            }
        }
        return result;
    }
}
