package model;

public class MediumCar extends Car {
	private boolean havePowerSteering;

	public MediumCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MediumCar(String carName, int numberPlate, int yearOfManufacture, String brand, boolean insurance,
			boolean havePowerSteering) {
		super(carName, numberPlate, yearOfManufacture, brand, insurance);
		// TODO Auto-generated constructor stub
		this.havePowerSteering = havePowerSteering;
	}

	@Override
	public void showCarInfo() {
		// TODO Auto-generated method stub
		// super.showCarInfo();
		System.out.println(getCarName() + " - " + getNumberPlate() + " - " + getYearOfManufacture() + " - " + getBrand()
				+ " - " + isInsurance() + " - " + havePowerSteering);

	}

	public boolean isHavePowerSteering() {
		return havePowerSteering;
	}

	public void setHavePowerSteering(boolean havePowerSteering) {
		this.havePowerSteering = havePowerSteering;
	}

}
