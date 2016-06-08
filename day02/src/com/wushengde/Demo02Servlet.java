package com.wushengde;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servletContext 实现请求转发：
 */
public class Demo02Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//此处用的路径是转发目的路径的虚拟路径，即：web.xml中配置的servlet的虚拟路径
		//此处的RequestDispatcher是一个转发器。
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/servlet/Demo03Servlet");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
