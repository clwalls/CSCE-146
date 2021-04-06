/**
 * Written by Christopher Walls.
 */
public class ProcessScheduler {
  
  LinkedListQueue<Process> processes = new LinkedListQueue<Process>();
  Process currentProcess;
  
  public Process getCurrentProcess() {
    /*  This method takes no parameters and returns the currently running process. 
     * Note that this is not the first element of the process queue.
     */
    return currentProcess;
  }
  public void addProcess(Process aProcess) {//good
    /*  Taking in a process via a parameter it either sets the current process if 
     * the current process is null or it adds it to the process queue. Also it doesn’t 
     * return any values.
     */
    if(currentProcess==null) {
      currentProcess = aProcess;
      return;
    }
    processes.enqueue(aProcess);
  }
  public void runNextProcess() {
    //This method dequeues from the process queue and sets that to the current process.
    currentProcess = processes.dequeue();
    //sets current to first in queue and takes it out of queue
  }
  public void cancelCurrentProcess() {//CHECK IF THIS IS RIGHT
    /* The current process is cancelled and is replaced by the first element on the 
     * process queue. Make sure that the process is also removed from the process
     * queue after the current process has been set. Neither parameters nor return 
     * values are expected for this method.
     */
    currentProcess = null;
    currentProcess = processes.dequeue();
  }
  public void printProcessQueue() {
    //This method should print all of the elements from the process queue.
    processes.print();
  }
}
