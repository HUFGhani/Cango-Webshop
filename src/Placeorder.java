import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Placeorder
 */
@WebServlet("/Placeorder")
public class Placeorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private float total;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Placeorder() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings({ "unchecked", "unchecked", "unchecked", "unchecked",
			"unchecked" })
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String moviesname = request.getParameter("title");

		HttpSession seasion = request.getSession();

		ArrayList<String> titlesArray;

		if (seasion.isNew()) {
			titlesArray = new ArrayList<String>();

			seasion.setAttribute("order", titlesArray);
		} else {
			titlesArray = (ArrayList<String>) seasion.getAttribute("order");
		}
		titlesArray.add(moviesname);

		DAO vconnect = new DAO();


		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String title = "cart";
		out.println(ServletUtilities.headWithTitle(title));
		ArrayList<Bean> video = vconnect.GetVideobytitles(moviesname);
		
		/*
		 * for (Bean v: video){ out.println(); titlesArray.add(v.getTitle());
		 * titlesArray. }
		 */

		out.println("<table>");
		for (String s : titlesArray) {
			out.println("<tr><td> " + s + "</td>");
			for (Bean v : video) {
				
				out.println("<td>" + v.getPrice() + "</td>");
				out.println("<td>" + "<form>"
						+ "<button type='button'>delete</button>"
						+ "<input type=\"hidden\" name=\"recording_id\" value=\""
						+ v.getRecording_id() + "\">" + "</form>");

				if (titlesArray.equals(v.getTitle())) {
					titlesArray.remove(s);
				}
				
				
			}
			out.println("</tr>");
			
			out.println(total);
		}
		out.println("</table>");

		out.println("<form action='ordersentpage'>\n"
				+ "<input type='submit' value='Submit'>"
				+ "<input type=\"hidden\" name=\"seasion\" value=\""
				+ seasion.getId() + "\">" + "</form>");
		
		

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
