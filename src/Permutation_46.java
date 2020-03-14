import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation_46 {

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2};
        List<List<Integer>> list = permute(arr);
        System.out.println(list.toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getperm(list, new ArrayList<>(), new HashSet<>(), nums);
        return list;
    }

    public static void getperm(List<List<Integer>> list, List<Integer> temp, HashSet<Integer> set, int[] nums) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));

        } else {
            for (int i = 0; i < nums.length; i++) {
                int n = nums[i];
                if (!set.contains(n)) {
                    set.add(n);
                    temp.add(n);
                    getperm(list, temp, set, nums);
                    temp.remove(temp.size() - 1);
                    set.remove(n);

                }
            }
        }
    }
}