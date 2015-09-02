/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * 
 An example is the root-to-leaf path 1->2->3 which represents the number 123.
 
 Find the total sum of all root-to-leaf numbers % 1003.
 
 Example :
 
 1
 / \
 2   3
 The root-to-leaf path 1->2 represents the number 12.
 The root-to-leaf path 1->3 represents the number 13.
 
 Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
import java.util.*;
public class SumRootLeaf{
    public int sumNumbers(TreeNode a) {
        if(a == null)
            return 0;
        
        return (dfs(a, 0)) % 1003;
    }
    public int dfs(TreeNode node, int num){
        if(node == null)
            return 0;
        
        
        
        if(node.left == null && node.right == null){
           int newNum = num * 10 + node.val;           
           return newNum % MOD;
        }
        num = num * 10 + node.val;
        num %= MOD;
        int sum = dfs(node.left, num, sum) + dfs(node.right, num, sum);
        return sum %1003;
    }
    public static void main(String[] args){
        
        System.out.println(257 % 1003);
    }
}