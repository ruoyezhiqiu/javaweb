package com.wushengde.jdbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Demo {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		//MyPool pool = new MyPool();
		
		//创建数据连接方式一：
		
/*		//1.创建数据源：
		BasicDataSource source= new BasicDataSource();
		//2.设置数据源驱动
		source.setDriverClassName("com.mysql.jdbc.Driver");
		//3.设置数据库的连接语句
		source.setUrl("jdbc:mysql:///day09");
		//4.设置数据库连接的用户名
		source.setUsername("root");
		//5.设置数据库连接的密码
		source.setPassword("123456");*/
		
		try {
			
			//创建数据库连接方式二：使用配置文件将其中的参数都封装起来
/*		 	Properties prop = new Properties();
			prop.load(new FileReader("dbcp.properties"));
			BasicDataSourceFactory factory= new BasicDataSourceFactory();
			DataSource source= factory.createDataSource(prop);*/
		
				
			//创建数据库连接方式三：使用C3P0开放数据库连接池连接数据库
			
			//C3P0基于参数配置：
/*			ComboPooledDataSource source= new ComboPooledDataSource();
			source.setDriverClass("com.mysql.jdbc.Driver");
			source.setJdbcUrl("jdbc:mysql:///day09");
			source.setUser("root");
			source.setPassword("123456");*/
			
			//C3P0基于配置文件配置：默认会去类加载目录中找：c3p0-config.xml 文件，一句代码搞定数据库连接！
			
			ComboPooledDataSource source= new ComboPooledDataSource();
			
			//1.利用JDBCUtils工具类 -->获取数据库连接:conn
			// conn=JDBCUtils.getConn();
			
			//2.利用自定义地址池 -->获取数据库连接:conn
			//conn=pool.getConnection();
			
			//3.利用开源数据库连接池 -->获取数据库连接:conn
			conn=source.getConnection();
			
			ps = conn.prepareStatement("select * from account");
			rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				System.out.println(name);
			}
		} catch (Exception e) {

		} finally {
			//其中的close()方法后台已经改造好了，自动还到地址池中去，我们只需要按照常规写法即可完成
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
