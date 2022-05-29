// DLList: Doubly Linked List
public class DLList {
    public class IntNode{
        // In other words, use a doubly linked list.
        public IntNode prev;
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode p, IntNode n ){
            item = i;
            prev = p;
            next = n;

        }
    }
    IntNode sentF;
    IntNode sentB;
    int size;
    public DLList(int x){
        sentF = new IntNode(69, null, null);
        sentB = new IntNode(69, null, null);
        sentF.next = new IntNode(x, sentB, sentB);
        sentB.prev = sentF.next;
        size = 1;
    }
    
    
}
