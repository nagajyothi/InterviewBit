/*
 * Given an inorder traversal of a cartesian tree, construct the tree.
 * 
 Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 Note: You may assume that duplicates do not exist in the tree.
 Example :
 
 Input : [1 2 3]
 
 Return :   
 3
 /
 2
 /
 1
 */
import java.util.*;
public class Cartesian{
    public TreeNode buildTree(ArrayList<Integer> a) {
        if(a == null || a.size() == 0)
            return null;
        TreeNode root = buildTree(a, 0, a.size() -1 );
        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> a, int start, int end){
        if(start > end)
            return null;
        
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for(int i = start; i <= end; i++){
            if(max < a.get(i)){
                max = a.get(i);
                maxIndex = i;
            }
        }
        
        TreeNode root = new TreeNode(max);
        
        if(start == end)
            return root;
        root.left = buildTree(a, start, maxIndex - 1);
        root.right = buildTree(a, maxIndex + 1, end);
        return root;
    }
    public static void main(String[] args){
    }
}