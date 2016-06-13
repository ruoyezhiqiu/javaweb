<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  	function changeImg(img){
  		img.src = img.src+"?time="+new Date().getTime(); 
  	}
  </script>
  </head>
  
  <body>
  <div align="center">
  <h1>我的网站-注册</h1>
  <form action="${pageContext.request.contextPath }/servlet/RegistServlet" method="POST">
  	<table border="1">
  		<tr>
  			<td>用户名：</td>
  			<!-- 其中的value值实现了数据回显，使用了EL表达式中11个内置对象中的param(代表所有请求参数组成的Map<String,String>) -->
  			<td><input type="text" name="username" value="${param.username }" /></td>
  		</tr>
  		
  		<tr>
  			<td>密码：</td>
  			<td><input type="password" name="password"/></td>
  		</tr>
  		
  		<tr>
  			<td>确认密码：</td>
  			<td><input type="password" name="password2"/></td>
  		</tr>
  		
  		<tr>
  			<td>昵称：</td>
  			<td><input type="text" name="nickname" value="${param.nickname }" /></td>
  		</tr>
  		
  		<tr>
  			<td>邮箱：</td>
  			<td><input type="text" name="email" value="${param.email }" /></td>
  		</tr>
  		
  		<tr>
  			<td>验证码：</td>
  			<td><input type="text" name="valistr"/></td>
  			<td><img src="${pageContext.request.contextPath }/servlet/ValiImg" style="cursor: pointer;" onclick="changeImg(this)" /></td>
  		</tr>
  		<tr>
  			<td><input type="submit" value="注册"/></td>
  			<td><font color="red">${msg }</font></td>
  		</tr>
  	</table>
  
  </form>
  </div>
  </body>
</html>
