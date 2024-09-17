package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*

Problem Description

You are given an array of N integers, A1, A2 ,..., AN and an integer B.
Return the of count of distinct numbers in all windows of size B.
Formally, return an array of size N-B+1 where i'th element in this array
contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
NOTE: if B > N, return an empty array.

Problem Constraints
1 <= N <= 10^6
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A
Second argument is an integer B.

Output Format
Return an integer array.

Example Input

Input 1:
 A = [1, 2, 1, 3, 4, 3]
 B = 3

Input 2:
 A = [1, 1, 2, 2]
 B = 1

Example Output

Output 1: [2, 3, 3, 2]
Output 2: [1, 1, 1, 1]

Example Explanation

Explanation 1:
 A=[1, 2, 1, 3, 4, 3] and B = 3
 All windows of size B are
 [1, 2, 1]
 [2, 1, 3]
 [1, 3, 4]
 [3, 4, 3]
 So, we return an array [2, 3, 3, 2].

Explanation 2:
 Window size is 1, so the output array is [1, 1, 1, 1].

 */
public class DistinctNumbersInWindow {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 2, 1, 3, 0, 2, 1, 4, 1));
        int B = 3;

        ArrayList<Integer> res = bruteForce(A, B);
        System.out.println(res);
        // Time O(N * B);
        // Space O(N);

        ArrayList<Integer> val = optimized(A, B);
        System.out.println(val);
        // Time O(N);
        // Space O(N);
    }

    public static ArrayList<Integer> bruteForce(ArrayList<Integer> A, int B) {

        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();

        if (B > n) return res;

        for (int i = 0; i <= n - B; i++) {

            HashSet<Integer> hs = new HashSet<>();

            for (int j = i; j < i + B; j++) {
                hs.add(A.get(j));
            }

            res.add(hs.size());
        }

        return res;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> A, int B) {

        int n = A.size();
        ArrayList<Integer> res = new ArrayList<>();

        if (B > n) return res;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < B; i++) {
            int val = A.get(i);
            if (hm.containsKey(val)) hm.put(val, hm.get(val) + 1);
            else hm.put(val, 1);
        }

        res.add(hm.size());

        for (int i = 1; i <= n - B; i++) {

            int prev = A.get(i - 1);
            int next = A.get(B + i - 1);

            if (hm.containsKey(prev)) {
                int freq = hm.get(prev);
                if (freq > 1) hm.put(prev, freq - 1);
                else hm.remove(prev);
            }

            if (hm.containsKey(next)) hm.put(next, hm.get(next) + 1);
            else hm.put(next, 1);

            res.add(hm.size());
        }

        return res;

    }
}
