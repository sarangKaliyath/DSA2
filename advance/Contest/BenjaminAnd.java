package advance.Contest;

import java.util.ArrayList;
import java.util.Arrays;

/*
Benjamin and XOR
Problem Description

Benjamin is tasked with designing a digital lock system for a high security vault.
The lock mechanism relies on an array of N integers,
each containing a unique code that can unlock the vault,
To ensure the locks reliability, Benjamin needs to evaluate various security patterns,
based on specific bit positions.

He has a set of Q security checks, each represented by an integer in the array B.
For each security check B[i], Benjamin must find how many pairs of code from the array A have,
the B[i]th bit set to 1 in their bitwise AND result.

NOTE: Its is guaranteed that the answer will fit in 32 bits.
HINT: Look at the binary representation of given numbers

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= Q <= 50
0 <= B[i] <= 31

Input Format
First argument contains an array A.
Second argument contains an array B.

Output Format
Return an array of integers containing answer to all the queries.

Example Input
Input 1:
A = [1, 2, 3]
B = [0, 1, 2]

Input 2:
A = [2, 5, 6, 7]
B = [1, 2]

Example Output
Output 1:
[1, 1, 0]
Output 2:
[3, 3]

Example Explanation
Explanation 1:
    The Pair with 0-th bit set is (1, 3);
    The Pair with 1-th bit set is (2, 3);
    There are no Pairs with 2-th bit set.

Explanation 2:
    The pair with 1-th bit set is (2, 6), (2, 7) & (6, 7);
    The pair with 2-th bit set is (5, 6), (5, 7) & (6, 7);
 */
public class BenjaminAnd {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(0, 1, 2));

        ArrayList<Integer> ans = bruteForce(A, B);
        System.out.println(ans);
        // Time ( B * N ^ 2);
        // Space (B);

        ArrayList<Integer> res = optimized(A, B);
        System.out.println(res);
        // Time O(Q + N);
        // Space O(B);
    }

    public  static ArrayList<Integer> bruteForce(ArrayList<Integer> A, ArrayList<Integer> B){

        int n = A.size();

        ArrayList<Integer> res = new ArrayList<>();

        for(int el : B){

            int count = 0;

            for(int j = 0; j < n; j++){

                for(int k = j + 1; k < n; k++){

                    int ans = A.get(j) & A.get(k);

                    if((ans & (1 << el)) > 0) count++;
                }

            }
            res.add(count);
        }
        return res;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();

        int[] feq = new int[33];

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < n; j++) {
                if ((A.get(j) & (1 << i)) > 0) feq[i]++;
            }
        }

        for (int el : B) {
            int x = feq[el];
            int pairs = (x * (x - 1)) / 2;
            res.add(pairs);
        }

        return res;

    }
}
