package assignment1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet to manage database connections 2/9/2018
 */
@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DatabaseServlet() {
		super();
	}

	/**
	 * Create a connection the the database
	 * 
	 * @return the connection
	 * @throws SQLException
	 *             if unable to connect to database
	 */
	public Connection connectToDatabase(String user, String password) throws SQLException {

		try {
			Class.forName("org.apache.derby.client");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties props = new Properties();
		props.put("user", user);
		props.put("pass", password);

		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/CanadaCensusDB", props);
		connection.createStatement().execute("SET SCHEMA APP;");
		return connection;

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String redirectionPath = "/Home.jsp";
		String errors = "";

		if (session.getAttribute("connection") == null) {
			String user = null;
			String pass = null;

			// Make sure user and pass is valid
			if (!Utils.isNullOrEmpty((user = (String) request.getParameter("user"))))
				request.setAttribute("user", user);
			if (!Utils.isNullOrEmpty((pass = (String) request.getParameter("pass"))))
				request.setAttribute("pass", pass);

			if (!Utils.isNullOrEmpty(user) && !Utils.isNullOrEmpty(pass))
				// Connect to database
				try {
					session.setAttribute("user", user);
					session.setAttribute("pass", pass);
					session.setAttribute("connection", connectToDatabase(user, pass));
				} catch (Exception e) {
					errors += "<li>Unable to connect to database</li>";
					e.printStackTrace();
					redirectionPath = "/Login.jsp";
				}
			else
				redirectionPath = "/Login.jsp";
			
			//Set error messages
			if (Utils.isNullOrEmpty(user))
				errors += "<li>Enter an username</li>";
			if (Utils.isNullOrEmpty(pass))
				errors += "<li>Enter a password</li>";

		} else {
			if(!Utils.isNullOrEmpty(request.getParameter("dataType"))) {
				//Do something
			}
		}

		// If errors exist, then set the message
		if (errors.length() > 0)
			request.setAttribute("errorMessage", errors);

		// Send to new page
		request.getRequestDispatcher(redirectionPath).forward(request, response);

	}

}
