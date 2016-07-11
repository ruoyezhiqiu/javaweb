package com.wushengde.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wushengde.pool.MyPool;
import com.wushengde.util.JDBCUtils;

/**
 * 利用自定义数据库连接池(MyPool) 创建数据库的连接
 * @author john
 *
 */
public class JDBCDemo01 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MyPool pool = new MyPool();
		try {
			// conn=JDBCUtils.getConn();
			conn=pool.getConnection();
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (Exception e) {

		} finally {
			if(rs!=null){
				try{
					rs.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					rs=null;
				}
			}
			if(ps!=null){
				try{
					ps.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					ps=null;
				}
			}
			if(conn!=null){
				try{
					conn.close();
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					conn=null;
				}
			}
		}
	}
}
