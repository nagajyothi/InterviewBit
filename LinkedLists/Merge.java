/*
 * 
 */
public class Merge{
    public ListNode mergeTwoLists(ListNode a, ListNode b) {
         if(a == null && b == null) return null;
     if(a == null) return b;
     if(b == null) return a;
     ListNode head = new ListNode(0);
     ListNode p = head;
     while(a != null && b != null){
         if(a.val <= b.val){
             p.next = a;
             a = a.next;
         }
         else{
             p.next = b;
             b = b.next;
         }p = p.next;
     }
     if(a != null) p.next = a;
     if(b != null) p.next = b;
     
     return head.next;
    }
    public static void main(String[] args){
    }
}