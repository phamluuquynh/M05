package model;

public class Insurance {
	private String nameInsurance;
	private String typeInsurance;
	private boolean isBought;
	
	
	
	public boolean isBought() {
		return isBought;
	}
	public void setBought(boolean isBought) {
		this.isBought = isBought;
	}
	public String getNameInsurance() {
		return nameInsurance;
	}
	public void setNameInsurance(String nameInsurance) {
		this.nameInsurance = nameInsurance;
	}
	public String getTypeInsurance() {
		return typeInsurance;
	}
	public void setTypeInsurance(String typeInsurance) {
		this.typeInsurance = typeInsurance;
	}
	public Insurance() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Insurance(String nameInsurance, String typeInsurance, boolean isBought) {
		super();
		this.nameInsurance = nameInsurance;
		this.typeInsurance = typeInsurance;
		this.isBought = isBought;
	}

}
