package advance.CountSortAndMergeSort;

import java.util.ArrayList;
import java.util.Arrays;

/*
Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.
Note: A linear time complexity is expected and you should avoid use of any library function.

Problem Constraints
-2×10^9 <= A[i], B[i] <= 2×10^9
1 <= |A|, |B| <= 5×10^4

Input Format
First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.

Output Format
Return a 1-D vector which you got after merging A and B.

Example Input
Input 1:
A = [4, 7, 9]
B = [2, 11, 19]
Input 2:
A = [1]
B = [2]

Example Output
Output 1: [2, 4, 7, 9, 11, 19]
Output 2: [1, 2]

Example Explanation
Explanation 1:
Merging A and B produces the output as described above.
Explanation 2:
 Merging A and B produces the output as described above.

 */
public class MergeTwoSortedArrays {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2));

        ArrayList<Integer> res = mergeSortedArrays(A, B);

        System.out.println(res);

    }

    public  static  ArrayList<Integer> mergeSortedArrays (ArrayList<Integer> A, ArrayList<Integer> B){

        int n1 = A.size();
        int n2 = B.size();

        int mergedArrayLen = n1 + n2;

        ArrayList<Integer> res = new ArrayList<>(mergedArrayLen);

        for(int i = 0; i < mergedArrayLen; i++){
            res.add(0);
        }

        int i = 0;
        int j = 0;
        int index = 0;

        while (i < n1 && j < n2){

            if(A.get(i) < B.get(j)){
                res.set(index , A.get(i));
                i++;
            }
            else {
                res.set(index, B.get(j));
                j++;
            }
            index++;
        }

        while (i < n1){
            res.set(index, A.get(i));
            i++;
            index++;
        }

        while (j < n2){
            res.set(index, B.get(j));
            j++;
            index++;
        }

        return res;
    }
}
