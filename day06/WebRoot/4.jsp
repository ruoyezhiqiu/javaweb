<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
		from 4.jsp......

		<!-- jsp中的标签技术实现jsp的请求包含，以下属于动态引入jsp页面：除了使用include指令引入jsp页面属于静态引入，其他的都是属于动态引入技术 -->
		
		<!-- jsp中的标签技术实现jsp的请求转发功能 -->
		<jsp:forward page="/index.jsp">
		<jsp:param value = "zhang" name="name"/>
		</jsp:forward>
	</body>
</html>
