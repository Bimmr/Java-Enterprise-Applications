package prog3060.assignment2.servlets;

import java.io.IOException;

import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.assignment2.DataHandler;
import prog3060.assignment2.Utils;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirectionPath = "/GeographicArea";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String errors = "";
		DataHandler dh = null;
		
		if (session.getAttribute("dataHandler") == null) {
			
				// Make sure user and pass is valid
				if (Utils.isValid(username))
					request.setAttribute("username", username);
				if (Utils.isValid(password))
					request.setAttribute("password", password);

				if (Utils.isValid(username) && Utils.isValid(password))
					// Connect to database
					try {
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						dh = new DataHandler(username, password);
						session.setAttribute("dataHandler", dh);
					}catch(PersistenceException e) {
						if(dh != null)
							dh.close();
						errors += "<li>Invalid Login Information</li>";
						e.printStackTrace();
						redirectionPath = "/Login.jsp";
						
					}catch (Exception e) {
						if(dh != null)
							dh.close();
						errors += "<li>"+e.getMessage()+"</li>";
						e.printStackTrace();
						redirectionPath = "/Login.jsp";
					}
				else
					redirectionPath = "/Login.jsp";
				
				//Set error messages
				if (!Utils.isValid(username))
					errors += "<li>Enter an username</li>";
				if (!Utils.isValid(password))
					errors += "<li>Enter a password</li>";
		}
		// If errors exist, then set the message
		if (errors.length() > 0)
			request.setAttribute("errorMessage", errors);

		// Send to new page
		request.getRequestDispatcher(redirectionPath).forward(request, response);

	}

}
