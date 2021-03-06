package com.wushengde.jsp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.domain.Book;

public class BookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.获取要看的书的id，查询数据库找出书的详细信息：

		String id = request.getParameter("id");
		Book book = BookDao.getBook(id);
		if (book == null) {
			response.getWriter().write("找不到这本书");
			return;
		} else {
			response.getWriter().write("<h1>书名：" + book.getName() + "</h1>");
			response.getWriter().write(
					"<h3>价格：" + book.getPrice() + "元" + "</h3>");
			response.getWriter().write("<h3>作者：" + book.getAuthor() + "</h3>");
			response.getWriter()
					.write("<h3>出版社：" + book.getPublish() + "</h3>");
			response.getWriter().write(
					"<h3>描述：" + book.getDescrption() + "</h3>");
		}

		// 2.发送cookie保存看过的书:
		String ids = "";
		Cookie[] cs = request.getCookies();
		Cookie findC = null;
		if (cs != null) {
			for (Cookie c : cs) {
				if ("last".equals(c.getName())) {
					findC = c;
				}
			}
		}
		if (findC == null) {
			ids += book.getId();
		} else {
			String[] olds = findC.getValue().split(",");
			StringBuffer buffer = new StringBuffer();
			buffer.append(book.getId() + ",");
			for (int i = 0; i < olds.length
					&& buffer.toString().split(",").length < 3; i++) {
				String old = olds[i];
				if (!old.equals(book.getId())) {
					buffer.append(old + ",");
				}
			}
			ids = buffer.substring(0, buffer.length() - 1);
		}
		// 此句是创建一个Cookie的对象：并且此对象没有无参构造函数需要直接设置其name以及其value
		Cookie lastC = new Cookie("last", ids);
		// 此句设置Cookie对象在浏览器中保存的时间：以秒作为单位（以下表示存储一个月）
		lastC.setMaxAge(3600 * 24 * 30);
		// 此句设置Cookie对象都传入到哪个路径下的所有servlet页面
		lastC.setPath(request.getContextPath());
		// 此句表示将这个Cookie发送个浏览器使其保存该Cookie
		response.addCookie(lastC);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
