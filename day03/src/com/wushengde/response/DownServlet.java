package com.wushengde.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载图片视频等将图片发送到浏览器
 * 
 * @author john
 * 
 */
public class DownServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

/*		response.setContentType("text/html;charset=utf-8");
		Writer writer = response.getWriter();
		writer.write("北京");
		writer.close();*/

		// 实现下载功能，其中可以下载图片视频等等文件。
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode("美女.jpg","utf-8"));
		InputStream in = new FileInputStream(this.getServletContext().getRealPath("images/a.jpg"));
		OutputStream out = response.getOutputStream();

		byte[] bs = new byte[1024];
		int i = 0;
		while ((i = in.read(bs)) != -1) {
			out.write(bs, 0, i);
		}
		in.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public static void main(String[] args) {
		//测试URL编码解码过程：
		String str = "中国";
		try {
			String str2 = URLEncoder.encode(str,"utf-8");
			System.out.println(str2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String str3 =URLDecoder.decode("%E4%B8%AD%E5%9B%BD","utf-8");
			System.out.println(str3);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
