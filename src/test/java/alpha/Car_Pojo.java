package alpha;

public class Car_Pojo {
	
	String make;
	String model;
	int year;
	
	public Car_Pojo() {
		
	}
	
	public Car_Pojo(String make, String model, int year) {
		
		this.make = make;
		this.model = model;
		this.year = year;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String toString() {
		return "My car is a " + this.year + " " + this.make + " " + this.model;
	}
}