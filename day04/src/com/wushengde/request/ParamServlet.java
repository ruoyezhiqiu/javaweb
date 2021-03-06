package com.wushengde.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ParamServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * String username = request.getParameter("username");
		 * System.out.println(username); response.getWriter().write(username);
		 */
		//通知服务器以什么编码解码http中请求实体的内容，即只能解决post提交的请求，不能解决get提交的请求中的乱码问题！
		//对于get请求只能使用手动解决乱码！
		request.setCharacterEncoding("utf-8");
		Enumeration<String> enumeration = request.getParameterNames();
		while (enumeration.hasMoreElements()) {

			String name = enumeration.nextElement();
			String value = request.getParameter(name);
			//此处手动解决了乱码问题：此方法也适合post请求的提交方式：
			value = new String(value.getBytes("iso-8859-1"),"utf-8");
			System.out.println(name + ":" + value + " ");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
