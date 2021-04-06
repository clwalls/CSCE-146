/**
 * Written by Christopher Walls.
 */
public class Player {
  //INSTANCE VARIABLES
  private int name;
  private int wins;
  private int ties;
  private int losses;
  //CONSTRUCTORS
  public Player() { 
    this.name = 0;
    this.wins = 0;
    this.ties = 0;
    this.losses = 0;
  }
    public Player(int aName, int aWins, int aTies, int aLosses) { 
    setName(aName);
    setWins(aWins);
    setTies(aTies);
    setLosses(aLosses);
  }
    //SETTERS/MUTATORS
    public void setName (int aName) { //Names 0-4
      if (aName < 0 )
        return;
      this.name = aName;
    }
    public void setWins (int aWins) {
      if (aWins < 0 )
        return;
      this.wins = aWins;
    }
    public void setTies (int aTies) {
      if (aTies < 0 )
        return;
      this.ties = aTies;
    }
    public void setLosses (int aLosses) {
      if (aLosses < 0 )
        return;
      this.losses = aLosses;
    }
    //GETTERS/ACCESSORS
    public int getName() {
      return name;
    }
    public int getWins() {
      return wins;
    }
    public int getTies() {
      return ties;
    }
    public int getLosses() {
      return losses;
    }
    //METHODS
    public String toString() {
      return "Name " + getName() + " Wins " + getWins() + " Ties " + getTies() + " Losses " + getLosses();
    }
  /* ADD YOUR CODE HERE */
  
}
