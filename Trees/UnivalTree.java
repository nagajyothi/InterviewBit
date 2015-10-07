/*
 * Unival Tree: A tree in which all the node values are same
 */
public class UnivalTree{
    int count = 0; //to count the unival trees
    public boolean unival(TreeNode root){
        if(root == null)
            return true;
        boolean left  = unival(root.left);
        boolean right = unival(root.right);
        
        if(left && right && 
           (root.left == null || root.left.val == root.val) &&
           (root.right == null || root.right.val == root.val)){
            count++;
            return true;
        }
        return false;
    }
}