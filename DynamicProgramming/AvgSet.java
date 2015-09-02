/*
 * Given an array with non negative numbers, divide the array into two parts such that the average of both the parts is equal. 
 Return both parts (If exist).
 If there is no solution. return an empty list.
 
 Example:
 
 
 Input:
 [1 7 15 29 11 9]
 
 Output:
 [9 15] [1 7 11 29]
 
 The average of part is (15+9)/2 = 12,
 average of second part elements is (1 + 7 + 11 + 29) / 4 = 12
 
 NOTE 1: If a solution exists, you should return a list of exactly 2 lists of integers A and B which follow the following condition :
 * numElements in A <= numElements in B
 * If numElements in A = numElements in B, then A is lexicographically smaller than B ( https://en.wikipedia.org/wiki/Lexicographical_order )
 * 
 NOTE 2: If multiple solutions exist, return the solution where length(A) is minimum. If there is still a tie, return the one where A is lexicographically smallest.
 
 NOTE 3: Array will contain only non negative numbers.
 */
import java.util.*;
public class AvgSet{   
    static int totalSize;
    static ArrayList<Integer> res = new ArrayList<Integer>();
    static ArrayList<Integer> original;
    static boolean[][][] dp;
    
    public static ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
        /* 
         * SUM_of_Set1 / size_of_set1 = SUM_of_Set2 / size_of_set2 
         * SUM_of_Set1 = SUM_of_Set2 * (size_of_set1 / size_of_set2)
         *
         * total_sum = Sum_of_Set1 + Sum_of_Set2
         * and size_of_set2 = total_size - size_of_set1 
         *
         * Sum_of_Set1 = (total_sum - Sum_of_Set1) * (size_of_set1 / (total_size - size_of_set1))
         * OR on simplifying, 
         *   total_sum / Sum_of_Set1 - 1 = (total_size - size_of_set1) / size_of_set1 
         *   total_sum / Sum_of_Set1 = total_size / size_of_set1 
         *   Sum_of_Set1 / size_of_set1 = total_sum / total_size 
         *
         *   Now we can just iterate on size_of_set1, and we would know the required Sum_of_Set1 
         */
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        totalSize = A.size();
        if(A == null || A.size() == 0)
            return result;
        
        
        //Collections.sort(A);
        
        original = new ArrayList<Integer>(A);
        System.out.println("original : " + original);
        
        int totalSum = 0;
        for(int i = 0; i < A.size(); i++)
            totalSum += A.get(i);
        System.out.println("Total Sum : " + totalSum + "  Total Size: " + totalSize);
        
        dp = new boolean[original.size()][totalSum + 1][totalSize];
        for(int i =0; i < original.size(); i++){
            for(int j = 0; j < totalSum + 1; j++){
                for(int k =0; k < totalSize; k++)
                    dp[i][j][k] = true;
            }
        }
            
            
            // We need to minimize size_of_set1. So, lets search for the first size_of_set1 which is possible.
        for(int i = 1; i < totalSize; i++){
            System.out.println("For i : " + i);
            //SumOfSet1 has to be an integer
            System.out.println("\t (totalSum * i) % totalSize : " + (totalSum * i) % totalSize);
            if((totalSum * i) % totalSize != 0) continue;
            int sumOfSet1 = (totalSum * i) / totalSize;
            System.out.println("\t sumOfSet1 : " + sumOfSet1);
            System.out.println("\t isPossible(0, " + sumOfSet1 +", " + i + "): " + isPossible(0, sumOfSet1, i));
            if(isPossible(0, sumOfSet1, i) == true){
                System.out.println("\t Entering ispossible condition of true:");
                int ptr1 = 0;
                int ptr2 = 0;
                ArrayList<Integer> res1 = new ArrayList<Integer>(res);
                ArrayList<Integer> res2 = new ArrayList<Integer>();
                
                while(ptr1 < totalSize || ptr2 < res.size()){
                    if(ptr2 < res.size() && res.get(ptr2) == A.get(ptr1)){
                        ptr1++;
                        ptr2++;
                        continue;
                    }
                    res2.add(A.get(ptr1));
                    ptr1++;
                }
                System.out.println("Res1 : " + res1);
                System.out.println("Res2 : " + res2);
                result.add(res1);
                result.add(res2);
                return result;
            }
        }
        System.out.println("Result : " + result);
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        return result;
        
    }
    
    public static boolean isPossible(int index, int sum, int sz){
        System.out.println("\nEntering isPossible function");
        System.out.println("Index : " + index + " sum : " + sum + " sz : " + sz);
        if(sz == 0){
            System.out.println("Returning : " + (sum == 0));
            return sum == 0;
        }
        if(index >= totalSize) {
            System.out.println("returning False");
            return false;
        }
        if(dp[index][sum][sz] == false){
            System.out.println("returning False");
            return false;
        }
        if(sum >= original.get(index)){
            res.add(original.get(index));
            if(isPossible(index + 1, sum - original.get(index), sz - 1) == true)
                return true;
            res.remove(res.size() - 1);            
        }
        System.out.println("Res: " + res);
        
        if(isPossible(index + 1, sum, sz))
            return true;
        dp[index][sum][sz] = false;
        return dp[index][sum][sz];
    }
    public static void main(String[] args){
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(7);
        A.add(15);
        A.add(29);
        A.add(11);
        A.add(9);
        System.out.println("Original List: \n" + A); 
        ArrayList<ArrayList<Integer>> result = avgset(A);
        for(ArrayList<Integer> list : result)
            System.out.println(list);
        
    }
}