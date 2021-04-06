/**
 * Written by Christopher Walls.
 */
public class IntBSTreeDriver {
  
  private static int NUM_INSERTS = 10;
  private static int NUM_MIN = 0;
  private static int NUM_MAX = 20;
  //These are only used for secondary test.
  public static void main(String[] args) { 
    
    IntBSTree<Integer> intTree = new IntBSTree<Integer>();
    //JJ'S lab output example.
    System.out.println("Testing the tree");
    int[] nums ={7,9,18,0,8,13,2,10,16,6};
    //Inserting
    System.out.println("Inserting 10 numbers");
    for(int i=0; i<nums.length; i++)
    {
      System.out.println("Inserting "+nums[i]);
      intTree.insert(nums[i]);
    }
    //Printing pre-order traversal
    intTree.printPreorder();
    //Removing
    System.out.println("Removing the number 9");
    intTree.remove(9);
    intTree.printPreorder();
    //Depth
    intTree.getDepth(9);
    
    System.out.println("Done!");
    
    
    /*
     //Use to test random values
     System.out.println("Testing the tree");
     int fourthNum = 0;
     int sixthNum = 0;
     //Insert
     System.out.println("Inserting 10 numbers");
     for(int i=0; i<NUM_INSERTS; i++) {
     int num = (int)(Math.random() * (NUM_MAX-NUM_MIN)+NUM_MIN);
     if(i==3)//Grabs fourth number added to delete latter
     fourthNum = num;
     if(i==5)
     sixthNum = num;
     intTree.insert(num);
     System.out.println("Inserting " + num);
     }
     //Printing pre-order traversal
     System.out.println("Printing pre-order traversal");
     intTree.printPreorder();
     //Removing
     System.out.println("Removing the number " + fourthNum);
     intTree.remove(fourthNum);
     intTree.printPreorder();
     //Depth
     intTree.getDepth(sixthNum);
     */
  }
  
  /* ADD YOUR CODE HERE */
  
}
