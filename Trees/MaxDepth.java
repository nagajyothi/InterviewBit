/*
 * Given a binary tree, find its maximum depth.
 * 
 The maximum depth is the number of nodes along the longest path from the root node down to the nearest leaf node.
 
 NOTE : The path has to end on a leaf node.
 Example :
 
 1
 /
 2
 max depth = 2.
 */
import java.util.*;
public class MaxDepth{
    public int maxDepth(TreeNode a) {
        if(a == null)
            return 0;
        return Math.max(maxDepth(a.left) + 1, maxDepth(a.right) + 1);
    }
    public static void main(String[] args){
        
    }
}