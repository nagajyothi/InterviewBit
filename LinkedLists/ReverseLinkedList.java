/*
 * Reversing Linked list from  m to n positions
 */
public class ReverseLinkedList{
    public ListNode reverseBetween(ListNode a, int m, int n) {
        if(m == n) return a;
        
        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0); //First's next points to mth Node
        ListNode second = new ListNode(0); //Seconds next points to (n+1)th node
        
        int i =0;
        ListNode p = a;
        while(p != null){
            i++;
            if(i == m-1)
                prev = p;
            
            if(i == m)
                first.next = p;
            
            if(i == n){
                second.next = p.next;
                p.next = null;
            }
            p = p.next;
        }
        
        if(first.next == null)
            return a;
        
        //Reverse list from m to n
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;
        while(p1 != null && p2 != null){
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;
          
        }
        if(prev != null)
            prev.next = p1;
        else
            return p1;
        return head;
    }
}