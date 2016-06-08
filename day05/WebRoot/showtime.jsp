<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <font color="red">
  <%-- 以下代码属于jsp中的脚本片段用：“<%若干java语句 %>”表示 --%>
  <%
    Date date = new Date();
    String dateStr = date.toLocaleString();
    //此处的out是jsp的9大内置隐式对象之一：相当于response.getWriter()。
    out.write(dateStr);
  %>
  
  <%-- 此处属于jsp页面的脚本表达式且后面不用跟分号用：“<%=java表达式 %>”表示 --%>
  <%=new Date().toLocaleString()%>
     </font>
  </body>
</html>
