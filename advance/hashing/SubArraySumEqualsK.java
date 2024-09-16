package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given an array of integers A and an integer B.
Find the total number of sub-arrays having sum equals to B.

Problem Constraints
 1 <= length of the array <= 50000
-1000 <= A[i] <= 1000

Input Format
The first argument given is the integer array A.
The second argument given is integer B.

Output Format
Return the total number of sub-arrays having sum equals to B.

Example Input
Input 1:
A = [1, 0, 1]
B = 1

Input 2:
A = [0, 0, 0]
B = 0

Example Output
Output 1: 4
Output 2: 6

Example Explanation
Explanation 1:
[1], [1, 0], [0, 1] and [1] are four sub-arrays having sum 1.

Explanation 1:
All the possible sub-arrays having sum 0.
 */
public class SubArraySumEqualsK {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 0, 0));
        int B = 0;

        bruteForce(A, B);

        optimized(A, B);

    }

    public static void bruteForce(ArrayList<Integer> A, int B) {

        int count = 0;

        for (int i = 0; i < A.size(); i++) {

            int sum = 0;

            for (int j = i; j < A.size(); j++) {

                sum += A.get(j);

                if (sum == B) count++;
            }

        }

        System.out.println(count);
        // Time O(N ^ 2);
        // Space O(1);

    }

    public static void optimized(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> hs = new HashMap<>();
        int count = 0;

        int[] pf = new int[A.size()];
        pf[0] = A.get(0);

        for (int i = 1; i < A.size(); i++) {
            pf[i] = pf[i - 1] + A.get(i);
        }

        for (int el : pf) {

            if(hs.containsKey(el - B)) count += hs.get(el - B);

            if(el == B) count++;

            if(hs.containsKey(el)) hs.put(el, hs.get(el) + 1);
            else hs.put(el, 1);

        }

        System.out.println(count);
        // Time O(N);
        // Space O(N);
    }
}
