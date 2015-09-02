/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.
 */
public class RemDuplicatesLink{
    public static ListNode deleteDuplicates(ListNode a) {
        ListNode cur = a;
        ListNode next = a.next;
        while(next != null){
            if(cur.val == next.val){
                cur.next = next.next;
                next = cur.next;
            }
            else{
                cur = next;
                next = next.next;
            }
        }
        return a;
    }
    public static void main(String[] args){
        
    }
}