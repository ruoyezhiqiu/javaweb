<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <h1 style="text-align:center;">编辑文章</h1>
    <form action="${pageContext.request.contextPath }/servlet/EditEndServlet" method="POST">
    <input type="hidden" name="id" value="${sessionScope.message.id }"/>
	标题：<input type="text" name="title" value="${sessionScope.message.title }"/><br><br>
	文章内容：<textarea name="context" style="height:200px;width:80%;">${sessionScope.message.context }</textarea><br><br>
	发布日期：<input type="text" name="time" value="${sessionScope.message.time }"/><br><br>
	<input type="submit" value="更新" />
</form>
  </body>
</html>
