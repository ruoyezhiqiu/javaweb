package com.wushengde.init;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * ����tomcat�ڲ�����������Դ������
 * ��һ������META-INF��дһ��context.xml�ļ�����Ӧ������
 * �ڶ������˴���servlet����ʾ����Ҫʵ�ַ�����������ʱִ�и�servlet��������web.xml�е�servlet��ǩ
 * �����������ã�<load-on-startup>1</load-on-startup>
 * ����������Ϊ������������ʱ���ظ�webӦ�ã�������init()����������ȡ����д���÷�����
 * @author john
 *
 */
public class DataSourceInitServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}


	@Override
	public void init() throws ServletException {
		try {
			
			Context initCtx = new InitialContext();
			Context jndi =(Context) initCtx.lookup("java:comp/env");
			DataSource source = (DataSource) jndi.lookup("mysource");
			
			Connection conn=source.getConnection();
			PreparedStatement ps=conn.prepareStatement("select*from account");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("name");
				System.out.println("����:"+name);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	

}
