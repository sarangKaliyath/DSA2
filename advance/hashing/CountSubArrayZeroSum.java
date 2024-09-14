package advance.hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashMap;

/*
Problem Description
Given an array A of N integers.
Find the count of the subarrays in the array which sums to zero.
Since the answer can be very large, return the remainder on dividing the result with 10^9+7

Problem Constraints
1 <= N <= 10^5
-109 <= A[i] <= 10^9

Input Format
Single argument which is an integer array A.

Output Format
Return an integer.

Example Input
Input 1: A = [1, -1, -2, 2]
Input 2: A = [-1, 2, -1]

Example Output
Output 1: 3
Output 2: 1

Example Explanation

Explanation 1:
 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].

Explanation 2:
 The subarray with zero sum is [-1, 2, -1].

 */
public class CountSubArrayZeroSum {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(-1, 2, -1));
        int n = A.size();

        bruteForce(A, n);

        optimized(A);
    }

    public static void bruteForce(ArrayList<Integer> A, int n) {

        int count = 0;

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += A.get(j);

                if (sum == 0) count++;

            }

        }

        System.out.println(count);
        // Time O(N^2);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A) {

        HashMap<Long, Long> hm = new HashMap<>();
        int mod = (int) Math.pow(10, 9) + 7;

        long sum = 0;
        long count = 0;

        hm.put(0L, 1L);

        for (int el : A) {

            sum += el;

            if (hm.containsKey(sum)) {
                count += hm.get(sum);
                hm.put(sum, hm.get(sum) + 1);
            } else hm.put(sum, 1L);

        }

        System.out.println((int) count % mod);

        // Time O(N);
        // Space O(N);
    }
}
