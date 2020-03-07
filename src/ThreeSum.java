import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int arr[] = new int[] {-1,0,1,2,-1, -4};
        List<List<Integer>> list = threeSum2(arr);
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || nums[i] != nums[i - 1]) {
                int a = i + 1;
                int b = nums.length - 1;
                int sum = 0 - nums[i];
                while(a < b) {
                    if(nums[a] + nums[b] == sum) {
                        list.add(Arrays.asList(nums[a], nums[b], nums[i]));
                        while(a < b && nums[a] == nums[a + 1]) {
                            a++;
                        }
                        while(a < b && nums[b] == nums[b - 1]) {
                            b--;
                        }
                        a++;
                        b--;
                    } else if (nums[a] + nums[b] < sum) {
                        a++;
                    } else {
                        b--;
                    }
                }
            }
        }
        return list;
    }

    private static List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 ||  num[i] != num[i-1]) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1])
                            lo++;
                        while (lo < hi && num[hi] == num[hi-1])
                            hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

}
