package com.wushengde.request;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * URL����
 */
public class URLServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public static void main(String[] args)throws Exception {
		String str = "�й�";
		String str2 = URLEncoder.encode(str,"utf-8");
		System.out.println(str2);
		String str3 = URLDecoder.decode(str2,"utf-8");
		System.out.println(str3);
	}

}
