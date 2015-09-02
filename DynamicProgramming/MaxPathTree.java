/*
 * Given a binary tree, find the maximum path sum.
 * 
 The path may start and end at any node in the tree.
 
 Example :
 
 Given the below binary tree,
 
 1
 / \
 2   3
 Return 6.
 */
import java.util.*;
public class MaxPathTree{
    public int maxPathSum(TreeNode a) {
        
        int max[] = new int[1];
        max[0] = Integer.MIN_VALUE; 
        calculateSum(a, max);
        return max[0];
        
    }
    
    public int calculateSum(TreeNode node, int[] max){
        if(node == null)
            return 0;
        
        int left = calculateSum(node.left,max);
        int right = calculateSum(node.right, max);
        
        int current = Math.max(node.val, Math.max(node.val + left, node.val + right));
        max[0] = Math.max(max[0], Math.max(current, left + node.val + right));
        return current;
    }
    public static void main(String[] args){
    }
}