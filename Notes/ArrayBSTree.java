/**
 * Written by Christopher Walls
 */
public class ArrayBSTree<T extends Comparable<T>> {
  //base interface Shape, that gets area
  //2xindex +1 to go left 2xindex +2 to go right
  private T[] tree;
  public static final int DEFAULT_SIZE = 128;
  public ArrayBSTree()
  {
    init(DEFAULT_SIZE);
  }
  public ArrayBSTree(int size)
  {
    init(size);
  }
  private void init(int size)
  {
    if(size>0)
      tree = (T[])(new Comparable[size]);
  }
  public void insert(T aData)
  {
    if(tree[0] == null)
      tree[0] = aData;
    else
      insert(0, aData);
  }
  private void insert(int index, T aData)
  {
    if(index >= tree.length)//Outside bounds of the array
      return;
    if(tree[index] == null)//empty spot (a leaf)
      tree[index] = aData;
    else if(aData.compareTo(tree[index])<0)//go left
      insert(index*2+1,aData);
    else if(aData.compareTo(tree[index])>=0)//go right
      insert(index*2+2,aData);
  }
  public boolean search(T aData)
  {
    return search(0,aData);
  }
  private boolean search(int index, T aData)
  {
    if(index >= tree.length)//out of bounds
      return false;
    if(tree[index] == null)//nothing there bro
      return false;
    else if(aData.compareTo(tree[index]) == 0)//we found it dudeeeee
      return true;
    else if(aData.compareTo(tree[index])<0) // go left yo
      return search(index*2+1,aData);
    else //go right
      return search(index*2+2,aData);
  }
  public void printBreadthOrder()
  {
    for(T val : tree)
    {
      if(val != null)
        System.out.println(val);
      else
        System.out.println("Null");
    }
  }
  public void delete(T aData)
  {
    delete(0, aData);
  }
  private void delete(int index, T aData)
  {
    //find the value
    if(index >= tree.length)//not found
      return;
    if(tree[index] == null)//not found
      return;
    else if(aData.compareTo(tree[index])<0)
      delete(index*2+1,aData);
    else if(aData.compareTo(tree[index])>=0)//go right
      delete(index*2+2,aData);
    else//we found it
    {
      if(index*2+2 < tree.length && tree[index*2+2] == null)
        shiftTreeLeft(index);
    }
  }
  private void shiftTreeLeft(int index)
  {
    if(index >= tree.length)
      return;
    boolean isLeft = index%2 != 0;
    if(isLeft || index == 0)//root or left child
    {
      if(index*2+1 < tree.length)
        tree[index] = tree[index*2+1];
      else
      {
        tree[index] = null;
        return;
      }
    }
    else
    {
      if((index-1)*2+2 < tree.length)//checks parents sibling
        tree[index] = tree[(index-1)*2+2];
      else
      {
        tree[index] = null;
        return;
      }
    }
    shiftTreeLeft(index*2+1);
    shiftTreeLeft(index*2+2);//shifts those kids for Athene the best GAMER ALIVE
  }
  
  /* ADD YOUR CODE HERE */
  
}
