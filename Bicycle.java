package finalExam;

public class Bicycle extends Vehicle implements Comparable<Bicycle>{
	
	private double weight;
	
	private static final double ACCURACY_RANGE = 0.5;
	
	public Bicycle() {
		super(1, 1);
		this.weight = 0;
	}
	
	public Bicycle(Person driver) {
		super(driver, new int[] {1});
		this.weight = 0;
	}
	
	public Bicycle(Person driver, double weight) {
		super(driver, new int[] {1});
		this.weight = (weight < 0) ? 0 : weight;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Bicycle) {
			Bicycle otherBicycle = (Bicycle)o;
			return Math.abs(this.weight - otherBicycle.weight) <= 0.5;
		}
		return false;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public void setDriver(Person p) throws InvalidDriverException{
		if(p.getAge() < 3) {
			throw new InvalidDriverException("Peron is too young to drive.");
		}else {
			super.setDriver(p);
		}
	}
	
	@Override
	public String toString() {
	     String s = "Bicycle [rider = " + getDriver().getName() + "| weight = " + weight + " ]";
	     
	     return s;
	}
	
	@Override
	public int compareTo(Bicycle b) {
		if(this.weight - b.weight < -ACCURACY_RANGE) return -1;
		if(this.weight - b.weight > ACCURACY_RANGE) return 1;
		return 0;
	}

	@Override
	public boolean loadPassenger(Person p) {
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		return 0;
	}
	

}
