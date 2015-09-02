/*
 * Given a binary tree, return the zigzag level order traversal of its nodes’ values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 Example : 
 Given binary tree
 
 3
 / \
 9  20
 /  \
 15   7
 return
 
 [
 [3],
 [20, 9],
 [15, 7]
 ]
 */
public class ZigZagTree{
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(a == null)
            return result;
        
        boolean leftToRight = true;
        
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        
        queue.offer(a);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentLevelNum--;
            if(leftToRight)
                list.add(node.val); // add at end
            else
                list.add(0, node.val); //add at beginning of list
            
            if(node.left != null){
                queue.offer(node.left);
                nextLevelNum++;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLevelNum++;
            }
            
            if(currentLevelNum == 0){
                currentLevelNum = nextLevelNum;
                nextLevelNum = 0;
                leftToRight = !leftToRight; // reverse the order
                result.add(list);
                list = new ArrayList<Integer>();
            }
        }
        return result;
        
    }
    public static void main(String[] args){
    }
}