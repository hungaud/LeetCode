import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PrisonAfterNDays_957 {

    public static void main(String[] args) {
        int[] arr = new int[] {0,1,0,1,1,0,0,1};
        System.out.println(Arrays.toString(prisonAfterNDays(arr, 30)));
    }

    public static int[] prisonAfterNDays(int[] cells, int N) {
        int[] temp = Arrays.copyOf(cells, cells.length);
        int[] result = new int[cells.length];
        HashSet<String> seen = new HashSet<>();
        boolean isCycle = false;
        int count = 0;

        while(!isCycle) {
            for(int j = 0; j < temp.length; j++) {
                if(j == 0 || j == temp.length - 1 || temp[j - 1] != temp[j + 1])
                    result[j] = 0;
                else
                    result[j] = 1;
            }
            temp = Arrays.copyOf(result, result.length);
            if(seen.add(Arrays.toString(temp))) {
                count++;
            } else {
                isCycle = true;
            }
        }
        //System.out.println(count);

        if(N >= count)
            N = N % count + count;
        else
            N = N % count;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < cells.length; j++) {
                if(j == 0 || j == cells.length - 1 || cells[j - 1] != cells[j + 1])
                    result[j] = 0;
                else
                    result[j] = 1;
            }
            cells = Arrays.copyOf(result, result.length);
        }
        return result;
    }
}
