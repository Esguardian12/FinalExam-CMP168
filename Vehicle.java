package finalExam;

public abstract class Vehicle {
	
	private Person[][] personsOnBoard;
	private int numberOfRows;
	private int maxSeatsPerRow;
	private int [] numSeatsPerRow;

	public Vehicle() {
		
	}
	
	public Vehicle(int numRows, int numSeatsPerRow) {
		this.numberOfRows = numRows;
	}
	
	public Vehicle(int[] numSeatsPerRow) {
		this.numSeatsPerRow = numSeatsPerRow;
	}
	
	public Vehicle(Person driver, int [] numSeatsPerRow) {
		this(numSeatsPerRow);  //calls constructor
		
		if(driver.hasDriverLicense()) {
			personsOnBoard[0][0] = driver;
		}else {
			throw new IllegalArgumentException("Specified driver does not have a driver's license.");
		}
	}
	
	public abstract boolean loadPassenger(Person p);
	
	public abstract int loadPassengers(Person [] peeps);
	
	public void setDriver(Person p) throws InvalidDriverException {
		if(p.hasDriverLicense()) {
			personsOnBoard[0][0] = p;
		}else {
			throw new InvalidDriverException("Person doesn't have a drivere license.");
		}
	}
	
	public Person getDriver() {
		return personsOnBoard[0][0];
	}
	
	public boolean hasDriver() {
		return personsOnBoard[0][0] != null;
	}
	
	public int getNumberOfAvailableSeats() {
		int numberOfAvailableSeats = 0;
		for(int row = 0; row < personsOnBoard.length; row++) {
			for(int col = 0; col < personsOnBoard[row].length; col++) {
				if(personsOnBoard[row][col] == null) {
					numberOfAvailableSeats++;
				}
			}
		}
		return numberOfAvailableSeats;
	}
	
	
	public int getNumberOfAvailableSeatsInRow(int row) {
		//check if the specified row is invalid
		if(row < 0 || row >= numberOfRows) {
			return -1;
		}
		
		int numberOfAvailableSeatsInRow = 0;
		for(int col = 0; col < numSeatsPerRow[row]; col++) {
			if(personsOnBoard[row][col] == null) {
				numberOfAvailableSeatsInRow++;
			}
		}
		return numberOfAvailableSeatsInRow;
	}
	
	public int getNumberOfPeopleOnBoard() {
		int numberOfPeopleOnBoard = 0;
		for(int row = 0; row < personsOnBoard.length; row++) {
			for(int col = 0; col < personsOnBoard[row].length; col++) {
				if(personsOnBoard[row][col] != null) {
					numberOfPeopleOnBoard++;
				}
			}
		}
		return numberOfPeopleOnBoard;
	}
	
	
	public int getNumberOfPeopleInRow(int row) {
		if(row < 0 || row >= numberOfRows ) {
			return -1;
		}
		
		int numberOfPeopleInRow = 0;
		for(int col = 0; col < maxSeatsPerRow; col++) {
			if(personsOnBoard[row][col] != null) {
				numberOfPeopleInRow++;
			}
			
		}
		return numberOfPeopleInRow;
	}
	
	public Person getPersonInSeat(int row, int col) {
		//Check if the specified row or col is invalid
		if(row < 0 || row >= numberOfRows || col < 0 || col >= maxSeatsPerRow) {
			return null;
		}
		return personsOnBoard[row][col];
	}
	
	public int[] getLocationOfPersonInVehicle(Person p) {
		for(int row = 0; row < numberOfRows; row++) {
			for(int seatColumn = 0; seatColumn < maxSeatsPerRow; seatColumn++) {
				if(personsOnBoard[row][seatColumn] == p) {
					return new int[] {row, seatColumn};
				}
			}
		}
		return new int[] {-1, -1};
	}
	
	
	public Person[] getPeopleInRow(int row) {
		//Check if the specified row is invalid
		if(row < 0 || row >= numberOfRows) {
			return null;
		}
		
		//First, count how many people are in the row
		int count = 0;
		for(int col = 0; col < maxSeatsPerRow; col++) {
			if(personsOnBoard[row][col] != null) {
				count ++;
			}
		}
		
		//If no one is in the row, return null
		if(count == 0) {
			return null;
		}
		
		//Populate the Person array with clones of people in the row
		Person[] peopleInRow = new Person[count];
		int index = 0;
		for(int col = 0; col < maxSeatsPerRow; col++) {
			if(personsOnBoard[row][col] != null) {
				peopleInRow[index] = (Person) personsOnBoard[row][col].clone();
				index++;
			}
		}
		return peopleInRow;
	}
	
	public Person[][] getPeopleOnBoard(){
		Person[][] clone = new Person[numberOfRows][];
		
		for(int row = 0; row < numberOfRows; row++) {
			clone[row] = new Person[maxSeatsPerRow];
			for(int col = 0; col < maxSeatsPerRow; col++) {
				if(personsOnBoard[row][col] != null) {
					clone[row][col] = (Person) personsOnBoard[row][col].clone();
				}
			}
		}
		return clone;
	}
	
	public boolean isPersonVehicle(Person p) {
		for(int row = 0; row < numberOfRows; row++) {
			for(int col = 0; col < maxSeatsPerRow; col++) {
				if(personsOnBoard[row][col] == p) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isPersonDriver(Person p) {
		return personsOnBoard[0][0] == p;
		
	}	
	
	
	
	
}
