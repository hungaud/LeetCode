/*
An infrastructure consisting of N cities numbered from 1 to N, and M bidirectional roads between them are given.
Roads do not intersect apart from at their start and endpoints (they can pass through underground tunnels to avoid collisions).
For each pair of cities directly connected by a road, let’s define their network rank as the total number of roads that are connected to either of the two cities.
Write a function:
class Solution { public int solution(int[] A, int[] B, int N); }
that, given two arrays A, B consisting of M integers each and an integer N, where A[i] and B[i] are cities at the two ends of the i-th road, returns the maximal network rank in the whole infrastructure.

 Basically saying, which edge (a[i] b[i]) has the most adjacency neighbors.

 */

import javax.print.attribute.HashAttributeSet;
import java.util.Arrays;
import java.util.HashMap;

public class MaxNetworkRank {

    static int[][] testArrayOne = new int[][] {{1,2,3,3}, {1,2,4,5}, {1,2,3,4,5,6,3,12,11,10,9}};
    static int[][] testArrayTwo = new int[][] {{2,3,1,4,}, {2,3,5,6}, {7,7,7,7,7,7,8,8,8,8,8}};
    static int[] testNumCities = new int[] {4, 6, 11};
    static int[] expectedResult = new int[] {4, 2, 7};

    public static void main(String[] args) {
        int passedTests = 0;
        for(int i = 0; i < testArrayOne.length; i++) {
            int result = maxNetworkRank(testArrayOne[i], testArrayTwo[i], testNumCities[i]);
            System.out.println("Test " + i + ": \n" + Arrays.toString(testArrayOne[i]) + " \n" + Arrays.toString(testArrayTwo[i]));
            if(result == expectedResult[i]) {
                passedTests++;
            }
            System.out.println("Expected: " + expectedResult[i] + " result: " + result + "\n");
        }
        if(passedTests == expectedResult.length)
            System.out.println("All tests passed!");
    }

    private static int maxNetworkRank(int[] a, int[] b, int numCities) {
        int networkRank = 0;
        // key = city, val = number of roads connected
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
            map.put(b[i], map.getOrDefault(b[i], 0) + 1);
        }

        for(int i = 0; i < a.length; i++) {
            networkRank = Math.max(networkRank, map.get(a[i]) + map.get(b[i]) - 1);
        }
        return networkRank;
    }

}
