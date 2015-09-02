/*
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * 
 You should preserve the original relative order of the nodes in each of the two partitions.
 
 For example,
 Given 1->4->3->2->5->2 and x = 3,
 return 1->2->2->4->3->5.
 
 
 Analysis:
Simple idea but be careful with the operation of pointers.
The idea is:   first get the last element and the length of the list (1 while loop)
                    Then scan the whole list, if current node value < x, then go to the next node.
                    if current node value >=x, then move this node to the end of the list.
                    until  meet the length of the original list.
                    
http://www.programcreek.com/2013/02/leetcode-partition-list-java/
 */
public class PartitionList{
    public ListNode partition(ListNode a, int b) {
        if(a == null) return null;
        
        ListNode fakeHead1 = new ListNode(0);
    }
    public static void main(String[] args){
    }
}
