package com.wushengde.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.domain.User;
import com.wushengde.service.UserService;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.������������
		response.setContentType("text/html;charset=utf-8");
		//2.����POST�ύ������
		request.setCharacterEncoding("utf-8");
		//3.��ȡ�ͻ����ṩ���û�������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//4.����service��������û�������
		UserService service = new UserService();
		User user = service.isUser(username, password);
		//5.�������ȷ����ʾ
		if(user==null){
			request.setAttribute("msg", "�û������벻��ȷ��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		//6.�����ȷ���¼�û����ض�����ҳ
		}else{
			//7.����û���ѡ�˼�ס�û���������cookie������������û���
			request.getSession().setAttribute("user", user);
			if("ok".equals(request.getParameter("rename"))){
				Cookie reNameC = new Cookie("rename",URLEncoder.encode(user.getUsername(),"utf-8") );
				reNameC.setMaxAge(3600*24*30);
				reNameC.setPath(request.getContextPath());
				response.addCookie(reNameC);
			}else{
			//8.����û�û�й�ѡ��ס�û�������ɾ����ʷ��cookie��ɾ����ʽ������ͬ��ͬpath��������MaxAgeΪ0��cookie�������
				Cookie reNameC = new Cookie("rename","");
				reNameC.setPath(request.getContextPath());
				reNameC.setMaxAge(0);
				response.addCookie(reNameC);
			}
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}

}