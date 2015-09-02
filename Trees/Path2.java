/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path’s sum equals the given sum.
 * 
 For example:
 Given the below binary tree and sum = 22,
 
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
import java.util.*;
public class Path2{
    
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if(root == null)
            return null;
        // temp.add(root.val);
        pathSum(root, sum, result, temp);
        return result;
        
    }
    public void pathSum(TreeNode node, int sum, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp) {
        if(node == null)
            return;
        int currentVal = node.val;
        temp.add(currentVal);
        if(node.left == null && node.right == null){
            if(sum - currentVal == 0){
                result.add(new ArrayList<Integer>(temp));
            }
        }
        pathSum(node.left, sum - node.val, result, temp);
        pathSum(node.right, sum - node.val, result, temp);
        temp.remove(temp.size() - 1);
        
    }
    
    
    
    
    
    public static void main(String[] args){
    }
}