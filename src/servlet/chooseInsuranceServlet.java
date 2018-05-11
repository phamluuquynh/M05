package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.Insurance;

/**
 * Servlet implementation class chooseInsuranceServlet
 */
@WebServlet("/chooseInsurance")
public class chooseInsuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public chooseInsuranceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String syear = request.getParameter("index");
		int year = Integer.parseInt(syear);
		System.out.print(year+"");
		
		DAO dao = new DAO();
		List<Insurance> listTrueAvailableInsurance = null;
		if (year >= 2005) {
			
			listTrueAvailableInsurance = dao.getTrueAvailableInsurance("A");
		} else if (year >= 2004) {
			
			listTrueAvailableInsurance = dao.getTrueAvailableInsurance("B");
		} else {

			listTrueAvailableInsurance = dao.getTrueAvailableInsurance("C");
		}

		String name;
		for (int i = 0; i < listTrueAvailableInsurance.size(); i++) {
			name = listTrueAvailableInsurance.get(i).getNameInsurance();
			System.out.println(name);
		}

	}

}
