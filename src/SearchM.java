

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchM
 */
@WebServlet("/searchm")
public class SearchM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchM() {
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
		String title = "Search";
		out.println(ServletUtilities.headWithTitle(title));
		
		
		DAO mconnect = new DAO();
		ArrayList<Bean> music = mconnect.GetcategoryM();
		out.println("<form action =\"mpicker\">" + "<select name=\"category\">");
		out.println("<option value='disabled' disabled>genre</option>");
		for (Bean m : music) {
			out.println("<option value=\"" + m.getCategory() + "\">"
					+ m.getCategory().toUpperCase() + "</option>");
		}
		out.println("</select>\n" + "<input type = \"submit\"value = \"go\">"
				+ "</form>");
		
		
		ArrayList<Bean> musics = mconnect.findbypriceM();
		out.println("<form action =\"mprice\">" + "<select name=\"price\">");
		for (Bean m : musics) {
			out.println("<option value=\"" + m.getPrice() + "\">"
					+ m.getPrice()+ "</option>");
		}
		out.println("</select>\n" 
		+ "<input type = \"submit\"value = \"go\">"
				+ "</form>");
		
		
		out.println("<form action =\"mChoose\">");
		out.println("<input type='text' name='searchm' required ='required'>");
		
		out.println("<input type = \"submit\"value = \"go\">"
				+ "</form>\n");
			
		
		out.println(ServletUtilities.footer());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doGet(request,response);
	}

}
