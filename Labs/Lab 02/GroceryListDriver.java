/**
 * Written by Christopher Walls.
 */
public class GroceryListDriver {
  
  
  public static void main(String[] args) { 
    System.out.println("To Do List Tester!");
    System.out.println("Adding Five Tasks To do");
    ToDoList list = new ToDoList();
    //Populates List
    list.addItem("Buy Ground Beef");
    list.insertAfterCurrent("Buy Cheese");
    list.goToNext();
    list.insertAfterCurrent("Buy Taco Shells");
    list.goToNext();
    list.insertAfterCurrent("Make Tacos");
    list.goToNext();
    list.insertAfterCurrent("Eat Tacos");
    list.showList();
    //Adds salsa to list after step 2
    System.out.println("I forgot to get salsa. Let me add that after step 2.");
    list.resetCurrent();
    list.goToNext();
    list.insertAfterCurrent("Buy Salsa");
    list.showList();
    //Chances salsa to hotsauce at step 3.
    System.out.println("On second thought I'm in a spicy mood so let's chance salsa to hot sauce.");
    list.goToNext();
    list.setDataAtCurrent("Buy Hot Sauce");
    list.showList();
    //Adds guacamole after step 3.
    System.out.println("Do people put guacamole on tacos? I'll add it after step 3.");
    list.insertAfterCurrent("Buy Guacamole");
    list.showList();
    //Removes guacamole at step 4.
    System.out.println("On second thought I don't think they do let me take that out.");
    list.goToNext();
    list.deleteCurrentNode();
    list.showList();
    
    System.out.println("Now I have tested the perfect taco related list!");
  }
  
  /* ADD YOUR CODE HERE */
  
}
