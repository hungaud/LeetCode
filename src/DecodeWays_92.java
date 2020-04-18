import java.util.ArrayList;
import java.util.List;

public class DecodeWays_92 {

    // will need to do the actual one.
    public static void main(String[] args) {
        String num = "52422423";
        System.out.println(getStrings(num));
    }



    private static List<String> getStrings(String num) {
        List<String> res = new ArrayList<>();
        dfs(res, new StringBuilder(), num, 0);
        return res;
    }

    // this is to print out the words instead of getting the count.
    public static void dfs(List<String> res, StringBuilder sb, String digits, int index) {
        if(index >= digits.length()) {
            res.add(sb.toString());
            return;
        }

        if(digits.charAt(index) > '0') {
            sb.append((char)(digits.charAt(index) + 'A' - '1'));
            dfs(res, sb, digits, index + 1);
            sb.setLength(sb.length() - 1);
        }
        if(index < digits.length() - 1) {
            int x = Integer.parseInt(digits.substring(index, index+2));
            if(x > 9 && x <= 26) {
                sb.append((char)(x + 'A' - 1));
                dfs(res, sb, digits, index + 2);
                sb.setLength(sb.length() - 1);
            }
        }
    }
}
