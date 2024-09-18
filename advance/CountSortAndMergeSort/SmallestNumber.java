package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

An integer is given to you in the form of an array, with each element being a separate digit.
Find the smallest number (leading zeroes are allowed) that can be formed by rearranging the
digits of the given number in an array. Return the smallest number in the form an array.
Note - Do not use any sorting algorithm or library's sort method.

Problem Constraints
1 ≤ N ≤ 10^5
0 ≤ A[i] ≤ 9

Input Format
First argument A is an array of length N, representing digits of the number.

Output Format
Return the array representing the smallest possible number in form of an array.

Example Input
Input 1: A = [6, 3, 4, 2, 7, 2, 1]
Input 2: A = [4, 2, 7, 3, 9, 0]

Example Output
Output 1: [1, 2, 2, 3, 4, 6, 7]
Output 2: [0, 2, 3, 4, 7, 9]

Example Explanation
Explanation 1:
It can be proved that a rearrangement for 6342721 cannot be smaller than 1223467.
Explanation 2:
Similarly, a rearrangement for 427390 cannot be smaller than 023479, i.e. 23479.
 */
public class SmallestNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(6, 3, 4, 2, 7, 2, 1));
        int n = A.size();

        ArrayList<Integer> res = countSort(A, n);

        System.out.println(res);
        // Time O(N);
        // Space O(1);

    }

    public static ArrayList<Integer> countSort(ArrayList<Integer> A, int n) {

        int[] feq = new int[10];

        for (int i = 0; i < n; i++) {
            feq[A.get(i)]++;
        }

        int index = 0;

        for (int i = 0; i <= 9; i++) {

            for (int j = 0; j < feq[i]; j++) {
                A.set(index, i);
                index++;
            }

        }

        return A;
    }
}
