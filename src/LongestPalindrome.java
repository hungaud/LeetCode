public class LongestPalindrome {

    public static void main(String[] args) {
        String res = longestPalindrome("abba");
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        char[] arr = s.toCharArray();

        String result = "";
        int max = 0;
        //string length == 1
        for(int i = 0; i < len; i++) {
            matrix[i][i] = true;
            if (max < 1) {
                result = getSubstring(s, i, i + 1);
                max = 1;

            }
        }

        // length == 2
        for(int i = 0; i < len - 1; i++) {
            if(arr[i] == arr[i + 1]) {
                matrix[i][i + 1] = true;
                if ( max < 2) {
                    max = 2;
                    result = getSubstring(s, i, i + 2);

                }
            }
        }

        // length >= 3
        for(int i = 3; i <= len; i++) {
            for(int start = 0; start + i <= len; start++) {
                int end = start + i - 1;
                boolean sameLetter = arr[start] == arr[end];
                if(sameLetter && matrix[start + 1][end - 1]) {
                    matrix[start][end] = true;
                    if (max < i){
                        result = getSubstring(s, start, end + 1);
                        max = i;
                    }
                }
            }
        }
        return result;
    }

    private static String getSubstring(String s, int start, int end) {
        return s.substring(start, end);
    }
}
