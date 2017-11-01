package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.contactdao;
import dao.registerdao;
import model.contactusmodel;
import model.usermodel;

/**
 * Servlet implementation class contactus
 */
@WebServlet("/contactus")
public class contactus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static contactdao cdao = new contactdao();
	public static contactusmodel cu=new contactusmodel();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contactus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	cu.setName((String)request.getParameter("name"));
	cu.setEmail((String)request.getParameter("email"));
	cu.setMessage((String)request.getParameter("message"));
	 String ipAddress = request.getHeader("X-FORWARDED-FOR");  
     if (ipAddress == null) {  
       ipAddress = request.getRemoteAddr();  
       }
     cu.setIpaddress(ipAddress);
     cu.setCreatedate(new Date(System.currentTimeMillis()));
	
     String url="/thankyou.jsp";
	cdao.insertContactUs(cu);
	
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
