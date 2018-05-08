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
	private String user = "c##ex7_car";
	private String password = "1234";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";

	private Connection connection;

	public Connection getConnectDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;

	}

	public void closeConnect() {

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
			while (resultSet.next()) {
				Car car = null;
				String carName = resultSet.getString(1);
				int numberPlate = resultSet.getInt(2);
				int yearOfManufacture = resultSet.getInt(3);
				String brand = resultSet.getString(4);
				boolean insurance;
				String nameInsurance = resultSet.getString(9);
				if (nameInsurance == null) {
					insurance = false;
				} else {
					insurance = true;
				}
				boolean havePositioningDevice = false;
				String havePosition = resultSet.getString(5);
				if (havePosition != null) {
					if (havePosition.equals("yes")) {
						havePositioningDevice = true;
					} else {
						havePositioningDevice = false;
					}
				}
				car = new ModernCar(carName, numberPlate, yearOfManufacture, brand, insurance, havePositioningDevice);

				String haveSteering = resultSet.getString(6);
				if (haveSteering != null) {
					if (haveSteering.equals("yes")) {
						car = new MediumCar(carName, numberPlate, yearOfManufacture, brand, insurance, true);
					} else {
						car = new MediumCar(carName, numberPlate, yearOfManufacture, brand, insurance, false);
					}
				}
				int actionDuration = resultSet.getInt(7);
				if (actionDuration > 0) {
					car = new OldCar(carName, numberPlate, yearOfManufacture, brand, insurance, actionDuration);
				}

			}
			
			for(int i=0;i<listAllCars.size();i++) {
				String name = listAllCars.get(i).getCarName();
				System.out.println(name);
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

		return listAllCars;
		
		
	}

}
