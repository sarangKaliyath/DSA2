package advance.ModularArithematicsAndGcd;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array of integers A and an integer B,
find and return the number of pairs in A whose sum is divisible by B.
Since the answer may be large, return the answer modulo (10^9 + 7).
Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 10^9
1 <= B <= 10^6

Input Format
The first argument given is the integer array A.
The second argument given is the integer B.

Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).

Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2

Input 2:
 A = [5, 17, 100, 11]
 B = 28

Example Output
Output 1: 4
Output 2: 1

Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5).
 So total 4 pairs.

Explanation 2:
 There is only one pair which is divisible by 28 is (17, 11)


 */
public class PairSumDivisibleByM {

    public static void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int B = 2;

        bruteForce(A, B);
        optimized(A, B);
    }

    public  static void bruteForce (ArrayList<Integer> A, int B){

        int n = A.size();
        int pairs = 0;

        for(int i = 0; i < n; i++){

            for(int j = i + 1; j < n; j++){

                if((A.get(i) + A.get(j)) % B == 0) pairs++;

            }
        }

        System.out.println("pairs :" + pairs);
        // Time O(N^2);
        // Space O(1);
    }

    public  static  void optimized(ArrayList<Integer> A, int B){

        int n = A.size();
        int mod = (int) Math.pow(10, 9) + 7;

        int [] freq = new int [B];
        int pairs = 0;
        int res = 0;

        for(int i = 0; i < n; i++){

            int val = A.get(i) % B;

            if(val == 0) pairs = 0;

            else pairs = B - val;

            res += freq[pairs];

            freq[val]++;

        }

        int ans = res % mod;

        System.out.println(ans);

        // Time O(N);
        // Space O(M);
    }
}
