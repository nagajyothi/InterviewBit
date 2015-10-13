/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 Try solving it using constant additional space.
 */
public class ListCycle{
    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        
        boolean hasCycle = false;
        while(fast != null && fast.next != null && slow != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                hasCycle = true;
                break;
            }
        }
        
        if(!hasCycle) return null;
        
        else{
            fast = a;
            while(fast != slow){
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
            
    }
    public static void main(String[] args){
    }
}