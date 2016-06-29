<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://www.wushengde.com/UserTag" prefix="UserTag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	</head>

	<body>
	<div align="center">
		<h1>&nbsp; 
			我的网站-管理员登录 
		</h1>
		<form
			action="${pageContext.request.contextPath }/servlet/AdminLoginServlet"
			method="POST">
			<table border="1">
				<tr>
					<td>
						用户名：
					</td>
					<td>
					<!-- 此处为了防止使用java代码，自定义了UserTag标签来实现URL解码cookie中的中文信息 -->
						<input type="text" name="username" value="<UserTag:URLDEcoder content="${cookie.rename.value }" encode="utf-8"/>" />
					</td>
					<td><input type="checkbox" name="rename" value="ok"
					<c:if test="${cookie.rename!=null }">
						checked="checked"
					</c:if>
					 />记住用户名</td>
				</tr>

				<tr>
					<td>
						密码：
					</td>
					<td colspan="2">
						<input type="password" name="password" />
					</td>
				</tr>
				<tr>
				<td><input type="submit" value="登录" /></td>
				<td colspan="2"><font color="red">${msg }</font></td>
				</tr>
			</table>
		</form>
		</div>
	</body>
</html>
