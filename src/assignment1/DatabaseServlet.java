package assignment1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet to manage database connections
 * 2/9/2018
 */
@WebServlet("/Database")
public class DatabaseServlet extends HttpServlet {
	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";
	private static final long serialVersionUID = 1L;
       
    public DatabaseServlet() {
        super();
    }
    
    @Override
    public void init() {
    }
    
    public Connection connectToDatabase() {
    	Properties props = new Properties();
        props.put("user", USERNAME);
        props.put("pass", PASSWORD);
        
        try{
        	Connection connection = DriverManager.getConnection("", props);
			connection.createStatement().execute("SET SCHEMA APP;");
			return connection;
			
        }catch(Exception e) {
			return null;
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		if(session.getAttribute("connection") == null)
			session.setAttribute("connection", connectToDatabase());

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
