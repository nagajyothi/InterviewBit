
import java.util.*;
public class LevelOrderTraversal {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
    }
    public ArrayList<ArrayList<Integer>> traverse(TreeNode a){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if(a == null) return result;
        
        queue.offer(a);
        int currentLevel = 1;
        int nextLevel = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            currentLevel--;
            list.add(node.val);
            
            if(node.left != null){
                queue.offer(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.offer(node.right);
                nextLevel++;
            }
            
            if(currentLevel == 0){
                currentLevel = nextLevel;
                nextLevel = 0;
                result.add(list);
                list.clear();
            }
            
        }
        return result;
    }
}