package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Problem Description
Given an array A. You have some integers given in the array B.
For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.

Problem Constraints
1 <= |A| <= 10^5
1 <= |B| <= 10^5
1 <= A[i] <= 10^5
1 <= B[i] <= 10^5

Input Format
First argument A is an array of integers.
Second argument B is an array of integers denoting the queries.

Output Format
Return an array of integers containing frequency of the each element in B.

Example Input
Input 1:
A = [1, 2, 1, 1]
B = [1, 2]

Input 2:
A = [2, 5, 9, 2, 8]
B = [3, 2]

Example Output
Output 1: [3, 1]
Output 2: [0, 2]

Example Explanation
For Input 1:
The frequency of 1 in the array A is 3.
The frequency of 2 in the array A is 1.

For Input 2:
The frequency of 3 in the array A is 0.
The frequency of 2 in the array A is 2.
 */
public class FrequencyOfElementsQuery {

    public  static void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 1, 1));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1, 2));

        optimized(A, B);
    }

    public  static  void optimized(ArrayList<Integer> A, ArrayList<Integer> B){

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int el : A){

            if(hm.containsKey(el)) hm.put(el, hm.get(el) + 1);

            else hm.put(el, 1);

        }

        ArrayList<Integer> res = new ArrayList<>();

        for(int query : B){
            if(hm.containsKey(query)) res.add(hm.get(query));

            else res.add(0);
        }

        System.out.println(res);

        // Time O(A + B);
        // Space O(A);

    }
}
