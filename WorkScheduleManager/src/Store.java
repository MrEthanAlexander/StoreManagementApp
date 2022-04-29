import java.io.Serializable;
import java.util.LinkedList;
public class Store implements Serializable {
	
	private String name;
	private LinkedList<Worker> workers;
	private StoreDay[] schedule = new StoreDay[7];
	
	public Store() {
		this.name = "";
		this.workers = null;
	}
		
	//getters
	public String getName() {
		return this.name;
	}
	public LinkedList<Worker> getWorkers() {
		return this.workers;
	}
	public Worker getWorker(int aID) {
		for(int i=0; i<workers.size()-1; i++)
			if (workers.get(i).getID() == aID)
				return workers.get(i);
		return null;
	}
	public StoreDay[] getSchedule() {
		return this.schedule;
	}
	public StoreDay getStoreDay(int aIndex) {
		return this.schedule[aIndex];
	}
	
	//setters
	public void setName(String aName) {
		this.name = aName;
	}
	public void addWorker(Worker aWorker) {
		this.workers.add(aWorker);
	}
	public void removeWorker(int aID) {
		for(int i=0; i<workers.size()-1; i++)
			if (workers.get(i).getID() == aID)
				workers.remove(i);
	}
	
	//misc functions
	public String workersToString() {
		String ret = "";
		for (int i=0; i<workers.size()-1; i++) {
			ret = ret+workers.get(i).toString();
			if (i<workers.size()-1)
				ret = ret+"\n";
		}
		return ret;
	}
	
	public String scheduleToString() {
		String ret = "";
		for (int i=0; i<schedule.length-1; i++) {
			ret = ret + schedule[i].toString();
			if (i<schedule.length-1)
				ret = ret+"\n";
		}
		return ret;
	}

	
	public double calculateDayCost(int index) {
		double ret = schedule[index].getStoreRunningCosts();
		for (int i=0;i<workers.size()-1;i++)
			ret=ret + workers.get(index).getDayPay(index);
		return ret;
	}
	
	public int calculateMaxWorkers(int index) {
		int comparison = 0;
		int current = 0;
		
		for (int i=schedule[index].getStartTime(); i<schedule[index].getEndTime(); i++) {
			for (int j=0;j<workers.size()-1; j++) {
				
				if(workers.get(j).getSpecificDay(index).getStartTime()==i)
					current++;
				if(workers.get(j).getSpecificDay(index).getEndTime()==i)
					current--;
			}
			if(current > comparison)
				comparison=current;
		}
		return comparison;
	}
	
	public int calculateMinWorkers(int index) {
		int comparison = 0;
		int current = 0;
		
		for (int i=schedule[index].getStartTime(); i<schedule[index].getEndTime(); i++) {
			for (int j=0;j<workers.size()-1; j++) {
				
				if(workers.get(j).getSpecificDay(index).getStartTime()==i)
					current++;
				if(workers.get(j).getSpecificDay(index).getEndTime()==i)
					current--;
			}
			if(current < comparison || comparison==0)
				comparison=current;
		}
		return comparison;
	}
	
	public void printWeekSchedule() {
		for (int i=0; i<schedule.length-1; i++) {
			printDaySchedule(i);
			if (i<schedule.length-1)
				System.out.println();
		}
	}
	
	public void printDaySchedule(int i) {
		System.out.println(getDayString(i)+"'s Schedule for " + name);
		System.out.println("Opening - "+schedule[i].getHours()+" - Closing");
		System.out.println("Minimum Workers on Shift: "+calculateMinWorkers(i));
		System.out.println("Maximum Workers on Shift: "+calculateMaxWorkers(i)+"\n");
		for (int j=0; j<workers.size(); j++) {
			if(workers.get(j).doesWork(i))
				System.out.println(workers.get(j).toString()+
						workers.get(j).getSpecificDay(i).getHours()+"\n");
		}
	}
	
	
	public String getDayString(int index) {
		if (index==0)
			return "Sunday";
		else if (index==1)
			return "Monday";
		else if (index==2)
			return "Tuesday";
		else if (index==3)
			return "Wednesday";
		else if (index==4)
			return "Thursday";
		else if (index==5)
			return "Friday";
		else
			return "Saturday";
	}
	public int getDayIndex(String aDay) {
		if (aDay.equals("sunday"))
			return 0;
		else if(aDay.equals("nonday"))
			return 1;
		else if(aDay.equals("tuesday"))
			return 2;
		else if(aDay.equals("wednesday"))
			return 3;
		else if(aDay.equals("thursday"))
			return 4;
		else if(aDay.equals("friday"))
			return 5;
		else
			return 6;
	}
}
