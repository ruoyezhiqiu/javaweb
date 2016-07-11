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
 * 配置tomcat内部的数据连接源：步骤
 * 第一步：在META-INF中写一个context.xml文件做相应的配置
 * 第二步：此处在servlet中演示，需要实现服务器已启动时执行该servlet，即：在web.xml中的servlet标签
 * 中作如下配置：<load-on-startup>1</load-on-startup>
 * 第三步：因为是启动服务器时加载该web应用，则会调用init()方法：将获取方法写进该方法中
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
				System.out.println("姓名:"+name);
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
