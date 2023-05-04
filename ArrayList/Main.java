/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        ArrayList2 myList = new ArrayList2();

        System.out.println(myList.IsEmpty());//true

        myList.Add("Saint");
        System.out.println(myList.IsEmpty());//false

        myList.AddFirst("Martin");
        myList.AddBack("University");
        System.out.println(myList.getCount());//3

        myList.Clear();//clear the list
        System.out.println(myList.IsEmpty());
        //delete

        //clone

        //

        
        }
}