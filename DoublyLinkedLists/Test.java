
public class Test {

    public static void main(String[] args) throws Exception {

        DoublyLinkedList<Integer> myList = new DoublyLinkedList<Integer>();

        

        // AddFirst
        myList.addFirst(3);
        myList.addFirst(2);
        myList.addFirst(1);
        System.out.println("Adding 1, 2, 3 at the beginning:");
        myList.print();

        // AddLast
        myList.addLast(4);
        myList.addLast(5);
        myList.addLast(6);
        System.out.println("\nAdding 4, 5, 6 at the end:");
        myList.print();

        // DeleteFirst
        myList.deleteFirst();
        System.out.println("\nDeleting the first node:");
        myList.print();

        // DeleteLast
        myList.deleteLast();
        System.out.println("\nDeleting the last node:");
        myList.print();

        // Delete value
        myList.delete(3);
        System.out.println("\nDeleting the node with value 3:");
        myList.print();

        // Delete node
        Node<Integer> nodeToDelete = myList.head.next;
        myList.delete(nodeToDelete);
        System.out.println("\nDeleting the node at index 2:");
        myList.print();

        // Reverse
        myList.reverse();
        System.out.println("\nReversing:");
        myList.print();
        myList.reverse();
        System.out.println("\nReverse back to normal");
        myList.print();

        // IsEmpty
        System.out.println("\nList is empty: " + myList.isEmpty());

        // Clear
        myList.clear();
        System.out.println("\nClearing the list:");
        myList.print();
        System.out.println("\nList is empty: " + myList.isEmpty());

    }

}
