/**
 * Written by Christopher Walls.
 */
public class ToDoList {
  ListNode node = new ListNode();
  
  //INTERNAL CLASS
  private class ListNode {
    //INTERNAL CLASS INSTANCE VARIABLES
    private String data;
    private ListNode link;
    //INTERNAL CLASS CONSTRUCTORS
    //         DEFAULT
    public ListNode() {
      this.data = "Data not set";
      this.link = null;
    }
    //         PARAMETERIZED
    public ListNode (String aData, ListNode aLink) {
      this.data = aData;
      this.link = aLink;
    }
  }
  
  //INSTANCE VARIABLES
  private ListNode head;
  private ListNode previous;
  private ListNode current;
  //    DEFAULT CONSTRUCTOR
  public ToDoList () {
    head=current=previous=null;
  }
  //METHODS 
  public void addItem (String newData) {
    /* This method adds a new node at the end of the list (HINT: Look for 
     * first null element using a loop).  If the list is empty (thus head is null)
     * then it starts the list. 
     */
    ListNode newNode = new ListNode(newData, null);
    if (head == null) {//list is empty
      head = newNode;
      current = head;
      return;
    }
    ListNode temp = null;
    while(temp.link !=null) 
    {
      temp = temp.link;
    }
    temp.link = newNode;
  }
  public void showList () {
    // prints out the contents of the list line-by-line
    ListNode temp = head;
    System.out.println("Printing List");
    int elements = 0;
    while(temp !=null)
    {
      elements++;
      temp = temp.link;
    }
    temp = head;
    for(int i=1; i<=elements; i++) 
    {
      System.out.println(i+". "+temp.data);
      temp = temp.link;
    }
  }
  public String getDataAtCurrent () {
    // returns the data at the current node as long as the current isn’t null
    if (current != null) {
      return current.data;
    }
    return null;
  } 
  public void setDataAtCurrent (String aData) {
    /* takes in a parameter of type String and sets the data at the current
     * node to that value as long as current is not null
     */
    if (current != null) {
      current.data = aData;
    }
  }
  public void goToNext () {
    /* This moves the current node forward in the list by one node.  
     * It doesn’t move forward if that node is null
     */
    if (current != null) {
      previous = current;
      current = current.link;
    }
  }
  public void resetCurrent() 
  {
    current = head;
    previous = null;
  }
  public void insertAfterCurrent (String newData) {
    /* creates a new node based on data that is passed in by a parameter and puts
     * that node after the current position
     */
    ListNode newNode = new ListNode(newData, null);
    if(current != null)
    {
      newNode.link = current.link;
      current.link = newNode;
    }
    else if(head != null)
    {
      System.out.println("Current is outside of the linked list.");
    }
    else
    {
      System.out.println("The list was empty. Cannot complete operation.");
    }
  }
  public void deleteCurrentNode () {
    // removes the current node from the list by resetting the links
    if (current != null && previous != null)
    {
      previous.link = current.link;
      current = current.link;
    }
    else if (current != null && previous == null) //Current is the head
    {
      head = head.link;
      current = head;
    }
    else
      System.out.println("Cannot delete something that does not exist!");
  }
  public void goToPrev () {
    /* This moves the current node backwards in the list by one node.  
     * It does not move backwards if the current node is the head.
     */
    previous = current.link;
  }
  
}
