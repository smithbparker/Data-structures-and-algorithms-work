public class SinglyLinkedList<T> {
    //data
    Node<T> head;

    //methods
    //AddFirst
    public void AddFirst(T someNewValue) //AddFirst(5) O(1)
    {
        //1 create a new node
        Node<T> n1 = new Node<T>(someNewValue) ;

        //2 link the new node to point to the head node
        n1.next = head;

        //3 move the head to the new node
        head = n1;
    }
    //Print - O(n)
    public void Print()
    {
        System.out.print("\n head");
        Node<T> finger = head; 
        while(finger!=null)
        {
            System.out.print(" -> " + finger.value ); //display the value
            finger = finger.next;//move finger to the "right"
        }
    }
    //AddLast
    public void AddLast(T someNewValue){ //O(n)
        if(head==null)//the list is empty
        {
            AddFirst(someNewValue);
        }
        else{
            //create a new node
            Node<T> n1 = new Node<T>(someNewValue);
    
            //traverse the list, to find the last node
            Node<T> finger = head;
            while(finger.next!=null)
            {
                finger = finger.next;
            }
    
            //link in the new node  lastNode.next = newNode
            finger.next = n1;
        }
    }
    //DeleteFirst - O(1)
    public void DeleteFirst() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("You can't delete from an empty list");
        }
        head = head.next;
    }

    //DeleteLast
    public void DeleteLast() throws Exception{
        if(head==null)//the list is empty
        {
            throw new Exception("You can't delete from an empty list");
        }
        else if(head.next ==null) //there is only one node in the list
        {
            Clear();//head=null;
        }
        else{
            Node<T> finger = head;
    
            //traverse the list until you get to the second to last node
            while(finger.next.next!=null)
            {
                finger = finger.next; //move the finger from one node to the next
            }
    
            //break the last node from the list
            finger.next = null;
        }
    }

    //Clear - O(1)
    public void Clear()
    {
        head = null;
    }

    //IsEmpty - O(1)
    public boolean IsEmpty()
    {
        /*
        if(head == null)
        {
            return true;
        }
        return false;
        */

        return head == null;
    }

    public void Reverse()
    {
        Node<T> finger = head;

        head = null;
        while(finger !=null)
        {
            AddFirst(finger.value);
            finger = finger.next;
        }
    }

    public boolean ContainCycle()
    {
        Node<T> slow, fast;
        slow = fast = head;

        while(slow!=null && fast!= null && fast.next!=null && fast!=slow )
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        //when you get here
        if(fast ==null || fast.next==null)
        {
            return false; //no cycle
        }
        else //we assume fast == slow
        {
            return true; //yes cycle
        }
    }
    //ctor(s)
    
}