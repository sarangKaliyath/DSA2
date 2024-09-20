package advance.QuickSortAndComparatorProblems;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description

Given an array A of 0s and 1s of length N. Sort this array.
Note - Do not use any sorting algorithm or library's sort method.

Problem Constraints
1 ≤ N ≤ 10^5
0 ≤ A[i] ≤ 1

Input Format
First argument A is an array of length N.

Output Format
Return the sorted array.

Example Input
Input 1: A = [0,0,1,0,1,1,0]
Input 2: A = [1,0]

Example Output
Output 1: [0,0,0,0,1,1,1]
Output 2: [0,1]
 */
public class Sort01 {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(0));

        int n = A.size();

        int zeroCount = 0;

        for(int el : A) {
            if(el == 0) zeroCount++;
        }

        for(int i = 0; i < n; i++){
            if(zeroCount > 0){
                A.set(i, 0);
                zeroCount--;
            }
            else A.set(i, 1);
        }

        System.out.println(A);
    }
}
