<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- pageContext是jsp中的内置对象：也是域对象，是九大内置对象中最重要的一个对象！   -->
<html>
  <head>
  </head>
  
  <body>
    <% pageContext.setAttribute("name","zhang",pageContext.REQUEST_SCOPE); %>
    
    <%=request.getAttribute("name") %>
    <%=pageContext.getAttribute("name",pageContext.REQUEST_SCOPE) %>
    <%
    pageContext.setAttribute("name2","张三丰");
    request.setAttribute("name2","张无忌");
    session.setAttribute("name2","赵敏");
    application.setAttribute("name2","小昭");
     %>
     <!-- pageContext.findAttribute()方法是从最小的域开始搜索(即搜寻顺序是：最小的域到最大的域)，当这4个域中都存在相同的键时，取其中域范围最小的那个键的值 -->
    <%=pageContext.findAttribute("name2") %>
    <!--  当pageContext.findAttribute()搜寻的键不存在时，返回null -->
    <%=pageContext.findAttribute("name3") %>
    <!-- pageContext对象还提供了请求转发跟请求包含的快捷方法，请参考3.jsp页面 -->
  </body>
</html>
