package finalExam;

public class Person {
	
	String name;
	boolean hasDriverLicense;
	int age;
	int height;
	
//	public Person() {
//		
//	}
	
	public Person(String name, boolean hasDriverLicense, int age, int height) {
		this.name = name;
		this.hasDriverLicense = hasDriverLicense;
		this.age = age;
		this.height = height;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean hasDriverLicense() {
		return true;
	}
	
	public int getAge() {
		return age;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Person clone() {
		return new Person(this.name, this.hasDriverLicense, this.height, this.age);
	}
	
	public boolean equals(Object o) {
		if(o instanceof Person) {
			Person otherPerson = (Person)o;
			if(this.name.equals(otherPerson.name)) {
				if(this.hasDriverLicense == otherPerson.hasDriverLicense) {
					if(this.age == otherPerson.age) {
						if(this.height ==otherPerson.height) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	
	public String toString() {
		return String.format("Person [ name=%10s| age=%02d | height=%2d | has license/no license]",
				name, age, height, hasDriverLicense);
	}

}
