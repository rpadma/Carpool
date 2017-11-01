package dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.usermodel;
import utils.ConnectionPool;
import utils.DBUtils;
import utils.PasswordUtil;

public class registerdao {

	public boolean checkusername(String email)
	{
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String query="select Email from users where Email=?"; 
			
		 try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1, email);
			 rs=ps.executeQuery();
			return rs.next();
			
		 }
		catch(SQLException e)
		 {
			System.out.println(e);
			return false;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }
		
	}
	
	public static int registeruser(String email,String password)
	{
		usermodel um=new usermodel();
		um.setEmail(email);
		um.setRole("user");
		Date date=new Date(System.currentTimeMillis());
		um.setCreatedate(date);
		String salt= PasswordUtil.getSalt();
		um.setSalt(salt);
		try {
			um.setCiperpassword(PasswordUtil.hashPassword(password+salt));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertuser(um);
	}
	
    public static int insertuser(usermodel user){
		
    	ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String query="Insert into users(Email,CiperPassword,Salt,Role,CreateDate) values(?,?,?,?,?)"; 
			
		 try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1,user.getEmail());
			 ps.setString(2, user.getCiperpassword());
			 ps.setString(3, user.getSalt());
			 ps.setString(4, user.getRole());
			 ps.setDate(5, user.getCreatedate());
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
