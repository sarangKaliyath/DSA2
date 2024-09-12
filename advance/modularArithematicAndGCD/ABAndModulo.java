package advance.modularArithematicAndGCD;

/*
Problem Description
Given two integers A and B, find the greatest possible positive integer M, such that A % M = B % M.

Problem Constraints
1 <= A, B <= 10^9
A != B

Input Format
The first argument is an integer A.
The second argument is an integer B.

Output Format
Return an integer denoting the greatest possible positive M.

Example Input

Input 1:
A = 1
B = 2

Input 2:
A = 5
B = 10

Example Output
Output 1: 1
Output 2: 5

Example Explanation

Explanation 1:
1 is the largest value of M such that A % M == B % M.

Explanation 2:
For M = 5, A % M = 0 and B % M = 0.
No value greater than M = 5, satisfies the condition.
 */
public class ABAndModulo {

    public static  void main (String [] args){

        int A = 123213213;
        int B = 91999898;
        // 4380528
       int val =  bruteForce(A, B, A > B ? A : B);
       System.out.println("val : " + val);
        // Time O(Min(A, B));
        // Space O(1)

       int res = optimized(A, B);
       System.out.println("res : " + res);
        // Time O(1);
        // Space O(1);

    }

    public  static  int bruteForce(int A, int B, int M){
        for(int i = M; i >= 0; i--){
            if((A % i) == (B % i)) return i;
        }
        return 1;
    }

    public  static int optimized(int A, int B){

        return Math.abs(A - B);

    }
}
