package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

/**
 * Servlet implementation class AddInsuranceServlet
 */
@WebServlet("/AddInsuranceServlet")
public class AddInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddInsuranceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String insuranceName = request.getParameter("insuranceName");
		String insuranceType = request.getParameter("insuranceType");

		DAO dao = new DAO();
		if(dao.checkInsurance(insuranceName)) {
			writer.print("This insurance package is existed!");
			return;
		}
		dao.insertInsurance(insuranceName, insuranceType);
		writer.append("Served at: ").append(request.getContextPath());
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Menu.jsp");
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
