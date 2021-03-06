package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * request获取请求头信息
 */
public class CustinfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.获取客户端完整的URL:getRequestURL()
		String url = request.getRequestURL().toString();
		System.out.println(url);
		// 2.获取客户端请求的资源信息：getRequestURI()
		String uri = request.getRequestURI();
		System.out.println(uri);
		// 3.获取请求行中参数部分：getQueryString()
		String qStr = request.getQueryString();
		System.out.println(qStr);
		// 4.获取请求客户端的ip地址：getRemoteAddr()
		String ip = request.getRemoteAddr();
		System.out.println(ip);
		// 5.获取客户端的请求方式：getMethod()
		String method = request.getMethod();
		System.out.println(method);
		// 6.获取当前web应用的名称(注：此处是应用名称非工程名称)：getContextPath()
		String name = request.getContextPath();
		System.out.println(name);
		// 注：当需要使用web应用名称的时候，不能使用真正的web应用名称，需要使用以下方式：
		// 目的是为了防止当修改了发布的web名称时依然可以实现跳转：
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
