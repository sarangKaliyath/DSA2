package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array with N objects colored red, white, or blue,
sort them so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will represent the colors as,
red -> 0
white -> 1
blue -> 2
Note: Using the library sort function is not allowed.

Problem Constraints
1 <= N <= 1000000
0 <= A[i] <= 2

Input Format
First and only argument of input contains an integer array A.

Output Format
Return an integer array in asked order

Example Input
Input 1 : A = [0, 1, 2, 0, 1, 2]
Input 2: A = [0]

Example Output
Output 1: [0, 0, 1, 1, 2, 2]
Output 2: [0]

Example Explanation
Explanation 1:
    [0, 0, 1, 1, 2, 2] is the required order.
Explanation 2:
    [0] is the required order
 */
public class SortByColor {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2));
        int n = A.size();

        countSort(A, n);
        // Time O(N);
        // Space O(1);
    }

    public static void countSort(ArrayList<Integer> A, int n) {

        int[] feq = new int[3];

        for (int i = 0; i < n; i++) {
            feq[A.get(i)]++;
        }

        int index = 0;

        for (int i = 0; i <= 2; i++) {

            for (int j = 0; j < feq[i]; j++) {
                A.set(index, i);
                index++;
            }

        }

        System.out.println(A);

    }
}
