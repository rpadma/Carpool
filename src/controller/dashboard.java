package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.dashboarddao;
import com.google.gson.Gson;
import java.io.OutputStream;
/**
 * Servlet implementation class dashboard
 */
@WebServlet("/dashboard")
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static dashboarddao dash = new dashboarddao();
       
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Long> users = dash.getUsersTrips();
		ArrayList<Object> listresult=new ArrayList<Object>();

		listresult.add("values1");
		listresult.add("values2");
		listresult.add("values3");
		listresult.add("values4");
		response.setContentType("application/json");
		OutputStream outputStream= response.getOutputStream();
		Gson gson=new Gson();       
		outputStream.write(gson.toJson(listresult).getBytes());
		outputStream.flush();
	}

}
