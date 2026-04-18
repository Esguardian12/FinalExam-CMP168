package finalExam;

public class RecursionQuestion {
	
	public static int binarySearch(Car[] cars, Car c) {
		System.out.println("Looking for Car: " + c.toString());
		return binarySearchHelper(cars, c, 0 ,cars.length - 1);
	}
	
	private static int binarySearchHelper(Car[] cars, Car c, int s, int e) {
		if(s > e) {
			System.out.println("s = " + s + ", e = " + e);
			System.out.println("Not Found");
			return -1;
		}
		
		int mid = (s + e) / 2;
		System.out.println("s = " + s + ", e = " + e + ", mid = " + mid);
		
		int comparison = cars[mid].compareTo(c);
		
		if(comparison == 0) {
			System.out.println("FOUND at " + mid);
			return mid;
		}else if (comparison > 0) {
			System.out.println("go left");
			return binarySearchHelper(cars, c, s, mid - 1);
		}else {
			System.out.println("go right");
			return binarySearchHelper(cars, c ,mid + 1, e);
		}
		
	}

}
