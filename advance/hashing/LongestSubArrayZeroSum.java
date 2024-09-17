package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given an array A of N integers.
Find the length of the longest Sub-array in the array which sums to zero.
If there is no Sub-array which sums to zero then return 0.

Problem Constraints
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9

Input Format
Single argument which is an integer array A.

Output Format
Return an integer.

Example Input
Input 1: A = [1, -2, 1, 2]
Input 2: A = [3, 2, -1]

Example Output
Output 1: 3
Output 2: 0

Example Explanation

Explanation 1:
 [1, -2, 1] is the largest Sub-array which sums up to 0.

Explanation 2:
 No Sub-array sums up to 0.

 */
public class LongestSubArrayZeroSum {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 2, 1, -3, 4, 3, 1, -2, -3, 2));
        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);

    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        int maxCount = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += A.get(j);

                if (sum == 0) {
                    maxCount = Math.max(maxCount, j - i + 1);
                }
            }

        }
        System.out.println(maxCount);
        // Time O(N^2);
        // Space O(1);
    }

    public static void optimized(ArrayList<Integer> A, int n) {

        HashMap<Long, Integer> hm = new HashMap<>();

        long subArraySum = 0;
        long subArrayLen = 0;

        for(int i = 0; i < n; i++){

            subArraySum+= A.get(i);

            if(subArraySum == 0){
                subArrayLen = Math.max(subArrayLen, i + 1);
            }

            if(hm.containsKey(subArraySum)){
                subArrayLen = Math.max(subArrayLen, i - hm.get(subArraySum));
            }

            else hm.put(subArraySum, i);

        }


        System.out.println(subArrayLen);
        // Time O(N):
        // Space O(N);

    }
}
