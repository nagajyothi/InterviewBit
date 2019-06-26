/*
 * You are given a binary string(i.e. with characters 0 and 1) S consisting of characters S1, S2, …, SN. In a single operation, you can choose two indices L and R such that 1 ? L ? R ? N and flip the characters SL, SL+1, …, SR. By flipping, we mean change character 0 to 1 and vice-versa.

You aim is to perform ATMOST one operation such that in final string number of 1s is maximised. If you don’t want to perform the operation, return an empty array. Else, return an array consisting of two elements denoting L and R. If there are multiple solutions, return the lexicographically smallest pair of L and R.

Notes: 
- Pair (a, b) is lexicographically smaller than pair (c, d) if a < c or, if a == b, then b < d.

For example,

S = 010

Pair of [L, R] | Final string
_______________|_____________
[1 1]          | 110
[1 2]          | 100
[1 3]          | 101
[2 2]          | 000
[2 3]          | 001

We see that two pairs [1, 1] and [1, 3] give same number of 1s in final string. So, we return [1, 1].
Another example,
   If S = 111
   No operation can give us more than three 1s in final string. So, we return empty array [].


 */
public class Solution {
    public ArrayList<Integer> flip(String A) {
        int i = 0, maxSum = Integer.MIN_VALUE, sum = 0, left = 0, finalLeft = 0, finalRight = 0;
       /*
       sum : represesnts the potential effective no. of maximum 1s after flip, hence it is incremented and decremented by 1 when it encounters encountered 0 or 1 respectively, If sum becomes -ve it is restored to 0, and left is chenged.
       left : represesnts the temporary initial left position for the pair.
       finalLeft : represesnts the final answer of left position
       finalRight : likewise, but for right position
       maxSum : Is kept to compare previous max and current sum for max no. of 1s after flip.
      */    
        ArrayList<Integer> n = new ArrayList<Integer>();
        while( i < A.length() )
        {
            if(A.charAt(i) == '1')
            {
                sum--; // since after flip it becomes 0
            }
            else if (A.charAt(i) == '0')
            {
                sum++; // since after flip it becomes 1
            }
            
            if( sum < 0 )
            {
                left = i+1;
                sum = 0;
            }
            
            else if( sum > maxSum )
            {
                finalLeft = left;
                finalRight = i;
                maxSum = sum;
            }
            i++;
        }
        
        if(maxSum<=0)
        {
            return n; // if no such way of flip found that increases no. of 1s
        }
        n.add(finalLeft+1);// +1 since the answer is expected that way (index: 0 -> 1, basically) 
        n.add(finalRight+1);
        return n;
    }
}
