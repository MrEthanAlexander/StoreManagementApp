
public class StoreDay extends WorkerDay {
	private int minWorkers;
	private int maxWorkers;
	private double minIncomeNeeded;
	private double storeRunningCosts;
	
	
	//initialization
	public StoreDay() {
		super();
		this.minWorkers = 0;
		this.maxWorkers = 0;
		this.minIncomeNeeded = 0.0;
		this.storeRunningCosts = 0.0;
	}
	
	
	//accessors
	public int getMinWorkers() {
		return this.minWorkers;
	}
	public int getMaxWorkers() {
		return this.maxWorkers;
	}
	public double getMinIncomeNeeded() {
		return this.minIncomeNeeded;
	}
	public double getStoreRunningCosts() {
		return this.storeRunningCosts;
	}
	
	
	//mutators
	public void setMinWorkers(int aMinWorkers) {
		this.minWorkers = aMinWorkers;
	}
	public void setMaxWorkers(int aMaxWorkers) {
		this.maxWorkers = aMaxWorkers;
	}
	public void setMinIncomeNeeded(double aMinIncomeNeeded) {
		this.minIncomeNeeded = aMinIncomeNeeded;
	}
	public void setStoreRunningCosts(double aStoreRunningCost) {
		this.storeRunningCosts = aStoreRunningCost;
	}
}
