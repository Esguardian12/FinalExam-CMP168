package finalExam;

public class Car extends Vehicle implements Comparable<Car>, Annoucements{

	private int numDoors;
	private int numWindows;
	
	public Car() {
		
	}
	
	public Car(int numDoors, int numWindows) {
		super(new int[] {2, 2});
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	
	public Car(int numDoors, int numWindows, int numSeatsPerRow) {
		super(new int[] {numSeatsPerRow, numSeatsPerRow});
		this.numDoors = numDoors;
		this.numWindows = numWindows;
		
	}
	
	public Car(int numDoors, int numWindows, int[] numSeatsPerRow) {
		super(numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	
	public Car(int numDoors, int numWindows, Person driver, int[] numSeatsPerRow) {
		super(driver, numSeatsPerRow);
		this.numDoors = numDoors;
		this.numWindows = numWindows;
	}
	
	public boolean canOpenDoor(Person p) {
		int[] location = getLocationOfPersonInVehicle(p);
		int row = location[0];
		int col = location[1];
		
		if(row == -1 || col == -1) {
			return false;  //person not in vehicle
		}
		
		if(row >= numDoors) {
			return false;
		}
		
		int seatsInRow = getNumberOfPeopleInRow(row) + getNumberOfAvailableSeatsInRow(row); //exterior seats: 0 or last
		int lastIndex = seatsInRow - 1;
		return (col == 0 || col == lastIndex) && p.getAge() > 5;
	}
	
	public boolean canOpenWindow(Person p) {
		int[] location = getLocationOfPersonInVehicle(p);
		int row = location[0];
		int col = location[1];
		
		if(row == -1 || col == -1) {
			return false;
		}
		
		if(row >= numWindows / 2) {
			return false;
		}
		
		int seatsInRow = getNumberOfPeopleInRow(row) + getNumberOfAvailableSeatsInRow(row);
		int lastIndex = seatsInRow -1;
		return(col == 0 || col == lastIndex) && p.getAge() > 2;
	}
	
	public int getNumDoors() {
		return numDoors;
	}
	
	public int getNumWindows() {
		return numWindows;
	}
	
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	
	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Car) {
			Car otherCar = (Car)o;
			if(this.numDoors == otherCar.numDoors) {
				if(this.numWindows == otherCar.numWindows) {
						for(int row = 0; row < this.numDoors; row++) {
							int thisSeatsInRow = this.getNumberOfPeopleInRow(row) + this.getNumberOfAvailableSeatsInRow(row);
							int otherSeatsInRow = otherCar.getNumberOfPeopleInRow(row) + otherCar.getNumberOfAvailableSeatsInRow(row);
							if(thisSeatsInRow != otherSeatsInRow)
								return false;//mismatch found
						}
						return true;//all rows matched
			      }
		      }
	      }
		return false;
	 }
	
	public String toString() {
		int numberOfRows = getPeopleOnBoard().length;
		
		//Build seats per row string [val1, val2, val3]
		String seatsPerRow = "[";
		for(int row = 0; row < numberOfRows; row++) {
			int seatsInRow = getNumberOfPeopleInRow(row) + getNumberOfAvailableSeatsInRow(row);
			seatsPerRow += seatsInRow;
			if(row < numberOfRows - 1) seatsPerRow += ", ";
		}
		seatsPerRow += "]";
		
		//Build names string separated by commas, no trailing comma
		String names = "";
		boolean first = true;
		for(int row = 0; row < numberOfRows; row++) {
			int seatsInRow = getNumberOfPeopleInRow(row) + getNumberOfAvailableSeatsInRow(row);
			for(int col = 0; col < seatsInRow; col++) {
				Person p  = getPersonInSeat(row, col);
				if(p != null) {
					if(!first) names += ", ";
					names += p.getName();
					first = false;
				}
			}
		}
		
		return String.format("Car: number of doors= %02d | number of windows = %02d | number of rows= %02d | seats per row= %s | names of people on board= %s\\n",
				numDoors, numWindows, numberOfRows, seatsPerRow, names);
				
	}
	
	public int compareTo(Car c) {
		int TotalSeats = this.getNumberOfPeopleOnBoard() + this.getNumberOfAvailableSeats();
		int otherTotalSeats = c.getNumberOfPeopleOnBoard() + c.getNumberOfAvailableSeats();
		
		if(TotalSeats < otherTotalSeats) return -1;
		if(TotalSeats > otherTotalSeats) return 1;
		return 0;
	}

	@Override
	public String departure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String arrival() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String doNotDisturbTheDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean loadPassenger(Person p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int loadPassengers(Person[] peeps) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
