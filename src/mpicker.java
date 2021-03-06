

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mpicker
 */
@WebServlet("/mpicker")
public class mpicker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mpicker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String category = request.getParameter("category");
		DAO mconnect = new DAO();
		ArrayList<Bean> music = mconnect.GetMusicbycategory(category);
		
		String title=category ;
		out.println(ServletUtilities.headWithTitle(title));

		out.println("<table>" + "<tr>" + "<th>title</th>"
				+ "<th>artist_name</th>"+ "<th>image_name</th>" + "</tr>");

		for (Bean m : music) {
			out.println("<tr><td> " + m.getTitle() + "</td>");
			out.println("<td>" + m.getArtist_name()+ "</td>");
			out.println("<td>" + m.getImage_name() + "</td>");
				out.println("</tr>");
		}
		out.println("</table>");
		out.println(ServletUtilities.footer());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
