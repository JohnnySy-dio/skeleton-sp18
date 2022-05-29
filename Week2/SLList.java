public class SLList {
    public class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    private IntNode sentinel; 
    public int size;
    public SLList(){
        sentinel = new IntNode(63, null);
        size = 0;
    }
    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    } 
    public void addFirst(int x){
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }
    public int getFirst(){
        return sentinel.next.item;
    }
    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        size++;
        IntNode p = sentinel;
        // if (first == null){
        //     first = new IntNode(x,null);
        //     return;
        // }
        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        
    }
    /** Returns the size of the list starting at IntNode p. */
    public int size(){
        return size;
    }
    public static void main(String[] args) {
        // Creates a list of one integer, namely 10
        SLList L = new SLList();
        // L.addFirst(10);
        // L.addFirst(5);
        L.addLast(20);
        System.out.println(L.getFirst());
        System.out.println(L.size());
    }
}
