package com.wushengde.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 创建一个工具类，注：工具类不能直接new！因此私有化其构造方法
 * 因为一般都是通过类名调用其中的方法，所以其中的方法都是静态方法
 * 此工具类提供数据库中的两个方法：
 * 1.获取连接的方法
 * 2.关闭连接的方法
 */
public class JDBCUtils {
	private JDBCUtils() {
	}
	private static Properties prop=null;
	/**
	 * 获取连接的方法：
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	static{
		try{
		prop = new Properties();
		//使用类加载器读取配置文件，即使在web工程中调用该方法一样能够执行(原理：类加载器用来读取class文件，class文件将由src目录导出，因此需要将配置文件放在跟class文件相同的目录下才能被类加载器读取！)
		prop.load(new FileReader(JDBCUtils.class.getClassLoader().getResource("config.properties").getPath()));
		}catch(Exception e){
			e.printStackTrace();
			//将异常继续往下抛
			throw new RuntimeException(e);
		}
	}
	public static Connection getConn() throws SQLException, ClassNotFoundException{
		//1.注册数据库驱动:利用反射实现:其中参数写死了，需要写进配置文件中
		//Class.forName("com.mysql.jdbc.Driver");
		//此方法可能被多次调用，如果将以下两行代码写在此处，将多此调用Properties的解析文件，执行麻烦.
		//Properties prop = new Properties();
		//prop.load(new FileReader(""));
		
		//此句代码灵活性更高：如果需要更改只需要更改配置文件
		Class.forName(prop.getProperty("driver"));
		//2.获取数据库连接,并返回该连接对象：其中参数写死了，需要写进配置文件中
		return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("user"),prop.getProperty("password"));
	}
	
	/**
	 * 关闭连接的方法：
	 */
	
	public static void close(ResultSet rs,Statement stat,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs=null;
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				stat=null;
			}
		}
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				conn=null;
			}
		}
	}
}
