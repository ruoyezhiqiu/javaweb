package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Demo4 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*		String str = (String) request.getAttribute("banana");
		System.out.println(str);
		response.getWriter().write(str);*/
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("��� ���� !");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
