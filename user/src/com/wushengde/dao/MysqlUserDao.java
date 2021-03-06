package com.wushengde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import com.wushengde.domain.Admin;
import com.wushengde.domain.Message;
import com.wushengde.domain.User;
import com.wushengde.util.JDBCUtils;

public class MysqlUserDao implements UserDao {

	@Test
	public void addUser(User user) {
		Connection conn=null;
		Statement stat=null;
		String sql="insert into users values(null,'"+user.getUsername()+"','"+user.getPassword()+"','"+user.getNickname()+"','"+user.getEmail()+"')";
		try{
		conn=JDBCUtils.getConn();
		stat=conn.createStatement();
		stat.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(null, stat, conn);
		}
	}

	public User findUserByUNandPSW(String username, String password) {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql="select * from users where username='"+username+"' and password='"+password+"'";
		try{
		conn=JDBCUtils.getConn();
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		if(rs.next()){
			User user =new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			return user;
		}else{
			return null;
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public User findUserName(String username) {
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql="select * from users where username='"+username+"'";
		try{
		conn=JDBCUtils.getConn();
		stat=conn.createStatement();
		rs=stat.executeQuery(sql);
		if(rs.next()){
			User user =new User();
			user.setId(rs.getInt("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setNickname(rs.getString("nickname"));
			user.setEmail(rs.getString("email"));
			return user;
		}else{
			return null;
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(rs, stat, conn);
		}
	}

	public Admin findAdminUP(String username, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from admin where username=? and password=?";
		try{
			conn=JDBCUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				Admin admin =new Admin();
				admin.setId(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				return admin;
			}else{
				return null;
			}
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JDBCUtils.close(rs, ps, conn);
			}
	}

	public List findMessage() {
		return null;
	}

	public void addMsg(Message msg) {		
	}

	public Message findMsg(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateMsg(Message msg) {
		// TODO Auto-generated method stub
		
	}

	public void deleteMsg(Message msg) {
		// TODO Auto-generated method stub
		
	}


	
}
