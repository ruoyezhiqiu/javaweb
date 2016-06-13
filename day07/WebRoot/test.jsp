<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <p>hello world</p>
  <p style="color:red;">注：jsp的内置对象pageContext可以实现页面包含以及请求转发</p>
  <% pageContext.include("/index.jsp?name=wudi"); %>
  <% pageContext.forward("/index.jsp?name=xiaoming"); %>

  </body>
</html>
