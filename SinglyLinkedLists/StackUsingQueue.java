public class StackUsingQueue <T> {
    //data
    MyQueue<T> data = new MyQueue<T>();

    //methods
    //push
    public void Push(T newValue) throws Exception //O(n)
    {
        int n = data.GetCount();

        data.Enqueue(newValue);

        for(int i=0; i<n; i++)
        {
            data.Enqueue(data.Dequeue());
        }
    }
    //peek
    public T Peek() throws Exception //O(1)
    {
        return data.Peek();
    }
    //pop
    public T Pop() throws Exception //O(1)
    {
        return data.Dequeue();
    }
}
