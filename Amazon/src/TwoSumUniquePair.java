import java.util.HashMap;

public class TwoSumUniquePair {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 1};
        int target = 2;
        System.out.println(twoSumUnique(arr, target));

    }

    private static int twoSumUnique(int[] arr, int target) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : arr) {
            if(!map.containsKey(n)) {
                map.put(n, 0);
            }
            map.put(n, map.get(n) + 1);
        }
        for(int n : arr) {
            int remainder = target - n;
            if (n == remainder && map.containsKey(n) && map.get(n) > 1) {
                count++;
                map.remove(n);
            } else if(map.containsKey(remainder)) {
                count++;
                map.remove(remainder);
                map.remove(n);
            }
        }

        return count;
    }


}
