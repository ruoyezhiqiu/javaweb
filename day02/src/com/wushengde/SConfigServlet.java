package com.wushengde;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SConfigServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//��ȡ��ǰservlet��web.xml��<servlet>��ǩ������ö���
		ServletConfig config=this.getServletConfig();
		//��ȡ��ǰservlet��web.xml��<servlet>��ǩ�����õ�����
/*		String Sname=config.getServletName();
		System.out.println(Sname);*/
		//��ȡ��ǰservlet��web.xml��<servlet>��ǩ��ĳ�ʼ������
/*		String value = config.getInitParameter("name2");
		System.out.println(value);*/
		
		
		Enumeration enumeration = config.getInitParameterNames();
		while(enumeration.hasMoreElements()){
			String name =(String) enumeration.nextElement();
			String values = config.getInitParameter(name);
			System.out.println(name+":"+values);
		}
		
		
//		ServletContext context = config.getServletContext();
		ServletContext context = this.getServletContext();
		//����һ��һ��servletcontext ��ֵ�ԣ�Ȼ��������webӦ���ж��ܵ��������ֵ�ԡ�
		context.setAttribute("apple", "red apple");
		
		
		//��ȡwebӦ�õĳ�ʼ����Ϣ��
		Enumeration contextEnumeration = context.getInitParameterNames();		
		while(contextEnumeration.hasMoreElements()){
			String name =(String) contextEnumeration.nextElement();
			String value = context.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
