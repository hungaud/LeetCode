/*
Given a string, what is the minimum number of adjacent swaps required to convert a string into a palindrome. If not possible, return -1.
 */


import java.util.Arrays;

public class MinAdjacentSwapToMakePalindrome {

    static String[] testStrings = new String[] {"mamad", "asflkj", "aabb", "ntiin","daamm"};
    static int[] expectedResult = new int[] {3, -1, 2, 1, 4};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testStrings.length; i++) {
            int result = getNumSwap(testStrings[i]);
            boolean isPassed = result == expectedResult[i];
            System.out.println("Test " + i + ": " + testStrings[i]);
            if(isPassed) {
                passedTests++;
            }
            System.out.println("Expected: " + expectedResult[i] + " result: " + result  + ", passed: " + isPassed + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static int getNumSwap(String s) {
        int swapCount = 0;
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(arr[left] != arr[right]) {
                char matchLeft = arr[left];
                char matchRight = arr[right];
                int leftCur = left;
                int rightCur = right;

                // find first closest swap for the end.
                while(leftCur < right && matchLeft != arr[rightCur] && matchRight != arr[leftCur]) {
                    leftCur++;
                    rightCur--;
                }
                // no match was found. not able to get palindrome
                if(leftCur == right) {
                    return -1;
                } else if (matchLeft == arr[rightCur]) {
                    while(rightCur != right) {
                        swap(arr, rightCur, rightCur + 1);
                        rightCur++;
                        swapCount++;
                    }
                } else {
                    while (leftCur != left) {
                        swap(arr, leftCur, leftCur - 1);
                        leftCur--;
                        swapCount++;
                    }
                }
            }
            left++;
            right --;
        }
        System.out.println(Arrays.toString(arr));
        return swapCount;
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
