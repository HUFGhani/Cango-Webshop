
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class vpicker
 */
@WebServlet("/vpicker")
public class vpicker extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public vpicker() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String category = request.getParameter("category");
		DAO vconnect = new DAO();
		ArrayList<Bean> video = vconnect.GetVideobycategory(category);

		String title = "video";
		out.println(ServletUtilities.headWithTitle(title));

		out.println("<table>" + "<tr>" + "<th>title</th>"
				+ "<th>image_name</th>" + "<th>rating</th>"
				+ "<th>year_released</th>" + "</tr>");

		for (Bean v : video) {
			out.println("<tr><td> " + v.getTitle() + "</td>");
			out.println("<td>" + v.getImage_name() + "</td>");
			out.println("<td> " + v.getRating() + "</td>");
			out.println("<td>" + v.getYear_released() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println(ServletUtilities.footer());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
