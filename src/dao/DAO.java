package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Car;
import model.MediumCar;
import model.ModernCar;
import model.OldCar;

public class DAO {
	public static final String user = "c##ex7_car";
	public static final String password = "1234";
	public static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	public Connection connection;

	public Connection getConnectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// closeConnect();
		}
		return connection;

	}

	public void closeConnect() {

		if (connection != null) {
			try {
				System.out.println("Have a connect");
				connection.close();
				connection = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void insertCar(String name, int numberPlate, int yearOfM, String brand, String position, String steering,
			int duration) {
		String sql = "INSERT INTO CAR VALUES (?,?,?,?,?,?,?)";
		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, numberPlate);
			ps.setInt(3, yearOfM);
			ps.setString(4, brand);
			ps.setString(5, position);
			ps.setString(6, steering);
			ps.setInt(7, duration);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void insertInsurance(String insuranceName, String insuranceType) {
		String sql = "INSERT INTO insurance VALUES(?,?)";
		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, insuranceName);
			ps.setString(2, insuranceType);
			ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Car> getAllCars() {
		ArrayList<Car> listAllCars = new ArrayList<>();
		String sql = "select * from CAR c LEFT JOIN CAR_INSURANCE ci ON(c.NAMECAR = ci.NAMECAR)";
		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			Car car = null;
			while (resultSet.next()) {

				String carName = resultSet.getString("namecar");
				int numberPlate = resultSet.getInt("numberplate");
				int yearOfManufacture = resultSet.getInt("yearofmanufacture");
				String brand = resultSet.getString("brand");
				boolean insurance;
				String nameInsurance = resultSet.getString("nameinsurance");
				String haveSteering = resultSet.getString("havepowersteering");
				int actionDuration = resultSet.getInt("actionduration");
				if (nameInsurance != null) {
					insurance = true;
				} else {
					insurance = false;
				}

				String havePosition = resultSet.getString("havepositiondevice");
				// if (havePosition != null) {
				// if (havePosition.equals("yes")) {
				// havePositioningDevice = true;
				// } else {
				// havePositioningDevice = false;
				// }
				// }

				if (havePosition != null) {
					boolean havePositioningDevice = "yes".equals(havePosition);
					 car = new ModernCar(carName,numberPlate,yearOfManufacture,brand,insurance,havePositioningDevice);
//					 car.setCarName(carName);
//					 car.setNumberPlate(numberPlate);
//					 car.setYearOfManufacture(yearOfManufacture);
//					 car.setBrand(brand);
//					 car.setInsurance(insurance);
//					 
					 
				} else if (haveSteering != null) {
					if (haveSteering.equals("yes")) {
						car = new MediumCar(carName, numberPlate, yearOfManufacture, brand, insurance, true);
					} else {
						car = new MediumCar(carName, numberPlate, yearOfManufacture, brand, insurance, false);
					}
				} else if (actionDuration > 0) {
					car = new OldCar(carName, numberPlate, yearOfManufacture, brand, insurance, actionDuration);
				}

				listAllCars.add(car);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return listAllCars;

	}

}
