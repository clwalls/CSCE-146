/**
 * Written by Christopher Walls.
 */
public class Process {
  
  private String name;
  private double completionTime;
  public Process() { 
    this.name = "Name not set";
    this.completionTime = -0.1;
  }
    public Process(String aName, double aTime) { 
     setName(aName);
    setCompletionTime(aTime);
  }
    //Accessors
    public String getName() {
      return name;
    }
    public double getCompletionTime() {
      return completionTime;
    }
    //Mutators
    public void setName(String aName) {
      if(aName==null) 
        return;
      name = aName;
    }
    public void setCompletionTime(double aTime) {
      if(aTime<0.0) 
        completionTime = 0.0;
      completionTime = aTime;
    }
    //Methods
    public String toString() {
      return "Process's Name: " +getName()+" Completion Time: " +getCompletionTime();
    }
  /* ADD YOUR CODE HERE */
  
}
