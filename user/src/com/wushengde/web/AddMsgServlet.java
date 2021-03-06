package com.wushengde.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.wushengde.domain.Message;
import com.wushengde.domain.User;
import com.wushengde.service.UserService;

public class AddMsgServlet extends HttpServlet {
	UserService service = new UserService();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		Message msg= new Message();
		try {
			BeanUtils.populate(msg, request.getParameterMap());
			service.addMessages(msg);
			UserService us = new UserService();
			us.updateMsg(msg);
			List list = new ArrayList();
			list=service.findMessage();
			request.getSession().setAttribute("adminmsg", list);
			response.getWriter().write("恭喜您添加成功！3秒后跳转......");
			response.setHeader("Refresh", "3;url="+request.getContextPath()+"/admin.jsp");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} 
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}
