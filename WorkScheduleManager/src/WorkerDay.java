
public class WorkerDay {
	private int startTime;
	private int endTime;
	
	
	//initialization
	public WorkerDay() {
	    this.startTime = 0;
	    this.endTime = 0;
	}
	
	//accessors
	public int getStartTime() {
		return this.startTime;
	}
	public int getEndTime() {
		return this.endTime;
	}
	
	//mutators
	public void setStartTime(int aStartTime) {
		this.startTime = aStartTime;
	}
	public void setEndTime(int anEndTime) {
		this.endTime = anEndTime;
	}
	
	//misc functions
	public String toString() {
		return "Start: " + this.startTime + " | End: " + this.endTime;
	}
	
	public String getHours() {
		return convertTimeString(this.startTime) + " - " + convertTimeString(this.endTime);
	}
	
	public int convertTimeInt(String aTime) {
		int val1 = 0;
		int val2 = 0;
		for (int i=0; i<aTime.length()-1; i++) {
			if (aTime.substring(i,i+1).equals(":")) {
				val1 = Integer.parseInt(aTime.substring(0, i))*60;
				val2 = Integer.parseInt(aTime.substring(i+1));
				i = aTime.length();
			}
		}
		return val1 + val2;
	}
	
	public String convertTimeString(int aTime) {
		int val1 = aTime/60;
		int val2 = aTime%60;
		return val1+":"+val2;
	}
}
