public class StackUsingQ <T> {
    //data
    MyQueue <T> data = new MyQueue<T>();

    //methods
    //push
    public void Push(T newValue) throws Exception 
    {
        int n = data.GetCount();//O(n)

        data.Enqueue(newValue);

        for(int i =0; i<n; i++)
        data.Enqueue(data.Dequeue());//curly braces not needed when 1 line

    }

    //peek
    public T Peek() throws Exception
    {
        return data.Peek();
    }

    //pop
    public T Pop() throws Exception
    {
        return data.Dequeue();
    }

}
