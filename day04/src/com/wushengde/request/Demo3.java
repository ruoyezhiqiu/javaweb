package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo3 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("banana", "yellow banana");
		//请求转发：将request携带的键值对，转发到Demo4页面去。
		//this.getServletContext().getRequestDispatcher("/servlet/Demo4").forward(request, response);
		response.sendRedirect("/day04/servlet/Demo4");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
