package advance.QuickSortAndComparatorProblems;

/*
Problem Description

Given an integer array A of length N, considering the last element as pivot p,
rearrange the elements such that for all i:
    if A[i] < p then it should be present on left side of the partition
    if A[i] > p then it should be present on right side of the partition
Rearrange the given array as well as return the partition index.
Note: All elements are distinct

Problem Constraints
1 ≤ N ≤ 10^5
1 ≤ A[i] ≤ 10^9

Input Format
The only input argument is the given vector A.

Output Format
Return the partition index as well as rearrange the input array to satisfy the given conditions.

Example Input
Input: A = [6, 2, 0, 4, 5]

Example Output

Output:
Valid
A possible solution can be:
A = [2, 0, 4, 5, 6] and partitionIndex = 3

Example Explanation
Explanation:
 The rearrangement is valid because every element in [0, 2] index range is less than the pivot element, and every element in [3, 4] index range is greater than the pivot element.

 */
public class PartitionIndex {

    public static void main(String[] args) {

        int[] arr = {6, 2, 0, 4, 5};

        int n = arr.length;

        int left = 0;
        int right = n - 1;
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {

            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }

        }

        swap(arr, i + 1, right);

        System.out.println(i + 1);

    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
