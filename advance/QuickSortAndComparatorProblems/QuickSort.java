package advance.quickSortAndComparatorProblems;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an integer array A, sort the array using Quick Sort.

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
public class QuickSort {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 4, 10, 2, 1, 5));

        quickSort(A, 0, A.size() - 1);

        System.out.println(A);

        /*
            Best Case
                Time O(N log N);
                Space O(log N);
        */

        /*
            Worst Case
                Time O(N ^ 2); i.e if the pivot integer is either the smallest or largest integer in array;
                Space O(N);
         */
    }

    public static void quickSort(ArrayList<Integer> A, int left, int right) {

        if (left < right) {

            int partitionIndex = partition(A, left, right);

            quickSort(A, left, partitionIndex - 1);
            quickSort(A, partitionIndex + 1, right);

        }

    }

    public static int partition(ArrayList<Integer> A, int left, int right) {

        int randomIndex = (int) (Math.random() * (right - left + 1)) + left;
        swap(A, randomIndex, right);
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
