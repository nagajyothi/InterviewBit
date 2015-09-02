/*
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or NULL.

Return a deep copy of the list.

Example

Given list

   1 -> 2 -> 3
with random pointers going from

  1 -> 3
  2 -> 1
  3 -> 1
You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
import java.util.*;
public class CopyList{
    public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        RandomListNode p = head;
        RandomListNode q = newHead;
        
        map.put(head, newHead);
        p = p.next;
        while(p != null){
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            q.next = temp;
            q = temp;
            p = p.next;
        }
        p = head;
        q = newHead;
        while(p != null){
            if(p.randome != null)
                q.randome = map.get(p.random);
            else
                q.random = null;
            p = p.next;
            q = q.next;            
        }
        return newHead;
    }
    public static void main(String[] args){
    }
}