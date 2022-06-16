public class ArrayDeque <T>{
    // size of the deque
    private int size;

    // array to save data
    public T[] Array;

    // size of the array
    private int length;

    private int front;

    private int last;
    public  ArrayDeque(){
        Array = (T[]) new Object[8];
        size = 0;
        length = 8;
        front = 4;
        last = 4;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public int minusOne(int index) {
        if (index == 0){
            return length - 1;
        }

        return index -1;

    }

    public int plusOne(int index, int module){
        index %= module;
        if (index == module -1) {
            return 0;
        }

        return index +1;
    }

    public void grow(){
        T[] newArray = (T[]) new Object[length * 2];
        int ptr1 = front;
        int ptr2 = length;
        while (ptr1 != last) {
            newArray[ptr2] = Array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length * 2);
        }
        front = length;
        last = ptr2;
        Array = newArray;
        length *= 2;
    }
    public void shrink() {
        T[] newArray = (T[]) new Object[length / 2];
        int ptr1= front;
        int ptr2 = length / 4;
        while (ptr1 != last){
            newArray[ptr2] = Array[ptr1];
            ptr1 = plusOne(ptr1, length);
            ptr2 = plusOne(ptr2, length / 2);
        }
        front = length / 4;
        last = ptr2;
        Array = newArray;
        length /= 2;

    }

    public void addFirst(T item){
        if (size == length) {

        }
    }

    public void addLast(T item){

    }

    public void removeFirst(T item){

    }

    public void removeLast(T item){

    }

    public T get(int index){
        if(index >= length)
            return null;
        int ptr = front;
        for (int i = 0; i < index; i++) {
            ptr = plusOne(ptr, length);
        }
        }

    public void printDeque(){
        int ptr = front;
        while (ptr != last){
            System.out.print(Array[ptr] + " ");
            ptr = plusOne(ptr, length);
        }
    }
}
