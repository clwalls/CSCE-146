/**
 * Written by Christopher Walls. 
 */
public class GenCircularLinkedListDriver {
  
  public static void main(String[] args) { 
    
    GenCircularLinkedList<String> strList = new GenCircularLinkedList<String>();
    
    strList.insert("Helo i am number 1");
    strList.insertNodeAfterCurrent("number 2");
    strList.goToNext();
    strList.insertNodeAfterCurrent("number 3");
    strList.goToNext();
    strList.insertNodeAfterCurrent("number 4");
    strList.goToNext();
    strList.insertNodeAfterCurrent("number 5");
    strList.goToNext();
    strList.showList();
    
    if (strList.getDataAtCurrent().equals("number 5")) {
      strList.setDataAtCurrent("yo i am number 5");
    }
    System.out.println("is 'number 6' in list? " + strList.inList("number 6"));
    System.out.println("is 'number 3' in list? " + strList.inList("number 3"));
    strList.showList();
    strList.goToNext();
    System.out.println("hmm does moving out of list return to head? lets see what this returns!: "
                         + strList.getDataAtCurrent());
    System.out.println("does goToprev work?");
    strList.goToPrev();
    System.out.println(strList.getDataAtCurrent());
    strList.goToNext();
    System.out.println(strList.getDataAtCurrent());
    strList.goToNext();
    System.out.println(strList.getDataAtCurrent());
    System.out.println("what if i insert at the end of the list?");
    strList.insert("number 6?");
    strList.showList();
    
  }
  
  
  /* ADD YOUR CODE HERE */
  
}
