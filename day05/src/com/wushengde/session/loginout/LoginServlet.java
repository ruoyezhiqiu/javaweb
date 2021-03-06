package com.wushengde.session.loginout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setContentType("text/html;charset=utf-8"); 
		//1.获取用户密码：
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.查询数据库检查用户名密码：
		if(UserDao.valiNamePsw(username, password)){
			//3.如果正确重定向到主页：
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/loginout/index.jsp");
			//转发和重定向后建议跟一个return，防止后续代码继续执行
			return;
			
		}else{
		
		//4.如果错误提示错误：
		response.getWriter().write("用户名密码不正确，请重新输入！");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
