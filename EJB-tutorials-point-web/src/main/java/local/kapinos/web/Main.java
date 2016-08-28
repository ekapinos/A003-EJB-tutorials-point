package local.kapinos.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import local.kapinos.common.interfaces.ExceptionsSingletonSessionBeanLocal;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	ExceptionsSingletonSessionBeanLocal temp;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath()).append("<br>");
		response.getWriter().append("Temp EJB: ").append(temp.getSecret());
	}

}
