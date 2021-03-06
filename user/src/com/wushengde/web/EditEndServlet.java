package com.wushengde.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wushengde.domain.Message;
import com.wushengde.service.UserService;
import com.wushengde.util.JDBCUtils;

public class EditEndServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService service= new UserService();
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String context = request.getParameter("context");
		String time = request.getParameter("time");
		Message msg = new Message(id, title, context, time);
		UserService us = new UserService();
		us.updateMsg(msg);
		List list = new ArrayList();
		list=service.findMessage();
		request.getSession().setAttribute("adminmsg", list);
		response.getWriter().write("恭喜您更新成功！3秒后跳转......");
		
//		response.sendRedirect(request.getContextPath() + "/index.jsp");
		response.setHeader("Refresh","3;url="+request.getContextPath()+"/admin.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
