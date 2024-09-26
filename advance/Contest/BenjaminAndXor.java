package advance.Contest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description

In the picturesque town of Bitville, nestled amidst rolling hills and shimmering lakes,
the residents had a deep fascination with the world of bits and binary operations.
The townsfolk were avid mathematicians, always seeking new puzzles to unravel and insights to gain.
One sunny morning, the town's esteemed professor of mathematics, Dr. Benjamin,
presented a captivating challenge to his students. He introduced them to an array A of N integers,
representing a sequence of numbers with each element holding a special significance.
Dr. Benjamin explained that the students' task was to analyze the array and determine the count of pairs
that satisfied a unique condition.
The condition revolved around the XOR operation on the ith bit of the pair's elements.
The goal was to count the pairs for which the xor of the ith bit resulted in one.
You have to answer for Q queries given in array B,
each query B[i] denotes the index for which you need to find the count of pairs with xor of that index equals 1.

Can you solve the task given by Dr. Benjamin?
Please read the examples given below for better understanding of the problem.
HINT: Look at the binary representation of given numbers

Problem Constraints
1 <= N <= 4* 10^4
1 <= A[i] <= 10^9
1 <= Q <= 100
0 <= B[i] < 32

Input Format
First argument contains an array A.
Second argument contains an array B.

Output Format
Return an array of integers containing answer to all the queries.

Example Input
Input 1:
A = [1, 2, 3]
B = [0, 1]
Input 2:
A = [2, 4, 7, 11]
B = [3]

Example Output
Output 1:
[2, 2]
Output 2:
[3]

Example Explanation
Explanation 1:
Query with index = 0 means we have to find the total pairs whose XOR have 'index' bit set.
The corresponding pairs are [[1, 2], [2, 3]].

Query with index = 1 means we have to find the total pairs whose XOR have 'index' bit set.
The corresponding pairs are [[1, 2], [1, 3]].

Explanation 2:
Query with index = 3 means we have to find the total pairs whose XOR have 'index' bit set.
The corresponding pairs are [[2, 11], [4, 11], [7, 11]].

 */
public class BenjaminAndXor {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(0, 1));

        ArrayList<Integer> ans = bruteForce(A, B);
        System.out.println(ans);
        // Time O( B * N^2);
        // Space O(B);

        ArrayList<Integer> res = optimized(A, B);
        System.out.println(res);
        // Time O( B + N);
        // Space O(B);
    }

    public static ArrayList<Integer> bruteForce(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();

        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {

            int count = 0;

            for (int j = 0; j < n; j++) {
                int xor = 0;

                for (int k = j + 1; k < n; k++) {
                    xor = A.get(j) ^ A.get(k);
                }

                if (xor > 0) count++;
            }
            res.add(count);
        }
        return res;
    }

    public static ArrayList<Integer> optimized(ArrayList<Integer> A, ArrayList<Integer> B) {


        int n = A.size();

        int[] feq = new int[33];

        for (int i = 0; i < 32; i++) {

            for (int j = 0; j < n; j++) {

                if ((A.get(j) & (1 << i)) > 0) feq[i]++;

            }

        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int el : B) {

            int count = (feq[el]) * (n - feq[el]);

            res.add(count);
        }

        return res;
    }
}
