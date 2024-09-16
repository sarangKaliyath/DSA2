package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*

Problem Description
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.

Problem Constraints
1 <= Length of array B <= 10^5
0 <= Bi <= 10^9
0 <= A <= 10^9

Input Format
First argument A is the Target sum, and second argument is the array B

Output Format
Return an integer value 1 if there exists such pair, else return 0.

Example Input

Input 1:
A = 8
B = [3, 5, 1, 2, 1, 2]

Input 2:
A = 21
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]

Example Output
Output 1: 1
Output 2: 0

Example Explanation
Example 1:
It is possible to obtain sum 8 using 3 and 5.

Example 2:
There is no such pair exists.


 */
public class CheckPairSum {

    public static void main(String[] args) {

        int A = 100;
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(23,52,95,29,9,47,49,55,96,4));

        int val = bruteForce(A, B);
        System.out.println(val);
        // Time O(N^2);
        // Space O(1);

        int res = optimized(A, B);
        System.out.println(res);
        // Time O(N);
        // Space O(N);

    }

    public static int bruteForce(int A, ArrayList<Integer> B) {

        int res = 0;
        int n = B.size();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i != j && (B.get(i) + B.get(j)) == A) return 1;

            }
        }

        return res;
    }

    public  static  int optimized (int A, ArrayList<Integer> B){

        HashSet<Integer> hs = new HashSet<>();

        for(int el : B){

            if(hs.contains(A - el)) return 1;

            else hs.add(el);

        }

        return 0;
    }
}
