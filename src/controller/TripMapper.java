package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Gutils.MailUtilGmail;
import dao.tripsdao;
import model.usermodel;

/**
 * Servlet implementation class TripMapper
 */
@WebServlet("/TripMapper")
public class TripMapper extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static tripsdao trip = new tripsdao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripMapper() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String trip_id = request.getParameter("id");
		usermodel user =  (usermodel) request.getSession().getAttribute("user");
		System.out.println("trip_id: " + trip_id);
		long user_id = user.getId();
		int flag = trip.mapTrip(trip_id, user_id);
		request.setAttribute("mapflag", flag);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		String message = request.getParameter("message");
		String fromemail=request.getParameter("uemail");
		System.out.println("from mail"+fromemail);
		usermodel user =  (usermodel) request.getSession().getAttribute("user");
		
		try {
			MailUtilGmail.sendMail(fromemail, "carpooluncc@gmail.com","Mail from : "+user.getEmail(), message, false);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("home.jsp").forward(request,response);
	}

}
