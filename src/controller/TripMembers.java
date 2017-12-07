package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.tripsdao;
import model.usermodel;

/**
 * Servlet implementation class TripMembers
 */
@WebServlet("/TripMembers")
public class TripMembers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static tripsdao trip = new tripsdao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripMembers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String trip_id = request.getParameter("trip_id");
		System.out.println("trip id: "+trip_id);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long trip_id = Long.parseLong(request.getParameter("action"));
		ArrayList<usermodel> users = trip.getUsers(trip_id);
		request.setAttribute("users",users);
		request.getRequestDispatcher("mytrips").forward(request, response);
		
	}

}
