package model;

public class OldCar extends Car {
	private int actionDuration;

	public OldCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OldCar(String carName, int numberPlate, int yearOfManufacture, String brand, boolean insurance,
			int actionDuration) {
		super(carName, numberPlate, yearOfManufacture, brand, insurance);
		this.actionDuration = actionDuration;
	}

	@Override
	public void showCarInfo() {
		// TODO Auto-generated method stub
		System.out.println(getCarName()+" - "+getNumberPlate()+ " - "+getYearOfManufacture()+" - "+getBrand()+" - "+isInsurance()+" - "+actionDuration);

	}

}
