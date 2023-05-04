import javax.print.DocFlavor.STRING;

public class Test {

    public static void main(String[] args) throws Exception  {
        StackUsingQueue<String> s2 = new StackUsingQueue<String>();
        s2.Push("AAAA"); 
        s2.Push("BBBB"); 
        s2.Push("CCCC"); 
        s2.Push("DDDD"); 
        System.out.println(s2.Peek());//DDDD
        System.out.println(s2.Peek());//DDDD
        System.out.println(s2.Pop());//DDDD
        System.out.println(s2.Pop());//CCCC

        s2.Push("EEEE"); 
        System.out.println(s2.Pop());//EEEE


        MyQueue<Integer> q = new MyQueue<Integer>();
        q.Enqueue(10);
        q.Enqueue(20);
        q.Enqueue(30);
        System.out.println(q.Peek()); //10
        q.Dequeue();
        System.out.println(q.Peek()); //20
        System.out.println(q.Dequeue()); //20
        System.out.println(q.Peek()); //30



        MyStack<String> st = new MyStack<String>();
        st.Push("Saint");
        st.Push("Martin");
        st.Push("University");
        System.out.println(st.GetCount()); //3
        System.out.println(st.Peek());//University
        System.out.println(st.Peek());//University

        System.out.println( st.Pop() ); //University
        System.out.println(st.GetCount()); //2
        System.out.println( st.Pop() ); //Martin
        System.out.println(st.GetCount()); //1
        System.out.println(st.Peek());  //Saint
        System.out.println(st.GetCount()); //1

    }
}