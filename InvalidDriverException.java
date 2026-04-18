package finalExam;

public class InvalidDriverException extends Exception{

	public InvalidDriverException() {
		System.out.println("Invalid Driver:");
	}
	
	public InvalidDriverException(String message) {
		System.out.println("Invalid Driver: " + message);
	}
}
