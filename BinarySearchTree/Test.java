/**
 * Test
 */
public class Test {

    public static void main(String[] args)
     {
        BST tree = new BST();
        tree.Insert(50);
        tree.Insert(40);
        tree.Insert(100);
        tree.Insert(30);
        tree.Insert(50);
        tree.Insert(70);
        tree.Insert(200);
        tree.Insert(50);
        tree.Insert(45);
        tree.Insert(50);
        //tree.InOrder
        //tree.PreOrder();
        System.out.println("number of nodes: " + tree.CountNodes());
        System.out.println("number of leaf nodes: " + tree.CountLeafNodes());
        System.out.println("Total sum: " + tree.Sum());
        System.out.println("Tree height: " + tree.Height());
        tree.BFS();

        //Test homework problems below
        System.out.println("\nNumber of non leaf nodes: " + tree.CountNotLeafNodes());
        tree.listAtEachLevel();
        //assign node to values to see if theres a path
        Node node1 = tree.Find(40);
        Node node2 = tree.Find(200);
        System.out.println("Path from 40-200?: " + tree.doesPathExist(node1, node2));//false



    }
}