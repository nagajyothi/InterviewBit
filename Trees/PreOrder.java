/*
 * Given a binary tree, return the preorder traversal of its nodes’ values.
 * 
 Example :
 Given binary tree
 
 1
 \
 2
 /
 3
 return [1,2,3].
 
 Using recursion is not allowed.
 */
import java.util.*;
public class PreOrder{
    public ArrayList<Integer> preorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;
        stack.push(a);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            result.add(popped.val);
            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result;
    }
    public static void main(String[] args){
    }
}