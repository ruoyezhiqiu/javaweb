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
 * �Զ���һ�����ݿ����ӳأ�ʵ�ʿ����ж�����һЩ��Դ�����ӳ�
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
	 * ���ö�̬�������conn�е�close()����������ֱ�ӽ�conn�ŵ���ַ��
	 */
	public Connection getConnection() throws SQLException {
		if(pool.size()==0){
			for(int i=0;i<5;i++){
				Connection conn=DriverManager.getConnection("jdbc:mysql:///day09","root","123456");
				pool.add(conn);
				}
		}
		
		 final Connection conn=pool.remove(0);
		
		//--���ö�̬�������conn�е�close()������
		
		Connection proxy =(Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), new InvocationHandler(){

			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				if("close".equals(method.getName())){
					//������Ҫ����ķ������˴���conn��close()���� ���и��죺
					//ע�������ڲ�������ⲿ����ʱ���ⲿ���������final���͵�
					retConn(conn);
					return null;
				}else{
					//���ڲ������ķ��������ñ�������������ͬ�ķ�����
					return method.invoke(conn, args);
				}
			}
			
		});
		
		System.out.println("��ȡ��һ�����ӣ����ﻹʣ��"+pool.size()+"������");
		return proxy;

	}

	private void retConn(Connection conn){
		try{
		if(conn!=null && !conn.isClosed()){
			pool.add(conn);
			System.out.println("������һ�����ӣ����ﻹʣ��"+pool.size()+"������");
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
