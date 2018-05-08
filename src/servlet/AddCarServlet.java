package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

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

		 String carName = request.getParameter("carName");
		 String sNumberPlate = request.getParameter("numberPlate");
		 int numberPlate =Integer.parseInt(sNumberPlate);
		 int yearOfM = Integer.parseInt(request.getParameter("yearOfM"));
		 String brand = request.getParameter("brand");
		 String position = request.getParameter("position");
		 String steering = request.getParameter("steering");
		 int duration = Integer.parseInt(request.getParameter("duration"));
		
		 DAO dao = new DAO();
		 dao.insertCar(carName, numberPlate, yearOfM,brand,position, steering,
		 duration);
		 
		 doGet(request, response);
	}

}
