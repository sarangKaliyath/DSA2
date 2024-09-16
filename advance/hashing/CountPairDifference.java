package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
You are given an array A of N integers and an integer B.
Count the number of pairs (i,j) such that A[i] - A[j] = B and i ≠ j.
Since the answer can be very large, return the remainder after dividing the count with 10^9+7.

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
B = 4

Input 2:
A = [1, 2, 1, 2]
B = 1

Example Output
Output 1: 1
Output 2: 4

Example Explanation
Example 1:
The only pair is (2, 3) which gives difference as 4

Example 2:
The pair which gives difference as 3 are (2, 1), (4, 1), (2, 3) and (4, 3).

 */
public class CountPairDifference {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 2));
        int B = 1;

        bruteForce(A, B);

        optimized(A, B);

    }

    public static void bruteForce(ArrayList<Integer> A, int B) {

        int n = A.size();
        int count = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (i != j && (A.get(i) - A.get(j)) == B) count++;
            }
        }

        System.out.println(count);

    }

    public static void optimized(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        for(int i = 0; i < A.size(); i++){

            if(hm.containsKey(A.get(i) + B)){
                count += hm.get(A.get(i) + B);
            }

            if(hm.containsKey(A.get(i) - B)){
                count += hm.get(A.get(i) - B);
            }

            if(hm.containsKey(A.get(i))){
                hm.put(A.get(i), hm.get(A.get(i)) + 1);
            }
            else hm.put(A.get(i), 1);

        }

        System.out.println(count);

    }
}
