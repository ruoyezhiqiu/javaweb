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
		//1.��ȡ�û����룺
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.��ѯ���ݿ����û������룺
		if(UserDao.valiNamePsw(username, password)){
			//3.�����ȷ�ض�����ҳ��
			request.getSession().setAttribute("user", username);
			response.sendRedirect(request.getContextPath()+"/loginout/index.jsp");
			//ת�����ض�������һ��return����ֹ�����������ִ��
			return;
			
		}else{
		
		//4.���������ʾ����
		response.getWriter().write("�û������벻��ȷ�����������룡");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
