/*
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.
 * 
 Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 Example :
 
 
 _______3______
 /              \
 ___5__          ___1__
 /      \        /      \
 6      _2_     0        8
 /   \
 7    4
 For the above tree, the LCA of nodes 5 and 1 is 3.
 
 LCA = Lowest common ancestor
 Please note that LCA for nodes 5 and 4 is 5.
 
 You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 There are no duplicate values.
 You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 
 http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 */
import java.util.*;
public class LCA{
    public int lca(TreeNode a, int val1, int val2) {
        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        if(!findPath(a, path1, val1) || !findPath(a, path2, val2))
            return -1;
        int i = 0;
        for(i = 0; i < path1.size() && i < path2.size(); i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);        
    }
    
    public boolean findPath(TreeNode node, ArrayList<Integer> path, int val){
        if(node == null)
            return false;
        path.add(node.val);
        if(node.val == k)
            return true;
        if((node.left != null && findPath(node.left, path, val) )||
           (node.right != null && findPath(node.right, path, val)))
            return true;
        path.remove(path.size()-1);
        return false;
    }
    
    // efficient
    public int lca(TreeNode a, int val1, int val2) {
        
        a = findLCA(a, val1, val2);
        if(a == null)
            return -1;
        return a.val;
        
    }

    public TreeNode findLCA(TreeNode node, int val1, int val2){
        if( node == null)
            return null;
        if(node.val == val1 || node.val == val2)
            return node;
        
        TreeNode leftLCA = findLCA(node.left, val1, val2);
        TreeNode rightLCA = findLCA(node.right, val1, val2);
        
        if(leftLCA != null && rightLCA != null)
            return node;
        
        return (leftLCA != null)? leftLCA: rightLCA;
          
    }
    public static void main(String[] args){
    }
}