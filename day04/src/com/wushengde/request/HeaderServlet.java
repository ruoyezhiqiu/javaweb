package com.wushengde.request;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeaderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求的头信息：getHeader();
		String host = request.getHeader("Host");
		System.out.println(host);
		// 获取所有请求头名字后再获取其值(枚举：enumeration)：getHeaderNames()、getHeader(name)
		Enumeration<String> enumeration = request.getHeaderNames();
		while(enumeration.hasMoreElements()){
			String name = enumeration.nextElement();
			String value = request.getHeader(name);
			System.out.println(name+":"+value);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
