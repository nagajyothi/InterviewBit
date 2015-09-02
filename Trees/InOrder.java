/*
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 * 
 Example :
 Given binary tree
 
 1
 \
 2
 /
 3
 return [1,3,2].
 
 Using recursion is not allowed.
 */
public class InOrder{
    public ArrayList<Integer> inorderTraversal(TreeNode a) {        
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(a == null)
            return result;
        TreeNode node = a;
        //Go all the way to the left and then start poping add the val and go to the right
        while(!stack.isEmpty() || node != null){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }
}
public static void main(String[] args){
}
}