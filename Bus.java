package finalExam;

public class Bus extends Car{
	
	public Bus(int [] numSeatsPerRow) {
		super(2,(2 * numSeatsPerRow.length) - 1, buildSeatsPerRow(numSeatsPerRow));
	}
	
	public Bus(Person driver, int [] numSeatsPerRow) {
		super(2,(2* numSeatsPerRow.length) - 1, driver, buildSeatsPerRow(numSeatsPerRow));
	}
	
	private static int[] buildSeatsPerRow(int [] numSeatsPerRow) {
		int[] busSeats = new int[numSeatsPerRow.length];
		busSeats[0] = 1;  //first row is always the (driver)
		for(int i = 1; i < numSeatsPerRow.length; i++) {
			busSeats[i] = numSeatsPerRow[i];
		}
		return busSeats;
	}
	
	@Override
    public boolean canOpenDoor(Person p) {
		if(p.getAge() <= 5 || p.getHeight() <= 40) 
			return false;
		
		if(isPersonDriver(p))
			return true;
		
		//find last populated row
		int numberOfRows = getPeopleOnBoard().length;
		int lastPopulatedRow = -1;
		
		for(int row = numberOfRows - 1; row >= 0; row--) {
			if(getNumberOfPeopleInRow(row) > 0) {
				lastPopulatedRow = row;
				break;
			}
		}
		
		if(lastPopulatedRow == -1)
			return false;
		
		int [] location = getLocationOfPersonInVehicle(p);
		return location[0] == lastPopulatedRow;
	}
	
	@Override
	public boolean canOpenWindow(Person p) {
		return super.canOpenWindow(p) && p.getAge() > 5;
	}
	
	@Override
	public String toString() {
		return "Bus is an extension of " + super.toString();
	}
	
	@Override
	public boolean loadPassenger(Person p) {
		int numberOfRows = getPeopleOnBoard().length;
		for(int row = 0; row < numberOfRows; row++) {
			int seatsInRow = getNumberOfPeopleInRow(row) + getNumberOfAvailableSeatsInRow(row);
			for(int col = 0; col < seatsInRow; col++) {
				if(getPersonInSeat(row, col) == null) {
					//seat is available
					return true;  //confirm with professor how to assign seat
				}
			}
		}
		return false;
	}
	
	@Override
	public int loadPassengers(Person[] peeps) {
		int count = 0;
		for(Person p : peeps) {
			if(loadPassenger(p)) {
				count++;
			}
		}
		return count;
	}
	
	
}
