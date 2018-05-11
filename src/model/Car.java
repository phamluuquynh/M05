package model;

public class Car {
	private String carName;
	private int numberPlate;
	private int yearOfManufacture;
	private String brand;
	private boolean insurance;
	protected String otherFeature;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String carName,int numberPlate, int yearOfManufacture, String brand, boolean insurance) {
		super();
		this.carName = carName;
		this.numberPlate = numberPlate;
		this.yearOfManufacture = yearOfManufacture;
		this.brand = brand;
		this.insurance = insurance;
	}

	
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(int numberPlate) {
		this.numberPlate = numberPlate;
	}

	public int getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(boolean insurance) {
		this.insurance = insurance;
	}
	
	public void showCarInfo() {
		System.out.println(carName+" - "+numberPlate+ " - "+yearOfManufacture+" - "+brand+" - "+insurance);
	}

	public String getOtherFeature() {
		return otherFeature;
	}
	

}
