/*
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 Example :
 
 1 -> 10 -> 20
 4 -> 11 -> 13
 3 -> 8 -> 9
 will result in
 
 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
 * 
 */
import java.util.*;
public class MergeKList{
    public static ListNode mergeKLists(ArrayList<ListNode> a) {
        if(a.size() == 0)
            return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(a.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                if(a.val > b.val)
                    return 1;
                else if(a.val < b.val)
                    return -1;
                else
                    return 0;
            }
        });
        //Add first node of each list to the queue
        for(ListNode node : a){
            if(node != null)
            q.add(node);
        }
        
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(q.size() >  0){
            ListNode temp = q.poll(); // removes the first / head from queue
            p.next = temp;
            if(temp.next != null)
                q.add(temp.next);
            p = p.next;
        }
        return head.next;
        
    }
    public static void main(String[] args){
        ArrayList<ListNode> a = new ArrayList<ListNode>();
        
    }
}