package model;

public class ModernCar extends Car {
	private boolean havePositioningDevice;

	public ModernCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ModernCar(String carName, int numberPlate, int yearOfManufacture, String brand, boolean insurance, boolean havePositioningDevice ) {
		super(carName, numberPlate, yearOfManufacture, brand, insurance);
		this.havePositioningDevice = havePositioningDevice;
	
	}

	@Override
	public void showCarInfo() {
		// TODO Auto-generated method stub
//		super.showCarInfo();
		System.out.println(getCarName()+" - "+getNumberPlate()+ " - "+getYearOfManufacture()+" - "+getBrand()+" - "+isInsurance()+" - "+havePositioningDevice);
	}

	public boolean isHavePositioningDevice() {
		return havePositioningDevice;
	}

	public void setHavePositioningDevice(boolean havePositioningDevice) {
		this.havePositioningDevice = havePositioningDevice;
		this.otherFeature = "Have Position Device: " + this.havePositioningDevice;
	}


}
