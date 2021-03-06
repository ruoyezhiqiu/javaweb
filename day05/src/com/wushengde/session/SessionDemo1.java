package com.wushengde.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * Session的使用：表示一次会话，session是一个域：
 * 作用范围：当前会话的范围
 * 生命周期：当程序第一次调用到request.getSession()方法时，说明客户端明确
 * 的需要session对象；1.当超过30分钟（可在xml中修改）未使用session时则session
 * 超时，自动销毁；2.程序中明确调用了session.nvalidate()方法时，session销毁
 * 3.当服务器非正常关闭时session被销毁！
 * session的作用:在会话范围内共享数据
 * session的钝化与活化：
 * 如果服务器是正常关闭,还未超时的session会被以文件的形式保存在服务器的work目录下,这个过程叫做session的钝化.
 * 下次再正常启动服务器时,钝化着的session会被恢复到内存中,这个过程叫做session的活化.
 * session的超时配置请查看当前web应用下的web.xml中的<session-config>标签中的内容。
 */
public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("name", "zhangsanfeng");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

}
