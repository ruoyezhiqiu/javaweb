package com.wushengde.dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtilsUpdate {
	/*
	 * 自定义MyQueryRunner类实现与QueryRunner相同的功能
	 */
	
	//使用MyQueryRunner实现更改数据库信息
	@Test
	public void update3() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?", 777,"a");
	}
	
	//使用MyQueryRunner实现新增功能
	@Test
	public void add() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("insert into account values(null,?,?)", "c",555);
	}
	
	//使用MyQueryRunner实现删除数据的功能
	@Test
	public void delete() throws SQLException{
		MyQueryRunner runner=new MyQueryRunner(new ComboPooledDataSource());
		runner.update("delete from account where name=?", "a");
	}
	
	/*
	 * DBUtils框架中的QureyRunner类实现增删改的功能
	 */
	
	//以下方式使用DBUtils框架实现改的功能只需要两行代码
	@Test
	public void update2() throws SQLException{
		QueryRunner runner=new QueryRunner(new ComboPooledDataSource());
		runner.update("update account set money=? where name=?",888,"a");
	}
	
	
	/*
	 * 古老的增删查改代码编写
	 */
	//实现改的方法
	
	@Test
	public void update1(){
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	ComboPooledDataSource source=new ComboPooledDataSource();
		try{
			conn=source.getConnection();
			ps=conn.prepareStatement("update account set money=? where name=?");
			ps.setDouble(1, 999);
			ps.setString(2, "a");
			ps.executeUpdate();
		}catch(Exception e){
		e.printStackTrace();
		}finally{
			DbUtils.closeQuietly(conn, ps, rs);
		}
	}
}
