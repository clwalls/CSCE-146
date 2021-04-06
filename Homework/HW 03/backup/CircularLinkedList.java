/**
 * Written by Christopher Walls. 
 */
public class CircularLinkedList <T> extends Player {
  //INTERNAL CLASS
  private class ListNode {
    //INTERNAL CLASS INSTANCE VARIABLES
    private T data;
    private ListNode link;
    //INTERNAL CLASS CONSTRUCTORS
    //         DEFAULT
    public ListNode() {
      this.data = null;
      this.link = null;
    }
    //         PARAMETERIZED
    public ListNode (T aData, ListNode aLink) {
      this.data = aData;
      this.link = aLink;
    }
  }
  //INSTANCE VARIABLES
  private ListNode head;
  private ListNode current;
  private ListNode previous;
  private ListNode tail;
  //CONSTRUCTORS
  public CircularLinkedList() {
    head=current=previous=tail=null;
  }
  //METHODS
  public void insert(T aData) {
    //Inserts at the end of the list
    ListNode newNode = new ListNode(aData, null);
    if (head == null) //list is empty
    {
      head = newNode;
      current = head;
      tail = head;
      return;
    }
    //list not empty
    ListNode temp = head;
    while (temp != tail) 
    {
      temp = temp.link;
    }
    temp.link = newNode; 
    tail = newNode;
    tail.link = head;
  }
  public void showList() {
    // prints out the contents of the list line-by-line
    ListNode temp = head;
    do {
      System.out.println(temp.data);
      temp = temp.link;
    } while(temp != tail.link);
  }
  
  
  
}
