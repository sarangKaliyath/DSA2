package advance.modularArithematicAndGCD;

/*
Problem Description
Scooby has 3 three integers A, B, and C.
Scooby calls a positive integer special if it is divisible by B and it is divisible by C.
You need to tell the number of special integers less than or equal to A.

Problem Constraints
1 <= A, B, C <= 10^9

Input Format
First argument is a positive integer A
Second argument is a positive integer B
Third argument is a positive integer C

Output Format
One integer corresponding to the number of special integers less than or equal to A.

Example Input

Input 1:
 A = 12
 B = 3
 C = 2

Input 2:
 A = 6
 B = 1
 C = 4

Example Output
Output 1: 2
Output 2: 1

Example Explanation
Explanation 1:
 The two integers divisible by 2 and 3 and less than or equal to 12 are 6,12.

Explanation 2:
 Only 4 is a positive integer less than equal to 6 which is divisible by 1 and 4.
 */
public class DivisorGame {

    public  static  void main (String [] args){

        int A = 411753753; int B = 1876; int C = 7430;


        bruteForce(A, B, C);

        optimized(A, B, C);
    }

    public  static  void bruteForce(int A, int B, int C){

        int count = 0;

        for(int i = A; i >= 1; i--){
            if(i%B == 0 && i%C == 0) count++;
        }

        System.out.println(count);

        // Time O(A);
        // Space O(1);
    }

    public  static  void optimized (int A, int B, int C){

        int lcm = (B * C) / gcd(B, C);
        int ans = (int) A/lcm;
        System.out.println(ans);
        // Time O(log(Min(B, C));
        // Space O(1);
    }

    public  static  int gcd (int A, int B){
        if(B == 0) return A;
        return gcd(B, A % B);
    }


}
