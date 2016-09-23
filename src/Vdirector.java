
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class vChoose
 */
@WebServlet("/vChoose")
public class Vdirector extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Vdirector() {
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
		String director = request.getParameter("searchv");
		DAO vconnect = new DAO();
		ArrayList<Bean> video = vconnect.getvideobydirector(director);
		String title = null;
		out.println(ServletUtilities.headWithTitle(title));

		if (video != null && !video.isEmpty()) {
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
		} else {
			out.println("they is no director called " + director);
		}
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
