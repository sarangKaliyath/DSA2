package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
Problem Description

Given an array of integers A,
find and return whether the given array contains a non-empty subArray with a sum equal to 0.
If the given array contains a sub-array with sum zero return 1, valse return 0.

Problem Constraints
1 <= |A| <= 100000
-10^9 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return whether the given array contains a subArray with a sum equal to 0.

Example Input
Input 1: A = [1, 2, 3, 4, 5]
Input 2: A = [4, -1, 1]

Example Output
Output 1: 0
Output 2: 1

Example Explanation

Explanation 1:
 No subArray has sum 0.

Explanation 2:
 The subArray [-1, 1] has sum 0.

 */
public class SubArrayWithZeroSum {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(4, -1, 1));
        int n = A.size();

        int val = bruteForce(A, n);
        System.out.println("bruteForce -> val : " + val);
        // Time O(N ^ 2);
        // Space O(1);

        int res = optimized(A, n);
        System.out.println("optimized -> res : " + res);
        // Time O(N);
        // Space O(N);
    }

    public static int bruteForce(ArrayList<Integer> A, int n) {

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += A.get(j);

                if (sum == 0) return 1;

            }

        }

        return 0;
    }

    public static int optimized(ArrayList<Integer> A, int n) {

        HashSet<Long> hs = new HashSet<>();

        long sum = 0;

        for (int val : A) {

            sum += (long) val;

            if (hs.contains(sum)) return 1;

            if (sum == 0) return 1;

            hs.add(sum);
        }

        return 0;
    }
}
