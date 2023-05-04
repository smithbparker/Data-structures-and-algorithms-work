

public class DoublyLinkedList<T> {
    //data
    Node<T> head;
    Node<T> tail;

    //methods
    //AddFirst - O(1)
    public void addFirst(T someNewValue) { //AddFirst(5) O(1)
        //1 create a new node
        Node<T> n1 = new Node<T>(someNewValue);
        
        if (isEmpty()) {
            tail = n1;   
        } else {
            head.prev = n1;
        }

        //2 link the new node to point to the head node
        n1.next = head;
        n1.prev = null;

        //3 move the head to the new node
        head = n1;
    }

    //AddLast - O(1) 
    public void addLast(T someNewValue) { //O(1)
        if (isEmpty()) {
            addFirst(someNewValue);//this will also set the head
            return;
        }

        //create a new node
        Node<T> n1 = new Node<T>(someNewValue);

        //link it to the list
        n1.prev = tail;
        tail.next = n1;

        //move the tail
        tail = n1;
    }

    //delete first - O(1)
    public void deleteFirst() throws Exception {
        if (isEmpty()) {
            throw new Exception("You can't delete from an empty list");
        }

        if (head.next == null) { //if there's only one element in the list
            head = tail = null;
            return;
        }

        head = head.next;
        head.prev = null;
    }

    //delete last - O(1)
    public void deleteLast() throws Exception { 
        if (isEmpty()) {
            throw new Exception("You can't delete from an empty list");
        }

        if (tail.prev == null) { //if there's only one element in the list
            clear();//head = null;
            return;
        }

        tail = tail.prev;
        tail.next = null;
    }

    // Delete (given a value) - O(n)
    public void delete(T someValue) {
        Node<T> finger = head; // look at each node in the list from beginning
        while (finger != null) { // as long as there's a node there
            if (finger.value.equals(someValue)) {
                try {//try catch because of errors
                    if (finger == head) {
                        deleteFirst();
                    } else if (finger == tail) {
                        deleteLast();
                    } else {
                        finger.prev.next = finger.next;
                        finger.next.prev = finger.prev;
                    }
                } catch (Exception e) {
                    System.out.println("Error deleting node: " + e.getMessage());
                }
                return; // return once node is deleted
            }
            finger = finger.next; // move on to next node in the list
        }
    }

    // Delete (given a node) - O(1)
    public void delete(Node<T> nodeToDelete) throws Exception {
        if (nodeToDelete == null) {
            System.out.println("Error: nodeToDelete parameter is null");
            return;
        }
        if (nodeToDelete.prev == null) {
            System.out.println("Error: nodeToDelete does not belong to this linked list");
            return;
        }
        if (nodeToDelete == head) {
            deleteFirst();
        } else if (nodeToDelete == tail) {
            deleteLast();
        } else {
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
        }
    }

    



    

    

    //Reverse - O(n)
    public void reverse() {
        Node<T> temp = null;
        Node<T> finger = head;

        while (finger != null) {//loop through each node in the list
            temp = finger.prev;//swap the prev and next pointers of node
            finger.prev = finger.next;
            finger.next = temp;
            finger = finger.prev;//move on to next node in the list
        }

        if (temp != null) {//set the head to the last node in the list
            head = temp.prev;
        }
    }

    //Clear - O(1)
    public void clear() {//cut the ties to head and tail 
        head = tail = null;
    }

    //Print - O(n)
    public void print()
    {
        System.out.print("\n head");
        Node<T> finger = head; 
        while(finger!=null)
        {
            System.out.print(" -> " + finger.value ); //display the value
            finger = finger.next;//move finger to the "right"
        }
    }

    //  getNode - O(n)
    public Node<T> getNode(int index) {
        if (isEmpty()) {//check if the list is empty
            return null;
        }
        Node<T> finger;
        int i;
        if (index < 0) {//search the list for the node at the given index
            finger = tail;//search backwards from tail
            i = -1;
            while (i > index && finger != null) {
                finger = finger.prev;
                i--;
            }
        } else {
            finger = head;//search forwards from the head
            i = 0;
            while (i < index && finger != null) {
                finger = finger.next;
                i++;
            }
        }
        return finger;//return the node at the index or null
        }

        // isEmpty - O(1)
        public boolean isEmpty() {
            return head == null;//check if the head is null
        }
}