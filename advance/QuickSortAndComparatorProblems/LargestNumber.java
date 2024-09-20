package advance.QuickSortAndComparatorProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*

Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.
Note: The result may be very large, so you need to return a string instead of an integer.

Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*10^9

Input Format
The first argument is an array of integers.

Output Format
Return a string representing the largest number.

Example Input
Input 1: A = [3, 30, 34, 5, 9]
Input 2: A = [2, 3, 9, 0]

Example Output
Output 1: "9534330"
Output 2: "9320"

Example Explanation

Explanation 1:
Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.

Explanation 2:
Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

 */
public class LargestNumber {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(3, 30, 34, 5, 9));

        largestNumber(A);
        System.out.println(A);
    }

    public static String largestNumber(ArrayList<Integer> A) {

        Collections.sort(A, new Comparator<Integer>() {
            @Override

            public int compare(Integer x, Integer y) {

                String xy = String.valueOf(x) + String.valueOf(y);
                String yx = String.valueOf(y) + String.valueOf(x);

                if (xy.compareTo(yx) > 0) return -1;

                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for (int el : A) {
            sb.append(String.valueOf(el));
        }

        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}
