<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wushengde.dao.MysqlUserDao2"%>
<%@page import="com.wushengde.dao.UserDao" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>首页</title>
  <style>
  td{
  text-align:center;
  }
  </style>
  </head>
  <body>
	<h1>我的网站</h1><hr>
	<c:if test="${sessionScope.user==null}">
		欢迎光临，游客！
		<a href="${pageContext.request.contextPath }/regist.jsp">用户注册</a>
		<a href="${pageContext.request.contextPath }/login.jsp">用户登录</a>
		<a href="${pageContext.request.contextPath }/adminlogin.jsp">管理员登录</a>
		<hr>
	</c:if>
	<c:if test="${sessionScope.user!=null}">
		欢迎回来,${sessionScope.user.username }!<a href="${pageContext.request.contextPath }/servlet/LogoutServlet">注销</a>
	 <hr>
	 <table border="1">
	 <tr>
	 <td style="width:5%;">序号</td>
	 <td style="width:10%;">标题</td>
	 <td style="width:80%;">文章内容</td>
	 <td style="width:5%;">发布日期</td>
	 </tr>
	 <%int i=1; %>
	<c:forEach items="${sessionScope.messages}" var="message">
	<tr>
	<td style="width:5%;"><%=i %><%i++; %></td>
	<td style="width:10%;">${message.title}</td>
	<td style="width:80%;">${message.context}</td>
	<td style="width:5%;">${message.time}</td>
	</tr>
	</c:forEach>
    </table> 
	</c:if>
  </body>
</html>
