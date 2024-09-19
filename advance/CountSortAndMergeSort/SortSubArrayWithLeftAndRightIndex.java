package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

You are given an array A of integers of length N and two indices, B and C.
Your task is to sort the subarray [B, C] within the given array.
The rest of the array should remain unchanged.

Problem Constraints
1 ≤ N ≤ 10^5
0 ≤ A[i] ≤ 10^9
0 ≤ B ≤ C ≤ N - 1

Input Format
First argument is the array A of length N. The next two arguments are the integers B and C.

Output Format
Return the array after sorting the [B, C] subarray.

Example Input

Input:
A = [59, 11, 8, 91, 49, 44, 8]
B = 4
C = 6

Input 2:
A = [50, 40, 30, 20, 10]
B = 0
C = 3

Example Output
Output: [59, 11, 8, 91, 8, 44, 49]
Output: [20, 30, 40, 50, 10]

Example Explanation
Explanation 1:
Initially the subarray [B, C], i.e. A[4, 6] = [49, 44, 8].
After sorting this becomes [8, 44, 49].
It can be seen that this subarray gets sorted and rest of the array remains unchanged!

Explanation 2:
Initially the subarray [B, C], i.e. A[0, 3] = [50, 40, 30, 20].
After sorting this becomes [20, 30, 40, 50].
It can be seen that this subarray gets sorted and rest of the array remains unchanged!

 */
public class SortSubArrayWithLeftAndRightIndex {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(50, 40, 30, 20, 10));
        int B = 0;
        int C = 3;

        countSort(A, B, C);
        System.out.println(A);

    }

    private  static int len = 100001;
    public  static  void countSort (ArrayList<Integer>  A, int B, int C){

        int n = A.size();

        if(B == C) return;

        int [] feq = new int [len];

        for(int i = B; i <= C; i++){
            feq[A.get(i)]++;
        }

        int index = B;

        for(int i = 0; i < len; i++){

            for(int j = 0; j < feq[i]; j++){

                if(index > C) break;

                A.set(index++, i);

            }

        }
    }
}
