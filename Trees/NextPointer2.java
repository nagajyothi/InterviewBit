/*
 * Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Example :

Given the following binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
Note 1: that using recursion has memory overhead and does not qualify for constant space.
Note 2: The tree need not be a perfect binary tree
 */
import java.util.*;
public class NextPointer2 {
    public void connect(TreeLinkNode root) {
        
        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        if(root == null)
        return;
        
        int currentLevelNum = 1;
        int nextLevelNum = 0;
        queue.offer(root);
        
        while(!queue.isEmpty()){
            TreeLinkNode node = queue.poll();
            currentLevelNum--;
            
            list.add(node);
            
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
                
                for(int i = 0; i < list.size()-1; i++){
                    list.get(i).next = list.get(i+1);
                }
                list = new ArrayList<TreeLinkNode>();
            }
        }
        
    }
    public static void main(String[] args){
    }
}