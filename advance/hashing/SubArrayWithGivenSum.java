package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous sub-array which adds to B.
If the answer does not exist return an array with a single integer "-1".
First sub-array means the sub-array for which starting index in minimum.

Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the first continuous sub-array which adds to B and
if the answer does not exist return an array with a single integer "-1".

Example Input

Input 1:
 A = [1, 2, 3, 4, 5]
 B = 5

Input 2:
 A = [5, 10, 20, 100, 105]
 B = 110

Example Output
Output 1: [2, 3]
Output 2: [-1]

Example Explanation
Explanation 1:
 [2, 3] sums up to 5.
Explanation 2:
 No sub-array sums up to required number.

 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 5;

        ArrayList<Integer> res = bruteForce(A, B);
        System.out.println(res);
        // Time O(N^3);
        // Space O(N);

        ArrayList<Integer> val = optimized(A, B);
        System.out.println(val);
        // Time O(N);
        // Space O(N);
    }

    public static ArrayList<Integer> bruteForce(ArrayList<Integer> A, int B) {

        int n = A.size();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int sum = 0;

            for (int j = i; j < n; j++) {

                sum += A.get(j);

                if (sum == B) {
                    for (int k = i; k <= j; k++) {
                        res.add(A.get(k));
                    }
                    return res;
                }

            }

        }

        res.add(-1);
        return res;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> A, int B) {

        int n = A.size();

        ArrayList<Integer> res = new ArrayList<>();

        HashMap<Long, Integer> hm = new HashMap<>();
        long sum = 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++) {

            sum += A.get(i);

            if (sum == B) {
                start = 0;
                end = i;
                break;
            }

            long diff = sum - B;

            if (hm.containsKey(diff)) {
                start = hm.get(diff) + 1;
                end = i;
                break;
            }

            hm.put(sum, i);

        }

        if (start != -1 && end != -1) {
            for (int i = start; i <= end; i++) {
                res.add(A.get(i));
            }
        } else res.add(-1);

        return res;

    }

}
