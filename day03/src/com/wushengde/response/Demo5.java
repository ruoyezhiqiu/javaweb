package com.wushengde.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//request实现请求转发：request.getRequestDispatcher("虚拟路径").forward(request,response);
public class Demo5 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// request实现请求转发：与this.getServletContext.getRequestDispatecher("/servlet/Demo6").forward(request,response);一样的功能。
		response.setContentType("text/html;charset=utf-8");
		// response.getOutputStream().write("你好啊".getBytes("utf-8"));
		response.getWriter().write("from Demo5");
		// 此句代码将会把内容打印到浏览器，结束一次请求的响应！注：浏览器的一次请求只能对应服务器的一次响应！
		// 如果没有以下语句，将实现请求转发，response中的缓存内容将被清空。
		// response.getWriter().flush();
		// 此句代码将出现异常。
		request.getRequestDispatcher("/servlet/Demo6").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
