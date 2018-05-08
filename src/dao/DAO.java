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
				String haveSteering = resultSet.getString(6);
				int actionDuration = resultSet.getInt(7);
				if (actionDuration > 0) {
					OldCar oldCar = new OldCar();
					this.setCarCommonInformation(resultSet, oldCar);
					oldCar.setActionDuration(actionDuration);
					listAllCars.add(oldCar);
				} else if (null != haveSteering) {
					MediumCar mediumCar = new MediumCar();
					this.setCarCommonInformation(resultSet, mediumCar);
					mediumCar.setHavePowerSteering("yes".equals(haveSteering));
					listAllCars.add(mediumCar);
				} else {
					ModernCar modernCar = new ModernCar();
					this.setCarCommonInformation(resultSet, modernCar);
					modernCar.setHavePositioningDevice("yes".equals(resultSet.getString(5)));
					listAllCars.add(modernCar);
				}

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return listAllCars;
	}

	private void setCarCommonInformation(ResultSet resultSet, Car car) {
		try {
			car.setCarName(resultSet.getString(1));
			car.setNumberPlate(resultSet.getInt(2));
			car.setYearOfManufacture(resultSet.getInt(3));
			car.setBrand(resultSet.getString(4));
			car.setInsurance(resultSet.getString(9) != null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
