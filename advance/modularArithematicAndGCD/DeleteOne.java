package advance.modularArithematicAndGCD;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A of size N.
You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
Find the maximum value of GCD.

Problem Constraints
2 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return an integer denoting the maximum value of GCD.

Example Input
Input 1: A = [12, 15, 18]
Input 2: A = [5, 15, 30]

Example Output
Output 1: 6
Output 2: 15

Example Explanation

Explanation 1:
 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.

Explanation 2:
 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 Maximum value of gcd is 15.

 */
public class DeleteOne {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(7, 21));
        int n = A.size();

//        bruteForce(A, n);
        optimized(A, n);
    }

    public  static  int gcd (int A, int B){
        if(B == 0) return A;
        return  gcd(B, A % B);
    }

    public  static  void bruteForce (ArrayList<Integer> A, int n){

        int max = 0;

        for(int i = 0; i < n; i++){

            int val = 0;

            for(int j = 0; j < n; j++){

                if(i != j) val = gcd(A.get(i), A.get(j));

            }

            max = Math.max(max, val);

        }

        System.out.println(max);

    }

    public  static  void optimized (ArrayList<Integer> A, int n){

        int [] prefixGcd = new int[n];
        int [] suffixGcd = new int[n];

        prefixGcd[0] = A.get(0);
        suffixGcd[n - 1] = A.get(n - 1);

        for(int i = 1; i < n ; i++){
            prefixGcd[i] = gcd(A.get(i), prefixGcd[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            suffixGcd[i] = gcd(A.get(i), suffixGcd[i + 1]);
        }

        int max = Math.max(prefixGcd[n - 2], suffixGcd[1]);

        for(int i = 1; i < n - 1; i++){
            int prefixVal = prefixGcd[i - 1];
            int suffixVal = suffixGcd[i + 1];
            max = Math.max(max, gcd(prefixVal, suffixVal));
        }

        System.out.println(max);

    }
}
