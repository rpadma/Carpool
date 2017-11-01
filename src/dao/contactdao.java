package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.contactusmodel;
import utils.ConnectionPool;
import utils.DBUtils;

public class contactdao {

	
	public int insertContactUs(contactusmodel contactus)
	{
		
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String query="Insert into contactus(UserName,Email,Message,CreateDate,IPAddress) values(?,?,?,?,?)"; 
			
		 try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1,contactus.getName());
			 ps.setString(2, contactus.getEmail());
			 ps.setString(3, contactus.getMessage());
			 ps.setDate(4,contactus.getCreatedate());
			 ps.setString(5,contactus.getIpaddress());
			 return  ps.executeUpdate();
			
		 }
		catch(SQLException e)
		 {
			System.out.println(e);
			return 0;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }

	}
}
