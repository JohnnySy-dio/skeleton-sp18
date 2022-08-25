package synthesizer;
import java.util.Iterator;
//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T>{
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;

        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull())
        {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount++;
        last = (last + 1) % capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
        if(!isEmpty())
        {
           T retValue = rb[first];
           fillCount--;
           first = (first + 1) % capacity;
           return retValue;
        }
        throw new RuntimeException("Ring buffer underflow");
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        return rb[first];
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    private class ArrayBufferIterator implements Iterator<T>
    {
        private int pos;
        private int curNum;
        public ArrayBufferIterator()
        {
            pos = first;
            curNum = 0;
        }


        @Override
        public boolean hasNext()
        {
            return curNum < fillCount;
        }

        @Override
        public T next()
        {
            pos = (pos + 1) % capacity;
            T retValue = rb[pos];
            curNum++;
            return retValue;

        }
    }

    @Override
    public Iterator<T> iterator()
    {
        return new ArrayBufferIterator();
    }
}
