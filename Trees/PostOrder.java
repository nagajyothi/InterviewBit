/*
 * Given a binary tree, return the postorder traversal of its nodes’ values.
 * 
 Example :
 
 Given binary tree
 
 1
 \
 2
 /
 3
 return [3,2,1].
 
 Using recursion is not allowed.
 */
public class PostOrder{
    public ArrayList<Integer> postorderTraversal(TreeNode a) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;
        TreeNode node = a;
        while(!stack.isEmpty() || node != null){
            while(node != null){
                if(node.right != null)
                    stack.push(node.right);
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            
            if(node.right != null && !stack.isEmpty() && node.right == stack.peek()){
                TreeNode rightNode = stack.pop();
                stack.push(node);
                node = rightNode;
            }
            else{
                result.add(node.val);
                node = null;
            }
        }
        return result;
    }
    public static void main(String[] args){
        
    }
}