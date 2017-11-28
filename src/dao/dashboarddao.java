package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.tripsmodel;
import utils.ConnectionPool;
import utils.DBUtils;

public class dashboarddao {
	public ArrayList<Long> getUsersTrips(){
		ArrayList<Long> users = new ArrayList<Long>();
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query = "SELECT ID from users";
		
		try{
			 ps=connection.prepareStatement(query);
			 rs=ps.executeQuery();
			 while(rs.next())
			 {
				 users.add(rs.getLong("ID"));
				 
			 }
			  
			  return users;
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in dashboard dao");
			System.out.println(e);
			return users;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }
	}
}
