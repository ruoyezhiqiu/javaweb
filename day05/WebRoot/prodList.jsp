<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>
	<body>
		<!-- 以下java脚本实现所有跳转地址的URL重写：目的避免用户禁用Cookie信息而无法实现购物
  URL重写的作用：给每一个URL一个session标识，从标识的方式解决问题，即不使用jsession的cookie来标记session。
   -->
   <!-- 禁用cookie的情况下使用URL重写的方式在URL中保存sessionid的值来标记不同的session 可以查看该页面的源码验证-->
		<%
			request.getSession();
			String url01 = request.getContextPath()+ "/servlet/BuyServlet?prod=电视机";
			url01 = response.encodeURL(url01);
			String url02 = request.getContextPath()+ "/servlet/BuyServlet?prod=冰箱";
			url02 = response.encodeURL(url02);
			String url03 = request.getContextPath() + "/servlet/PayServlet";
			url03 = response.encodeURL(url03);
		%>
		<a href="<%=url01 %>">电视机</a>
		<br>
		<a href="<%=url02 %>">电冰箱</a>
		<br>
		<a href="<%=url03 %>">结账</a>
	</body>
</html>
