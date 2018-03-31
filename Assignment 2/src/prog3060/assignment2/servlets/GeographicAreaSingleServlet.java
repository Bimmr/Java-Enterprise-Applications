package prog3060.assignment2.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import prog3060.assignment2.DataHandler;
import prog3060.assignment2.Models.GeographicArea;
import prog3060.assignment2.Models.Household;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/GeographicAreaSingleServlet")
public class GeographicAreaSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GeographicAreaSingleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String redirectionPath = "/GeographicAreaSingle.jsp";
		
		if(session.getAttribute("dataHandler") == null) {
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
			return;
		}
		DataHandler dh = (DataHandler)session.getAttribute("dataHandler");
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			GeographicArea area = dh.getGeographicAreas("geographicAreaID", id).get(0);
			request.setAttribute("area", area);
			request.setAttribute("subLocations", dh.getSubGeographicAreas(area));
			request.setAttribute("ages", dh.getAges(id));
			List<Household> households = dh.getHousehold(id,
					2016,
					"One couple census family without other persons in the household",
					"2 or more persons",
					"Total - Households by number of persons aged 0 to 17 years",
					"1 earner or more",
					"$80,000 to $89,999"
					);
			
			request.setAttribute("households", households.size());
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
