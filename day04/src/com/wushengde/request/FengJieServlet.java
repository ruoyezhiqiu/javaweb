package com.wushengde.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * ʵ�ַ��������ܣ��ж�����ͷ�е�Referer�е������Ƿ�������ʵ����ȷ�����ӡ�
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
			response.getWriter().write("���ں����������ջ��˺ܶ�ܶ�......");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
