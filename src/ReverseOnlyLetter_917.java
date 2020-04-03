public class ReverseOnlyLetter_917 {

    public static void main(String[] args) {
        String s = "ab-cd";
        System.out.println(reverseOnlyLetters(s));
    }
    public static String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            while(start < arr.length && arr[start] < 'a' || arr[start] > 'z' || arr[start] < 'A' || arr[start] > 'Z') {
                start++;
            }
            while(end >= 0 && arr[end] < 'a' || arr[end] > 'z' || arr[end] < 'A' || arr[end] > 'Z') {
                end--;
            }
            swap(arr, start, end);
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static void swap (char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
