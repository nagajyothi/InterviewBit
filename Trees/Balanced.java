/*
 * Given a binary tree, determine if it is height-balanced.
 * 
 Height-balanced binary tree : is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 
 Example :
 
 Input : 
 1
 / \
 2   3
 
 Return : True or 1 
 
 Input 2 : 
 3
 /
 2
 /
 1
 
 Return : False or 0 
 Because for the root node, left subtree has depth 2 and right subtree has depth 0. 
 Difference = 2 > 1. 
 */
import java.util.*;
public class Balanced{
    public int isBalanced(TreeNode a) {
        if(a == null)
            return 0;
        int leftDepth = 0;
        int rightDepth = 0;
        if(a.left != null)
            leftDepth = depth(a.left);
        if(a.right != null)
            rightDepth = depth(a.right);
        if(Math.abs(leftDepth - rightDepth) > 1)
            return 0;
        return 1;
        
    }
    public int depth(TreeNode a){
        if(a == null)
            return 0;
        return Math.max(depth(a.left) + 1, depth(a.right) + 1);
    }
    public static void main(String[] args){
    }
}