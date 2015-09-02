/*
 * iven a binary tree, return the level order traversal of its nodes’ values. (ie, from left to right, level by level).

Example :
Given binary tree

    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
Also think about a version of the question where you are asked to do a level order traversal of the tree when depth of the tree is much greater than number of nodes on a level.
 */
import java.util.*;
public class LevelOrder{
   public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {
     ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
     Queue<TreeNode> queue = new LinkedList<TreeNode>();
     
     if(a == null)
         return result;
     
     int currentLevelNum = 1;
     int nextLevelNum = 0;
     queue.offer(a);
     ArrayList<Integer> levelList = new ArrayList<Integer>();
     while(!queue.isEmpty()){
         TreeNode node = queue.poll();
         currentLevelNum--;
         levelList.add(node.val);
         
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
             result.add(new ArrayList<Integer>(levelList));
             levelList.clear();
         }
         
     }
     
     return result;
 }
    public static void main(String[] args){
    }
}