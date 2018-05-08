package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import model.Car;

/**
 * Servlet implementation class ListOfCarServlet
 */
@WebServlet("/listOfCar")
public class ListOfCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListOfCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		ArrayList<Car> listAllCar = dao.getAllCars();
		for(int i=0;i<listAllCar.size();i++) {
			String name = listAllCar.get(i).getCarName();
			System.out.println(name);
		}
		
		request.setAttribute("listAllCar", listAllCar);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listOfCar.jsp");
		requestDispatcher.forward(request, response);
	}

}
