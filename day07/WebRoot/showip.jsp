<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.wushengde.com/MyTag" prefix="MyTag"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>

  <body>
  
   java输出的P：<%=request.getRemoteAddr() %>
   
   <hr>
   
   传统标签输出的IP：<MyTag:showip/>
   
   <hr>
   
   简单标签输出的IP：<MyTag:simpleshowip/>
  </body>
</html>
