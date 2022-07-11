public interface Deque<Item> {
    void addFirst(Item item);
    void addLast(Item item);
    void printDeque();
    Item getRecursive(int i);
    Item removeFirst();
    Item removeLast();
}
