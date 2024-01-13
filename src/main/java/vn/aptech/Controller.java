package vn.aptech;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.aptech.dao.LaptopDao;
import vn.aptech.entity.Laptop;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LaptopDao dao = new LaptopDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		if (a == null) {
			request.setAttribute("laptops", dao.findAll());
			request.getRequestDispatcher("laptop/index.jsp").forward(request, response);
		} else {
			switch (a) {
			case "Search": {
				String min = request.getParameter("min");
				int nMin = Integer.parseInt(min);
				String max = request.getParameter("max");
				int nMax = Integer.parseInt(max);
				request.setAttribute("laptops", dao.findByPrice(nMin, nMax));
				request.getRequestDispatcher("laptop/index.jsp").forward(request, response);
				break;
			}
			case "DisplayCreate": {
				request.getRequestDispatcher("laptop/create.jsp").forward(request, response);
				break;
			}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String a = request.getParameter("a");
		if (a != null) {
			switch (a) {
			case "Create": {
				String name = request.getParameter("name");
				String price = request.getParameter("price");
				int nPrice = Integer.parseInt(price);
				String desc = request.getParameter("desc");
				Laptop lt = new Laptop();
				lt.setName(name);
				lt.setPrice(nPrice);
				lt.setDescription(desc);
				dao.create(lt);
				response.sendRedirect("Controller");
				break;
			}
			}
		}
	}

}
