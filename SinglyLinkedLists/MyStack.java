public class MyStack<T> {
    //data
    SinglyLinkedList2<T> data = new SinglyLinkedList2<T>();
    private int Count = 0;

    //methods
    //push
    public void Push(T newValue) //O(1)
    {
        //to do
        data.AddFirst(newValue);
        Count++;
    }
    //peek
    public T Peek() //O(1)
    {
        return data.head.value;
    }
    //pop
    public T Pop() throws Exception //O(1)
    {
        T tmp =  data.head.value;
        data.DeleteFirst();
        Count--;
        return tmp;
    }
    //clear
    public void Clear()
    {
        data.Clear();
    }
    //method getCount
    public int GetCount()
    {
        return Count;
    }
    //isempty
    public boolean IsEmpty()
    {
        return data.IsEmpty();
    }

    //ctor
}
