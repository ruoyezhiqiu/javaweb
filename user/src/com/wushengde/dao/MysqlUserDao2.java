package com.wushengde.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.wushengde.domain.Admin;
import com.wushengde.domain.Message;
import com.wushengde.domain.User;
import com.wushengde.util.JDBCUtils;

public class MysqlUserDao2 implements UserDao {

	@Test
	public void addUser(User user) {
		Connection conn=null;
		//PreparedStatement��ֹsqlע�빥��
		PreparedStatement ps=null;
		String sql="insert into users values(null,?,?,?,?)";
		try{
		conn=JDBCUtils.getConn();
		ps=conn.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getNickname());
		ps.setString(4,user.getEmail());
		ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
	}

	public User findUserByUNandPSW(String username, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users where username=? and password=?";
		try{
		conn=JDBCUtils.getConn();
		ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		rs=ps.executeQuery();
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
			JDBCUtils.close(rs, ps, conn);
		}
	}

	public User findUserName(String username) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users where username=?";
		try{
		conn=JDBCUtils.getConn();
		ps=conn.prepareStatement(sql);
		ps.setString(1, username);
		rs=ps.executeQuery();
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
			JDBCUtils.close(rs, ps, conn);
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
		Connection conn=null;
		Statement stat=null;
		ResultSet rs=null;
		String sql="select * from message";
		try{
			List list = new ArrayList();
			conn=JDBCUtils.getConn();
			stat=conn.createStatement();
			rs=stat.executeQuery(sql);
			while(rs.next()){
				Message message= new Message();
				message.setId(rs.getInt("id"));
				message.setTitle(rs.getString("title"));
				message.setContext(rs.getString("context"));
				message.setTime(rs.getString("time"));
				list.add(message);
			}
			return list;
			}catch(Exception e){
				e.printStackTrace();
				throw new RuntimeException(e);
			}finally{
				JDBCUtils.close(rs, stat, conn);
			}
	}

	public void addMsg(Message msg) {
		Connection conn=null;
		//PreparedStatement��ֹsqlע�빥��
		PreparedStatement ps=null;
		String sql="insert into message values(null,?,?,?)";
		try{
		conn=JDBCUtils.getConn();
		ps=conn.prepareStatement(sql);
		ps.setString(1, msg.getTitle());
		ps.setString(2, msg.getContext());
		ps.setString(3, msg.getTime());
		ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally{
			JDBCUtils.close(null, ps, conn);
		}
	}

	public Message findMsg(int id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Message msg=null;
		String sql="select * from message where id=?";
		try{
			conn=JDBCUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				msg= new Message();
				msg.setId(rs.getInt("id"));
				msg.setTitle(rs.getString("title"));
				msg.setContext(rs.getString("context"));
				msg.setTime(rs.getString("time"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,ps,conn);
		}
		return msg;
	}

	public void updateMsg(Message msg) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="update message set title=?,context=?,time=? where id=?";
		try{
			conn=JDBCUtils.getConn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, msg.getTitle());
			ps.setString(2, msg.getContext());
			ps.setString(3,msg.getTime());
			ps.setInt(4, msg.getId());
			ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,ps,conn);
		}
	}

	public void deleteMsg(Message msg) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="delete from message where id=?";
		try{
		conn=JDBCUtils.getConn();
		ps=conn.prepareStatement(sql);
		ps.setInt(1, msg.getId());
		ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,ps,conn);
		}
	}

	
}

