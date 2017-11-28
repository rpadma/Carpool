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
import model.usermodel;

/**
 * Servlet implementation class mytrips
 */
@WebServlet("/mytrips")
public class mytrips extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static tripsdao trip = new tripsdao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mytrips() {
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
		usermodel user =  (usermodel) request.getSession().getAttribute("user");
		ArrayList<tripsmodel> trips = trip.mytrips(user.getId());
		if(trips.size()==0){
			request.setAttribute("mytrips_flag", "notrips");
		}
		else{
			request.setAttribute("mytrips_flag", trips);
		}
		System.out.println(trips.size());
		request.getRequestDispatcher("mytrips.jsp").forward(request, response);
	}

}
