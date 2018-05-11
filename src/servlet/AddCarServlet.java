package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;

import dao.DAO;
import javafx.scene.control.Alert;

/**
 * Servlet implementation class AddCarServlet
 */
@WebServlet("/AddCarServlet")
public class AddCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		// Get data
		String carName = request.getParameter("carName");
		String sNumberPlate = request.getParameter("numberPlate");
		int numberPlate = 0;
		if (!sNumberPlate.equals("")) {
			numberPlate = Integer.parseInt(sNumberPlate);
		}

		String sYearOfM = request.getParameter("yearOfM");
		int yearOfM = 0;
		if (!sYearOfM.equals("")) {
			yearOfM = Integer.parseInt(sYearOfM);
		}

		String brand = request.getParameter("brand");
		String position = request.getParameter("position");
		String steering = request.getParameter("steering");
		String sDuration = request.getParameter("duration");
		int duration = 0;
		if (!sDuration.equals("")) {
			duration = Integer.parseInt(sDuration);
		} else {
			duration = 0;
		}

		if (carName.equals("") || sNumberPlate.equals("") || sYearOfM.equals("") || brand.equals("")) {
			writer.print("Please full fill carName, NumberPlate, Year of manufacture, brand");
		} else {
			if (yearOfM >= 2005) {
				if (steering.length() > 0 || duration > 0) {
					writer.print("This is a modern car, don't fill steering or duraion");
				}else {
					InsertData(request, response, carName, numberPlate, yearOfM, brand, position, steering, duration);
				}

			} else if (yearOfM >= 1996) {
				if (position.length() > 0 || duration > 0) {
					writer.print("This is a medium car, don't fill duration or position");
				}else {
					InsertData(request, response, carName, numberPlate, yearOfM, brand, position, steering, duration);
				}

			}

			else {
				if (position.length() > 0 || steering.length() > 0) {
					
					writer.print("This is a old car, don't fill steering or position");
				}else {
					InsertData(request, response, carName, numberPlate, yearOfM, brand, position, steering, duration);
				}

			}

		}

	}

	public void InsertData(HttpServletRequest request, HttpServletResponse response, String carName, int numberPlate, int yearOfM, String brand, String position, String steering,
			int duration) {
		DAO dao = new DAO();
		dao.insertCar(carName, numberPlate, yearOfM, brand, position, steering, duration);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Menu.jsp");
		try {
			requestDispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
