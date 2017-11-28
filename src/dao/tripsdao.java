package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.tripsmodel;
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
		String query = "SELECT caravailable,vacantseat,estimatedcost,AddedBy,description from trips where Source=? and Destination=? and startDate=?";
		
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
	
	public ArrayList<tripsmodel> mytrips(long id){
		ArrayList<tripsmodel> trips = new ArrayList<tripsmodel>();
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String query = "SELECT caravailable,vacantseat,estimatedcost,description,Source,Destination,startDate from trips where AddedBy=?";
		
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
}
