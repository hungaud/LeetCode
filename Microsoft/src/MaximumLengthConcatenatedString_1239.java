import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class MaximumLengthConcatenatedString_1239 {

    public static void main (String[] args) {
        String[] arr = new String[] {"cha", "act","ers"};
        List<String> list = Arrays.asList(arr);
        System.out.println(maxLength(list));
    }

    static int maxLen = 0;
    public static int maxLength(List<String> arr) {
        for(int i = 0; i < arr.size(); i++) {
            dfs(arr, arr.get(i), new HashSet<>(), i);
        }
        return maxLen;
    }

    private static boolean dfs(List<String> arr, String word, HashSet<Character> seen, int index) {
        char[] letters = word.toCharArray();
        int n = 0;

        // add the letters to set.
        for(char c : letters) {
            if(seen.add(c))
                n++;
            else
                break;
        }

        // duplicated character, remove them.
        if(n < letters.length){
            while(n > 0) {
                seen.remove(letters[n - 1]);
                n--;
            }
            return false;
        }

        maxLen = Math.max(seen.size(), maxLen);
        for(int i = index + 1; i < arr.size(); i++) {
            dfs(arr, arr.get(i), seen, i);
        }

        // back track.
        for(char c : letters) {
            seen.remove(c);
        }
        return true;
    }
}
