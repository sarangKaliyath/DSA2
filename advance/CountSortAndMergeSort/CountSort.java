package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given an array A. Sort this array using Count Sort Algorithm and return the sorted array.

Problem Constraints
1 <= |A| <= 10^5
1 <= A[i] <= 10^5

Input Format
The first argument is an integer array A.

Output Format
Return an integer array that is the sorted array A.

Example Input
Input 1:
A = [1, 3, 1]
Input 2:
A = [4, 2, 1, 3]

Example Output
Output 1: [1, 1, 3]
Output 2: [1, 2, 3, 4]

Example Explanation
For Input 1:
The array in sorted order is [1, 1, 3].

For Input 2:
The array in sorted order is [1, 2, 3, 4].

 */
public class CountSort {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 3, 1));
        int n = A.size();

        countSort(A, n);
        System.out.println(A);
        // Time O(N + len);
        // Space O(len);
    }

    private static int len = 100001;
    public  static  void countSort (ArrayList<Integer> A, int n){

        int [] feq = new int [len];

        for(int i = 0; i < n; i++){
            feq[A.get(i)]++;
        }

        int index = 0;

        for(int i = 0; i < len; i++){

            for(int j = 0; j < feq[i]; j++){
                A.set(index++, i);
            }

        }

    }
}
