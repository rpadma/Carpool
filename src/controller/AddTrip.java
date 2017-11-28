package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tripsdao;
import model.usermodel;

/**
 * Servlet implementation class AddTrip
 */
@WebServlet("/AddTrip")
public class AddTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static tripsdao trip = new tripsdao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTrip() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		usermodel user =  (usermodel) request.getSession().getAttribute("user");
		String src = request.getParameter("Source");
		String dest = request.getParameter("Destination");
		String date_string = request.getParameter("date");
		String desc = request.getParameter("Description");
		String availability = request.getParameter("Availability");
		int cars_available;
		
		if(availability==null){
			cars_available = 0;
		}
		else{
			cars_available = 1;
		}
		
		int vacant_seats = Integer.parseInt(request.getParameter("VacantSeat"));
		int cost = Integer.parseInt(request.getParameter("estimatedcost"));
	

		int flag = trip.insertTrip(src, dest, desc, date_string, cars_available, vacant_seats, cost, user.getId());
		request.setAttribute("trip_msg", "added");
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
	}

}
