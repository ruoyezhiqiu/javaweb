package com.wushengde.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.domain.Message;
import com.wushengde.service.UserService;

public class DeleteServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int id =Integer.parseInt(request.getParameter("id"));
		UserService service =new UserService();
		Message msg=service.findMsg(id);
		service.deleteMsg(msg);
		UserService us = new UserService();
		us.updateMsg(msg);
		List list = new ArrayList();
		list=service.findMessage();
		request.getSession().setAttribute("adminmsg", list);
		response.getWriter().write("��ϲ��ɾ���ɹ���3��󷵻�......");
		response.setHeader("Refresh","3;url="+request.getContextPath()+"/admin.jsp");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
