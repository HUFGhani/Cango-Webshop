import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class search
 */
@WebServlet("/search")
public class SearchV extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchV() {
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
		String title = "Search";
		out.println(ServletUtilities.headWithTitle(title));

		DAO vconnect = new DAO();
		ArrayList<Bean> video = vconnect.Getcategory();
		out.println("<form action =\"vpicker\">" + "<select name=\"category\">");
		out.println("<option value='disabled' disabled>genre</option>");
		for (Bean v : video) {
			out.println("<option value=\"" + v.getCategory() + "\">"
					+ v.getCategory().toUpperCase() + "</option>");
		}

		out.println("</select>\n" + "<input type = \"submit\"value = \"go\">"
				+ "</form>");

		ArrayList<Bean> videos = vconnect.findbyprice();
		out.println("<form action =\"vprice\">" + "<select name=\"price\">");
		for (Bean v : videos) {
			out.println("<option value=\"" + v.getPrice() + "\">"
					+ v.getPrice() + "</option>");
		}
		out.println("</select>\n" 
		+ "<input type = \"submit\"value = \"go\">"
				+ "</form>");

		out.println("<form action =\"vChoose\">");
		out.println("<input type='text' name='searchv' required ='required'>");
		
		out.println("<input type = \"submit\"value = \"go\">"
				+ "</form>\n");
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
