package com.wushengde;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SConfigServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//获取当前servlet在web.xml中<servlet>标签里的配置对象
		ServletConfig config=this.getServletConfig();
		//获取当前servlet在web.xml中<servlet>标签里配置的名称
/*		String Sname=config.getServletName();
		System.out.println(Sname);*/
		//获取当前servlet在web.xml中<servlet>标签里的初始化参数
/*		String value = config.getInitParameter("name2");
		System.out.println(value);*/
		
		
		Enumeration enumeration = config.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String name =(String) enumeration.nextElement();
			String values = config.getInitParameter(name);
			System.out.println(name+":"+values);
		}
		
		
//		ServletContext context = config.getServletContext();
		ServletContext context = this.getServletContext();
		//设置一个一个servletcontext 键值对，然后再整个web应用中都能调用这个键值对。
		context.setAttribute("apple", "red apple");
		
		
		//获取web应用的初始化信息：
		Enumeration contextEnumeration = context.getInitParameterNames();		
		while(contextEnumeration.hasMoreElements()){
			String name =(String) contextEnumeration.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
