package advance.hashing;

/*
Problem Description
Given an integer array A of size N, find the first repeating element in it.
We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
If there is no repeating element, return -1.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
The first and only argument is an integer array A of size N.

Output Format
Return an integer denoting the first repeating element.

Example Input
Input 1: A = [10, 5, 3, 4, 3, 5, 6]
Input 2: A = [6, 10, 5, 4, 9, 120]

Example Output
Output 1: 5
Output 2: -1

Example Explanation

Explanation 1:
 5 is the first element that repeats
Explanation 2:
 There is no repeating element, output -1

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FirstRepeatingElement {

    public  static  void main (String [] args){


        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 5, 3, 4, 3, 5, 6));

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int el : A){
            if(hm.containsKey(el)) hm.put(el, hm.get(el) + 1);
            else hm.put(el, 1);
        }

        int res = -1;

        for(int el : A) {
            if(hm.get(el) > 1){
                res = el;
                break;
            }
        }

        System.out.println(res);

    }
}
