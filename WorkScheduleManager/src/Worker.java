
public class Worker {
	private String name;
	private String job;
	private double wage;
	private double requestedTotalHours;
	private int ID;
	private int priority;
	private WorkerDay[] requestedDays;
	private WorkerDay[] actualDays;
	
	public Worker() {
		this.name = "Null";
		this.job = "Null";
		this.wage = 0.0;
		this.requestedTotalHours = 0.0;
		this.ID = 0;
		this.priority = 0;
	}
	
	public String getName() {
		return this.name;
	}
	public String getJob() {
		return this.job;
	}
	public double getWage() {
		return this.wage;
	}
	public double getRequestedTotalHours() {
		return this .requestedTotalHours;
	}
	public int getID() {
		return this.ID;
	}
	public WorkerDay[] getRequestedDays() {
		return this.requestedDays;
	}
	public WorkerDay[] getActualDays() {
		return this.actualDays;
	}
	public WorkerDay getSpecificDay(int index) {
		return this.actualDays[index];
	}
	public int getPriority() {
		return this.priority;
	}
	
	
	
	public void setName(String aName) {
		this.name = aName;
	}
	public void setJob(String aJob) {
		this.job = aJob;
	}
	public void setWage(double aWage) {
		this.wage = aWage;
	}
	public void setRequestedTotalHours(double aRequestedTotalHours) {
		this.requestedTotalHours = aRequestedTotalHours;
	}
	public void setID(int aID) {
		this.ID = aID;
	}
	public void setRequestedDays(WorkerDay[] aRequestedDays) {
		this.requestedDays = aRequestedDays;
	}
	public void setRequestedDay(WorkerDay aRequestedDay, int index) {
		this.requestedDays[index] = aRequestedDay;
	}
	public void setActualDays(WorkerDay[] aActualDays) {
		this.actualDays = aActualDays;
	}
	public void setActualDay(WorkerDay aActualDay, int index) {
		this.actualDays[index] = aActualDay;
	}
	public void setPriority(int aPriority) {
		this.priority = aPriority;
	}
	
	
	
	//misc functions
	public String toString() {
		return "Name: "+this.name +" | ID: "+this.ID+ " | Job: "+this.job;
	}
	public boolean doesWork(int index) {
		if (this.actualDays[index].getStartTime()==this.actualDays[index].getEndTime())
			return false;
		else
			return true;
	}
	public double getDayPay(int day) {
		return this.wage*day-(this.getSpecificDay(day).getEndTime()-this.getSpecificDay(day).getStartTime());
	}
}
