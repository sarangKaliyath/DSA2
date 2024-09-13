package advance.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
Problem Description
You are given an array A of N integers. Return the count of elements with frequncy 1 in the given array.

Problem Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9

Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 4, 3, 6, 6]

Input 2:
A = [3, 3, 3, 9, 0, 1, 0]

Example Output
Output 1: 1
Output 2: 2

Example Explanation
Explanation 1:
Only the element 4 has a frequency 1.

Explanation 2:
The elements 9 and 1 has a frequncy 1.

 */
public class CountUniqueElements {

    public  static  void main (String [] args){

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 3, 3, 9, 0, 1, 0));

        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int el : A){
            if(hm.containsKey(el)) hm.put(el, hm.get(el) + 1);
            else hm.put(el, 1);
        }

        int count = 0;

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            if(entry.getValue() == 1) count++;
        }

        System.out.println(count);

        // Time O(N);
        // Space O(N);
    }
}
