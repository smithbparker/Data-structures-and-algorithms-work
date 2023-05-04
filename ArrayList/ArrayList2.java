public class ArrayList2 {
    //data - using fields
    private String[] arr; //stores our data
    private int count;

    //actions, behavior - methods
    public void Add(String newValue)//O(n) - worst case, on average O(1)
    {
        if(isFull())//if the array is full
        {
            Resize();
        }
        arr[count] = newValue;//we can assume the array has space
        count++; 
    }

    public void Resize()//O(n)
    {
        String[] tmp = new String[2* arr.length];//create a new array twice the size
        //copy values from old array into new tmp
        for(int i=0; i< count; i++)
        {
            tmp[i] = arr[i];
        }
        arr = tmp;//redirect arr to tmp

    }

    public void AddBack(String newValue)//O(n)
    {
        Add(newValue);
    }

    public void AddFirst(String newValue)//O(n)
    {
        Insert(newValue, 0);
    }
    

    public boolean isFull()//O(1)
        {
            return count == arr.length;
        }
    

    public void Insert(String newValue, int index)//O(n+1+1+n) = O(n)
    {//sanity check for index
        if(index > count || index < 0)
        {
            throw new IndexOutOfBoundsException("Invalid index, valid values: 0-"+count);
        }
        if(isFull())
        {
            Resize();
        }
        //in here we know there is space
        //will shift all values to the right one position
        for(int i = count-1; i>=0; i--)
        {
            arr[i+1] = arr[i];
        }

        arr[index] = newValue;//insert the new value and increase count
        count++;
    }

    public boolean IsEmpty()//O(1)
    {
       /**  if(count ==0)
        {
            return true;
        }
        else
        {
            return false;
        }*/
        return count ==0;
    }

    public void Clear()//O(1)
    {
        count=0;
    }

    public int getCount()//O(1)
    {
        return count;
    }

    public int getCapacity()//O(1)
    {
        return arr.length;
    }

    public void DeleteLast()//O(1)
    {
        if(IsEmpty())//if the list is already "empty"
        {
            throw new IndexOutOfBoundsException("you can't delete from an empty list");
        }
        count--;
    }

    //constructors
    public ArrayList2() {
        arr = new String[4];
        count = 0;
    }

}
