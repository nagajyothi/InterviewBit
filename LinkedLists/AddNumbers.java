/*
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

    342 + 465 = 807
Make sure there are no trailing zeros in the output list
So, 7 -> 0 -> 8 -> 0 is not a valid response even though the value is still 807.
 */
public class AddNumbers{
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode c = head;
        int carry = 0;
        while(a != null && b != null){
            int sum = a.val + b.val + carry;
            
            c.next  = new ListNode(sum % 10);
            carry = sum / 10;
            
            a = a.next;
            b = b.next;
            c = c.next;
        }
        while(a != null){
            int sum = a.val + carry;
            c.next  = new ListNode(sum % 10);
            carry = sum / 10;
            a = a.next;
            c = c.next;
        }
        
        while(b != null){
            int sum = b.val + carry;
            c.next  = new ListNode(sum % 10);
            carry = sum / 10;
            b = b.next;
            c = c.next;
        }
        if(carry != 0){
            c.next  = new ListNode(carry);
        }
        return head.next;
        
    }
    public static void main(String[] args){
        
    }
}