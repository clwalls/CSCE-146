//Written by Nicholas Heater
public class Process implements Comparable<Process> {
	private int priority;
	private String name;
	private double time;

	public Process() {
		priority = -1;
		name = "No name";
		time = 0.0;
	}

	public Process(String name, int priority, double time) {
		this.priority = priority;
		this.name = name;
		this.time = time;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		if (priority > 0)
			this.priority = priority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		if (time > 0) {
			this.time = time;
		} else
			this.time = 0.0;
	}

	public String toString() {
		return ("Process Name: " + name + " Completion Time: " + time + " Priority: " + priority);
	}

	public int compareTo(Process o) {
		if (this.priority > o.getPriority())
			return 1;
		else if (this.priority < o.getPriority())
			return -1;
		else
			return 0;
	}

}
