/**
 * Written by Christopher Walls. 
 */
public class GenCircularLinkedList <T> {
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
  public GenCircularLinkedList() {
    head=current=previous=tail=null;
  }
  //METHODS
  public void goToNext() {
    if (head != null) {
    /*if (current.link == null) {
     tail = head;
     current.link = tail;
     } */
    if (current.link == null) {
      current.link = head;
      current = current.link;
    }
    previous = current;
    current = current.link;
    }
  }
  public void goToPrev() {
   /* if (current == tail.link) {
      current = head;
    } */
    if (current == head) {
      current = tail.link;
    }
    if(current != head) {
      if (previous == head) {
        current = previous;
        previous = tail;
      }
      else {
        ListNode temp = head;
        while (temp.link != previous) 
        {
          temp = temp.link;
        }
        previous = temp;
        current = previous.link;
      }
    } 
  }
  public T getDataAtCurrent() {
    if (current != null)
      return current.data;
    else
      return null;
  }
  public void setDataAtCurrent(T aData) {
    if (current != null)
      current.data = aData;
  }
  public void insert(T aData) {
    //Inserts at the end of the list
    ListNode newNode = new ListNode(aData, null);
    if (head == null) //list is empty
    {
      head = newNode;
      //tail = tail.link;
      current = head;
      return;
    }
    //list not empty
    ListNode temp = head;
    while (newNode != null) 
    {
      temp = temp.link;
    }
    temp.link = newNode; 
    tail = newNode;
    tail.link = head;
    /*for circular
     newNode = head;
     tail.link = newNode;
     tail = tail.link;
     */
    /* if (current == null) {
     current = newNode;
     tail = newNode;
     newNode.link = newNode; //tail.link = current
     }
     else {
     tail.link = newNode; // tail.link = current
     newNode.link = current;
     current = newNode; //tail is unchanged, newNode is current
     } */
  }
  public void insertNodeAfterCurrent(T aData) {
    ListNode newNode = new ListNode(aData, null);
    if (current != head && current != tail) {
      newNode.link = current.link;
      current.link = newNode;
    }
    if (current == head) {
      newNode.link = head.link;
      head.link = newNode;
    }
    if (current == tail) {
      newNode.link = tail.link;
      tail.link = head;
      head = newNode;
    } 
    /*   if (current == null) {
     newNode.link = newNode;
     current = newNode;
     } */
    else if (head != null) {
      System.out.println("Current is outside of the list."); 
    } 
    /*  else {
     newNode.link = current.link;
     current.link = newNode;
     } */
  }
  public void deleteCurrentNode() {
    if (current != null && previous != null) {
      previous.link = current.link;
      current = current.link;
    }
    else if (current != null && previous == null) {//current is the head, previous should be tail
      head = head.link;
      current = head;
    }
    //ADD TWO MORE CASES
    //if head 
    //if tail
  }
  public void showList() {
    // prints out the contents of the list line-by-line
    ListNode temp = head;
    while(temp !=null)
    {
      System.out.println(temp.data);
      temp = temp.link;
    }
  }
  public boolean inList(T aData) {
    ListNode temp = head;
    while (temp != null)
    {
      if (temp.data.equals(aData) || temp.data == aData) {
        return true;
      }
      temp = temp.link;
    }
    return false; 
  }
  //extra methods
  public void resetCurrent() {
    current = head;
    previous = null;
  }
  public boolean moreToIterate() {
    return current != null;
  }
  
  
  
}
