/**
 * Auto Generated Java Class.
 */
import java.util.*;
public class TacoTreeTester {
  
  
  public static void main(String[] args) { 
    LinkedBSTree<Taco> tacoTree = new LinkedBSTree<Taco>();
    Random r = new Random();
    for(int i=0; i<10; i++)
      tacoTree.insert(new Taco(r.nextDouble()));
    tacoTree.printInOrder();
  }
  
  /* ADD YOUR CODE HERE */
  
}
