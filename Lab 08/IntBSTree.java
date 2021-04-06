/**
 * Created by Christopher Walls. 
 */
public class IntBSTree<T extends Comparable<T>> {
  private class Node {
    private T data;
    private Node leftChild;
    private Node rightChild;
    
    public Node (T aData) {
      data = aData;
      leftChild = rightChild = null;
    }
  }
  private Node root;//First element of the tree.
  public IntBSTree() {
    root = null;
  }
  //INSERT
  /* When adding a new value to a tree, smaller values go to the left, and
   * larger or equal valuse go to the right. A value traverses the tree 
   * following these rules until a null child is met. */
  public void insert(T aData) {
    if(root==null)
      root = new Node(aData);
    else
      insert(root,aData);
  }
  private Node insert(Node aNode, T aData) {
    if(aNode == null) //Found the link
      aNode = new Node(aData);
    else if(aData.compareTo(aNode.data)<0) //Go left
      aNode.leftChild = insert(aNode.leftChild, aData);
    else if(aData.compareTo(aNode.data)>=0) //Go right
      aNode.rightChild = insert(aNode.rightChild, aData);
    return aNode;
  }
  //REMOVE METHOD
  public void remove(T aData)
  {
    root = remove(root, aData);
  }
  private Node remove(Node aNode, T aData)
  {
    //Find the Value
    if(aNode == null)//The value isn't found
      return null;
    if(aData.compareTo(aNode.data)<0)//Go left
      aNode.leftChild = remove(aNode.leftChild,aData);
    else if(aData.compareTo(aNode.data)>0)//Go Right
      aNode.rightChild = remove(aNode.rightChild,aData);
    else//We found it: Kill it!
    {
      //We may or may not have a left child so whatever just return it
      if(aNode.rightChild == null)
        return aNode.leftChild;
      //We do have a right child but do not have a left
      if(aNode.leftChild == null)
        return aNode.rightChild;
      //Crap we have two kids
      Node temp = aNode;//Temp points to the node we are deleting
      //point aNode to the smallest value in the right subtree
      aNode = findMinInTree(aNode.rightChild);
      //remove smallest element from right subtree
      aNode.rightChild = removeMinFromTree(temp.rightChild);
      aNode.leftChild = temp.leftChild;
    }
    return aNode;
  }
  private Node findMinInTree(Node aNode)
  {
    if(aNode == null)
      return null; 
    //cannot go left any further
    if(aNode.leftChild == null)
      return aNode;
    else
      return findMinInTree(aNode.leftChild);
  }
  private Node removeMinFromTree(Node aNode)
  {
    if(aNode == null)
      return null;
    if(aNode.leftChild == null)
      return aNode.rightChild;
    aNode.leftChild = removeMinFromTree(aNode.leftChild);
    return aNode;
  }
  //PRINT PREORDER
  //Preorder left to right
  public void printPreorder() {
    printPreorder(root);
  }
  private void printPreorder(Node aNode) {
    if(aNode == null)
      return;
    System.out.println(aNode.data);//Access the node
    printPreorder(aNode.leftChild);//Go left
    printPreorder(aNode.rightChild);//Go Right
  }
  //GET DEPTH
  public void getDepth(T aData) 
  {
    //readapted search method to include depth
    //depth is number of edges from root to that number
    System.out.println("The Depth of " +aData+" is "+getDepth(root, aData, 0));
  }
  private int getDepth(Node aNode,T aData, int depth)
  {
    if(aNode==null)//Wasn't in the tree
      return -1;
    if(aData.compareTo(aNode.data)==0)//We found it
      return depth;
    else if(aData.compareTo(aNode.data)<0)//Go Left
      return getDepth(aNode.leftChild, aData, depth+1);
    else //go right
      return getDepth(aNode.rightChild, aData, depth+1);
  }
}
