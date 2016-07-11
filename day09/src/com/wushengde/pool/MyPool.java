package com.wushengde.pool;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.DataSource;

/**
 * 自定义一个数据库连接池：实际开发中都是用一些开源的连接池
 * @author john
 *
 */
public class MyPool implements DataSource {
	
	private static List<Connection> pool= new LinkedList<Connection>();
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			for(int i=0;i<5;i++){
			Connection conn=DriverManager.getConnection("jdbc:mysql:///day09","root","123456");
			pool.add(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	/**
	 * 利用动态代理改造conn中的close()方法，让其直接将conn放到地址池
	 */
	public Connection getConnection() throws SQLException {
		if(pool.size()==0){
			for(int i=0;i<5;i++){
				Connection conn=DriverManager.getConnection("jdbc:mysql:///day09","root","123456");
				pool.add(conn);
				}
		}
		
		 final Connection conn=pool.remove(0);
		
		//--利用动态代理改造conn中的close()方法：
		
		Connection proxy =(Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if("close".equals(method.getName())){
					//对于想要改造的方法：此处是conn的close()方法 进行改造：
					//注：匿名内部类调用外部对象时，外部对象必须是final类型的
					retConn(conn);
					return null;
				}else{
					//对于不想改造的方法：调用被代理者身上相同的方法：
					return method.invoke(conn, args);
				}
			}
			
		});
		
		System.out.println("获取了一个连接，池里还剩余"+pool.size()+"个连接");
		return proxy;

	}

	private void retConn(Connection conn){
		try{
		if(conn!=null && !conn.isClosed()){
			pool.add(conn);
			System.out.println("还回了一个连接，池里还剩余"+pool.size()+"个连接");
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public Connection getConnection(String username, String password)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub

	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
