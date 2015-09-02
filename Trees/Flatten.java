/*
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 Example :
 Given
 
 
 1
 / \
 2   5
 / \   \
 3   4   6
 The flattened tree should look like:
 
 1
 \
 2
 \
 3
 \
 4
 \
 5
 \
 6
 Note that the left child of all nodes should be NULL.
 */
public class Flatten{
    public TreeNode flatten(TreeNode a) {
        TreeNode result = new TreeNode(0);
        TreeNode node = result;
        result.right = node;
        if(a == null)
            return null;
        
        Stack<TreeNode> stack =  new Stack<TreeNode>();
        stack.push(a);
        while(!stack.isEmpty()){
            TreeNode popped = stack.pop();
            
            node.right = popped;
            node.left = null;
            node = node.right;
            
            if(popped.right != null)
                stack.push(popped.right);
            if(popped.left != null)
                stack.push(popped.left);
        }
        return result.right;
        
    }
    public static void main(String[] args){
        
    }
}