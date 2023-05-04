
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;


public class BST {
    //data
    Node root;

    //methods
    //IsEmpty
    public boolean IsEmpty()
    {
        return root == null;
    }

    //Insert
    public void Insert(int someValue)
    {
        //create a new node 
        Node n1 = new Node(someValue);

        //check if tree is empty
        if(IsEmpty())
        {
            root = n1;
        }
        else
        {
            Node finger = root;
            while(true)
            {
                if(someValue<=finger.value)
                {
                    if(finger.left!=null)
                    {
                        finger = finger.left; //move left
                    }
                    else //there is no left
                    {
                        //link it to the new node, n1, to the left
                        finger.left = n1;
                        break;
                    }
                }
                else
                {
                    if(finger.right!=null) //check if there is a right
                    {
                    finger = finger.right; //move right
                    }
                    else
                    {
                        finger.right=n1; //make n1 the right child
                        break;
                    }
                }
            }
        }
    }

    //Search
    public Node Find(int someValue)
    {
        Node finger = root;
        while(finger!=null)
        {
            if(finger.value == someValue)
            {
                return finger; //we found the node
            }
            else if(someValue < finger.value)
            {
                finger = finger.left; //go to the left
            }
            else
            {
                finger = finger.right; //go to right
            }

        }
        return null; //value not found, same as return finger
    }

    //traversal(s)
    //PREORDER - node then left then right
    public void PreOrder()
    {
        PreOrderHelper(root);
    }

    public void PreOrderHelper(Node finger)
    {
        if(finger!=null)
        {
            System.out.print(finger.value+" ");//N visit the node
            PreOrderHelper(finger.left);//L
            PreOrderHelper(finger.right);//R
        }
    }

    //INORDER - left then node then right
    public void InOrder()
    {
        InOrderHelper(root);
    }

    public void InOrderHelper(Node finger) //N = finger from LNR
    {
        if(finger!=null)
        {
            InOrderHelper(finger.left); //L
            System.out.print(finger.value+ " ");//N
            InOrderHelper(finger.right); //R
        }
    }

    //POSTORDER - left right node

    //max and min
    public Node getMax()
    {
        if(IsEmpty())
        {
            return null; //there is no max
        }

        Node finger = root;
        while(finger.right!=null) //as long as there is a node to the right
        {
            finger = finger.right; //move right
        }

        return finger; 
    }

    public int CountNodes()
    {
        return CountNodesHelper(root);
    }

    public int CountNodesHelper(Node current)
    {
        if(current==null)
        {
            return 0;
        }
       return CountNodesHelper(current.left) + CountNodesHelper(current.right) +1;
    }

    public int CountLeafNodes()//so you dont have to define what node youre starting w/
    {
        return CountLeafNodesHelper(root);
    }

    public int CountLeafNodesHelper(Node current)
    {
        if(current==null)
        {
            return 0;
        }
        else if(current.left ==null && current.right ==null)//we found a leaf
        {
            return 1;
        }
        return CountLeafNodesHelper(current.left) + CountLeafNodesHelper(current.right);
    }

    public int CountNotLeafNodes()//so you dont have to define what node youre starting w/
    {
        return CountNotLeafNodesHelper(root);
    }

    public int CountNotLeafNodesHelper(Node current)
    {
        if(current==null)//if the root is null
        {
            return 0;
        }
        else if(current.left !=null || current.right !=null)//not a leaf
        {
            //If the left or the right is not null (meaning it has a child)
            //then it is not a leaf node so add the left and right plus root as 1
            return CountNotLeafNodesHelper(current.left) + CountNotLeafNodesHelper(current.right)+1;
        }
        else //leaf nodes
        {
            return 0;
        }
    }

    public int Sum()
    {
        return SumHelper(root);
    }

    public int SumHelper(Node current)
    {
        if(current==null)
        {
            return 0;
        }
        return SumHelper(current.left) + SumHelper(current.right) + current.value;
    }

    public int Height()
    {
        return HeightHelper(root);
    }

    public int HeightHelper(Node current)
    {
        if(current==null)
        {
            return -1;
        }
        return Math.max(HeightHelper(current.left), HeightHelper(current.right))+1;
    }

    public void BFS()//Breadth first search
    {
        if(root==null)
        {
            System.out.println("Empty tree");
        }
        else
        {
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);

            while(q.size() > 0)
            {
                //remove the first in line
                Node current = q.poll();//get the next in line
                //visit it
                System.out.print(current.value + " ");

                if(current.left!=null)//add the left child
                {
                    q.add(current.left);
                }
                if(current.right!=null)//add the right child
                {
                    q.add(current.right);
                }
            }
        }
    }
    //method to call and adding root to save a step in main
    public List<List<Integer>> listAtEachLevel()
    {
        //looping through the list of lists returned by helper and printing
        for (List<Integer> level : listAtEachLevelHelper(root)) {
            System.out.println(level.toString());
        }
        return null;

    }

    public List<List<Integer>> listAtEachLevelHelper(Node current)
     {
        List<List<Integer>> result = new ArrayList<>();//creating an empty list
        if (root == null)//if it's an empty tree
        {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();//create queue starting with root
        queue.add(root);
        
        while (!queue.isEmpty()) {//as long as queue isn't empty (theres still nodes)
            //create empty list to hold values at current depth/level
            List<Integer> currentLevel = new ArrayList<>();
            int size = queue.size();
            //loop through every node in queue and add to 
            //the current level and when there are no more
            //add the current level list to result list
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                currentLevel.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(currentLevel);
        }
        
        return result;
    }

    public boolean doesPathExist(Node node1, Node node2)
     {
        //if one of the nodes dont exist
        if (node1 == null || node2 == null) {
            return false;
        }
        //return helper with two nodes as arguments
        return doesPathExistHelper(node1, node2);
    }
    
    private boolean doesPathExistHelper(Node current, Node target) 
    {
        //can't be a path if the start doesn't exist
        if (current == null) {
            return false;
        }
        //if theyre the same than there is technically a path
        if (current == target) {
            return true;
        }
        //recursively check through left and right child nodes of start
        return doesPathExistHelper(current.left, target) || doesPathExistHelper(current.right, target);
    }

    

   
   
    //ctor
}
