package com.wushengde.response;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 编码问题练习
 */
public class OutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 向浏览器输出中国两个字，并且设置其服务器编码及浏览器解码的编码类型：
		
		//此句代码设置了浏览器以“utf-8”的形式解码
		// response.setHeader("Content-Type", "text/html; charset=utf-8");
		
		//此句代码是服务器上将“中国”两字以“utf-8”的形式编码为二进制代码
		// response.getOutputStream().write("中国".getBytes("utf-8"));
		
		//此句代码是服务器上将“北京”两个字以“gbk”的形式编码编码为二进制代码
		// response.setCharacterEncoding("gbk");

		// 此行代码将解决所有服务器浏览器编码问题，统一规定了服务器浏览器编码解码类型：utf-8;
		response.setContentType("text/html;charset=utf-8");
		
		response.getWriter().write("北京");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
