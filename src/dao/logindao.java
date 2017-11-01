package dao;


import model.basemodel;
import model.usermodel;
import utils.ConnectionPool;
import utils.DBUtils;
import utils.PasswordUtil;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logindao {

	public usermodel getuser(String email)
	{
		usermodel um=new usermodel();
		
		ConnectionPool pool=ConnectionPool.getInstance();
		Connection connection=pool.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		 String query="select * from users where Email=?"; 
			
		 try{
			 ps=connection.prepareStatement(query);
			 ps.setString(1,email);
			 rs=ps.executeQuery();
			 
			 if(rs.next())
			 {
				 um.setId(rs.getLong("ID"));
				 um.setEmail(rs.getString("Email"));
				 um.setCiperpassword(rs.getString("CiperPassword"));
				 um.setSalt(rs.getString("Salt"));
				 um.setRole(rs.getString("Role"));
				 um.setCreatedate(rs.getDate("CreateDate"));
			 }
			  
			  return um;
			
		 }
		catch(SQLException e)
		 {
			System.out.println("in login dao");
			System.out.println(e);
			um.setMessage("Exception occurred");
			return um;
			
		 }
		 finally{
			 DBUtils.closeResultSet(rs);
			 DBUtils.closePreparedStatement(ps);
			 pool.freeConnection(connection);
		 }
		
	
	}

	
	public usermodel validatelogin(String email,String password)
	{
		usermodel um=new usermodel();
		um=getuser(email);
		if(um==null)
		{
		
			um.setMessage("Email doesn't exist");
			return um;
		
		}
		else
		{
			
			try {
				if(PasswordUtil.hashPassword(password+um.getSalt()).equals(um.getCiperpassword()))
				{
					um.setMessage("Successfully login ");
					um.setCode(200);
					return um;
				}
				else
				{
					um.setMessage("Email and password doesn't match ");
					return um;
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
				
			}
			finally{
				System.out.println("in finally");
				return um;
			}
			
		}
		
	
		
	}
	
	
}
