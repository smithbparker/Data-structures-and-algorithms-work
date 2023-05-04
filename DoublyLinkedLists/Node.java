public class Node<T> extends Object{

    // Data
    public T value;
    public Node<T> prev;
    public Node<T> next;

    // Constructor
    public Node(T value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }

}
