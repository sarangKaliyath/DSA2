package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*

Problem Description
Given an array of integers A. If i < j and A[i] > A[j],
then the pair (i, j) is called an inversion of A.
Find the total number of inversions of A modulo (10^9 + 7).

Problem Constraints
1 <= length of the array <= 10^5
1 <= A[i] <= 10^9

Input Format
The only argument given is the integer array A.

Output Format
Return the number of inversions of A modulo (10^9 + 7).

Example Input
Input 1: A = [1, 3, 2]
Input 2: A = [3, 4, 1, 2]

Example Output
Output 1: 1
Output 2: 4

Example Explanation

Explanation 1:
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]

Explanation 2:
The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]


 */
public class InversionCountInAnArray {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 4, 1, 2));

        int res = mergeSort(A, 0, A.size() - 1);
        System.out.println(res);
        // Time O(N logN);
        // Space O(N);
    }

    private static final int mod = 1000000007;

    public  static  int mergeSort(ArrayList<Integer> A, int left, int right){

        if(left >= right) {
            return 0;
        };

        int mid = (left + right) / 2;

        int leftInv = mergeSort(A, left, mid);
        int rightInv = mergeSort(A, mid + 1, right);

        int mergeInv = merge(A, left,  mid,right);

        return (leftInv + rightInv + mergeInv) % mod;
    }
    public static int merge(ArrayList<Integer> A, int left, int mid, int right){

        int nB = mid - left + 1;
        int nC = right - mid;

        int [] B = new int[nB];
        int [] C = new int[nC];

        for(int i = 0; i < nB; i++){
            B[i] = A.get(left + i);
        }

        for(int i = 0; i < nC; i++){
            C[i] = A.get(mid + i + 1);
        }

        int i = 0; int j = 0; int index = left;
        int inversion = 0;

        while (i < nB && j < nC){

            if(B[i] <= C[j]){
                A.set(index, B[i]);
                i++;
            }
            else {
                A.set(index, C[j]);
                j++;
                inversion = (inversion + (nB - i)) % mod;
            }
            index++;
        }

        while (i < nB){
            A.set(index, B[i]);
            i++;
            index++;
        }

        while (j < nC){
            A.set(index, C[j]);
            j++;
            index++;
        }

        return inversion;
    }
}
