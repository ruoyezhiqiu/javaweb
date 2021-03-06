package com.wushengde.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * 涉及请求参数中乱码的问题：get请求中的乱码解决方法：
 * 
 */
public class BuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是从哪个页面跳转过来的，即获取请求参数中prod的值来判断：
		String prod = request.getParameter("prod");
		//处理请求参数中的中文的乱码(此处是get提交方式：若使用request.setCharacterEncoding("utf-8")则无效，其只对post方式有效)
		//以下方式解决了get请求参数中的乱码问题：
		prod = new String(prod.getBytes("iso-8859-1"),"utf-8");
		
		//创建一个session对象,每一个session在创建时都会创建一个id为JSESSIONID的Cookie，但是这个Cookie会随着浏览器的关闭而消失
		//session的工作原理：基于cookie来工作的，浏览器保存session创建的id为jsession的cookie，该（此）浏览器再次访问时会携带这个cookie
		//到服务器中找到相应的session，然后就能获取其中保存的数据；但是session自己创建的这个cookie没有设置MaxAge当浏览器关闭时，将不会保存这个cookie
		//因此需要手动创建一个跟这个cookie完全相同的cookie，然后添加设置其MaxAge（建议设置半小时与session的生命周期同步）来保存cookie。
		HttpSession session = request.getSession();
		//创建与session中生成的相同的cookie，然后设置其MaxAge，来避免关闭浏览器丢失id为jsession的cookie
		Cookie jc = new Cookie("JSESSIONID",session.getId());
		jc.setPath(request.getContextPath());
		jc.setMaxAge(1800);
		response.addCookie(jc);
		session.setAttribute("prod", prod); 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
