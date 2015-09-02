/*
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

NOTE : The path has to end on a leaf node.
Example :

         1
        /
       2
min depth = 2.
 */
import java.util.*;
public class MinDepth{
    public int minDepth(TreeNode a) {
     if(a == null)
     return 0;
     if(a.left == null)
         return minDepth(a.right) + 1;
     if(a.right == null)
         return minDepth(a.left) + 1;
     return Math.min(minDepth(a.right) + 1, minDepth(a.left) + 1);
     
 }
    public static void main(String[] args){
    }
}