public class MyQueue<T> {
    //data
    private SinglyLinkedList2<T> data = new SinglyLinkedList2<T>();
    private int Count = 0;

    public int GetCount()
    {
        return Count;
    }

    //methods
    public void Enqueue(T newValue)
    {
        data.AddLast(newValue);
        Count++;
    }
    
    public void Clear()
    {
        data.Clear();
        Count = 0;
    }

    public boolean IsEmpty()
    {
        return data.IsEmpty();
    }
    public T Peek() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("The queue is empty!!!");
        }
        return data.head.value;
    }

    public T Dequeue() throws Exception
    {
        if(IsEmpty())
        {
            throw new Exception("The queue is empty!!!");
        }
        T tmp = Peek();
        data.DeleteFirst();
        Count--;
        return tmp;
    }

    //ctor
}
