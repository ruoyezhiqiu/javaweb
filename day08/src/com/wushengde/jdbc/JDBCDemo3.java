package com.wushengde.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wushengde.util.JDBCUtils;



public class JDBCDemo3 {
	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try{
			conn=JDBCUtils.getConn();
			ps=conn.prepareStatement("select * from user where name=? and password=?");
			ps.setString(1, "�ܲ�");
			ps.setString(2, "123456");
			rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("�ܲٵ������ǣ�"+rs.getString("email"));
				return;
			}
			System.out.println("�û��������������");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtils.close(rs,ps,conn);
		}
	}
}
