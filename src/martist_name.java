

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mChoose
 */
@WebServlet("/mChoose")
public class martist_name extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public martist_name() {
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
		String artist_name = request.getParameter("searchm");
		DAO mconnect = new DAO();
		ArrayList<Bean> music = mconnect.GetMusicbArtist_name(artist_name);
		
		String title=artist_name ;
		out.println(ServletUtilities.headWithTitle(title));
		if (music != null && !music.isEmpty()) {
		out.println("<table>" + "<tr>" + "<th>title</th>"
				+ "<th>artist_name</th>"+ "<th>image_name</th>" + "</tr>");

		for (Bean m : music) {
			out.println("<tr><td> " + m.getTitle() + "</td>");
			out.println("<td>" + m.getArtist_name()+ "</td>");
			out.println("<td>" + m.getImage_name() + "</td>");
				out.println("</tr>");
		}
		out.println("</table>");
		
		} else {
			out.println("they is no artist called " + artist_name);
		}
		out.println(ServletUtilities.footer());
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
