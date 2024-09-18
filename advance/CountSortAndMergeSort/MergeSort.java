package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A, sort the array using Merge Sort.

Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A.

Output Format
Return the sorted array.

Example Input
Input 1:- A = [1, 4, 10, 2, 1, 5]
Input 2:- A = [3, 7, 1]

Example Output
Output 1:- [1, 1, 2, 4, 5, 10]
Output 2:- [1, 3, 7]

Example Explanation
Explanation 1 and 2:
Return the sorted array.
 */
public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10, 2, 1, 5));
        int n = A.size();

        mergeSort(A, 0, n - 1);

        System.out.println(A);
        //Time O( NlogN );
        // Space O(N);
    }

    public static void mergeSort(ArrayList<Integer> A, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(A, left, mid);
        mergeSort(A, mid + 1, right);

        merge(A, left, mid, right);
    }

    public static void merge(ArrayList<Integer> A, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] B = new int[n1];
        int[] C = new int[n2];

        for (int i = 0; i < n1; i++) {
            B[i] = A.get(left + i);
        }
        for (int i = 0; i < n2; i++) {
            C[i] = A.get(mid + 1 + i);
        }

        int i = 0, j = 0;
        int index = left;

        while (i < n1 && j < n2) {
            if (B[i] <= C[j]) {
                A.set(index, B[i]);
                i++;
            } else {
                A.set(index, C[j]);
                j++;
            }
            index++;
        }

        while (i < n1) {
            A.set(index, B[i]);
            i++;
            index++;
        }

        while (j < n2) {
            A.set(index, C[j]);
            j++;
            index++;
        }
    }
}
