/*
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 push(x) – Push element x onto stack.
 pop() – Removes the element on top of the stack.
 top() – Get the top element.
 getMin() – Retrieve the minimum element in the stack.
 Note that all the operations have to be constant time operations.
 
 Questions to ask the interviewer :
 
 Q: What should getMin() do on empty stack ? 
 A: In this case, return -1.
 
 Q: What should pop do on empty stack ? 
 A: In this case, nothing. 
 
 Q: What should top() do on empty stack ?
 A: In this case, return -1
 NOTE : If you are using your own declared global variables, make sure to clear them out in the constructor.
 */
public class MinStack{
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();
     public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        //mIndex = -1;
    }
    public void push(int x) {
        stack.push(x);    
        if(minStack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
    }
    
    public void pop() {        
        if(!stack.isEmpty()){
            int num = stack.pop();
            if(num == minStack.peek())
                minStack.pop();
        }
    }
    
    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }
    
    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
/*
 * class Node {
 int value;
 int min;
 Node next;
 
 Node(int x) {
  value = x;
  next = null;
  min = x;
 }
}
class Solution {
    Node head;
 
 public void push(int x) {
  if (head == null) {
   head = new Node(x);
  } else {
   Node temp = new Node(x);
   temp.min = Math.min(head.min, x);
   temp.next = head;
   head = temp;
  }
 }
 
 public void pop() {
  if (head == null)
   return;
  head = head.next;
 }
 
 public int top() {
  if (head == null)
   return -1;
 
  return head.value;
 }
 
 public int getMin() {
  if (head == null)
   return -1;
 
  return head.min;
 }
}

 */