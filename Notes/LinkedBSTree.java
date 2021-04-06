/**
 * Auto Generated Java Class.
 */
public class LinkedBSTree<T extends Comparable<T>> {
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
  public LinkedBSTree() {
    root = null;
  }
  /* When adding a new value to a tree, smaller values go to the left, and
   * larger or equal valuse go to the right. A value traverses the tree 
   * following these rules until a null child is met. */
  public void insert(T aData) {
    if(root==null)
      root = new Node(aData);
    else
      insert(root,aData);
  }
  private Node insert(Node aNode, T aData) { //two on extra credit 
    if(aNode == null) //Found the link
      aNode = new Node(aData);
    else if(aData.compareTo(aNode.data)<0) //Go left
      aNode.leftChild = insert(aNode.leftChild, aData);
    else if(aData.compareTo(aNode.data)>=0) //Go right
      aNode.rightChild = insert(aNode.rightChild, aData);
    return aNode;
  }
  public boolean search(T aData)
  {
   return search(root, aData); 
  }
  private boolean search(Node aNode, T aData)
  {
    if(aNode==null)//Wasn't in the tree
      return false;
    if(aData.compareTo(aNode.data)==0)//We found it
      return true;
    else if(aData.compareTo(aNode.data)<0)//Go Left
      return search(aNode.leftChild, aData);
    else
      return search(aNode.rightChild, aData);
  }
  //Preorder left to right
  public void printPreOrder() {
    printPreOrder(root);
  }
  private void printPreOrder(Node aNode) {
    if(aNode == null)
      return;
    System.out.println(aNode.data);//Access the node
    printPreOrder(aNode.leftChild);//Go left
    printPreOrder(aNode.rightChild);
  }
  //In order
   public void printInOrder() {
    printInOrder(root);
  }
  private void printInOrder(Node aNode) {
    if(aNode == null)
      return;
    printInOrder(aNode.leftChild);//Go left
    System.out.println(aNode.data);//Access the node
    printInOrder(aNode.rightChild);
  }
  //Post order
  public void printPostOrder() {
    printPostOrder(root);
  }
  private void printPostOrder(Node aNode) {
    if(aNode == null)
      return;
    printPostOrder(aNode.leftChild);//Go left
    printPostOrder(aNode.rightChild);
    System.out.println(aNode.data);//Access the node
  }
  public void delete(T aData)
  {
    root = delete(root, aData);
  }
  private Node delete(Node aNode, T aData)
  {
    //Find the Value
    if(aNode == null)//The value isn't found
      return null;
    if(aData.compareTo(aNode.data)<0)//Go left
      aNode.leftChild = delete(aNode.leftChild,aData);
    else if(aData.compareTo(aNode.data)>0)//Go Right
      aNode.rightChild = delete(aNode.rightChild,aData);
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
      //delete smallest element from right subtree
      aNode.rightChild = deleteMinFromTree(temp.rightChild);
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
  private Node deleteMinFromTree(Node aNode)
  {
    if(aNode == null)
      return null;
    if(aNode.leftChild == null)
      return aNode.rightChild;
    aNode.leftChild = deleteMinFromTree(aNode.leftChild);
    return aNode;
  }
}

