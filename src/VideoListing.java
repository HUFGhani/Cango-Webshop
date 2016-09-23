import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Hamza Ghani 12077582
 * 
 *         this class display all of the video from the database and on to the
 *         web site using the html tages.
 * 
 *         Servlet implementation class video
 */
@WebServlet("/video")
public class VideoListing extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoListing() {
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
		DAO vconnect = new DAO();
		ArrayList<Bean> video = vconnect.GetAll();
		String title = "video";
		out.println(ServletUtilities.headWithTitle(title));

		out.println("<table>" + "<tr>" + "<th>title</th>"
				+ "<th>image_name</th>" + "<th>rating</th>"
				+ "<th>year_released</th>" + "<th>price</th>" + "<th></th>"
				+ "</tr>");
		for (Bean v : video) {
			out.println("<tr><td>" + v.getTitle() + "<form>");
			out.println("<td>" + "<img src=/WebContent/images/"
					+ v.getImage_name() + "></td>");
			out.println("<td> " + v.getRating() + "</td>");
			out.println("<td>" + v.getYear_released() + "</td>");
			out.println("<td>" + v.getPrice() + "</td>");
			out.print("<td>" + "<form action=\"Placeorder\" method=\"get\">"
					+ "<input type=\"hidden\" name=\"title\" value=\""
					+ v.getTitle() + "\">"
					+ "<input type=\"submit\" value=\"Add\" >" + "</form>"
					+ "</td>");
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

		doGet(request, response);
	}

}
