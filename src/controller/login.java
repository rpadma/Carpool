package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import dao.logindao;
import model.usermodel;

/**
 * Servlet implementation class login
 */
@WebServlet("/index")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static logindao login = new logindao();
    public static usermodel user = new usermodel();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
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
		
		String action = (String) request.getParameter("action");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String url = "";
		System.out.println("action="+action);
		
		if(action.equals("login")){
	
			user = login.validatelogin(email, password);
			

			System.out.println("in loop"+user.getCiperpassword()+user.getCode() +user.getMessage());
			
			if(user!=null && user.getCode()==200){
				System.out.println("in loop"+user.getCiperpassword()+user.getCode());
				request.getSession().setAttribute("user", user);
				url = "/home.jsp";
			}
			else{

				System.out.println("in else"+user.getCiperpassword()+user.getCode());
				url = "/index.jsp";
				request.setAttribute("user", user);
			}
		}
		
		else if(action.equals("logout")){
			request.getSession().invalidate();
			url="/index.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
	}

}
