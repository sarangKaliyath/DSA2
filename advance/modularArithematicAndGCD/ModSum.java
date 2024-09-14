package advance.modularArithematicAndGCD;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array of integers A,
calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs.
Return sum % (10^9 + 7) as an output.

Problem Constraints
1 <= length of the array A <= 10^5
1 <= A[i] <= 10^3

Input Format
The only argument given is the integer array A.

Output Format
Return a single integer denoting sum % (109 + 7).

Example Input
Input 1: A = [1, 2, 3]
Input 2: A = [17, 100, 11]

Example Output
Output 1: 5
Output 2: 61

Example Explanation
Explanation 1:
 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5

 */
public class ModSum{

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(17, 100, 11));

        int n = A.size();

        bruteForce(A, n);

        optimized(A, n);

    }

    public  static  void bruteForce(ArrayList<Integer> A, int n){

        int mod = (int) Math.pow(10, 9) + 7;

        int sum = 0;

        for(int i = 0; i < n; i++){

            for(int j = 0; j < n ; j++){

                sum =  (sum + (A.get(i) % A.get(j))) % mod;

            }

        }

        System.out.println(sum % mod);

        // Time O(N^2);
        // Space O(1);
    }

    public  static  void optimized (ArrayList<Integer> A, int n){

        int mod = (int) Math.pow(10, 9) + 7;

        int res = 0;

        int [] feq = new int [1001];

        for(int i = 0; i < n; i++){
            feq[A.get(i)]++;
        }

        for(int i = 1; i <= 1000; i++){

            for(int j = 1; j <= 1000; j++){

                int val = i % j;

                int prod = (feq[i] * feq[j] * val);

                res = ((res % mod) + (prod % mod)) % mod;

            }

        }

        System.out.println(res);

        // Time O(Range ^ 2);
        // Space O(Range);
    }
}
