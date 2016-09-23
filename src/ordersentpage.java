import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ordersentpage
 */
@WebServlet("/ordersentpage")
public class ordersentpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Bean video = new Bean();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ordersentpage() {
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
		String seasion = request.getParameter("seasion");
		String recording_id;
		recording_id = request.getParameter("recording_id");
		video.setRecording_id(recording_id);
		video.setSession_id(seasion);

		DAO vconnect = new DAO();
		vconnect.storeVorder(video);

		String title = "thank you";
		out.println(ServletUtilities.headWithTitle(title));

		out.println("you order will be sent out two you in the next 24 hour with cake");

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
