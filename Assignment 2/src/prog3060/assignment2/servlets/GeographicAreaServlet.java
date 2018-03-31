package prog3060.assignment2.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.assignment2.DataHandler;
import prog3060.assignment2.Utils;
import prog3060.assignment2.Models.GeographicArea;
import prog3060.assignment2.Models.Household;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/GeographicArea")
public class GeographicAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeographicAreaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirectionPath = "/GeographicArea.jsp";
		
		
		if(session.getAttribute("dataHandler") == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
		DataHandler dh = (DataHandler)session.getAttribute("dataHandler");
		try {
			request.setAttribute("countries", dh.getGeographicAreas("level", 0));
			request.setAttribute("provs", dh.getGeographicAreas("level", 1));
			request.setAttribute("cities", dh.getGeographicAreas("level", 2));
			request.setAttribute("ages", dh.getAges(1));
			List<Household> medians = dh.getMedianIncomes(1, 2016, 
					"One couple census family without other persons in the household", 
					"2 or more persons", 
					"Total - Households by number of persons aged 0 to 17 years", 
					"1 earner or more", 
					"Median total income of household ($)");
			System.out.println(medians.size());
			request.setAttribute("medianIncome", medians);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher(redirectionPath).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
