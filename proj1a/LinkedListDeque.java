
public class LinkedListDeque <T>{
    public class Node{
        public T item;
        public Node prev;
        public Node next;
        public Node(T i, Node p, Node n){
            item = i;
            prev = p;
            next = n;
        }
    }
    private Node sentF;
    private Node sentB;
    private int size;
    public LinkedListDeque(T x){
        sentF = new Node(x, null,null);
        sentB = new Node(x, null, null);
        sentF.next = new Node(x, sentF, sentB);
        sentB.prev = sentF.next;
        size = 1;
    }
    // Creating an empty list
    public LinkedListDeque(){
        sentF = new Node(null, null,null);
        sentB = new Node(null, sentF, null);
        sentF.next = sentB;
        size = 0;
    }
    // Adds an item of type T to the front of the deque.
    public void addFirst(T item){
       Node p1 = new Node(item,sentF,sentF.next);
       Node p2 = sentF.next;
       sentF.next = p1;
       p2.prev = p1;
       size++;
    }

    // TODO: Adds an item of type T to the back of the deque.
    public void addLast(T item){
       Node p1 = new Node(item, sentF.prev,sentB);
       Node p2 = sentB.prev;
       sentB.prev = p1;
       p2.next = p1;
       size++;
    }

    // TODO: Returns true if deque is empty, false otherwise.
    public boolean isEmpty(){
        return size == 0;
    }

    // Returns the number of items in the deque.
    public int size(){
        return size;
    }

    // Prints the items in the deque from first to last, 
    // separated by a space. 
    // Once all the items have been printed, 
    // print out a new line.
    public void printDeque(){
        Node p = sentF.next;
        while(p.item != null){
            System.out.print(p.item + " ");
            p = p.next;
        }

    }

    // Removes and returns the item at the front of the deque. 
    // If no such item exists, returns null.
    public T removeFirst(){
        if(isEmpty())
            return null;
        Node p1 = sentF.next;
        Node p2 = sentF.next.next;
        sentF.next = sentF.next.next;
        p2.prev = p1;
        size--;
        return p1.item;

    }

    // Removes and returns the item at the front of the deque. 
    // If no such item exists, returns null.
    public T removeLast(){
    // If the Linked List is empty
    if(isEmpty()){
        return null;
    }

    Node p1 = sentB.prev;
    Node p2 = sentB.prev.prev;
    sentB.prev = sentB.prev.prev;
    p2.next = sentB;
    size--;
    return p1.item;

    }

    /* 
    TODO: Gets the item at the given index,
          where 0 is the front, 1 is the next item,
          and so forth. If no such item exists, returns null.
          Must not alter the deque!
    */
    public T get(int index){
    // If there is no such item exists
        if(index > size)
            return null;
        Node p = sentF;
        int n = 0;
        while(n != index){
            n++;
            p = p.next;
        }
        return p.item;

    }
    private T getRecursivehelp(Node start,int index){
        if(index == 0)
            return start.item;
        else
            return getRecursivehelp(start.next,index -1);
    }
    public T getRecursive(int index){
        // The breaking condition
        if (index >= size)
            return null;
        return getRecursivehelp(sentF,index);
    }
}
