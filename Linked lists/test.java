public class test {
    public static void main(String[] args) {
        node<Integer> Node1 = new node<Integer>(10);
        node<Integer> Node2 = new node<Integer>(20);
        node<Integer> Node3 = new node<Integer>(30);

        //chain the node Node1 -> Node2 -> Node3
        Node1.next = Node2;
        Node2.next = Node3;

        System.out.println(Node1.value);//node 1's value

        System.out.println(Node2.value);//node 2's value
        System.out.println(Node1.next.value);//node 2's value

        System.out.println(Node3.value);//node 3's value
        System.out.println(Node1.next.next.value);//node 3's value

        singlylinkedlist<Integer> list = new singlylinkedlist<Integer>();
        list.AddFirst(10);
        list.AddFirst(20);
        list.AddFirst(30);
        list.AddFirst(40);
        try{
        list.Print();
        list.DeleteFirst();
         }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
