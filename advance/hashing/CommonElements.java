package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Problem Description
Given two integer arrays, A and B of size N and M, respectively.
Your task is to find all the common elements in both the array.
NOTE:
    Each element in the result should appear as many times as it appears in both arrays.
    The result can be in any order.

Problem Constraints
1 <= N, M <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument is an integer array A of size N.
Second argument is an integer array B of size M.

Output Format
Return an integer array denoting the common elements.

Example Input

Input 1:
 A = [1, 2, 2, 1]
 B = [2, 3, 1, 2]

Input 2:
 A = [2, 1, 4, 10]
 B = [3, 6, 2, 10, 10]

Example Output

Output 1: [1, 2, 2]
Output 2: [2, 10]

Example Explanation

Explanation 1:
 Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
Explantion 2:
 Elements (2, 10) appears in both the array.

 */
public class CommonElements {

    public static void main(String[] args) {

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 2, 1));
//        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2, 3, 1, 2));

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 4, 10));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 6, 2, 10, 10));

//        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(19,19,3,5,6));
//        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(2,8,2,12,16,3));

        optimized(A, B);
    }

    public static void optimized(ArrayList<Integer> A, ArrayList<Integer> B) {


        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int el : A) {
            if (hm.containsKey(el)) hm.put(el, hm.get(el) + 1);
            else hm.put(el, 1);
        }

        ArrayList<Integer> res = new ArrayList<>();

        for (int el : B) {

            if (hm.containsKey(el) && hm.get(el) > 0) {
                res.add(el);
                hm.put(el, hm.get(el) - 1);
            }

        }

        System.out.println(res);

    }
}
