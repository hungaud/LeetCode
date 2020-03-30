public class CompressString {

    public static void main(String[] args) {
        System.out.println("Compress: a " + compress("a") );
        System.out.println("Compress: aaa " + compress("aaa") );
        System.out.println("Compress: aaabbaa " + compress("aaabbaa") );
        System.out.println("Compress: aabbccc " + compress("aabbccc") );

    }

    private static String compress(String s) {
        StringBuilder sb = new StringBuilder();
        char[] str = s.toCharArray();
        int index = 0;
        while(index < s.length()) {
            int count = 0;
            char currentChar = str[index];
            while(index < str.length && currentChar == str[index]) {
                index++;
                count++;
            }
            sb.append(currentChar);
            if(count <= 1)
                continue;
            sb.append(count);
        }
        return sb.toString();
    }
}
