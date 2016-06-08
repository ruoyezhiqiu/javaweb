package com.wushengde;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * servletContext ʵ������ת����
 */
public class Demo02Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�˴��õ�·����ת��Ŀ��·��������·��������web.xml�����õ�servlet������·��
		//�˴���RequestDispatcher��һ��ת������
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/servlet/Demo03Servlet");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
