import java.util.HashMap;

public class Atoi_8 {

    public static void main(String[] args) {
        String s = "2147483648";
        int n = myAtoi(s);
        System.out.println(n);
        //long longnumber = 10100236300;
        //.out.println((int)longnumber / 10 * -1);
    }

    private static int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        String s = "0123456789";
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        str = str.trim();
        if(str.length() == 0)
            return 0;
        char c = str.charAt(0);
        boolean isNegative = c == '-';
        boolean isSign = c == '-' || c == '+';
        long longnumber = 0;

        int i = isSign ? 1 : 0;
        while(i < str.length()) {
            c = str.charAt(i);
            if(!map.containsKey(c)) {
                break;
            }
            if(isSign && (c == '-' || c == '+')) return 0;

            if(Integer.MAX_VALUE / 10 < longnumber || Integer.MAX_VALUE / 10 == longnumber && Integer.MAX_VALUE % 10 < map.get(c)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            longnumber *= 10;
            longnumber += map.get(c);
            i++;
        }
        return isNegative ? (int) (longnumber * -1) : (int)(longnumber);
    }
}
