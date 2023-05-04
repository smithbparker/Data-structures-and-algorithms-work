public class SinglyLinkedList2<T> {
    //data
    Node<T> head;
    Node<T> tail;

    //methods
    //AddFirst
    public void AddFirst(T someNewValue) //AddFirst(5) O(1)
    {
        //1 create a new node
        Node<T> n1 = new Node<T>(someNewValue) ;
        
        if(IsEmpty())
        {
            tail = n1;
        }

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
    public void AddLast(T someNewValue){ //O(1)
        if(IsEmpty())
        {
            AddFirst(someNewValue); //this will also set the head
        }
        else{
            //1 create a new node
            Node<T> n1 = new Node<T>(someNewValue);
    
            //2 linked it to the list
            tail.next = n1;
    
            //3 move the tail
            tail = n1;
        }
    }
    //DeleteFirst - O(1)
    public void DeleteFirst() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("You can't delete from an empty list");
        }
        else if(head.next==null)//there is exactly one element in the list
        {
            head = tail =null;
        }
        else
        {
            head = head.next;
        }
    }

    //DeleteLast
    public void DeleteLast() throws Exception{
        if(head==null)//the list is empty
        {
            throw new Exception("You can't delete from an empty list");
        }
        else if(head.next ==null) //there is only one node in the list
        {
            Clear();//head=null; tail = null - to do
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
            tail = finger;
        }
    }

    //Clear - O(1)
    public void Clear()
    {
        head =tail =  null;
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

    //ctor(s)
    
}