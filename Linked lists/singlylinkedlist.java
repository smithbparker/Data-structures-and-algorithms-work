public class singlylinkedlist<T> {
    //data
    node<T> head;

    //methods
    //AddFirst
    public void AddFirst(T someNewValue)
    {
        //1 create new node
        node<T> n1 = new node<T>(someNewValue);
        //2 link new node to point to head node
        n1.next = head;

        //3 move the head to new node
        head = n1;
    }

    //print 
    public void Print(){
        System.out.print("\n head ");
        node<T> finger = head;
        while(finger!=null)
        {
        System.out.print(" -> " + finger.value);//display current value
        //move finger to the next node
        finger = finger.next;
        }
    }

    //addlast
    public void AddLast(T someNewValue){ //O(n) doubly will be O(1)
        if (head==null) {
            AddFirst(someNewValue);
        }
        //1 create new node
        node<T> n1 = new node<T>(someNewValue);

        //2 traverse the list to find the last node
        node<T> finger = head;
        while (finger.next !=null) 
        {
         finger = finger.next;   
        }

        //link in the new node lastNode.next = newNode
        finger.next = n1;
    }
    //delete first O(1)
    public void DeleteFirst() throws Exception
    {
        if(IsEmpty())
        throw new Exception("You can't delete from an empty list");
    }
    //delete last
    public void DeleteLast()
    {
        
    }

    //clear O(1)
    public void Clear()
    {
        head = null;
    }

    //IsEmpty
    public boolean IsEmpty()
    {
        /*if(head == null)
        {
            return true;
        }
        return false; */
        return head == null; 
    }

    //constructors(ctors)
}
