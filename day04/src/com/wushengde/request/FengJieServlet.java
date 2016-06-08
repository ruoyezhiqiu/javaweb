package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 实现防盗链功能：判断请求头中的Referer中的链接是否是其真实的正确的链接。
 */
public class FengJieServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			response.setContentType("text/html;charset=utf-8");
			String ref = request.getHeader("Referer");
			if(ref==null || "".equals(ref) || !ref.startsWith("http://localhost:8080/day04/index.html")){
				response.sendRedirect(request.getContextPath()+"/index.html");
				return;
			}
			response.getWriter().write("我在黑马的日子里，收获了很多很多......");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
