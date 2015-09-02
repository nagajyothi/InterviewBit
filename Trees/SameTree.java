/*
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 
 Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 
 Example :
 
 Input : 
 
 1       1
 / \     / \
 2   3   2   3
 
 Output : 
 1 or True
 */
public class SameTree{
    public static int isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b == null)
            return 1;
        else if(a == null || b == null)
            return 0;
        
        if(a.val == b.val && isSameTree(a.left, b.left) == 1 && isSameTree(a.right, b.right) == 1)
            return 1;
        
        return 0;
    }
    public static void main(String[] args){
    }
}