<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 此页面将利用session防止页面重复提交-->
<html>
	<head>
	<script type="text/javascript">
	var isNotSub = true;
	function canSub(){
		if(isNotSub){
		isNotSub=false;
		return true;
		}else{
		alert("请不要重复提交!!!");
		return false;
		}
	}
	</script>
	</head>
	<body>
		<%
		//此句定义一个生成随机数的对象：用Random这个类来定义的
		Random r = new Random();
		//此句返回下一个伪随机数int的值并赋值给valinum变量
		int valinum = r.nextInt();
		//此句是将生成的随机数存到session中，其中的value为：valinum+"" 表示将结果转换为字符串类型,
		//到时候取就不需要再进行类型转换了！
		session.setAttribute("valinum",valinum+"");
		 %>
		<form action="${pageContext.request.contextPath}/servlet/ResubServlet"
			method="POST" onsubmit="return canSub()">
			用户名：
			<input type="text" name="username" />
			<input type="hidden" name="valinum" value="<%=valinum %>" />
			<input type="submit" value="注册" />
		</form>
	</body>
</html>
