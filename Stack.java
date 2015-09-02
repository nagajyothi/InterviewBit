import java.util.Iterator;
public class Stack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    
    private class Node{
        Item item;
        Node next;
    }
    
    public void push(Item item){
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    
    public Item pop(){
        Item item = first.item;
        N--;
        first = first.next;
        return item;
    }
    
    public Item peek(){
        return first.item;
    }
    
    public boolean isEmpty(){
        return first == null;
    }
    
    public int size(){
        return N;
    }
    
    public Iterator<Item> iterator(){
        return new ListIterator();
    }
    
    public class ListIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext(){
            return current != null;
        }
        public Item next(){
            Item item = current.item;
            current = current.next;
            return item;
        }
        public void remove(){
        }
    }
    
    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        while(!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.push(item);
            else{
                if(!s.isEmpty()) System.out.print(s.pop() + " ");
            }
        }
        System.out.println();
        System.out.println("Size left on the stack is " + s.size()); 
    }      
}
/*
C:\Users\ngunti\algs4\FundamentalsOfProgramming\BagsQueuesStacks>java-algs4 Stack <tobe.txt
to be not that or be
Size left on the stack is 2
 */
