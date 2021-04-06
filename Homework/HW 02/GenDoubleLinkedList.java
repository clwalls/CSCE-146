/**
 * Written by Christopher Walls. 
 */
public class GenDoubleLinkedList <T> {
  ListNode node = new ListNode();
  
  //INTERNAL CLASS
  private class ListNode {
    //INTERNAL CLASS INSTANCE VARIABLES
    private T data;
    private ListNode nextLink;
    private ListNode prevLink;
    //INTERNAL CLASS CONSTRUCTORS
    //         DEFAULT
    public ListNode() {
      this.data = null;
      this.nextLink = null;
      this.prevLink = null;
    }
    //         PARAMETERIZED
    public ListNode (T aData, ListNode aNextLink, ListNode aPrevLink) {
      this.data = aData;
      this.nextLink = aNextLink;
      this.prevLink = aPrevLink;
    }
  }
  
  private ListNode head;
  private ListNode current;
  
  public GenDoubleLinkedList() {
    head=current=null;
  }
  //METHODS
  public void insert(T aData) {
    //create the node
    ListNode newNode = new ListNode(aData, null, null);//TODO Change
    if (head == null) //empty list 
    {
      head = newNode;
      current = head;
      return;
    }
    //list is not empty
    ListNode temp = head;
    while(temp.nextLink != null)
    {
      temp = temp.nextLink;
    }
    temp.nextLink = newNode;//adds new node to the end of the list
  }
  public void showList () {
    // prints out the contents of the list line-by-line
    ListNode temp = head;
    System.out.println("Hook:");
    while(temp !=null)
    {
      System.out.println(temp.data);
      temp = temp.nextLink;
    }
  }
  public T getDataAtCurrent() {
    if(current != null)
      return current.data;
    else
      return null;
  }
  public void setDataAtCurrent(T aData) {
    if(current != null)
      current.data = aData;
  }
  public void goToNext() {
    if(current != null && current.nextLink != null) {
      current.prevLink = current;
      current = current.nextLink;
    }
  }
  public void goToPrev() {
    if(current != null && current.prevLink != null) {
      current.nextLink = current;
      current = current.prevLink;
    }
  }
  public void resetCurrent() {
    current = head;
    current.prevLink = null;
  }
  public void insertNodeAfterCurrent(T aData) {
    ListNode newNode = new ListNode(aData, null, null);
    if (current != null) {
      newNode.nextLink = current.nextLink;
      current.nextLink = newNode;
    }
    else if (head != null) {
      System.out.println("Current is outside of the list.");
    }
    else {
      System.out.println("The list is empty.");
    }
  }
  public void deleteCurrentNode(T aData) {
    /*  if (head == null || current == null) { //base
     return;
     }
     if (head == current) {//current is head
     head = current.nextLink;
     }
     if (current.nextLink != null) { // not last node
     current.nextLink.prevLink = current.prevLink;
     //current = current.prevLink;
     }
     if (current.prevLink != null) {
     current.prevLink.nextLink = current.nextLink;
     //current = current.nextLink;
     }
     return;
     */
    if (current != null && current.prevLink != null)
    {
      current.prevLink = current.nextLink;
      current = current.nextLink;
    }
    else if (current != null && current.prevLink == null) //Current is the head
    {
      head = head.nextLink;
      current = head;
    }
    else
      System.out.println("Cannot delete something that does not exist!");
  }
  public boolean moreToIterate() {
    return current != null;
  }
  public boolean inList (T aData) {
    ListNode temp = head;
    while(temp !=null)
    {
      if (temp.data.equals(aData) || temp.data == aData) {
        return true;
      }
      temp = temp.nextLink;
    }
    return false;
  }
  /* ADD YOUR CODE HERE */
  
}
