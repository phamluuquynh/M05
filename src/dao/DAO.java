package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Car;
import model.MediumCar;
import model.ModernCar;
import model.News;
import model.OldCar;
import model.Insurance;

public class DAO {
	private static final String user = "c##ex7_car";
	private static final String password = "1234";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:orcl";

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
		} finally {
			closeConnect();
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
		} finally {
			closeConnect();
		}
	}

	public boolean checkInsurance(String insuranceName) {
		String sql = "SELECT nameinsurance FROM INSURANCE WHERE NAMEINSURANCE=?";
		boolean isExisted = false;
		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, insuranceName);
			ResultSet resultSet = ps.executeQuery();

			if (resultSet.next()) {
				isExisted = true;
			} else {
				isExisted = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return isExisted;
	}

	public List<Insurance> getAllInsurance() {
		List<Insurance> listAllInsurance = new ArrayList<>();
		String sql = "SELECT *\r\n" + "FROM INSURANCE\r\n"
				+ "LEFT JOIN CAR_INSURANCE ON insurance.nameinsurance = CAR_INSURANCE.NAMEINSURANCE";

		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Insurance insurance = new Insurance();
				String nameInsurance = resultSet.getString("nameinsurance");
				String typeInsurance = resultSet.getString("typeinsurance");
				boolean isBought = resultSet.getString(4) != null;
				insurance.setNameInsurance(nameInsurance);
				insurance.setTypeInsurance(typeInsurance);
				insurance.setBought(isBought);
				listAllInsurance.add(insurance);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return listAllInsurance;

	}

	public List<Insurance> getTrueAvailableInsurance(String insuranceType) {
		ArrayList<Insurance> listTrueAvailableInsurance = new ArrayList<>();
		String sql = "SELECT * FROM insurance WHERE NAMEINSURANCE NOT IN(SELECT insurance.nameinsurance\r\n"
				+ "FROM insurance\r\n"
				+ "INNER JOIN car_insurance ON insurance.nameinsurance = car_insurance.nameinsurance)AND typeinsurance=?";
		try {

			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, insuranceType);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String nameInsurance = resultSet.getString("nameinsurance");
				String typeInsurance = resultSet.getString("typeinsurance");
				Insurance insurance = new Insurance();
				insurance.setNameInsurance(nameInsurance);
				insurance.setTypeInsurance(typeInsurance);
				listTrueAvailableInsurance.add(insurance);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return listTrueAvailableInsurance;
	}

	public List<Car> getAvailableCars() {
		ArrayList<Car> listAvailableCars = new ArrayList<>();
		String sql = "SELECT * FROM CAR WHERE NAMECAR NOT IN(SELECT car.namecar\r\n" + "FROM car\r\n"
				+ "INNER JOIN car_insurance ON car.namecar = car_insurance.NAMECAR)";

		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String haveSteering = resultSet.getString("havepowersteering");
				String havePosition = resultSet.getString("havepositiondevice");
				int actionDuration = resultSet.getInt("actionduration");
				if (actionDuration > 0) {
					OldCar oldCar = new OldCar();
					this.setCarCommonInformation(resultSet, oldCar);
					oldCar.setActionDuration(actionDuration);
					listAvailableCars.add(oldCar);
				} else if (null != haveSteering) {
					MediumCar mediumCar = new MediumCar();
					this.setCarCommonInformation(resultSet, mediumCar);
					mediumCar.setHavePowerSteering("yes".equals(haveSteering));
					listAvailableCars.add(mediumCar);
				} else {
					ModernCar modernCar = new ModernCar();
					this.setCarCommonInformation(resultSet, modernCar);
					modernCar.setHavePositioningDevice("yes".equals(havePosition));
					listAvailableCars.add(modernCar);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnect();
		}

		return listAvailableCars;
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
		} finally {
			closeConnect();
		}

		return listAllCars;
	}

	private void setCarCommonInformation(ResultSet resultSet, Car car) {
		try {
			car.setCarName(resultSet.getString("namecar"));
			car.setNumberPlate(resultSet.getInt("numberplate"));
			car.setYearOfManufacture(resultSet.getInt("yearofmanufacture"));
			car.setBrand(resultSet.getString("brand"));
			car.setInsurance(resultSet.getString("nameinsurance") != null);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<News> GetNews() {

		ArrayList<News> listNews = new ArrayList<>();
		String sql = "SELECT * FROM NEWS";
		
		try {
			connection = this.getConnectDB();
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet resultSet = ps.executeQuery();
//			ps.executeUpdate("insert into news values('dsd','dsa','dsa')");
			while(resultSet.next()) {
				String newsTitle = resultSet.getString("NEWSTITLE");
				String newsContent = resultSet.getString("NEWSCONTENT");
				String newsImage = resultSet.getString("NEWSIMAGE");
				News news = new News(newsTitle, newsContent, newsImage);
//				news.setNewsTitle(newsTitle);
//				news.setNewsContent(newsContent);
//				news.setNewsImage(newsImage);
				listNews.add(news);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			closeConnect();
		}
		
		return listNews;
	}

}
