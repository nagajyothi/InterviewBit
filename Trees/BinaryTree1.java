/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 Note: You may assume that duplicates do not exist in the tree.
 Example :
 
 Input : 
 Inorder : [2, 1, 3]
 Postorder : [2, 3, 1]
 
 Return : 
 1
 / \
 2   3
 */
import java.util.*;
public class BinaryTree1{
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        if(inorder == null || inorder.size() == 0 ||
           postorder == null || postorder.size() == 0 ||
           postorder.size() != inorder.size())
            return null;
        
        
        TreeNode root = buildTree(inorder, postorder, 0, inorder.size() - 1, 0, postorder.size() -1);
        return root;
    }
    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder, int inStart, int inEnd, int postStart, int postEnd) {
        
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder.get(postEnd));
        
        
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++){
            if(inorder.get(i) == node.val){
                inIndex = i;
                break;
            }
        }
        
        node.left = buildTree(inorder, postorder, inStart, inIndex - 1, postStart, postStart + inIndex - (inStart +1));
        node.right = buildTree(inorder, postorder, inIndex + 1, inEnd, postStart + inIndex - inStart, postEnd - 1);
        return node;
        
    }
    
    public static void main(String[] args){
    }
}