import java.lang.reflect.Array;
import java.util.*;

public class CombindationSum_39 {

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 6, 7};
        int target = 7;
        String s = combinationSum(arr, target).toString();
        System.out.println(s);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        //Arrays.sort(candidates);
        getCombos(candidates, target, 0, new ArrayList<>(), list, 0);
        return list;
    }

    public static void getCombos(int[] candidates, int target, int sum, List<Integer> temp, List<List<Integer>> res, int start) {
        if(sum == target) {
            res.add(new ArrayList<>(temp));

        } else {
            int index = start;
            while(sum < target && index < candidates.length) {
                int numToAdd = candidates[index];
                temp.add(numToAdd);
                getCombos(candidates, target, sum + numToAdd, temp, res, index);
                temp.remove(temp.size() - 1);
                index++;
            }
        }
    }

    private static boolean checkSeen(HashSet<List<Integer>> seen, List<Integer> currentList) {
        List<Integer> temp = new ArrayList<>(currentList);
        Collections.sort(temp);
        return(seen.add(temp));
    }

}
