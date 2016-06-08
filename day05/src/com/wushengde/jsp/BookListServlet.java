package com.wushengde.jsp;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wushengde.domain.Book;

public class BookListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 1.查询数据库（此处是一个BookDao类代替数据库）中所有的书：
		Map<String, Book> map = BookDao.getBooks();
		for (Map.Entry<String, Book> entry : map.entrySet()) {
			Book book = entry.getValue();
			response.getWriter().write(
					"<a href=' " + request.getContextPath()
							+ "/servlet/BookInfoServlet?id=" + book.getId()
							+ "'>" + book.getName() + "</a><br>");
		}
		response.getWriter().write("<hr>");
		// 2.显示看过的书：即接受Cookie存储的信息
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
			response.getWriter().write("您还没有看过任何书呢");
		} else {
			response.getWriter().write("您曾经浏览过的书有：<br>");
			String[] ids = findC.getValue().split(",");
			for (String id : ids) {
				Book book = BookDao.getBook(id);
				response.getWriter().write(book.getName() + "<br>");
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
