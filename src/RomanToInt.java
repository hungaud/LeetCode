public class RomanToInt {

    public static void main(String[] args) {
        String s = "IV";
        int n = romanToInt(s);
    }
    public static int romanToInt(String s) {
        int n = 0;
        char prev = ' ';
        for(int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            char next = i + 1 < s.length() ? s.charAt(i + 1) : ' ';
            if(c =='M') {
                n += 1000;
                if(prev == 'C')
                    n -= 100;
            } else if (c == 'D') {
                n += 500;
                if(prev == 'C')
                    n -= 100;
            } else if (c == 'C') {
                n += 100;
                if(prev == 'X')
                    n -= 10;
            } else if (c == 'L') {
                n += 50;
                if(prev == 'X')
                    n -= 10;
            } else if (c == 'X') {
                n += 10;
                if(prev == 'I')
                    n -= 1;
            } else if (c == 'V' && (next != 'V' || next != 'X')) {
                n += 5;
                if(prev == 'I')
                    n -= 1;

            } else if (c == 'I' && (next != 'V' || next != 'X')) {
                n += 1;

            }
            prev = c;
        }
        return n;
    }

}
