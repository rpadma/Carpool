package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.tripsmodel;
import model.usermodel;
import utils.ConnectionPool;
import utils.DBUtils;

public class tripsdao {
	public int insertTrip(String src,String dest,String desc,String date,int cars_available,int vacant_seats,int cost,Long user){
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.sql.Date start_date = java.sql.Date.valueOf(date);
		String query="Insert into trips(Source,Destination,startDate,description,caravailable,vacantseat,estimatedcost,AddedBy) values(?,?,?,?,?,?,?,?)"; 
		
		 try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1,src);
			 ps.setString(2, dest);
			 ps.setDate(3, start_date);
			 ps.setString(4, desc);
			 ps.setInt(5, cars_available);
			 ps.setInt(6, vacant_seats);
			 ps.setInt(7, cost);
			 ps.setLong(8,user);
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
	
	public ArrayList<tripsmodel> searchTrips(String src, String dest, String date){
		ArrayList<tripsmodel> trips = new ArrayList<tripsmodel>();
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		java.sql.Date start_date = java.sql.Date.valueOf(date);
		String query = "SELECT t.caravailable,t.vacantseat,t.estimatedcost,t.AddedBy,t.description,t.ID ,u.email from trips t inner join users u on u.ID=t.AddedBy where t.Source=? and t.Destination=? and t.startDate=?";
		
		try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1,src);
			 ps.setString(2,dest);
			 ps.setDate(3,start_date);
			 rs=ps.executeQuery();
			 tripsmodel trip;
			 while(rs.next())
			 {
				 trip = new tripsmodel();
				 trip.setUser_id(rs.getLong("AddedBy"));
				 trip.setCars_available(rs.getInt("caravailable"));
				 trip.setCost(rs.getInt("estimatedcost"));
				 trip.setVacant_seats(rs.getInt("vacantseat"));
				 trip.setDesc(rs.getString("description"));
				 trip.setTrip_id(rs.getLong("ID"));
				 trip.setUser_email(rs.getString("email"));
				 trips.add(trip);
				 
				 System.out.println(trip.getUser_email());
				 
			 }
			  
			  return trips;
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in trips dao");
			System.out.println(e);
			return trips;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }
	}
	
	public ArrayList<tripsmodel> mytrips(long id){
		ArrayList<tripsmodel> trips = new ArrayList<tripsmodel>();
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query = "SELECT caravailable,vacantseat,estimatedcost,description,Source,Destination,startDate ,Id from trips where AddedBy=?";
		
		try{
			 ps=connection.prepareStatement(query);
			 ps.setLong(1,id);
			 rs=ps.executeQuery();
			 tripsmodel trip;
			 while(rs.next())
			 {
				 trip = new tripsmodel();
				 trip.setCars_available(rs.getInt("caravailable"));
				 trip.setCost(rs.getInt("estimatedcost"));
				 trip.setVacant_seats(rs.getInt("vacantseat"));
				 trip.setDesc(rs.getString("description"));
				 trip.setDest(rs.getString("Destination"));
				 trip.setSrc(rs.getString("Source"));
				 trip.setDate(rs.getDate("startDate"));
				 trip.setTrip_id(rs.getLong("Id"));
				 trips.add(trip);
				 
			 }
			  
			  return trips;
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in trips dao");
			System.out.println(e);
			return trips;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }
	}
	
	public int mapTrip(String trip_id,long user_id){
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		long tripid = Long.valueOf(trip_id);
		
		String query = "select * from tripmapper where tripid=? and userid=?";
		int count = 0;
		
		try{
			 ps=connection.prepareStatement(query);
			 ps.setLong(1,tripid);
			 ps.setLong(2,user_id);
			 rs=ps.executeQuery();
			 
			 while(rs.next())
			 {
				 count = count + 1;
			 }
			 
			 System.out.println("ass result"+count);
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in map trips");
			System.out.println(e);
			
		 }
		System.out.println(count);
		
		if(count>0){
			DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
			return 0;
		}
		else{
			query = "insert into tripmapper(tripid,userid) values(?,?)";
			try{
				 ps=connection.prepareStatement(query);
				 ps.setLong(1,tripid);
				 ps.setLong(2,user_id);
				 ps.executeUpdate();
				
			 }
			catch(SQLException e)
			 {
				System.out.println("in map trips");
				System.out.println(e);
				
			 }
			
		}
		 DBUtils.closeResultSet(rs);
		 DBUtils.closePreparedStatement(ps);
		 pool.freeConnection(connection);
		return 1;
	}
	
	public ArrayList<usermodel> getUsers(long trip_id){
		ArrayList<usermodel> users = new ArrayList<usermodel>();
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query = "select u.Email from tripmapper tm inner join users u on u.Id=tm.userid where tm.Id=?";
		
		try{
			 ps=connection.prepareStatement(query);
			 ps.setLong(1,trip_id);
			 rs=ps.executeQuery();
			 usermodel user;
			 while(rs.next())
			 {
				 user = new usermodel();
				 user.setEmail(rs.getString("Email"));
				 users.add(user);
				 
			 }
			  
			  return users;
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in trips dao");
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
