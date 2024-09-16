package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.
Since the answer can be very large, return the remainder after dividing the count with 10^9+7.
Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= B <= 10^9

Input Format
First argument A is an array of integers and second argument B is an integer.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 5, 1, 2]
B = 8

Input 2:
A = [1, 2, 1, 2]
B = 3

Example Output
Output 1: 1
Output 2: 4

Example Explanation

Example 1:
The only pair is (1, 2) which gives sum 8

Example 2:
The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4).

 */
public class CountPairSum {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        int B = 3;

        bruteForce(A, B);

        optimized(A, B);
    }

    public static void bruteForce(ArrayList<Integer> A, int B) {

        int n = A.size();

        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (i != j && (A.get(i) + A.get(j)) == B) count++;

            }

        }

        System.out.println(count);

        // Time O(N ^ 2);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A, int B) {

        int mod = (int) Math.pow(10, 9) + 7;
        HashMap<Integer, Integer> hm = new HashMap<>();

        long count = 0;

        for (int i : A) {

            if (hm.containsKey(B - i)) count = (count + hm.get(B - i)) % mod;

            if (hm.containsKey(B)) hm.put(B, hm.get(B) + 1);

            if (hm.containsKey(i)) hm.put(i, hm.get(i) + 1);

            else hm.put(i, 1);

        }

        System.out.println(count);

        // Time O(N);
        // Space O(N);

    }
}
