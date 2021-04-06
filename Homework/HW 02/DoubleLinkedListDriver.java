/**
 * Written by Christopher Walls.
 */
public class DoubleLinkedListDriver {
  
  
  public static void main(String[] args) { 
    
    GenDoubleLinkedList<String> strList = new GenDoubleLinkedList<String>();
    GenDoubleLinkedList<Integer> intList = new GenDoubleLinkedList<Integer>();
    
    intList.insert(1);
    for (int i=2; i<=6; i++)
    {
      intList.insertNodeAfterCurrent(i);
      intList.goToNext();
    }
    intList.showList();
    System.out.println();
    
    if(intList.inList(2)) {
      System.out.println("2 was found in the list");
    }
    intList.resetCurrent();
    System.out.println("This is Computer Science! Don't we start counting at 0 for no reason?");
    if (intList.getDataAtCurrent().equals(1)) {
      intList.setDataAtCurrent(0);
    }
    intList.goToNext();
    intList.goToNext();
    intList.showList();
    System.out.println();
    
    System.out.println();
    
    strList.insert("1, 2, 3 - Monopoly");
    strList.insertNodeAfterCurrent("With high price, low quantity");
    strList.goToNext();
    strList.insertNodeAfterCurrent("Get low, get low, get low get low!");
    strList.goToNext();
    strList.insertNodeAfterCurrent("To the window, to the wall!");
    strList.goToNext();
    strList.insertNodeAfterCurrent("I get 10 times what you earn");
    strList.goToNext();
    strList.insertNodeAfterCurrent("All you other firms can learn.");
    strList.showList();
    
    System.out.println("\nUhh that looks a little off, are you sure this is Lil Jon?" +
                       "\nOh sorry, must've been corrupted with some kid's high school project, try this out!\n");
    strList.resetCurrent();
    
    strList.setDataAtCurrent("3, 6, 9 - damn she fine");
    strList.goToNext();
    if (strList.getDataAtCurrent().equals("With high price, low quantity")) {
      strList.setDataAtCurrent("Hoping she can sock it to me one more time");
    }
    strList.goToNext();
    strList.goToNext();
    strList.goToNext();
    strList.setDataAtCurrent("Til the sweat drop down my b*lls");
    strList.goToNext();
    strList.setDataAtCurrent("Til all these b*tches crawl");
    strList.showList();
    System.out.println("Is 'Till the sweat drop down my b*lls' in the list?: " +
                       strList.inList("Til the sweat drop down my b*lls"));
    System.out.println();
    strList.goToPrev();
    strList.deleteCurrentNode(strList.getDataAtCurrent());
    strList.showList();
    
    System.out.println();
    strList.resetCurrent();
    strList.goToNext();
    strList.goToNext();
    strList.goToNext();
    strList.goToNext();
    strList.setDataAtCurrent("WELL ITS NOT HERE ANYMORE");
    strList.showList();
  }
  
  /* ADD YOUR CODE HERE */
  
}
