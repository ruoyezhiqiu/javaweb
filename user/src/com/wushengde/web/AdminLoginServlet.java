package com.wushengde.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.dao.MysqlUserDao2;
import com.wushengde.dao.UserDao;
import com.wushengde.domain.Admin;
import com.wushengde.domain.User;
import com.wushengde.service.UserService;

public class AdminLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.处理乱码问题
		response.setContentType("text/html;charset=utf-8");
		//2.处理POST提交的乱码
		request.setCharacterEncoding("utf-8");
		//3.获取客户端提供的用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//4.调用service方法检查用户名密码
		UserService service = new UserService();
		Admin admin = service.isAdmin(username, password);
		//5.如果不正确则提示
		if(admin==null){
			request.setAttribute("msg", "用户名密码不正确！");
			request.getRequestDispatcher("/adminlogin.jsp").forward(request, response);
			return;
		//6.如果正确则登录用户后重定向到主页
		}else{
			List list = new ArrayList();
			list=service.findMessage(); 
			//7.如果用户勾选了记住用户名，则发送cookie令浏览器保存用户名
			 request.getSession().setAttribute("adminmsg", list);
			 request.getSession().setAttribute("admin", admin);
			if("ok".equals(request.getParameter("rename"))){
				Cookie reNameC = new Cookie("rename",URLEncoder.encode(admin.getUsername(),"utf-8") );
				reNameC.setMaxAge(3600*24*30);
				reNameC.setPath(request.getContextPath());
				response.addCookie(reNameC);
			}else{
			//8.如果用户没有勾选记住用户名，则删除历史的cookie：删除方式：发送同名同path无内容且MaxAge为0的cookie给浏览器
				Cookie reNameC = new Cookie("rename","");
				reNameC.setPath(request.getContextPath());
				reNameC.setMaxAge(0);
				response.addCookie(reNameC);
			}
			response.sendRedirect(request.getContextPath()+"/admin.jsp");
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);

	}

}
