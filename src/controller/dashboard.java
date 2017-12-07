package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.contactdao;
import dao.dashboarddao;
import model.contactusmodel;
import model.tripsmodel;
import model.usermodel;

import com.google.gson.Gson;
import java.io.OutputStream;
/**
 * Servlet implementation class dashboard
 */
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static dashboarddao dash = new dashboarddao();
	private static contactdao contact = new contactdao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("In get dashboard");
		doPost(request, response);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		usermodel user =  (usermodel) request.getSession().getAttribute("user");
		
		if(user.getRole().equals("admin"))
		{
		
		System.out.println("In contact dao");
		ArrayList<contactusmodel> allcontact = contact.allcontactus();
		if(allcontact.size()==0){
			request.setAttribute("cont_flag", "NoMessages");
		}
		else{
			request.setAttribute("cont_flag", allcontact);
		}
		System.out.println(allcontact.size());
		request.getRequestDispatcher("dashboard.jsp").forward(request, response);
	}
	else
	{
		request.getRequestDispatcher("notauthorized.jsp").forward(request, response);

	}
		
	}

}
