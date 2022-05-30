public class AList<T>{
    // public class Node{
    //     T item;
    //     Node prev;
    //     Node next;
    //     public Node(T i,Node p,Node n){
    //         item = i;
    //         prev = p;
    //         next = n;
    //     }
    // }
    private int size;
    public T[] A;

    public  AList(T item){
        size = 1;
        A = new T[100];
    }

    // Creating an empty array list
    public AList(){
        size = 0;
        A = new T[100];
    }
    
    public void addLast(T item){
        size++;
        A[size-1] = item;
    }

    public T getLast(){
        return A[size -1];
    }

    public T get(int index){
        if(index < 0 || index >=size)
            return null;
        return A[index];

    }

    public int size(){
        return size;
    }

    public T removeLast(){
        T x = getLast();
        size--;
        return x;
    }
}
