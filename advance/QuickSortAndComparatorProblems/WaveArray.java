package advance.QuickSortAndComparatorProblems;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array of integers A, sort the array into a wave-like array and return it.
In other words, arrange the elements into a sequence such that
a1 >= a2 <= a3 >= a4 <= a5.....
NOTE: If multiple answers are possible, return the lexicographically smallest one.

Problem Constraints
1 <= len(A) <= 10^6
0 <= A[i] <= 10^6

Input Format
The first argument is an integer array A.

Output Format
Return an array arranged in the sequence as described.

Example Input

Input 1: A = [1, 2, 3, 4]
Input 2: A = [1, 2]

Example Output
Output 1: [2, 1, 4, 3]
Output 2: [2, 1]

Example Explanation

Explanation 1:
One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
First answer is lexicographically smallest. So, return [2, 1, 4, 3].

Explanation 1:
Only possible answer is [2, 1].

 */
public class WaveArray {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 4, 1, 3));

        int n = A.size();

        quickSort(A, 0, n - 1);

        for (int i = 0; i < n - 1; i += 2) {
            swap(A, i, i + 1);
        }

        System.out.println(A);
        // Time O(N log N);
        // Space O(log N);
    }

    public static void quickSort(ArrayList<Integer> A, int left, int right) {

        if (left < right) {

            int pivot = partition(A, left, right);

            quickSort(A, left, pivot - 1);
            quickSort(A, pivot + 1, right);
        }

    }

    public static int partition(ArrayList<Integer> A, int left, int right) {

        int randomIndex = (int) (Math.random() * (right - left + 1) + left);
        swap(A, right, randomIndex);

        int pivot = A.get(right);

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (A.get(j) < pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, right);

        return i + 1;
    }

    public static void swap(ArrayList<Integer> A, int x, int y) {
        int temp = A.get(x);
        A.set(x, A.get(y));
        A.set(y, temp);
    }
}
