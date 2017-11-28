package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tripsdao;
import model.tripsmodel;

/**
 * Servlet implementation class searchtrip
 */
@WebServlet("/searchtrip")
public class searchtrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static tripsdao trip = new tripsdao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchtrip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String date_string = request.getParameter("date");
		String src = request.getParameter("Source");
		String dest = request.getParameter("Destination");
		
		ArrayList<tripsmodel> trips = trip.searchTrips(src, dest, date_string);
		System.out.println(trips.size());
		if(trips.size()==0){
			request.setAttribute("search_flag", "notrips");
		}
		else{
			request.setAttribute("search_flag", trips);
		}
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

}
