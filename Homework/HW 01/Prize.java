/**
 * Written by Christopher Walls.
 */
public class Prize {
  //INSTANCE VARIABLES
  private String name = "";
  private int price = 0;
  //CONSTRUCTORS
  public Prize () {
    this.name = "Name not set!";
    this.price = -1;
  }
  public Prize (String aName, int aPrice) {
    this.setName(aName);
    this.setPrice(aPrice);
  }
  //ACCESSORS/GETTERS
  public String getName() {
    return this.name;
  }
  public int getPrice() {
    return this.price;
  }
  //MUTATORS/SETTERS
  public void setName(String aName) {
    if (aName!=null) {
      this.name = aName;
    }
  }
  public void setPrice(int aPrice) {
    if (aPrice>0) {
      this.price = aPrice;
    }
  }
  //METHODS
  public String toString() {
    return "Name: " + this.name + " Price: " + this.price;
  }
  public Boolean equals(Prize aPrize) {
    return aPrize != null && this.name.equals(aPrize.getName()) && this.price==(aPrize.getPrice());
  }
  
  
  
  /* ADD YOUR CODE HERE */
  
}
