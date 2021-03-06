<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wushengde.el.Person"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- jstl即:jsp标准标签库 -->
<!-- jstl中重点学习：核心标签库 (core)---c -->
<html>
	<head>
	</head>
	<body>
		<h1 style="text-align: center;">
			JSTL标签库的使用
		</h1>
		<h2>
			c:out标签的作用:
		</h2>
		<hr>
		<p style="color: red;">
			注：c:out 标签的功能都能用EL表达式实现，更常用的是EL 表达式来实现c:out相关的功能！
		</p>
		<h3>
			作用一：输出常量的值
		</h3>
		<span> 1.执行向浏览器输出常量：</span>
		<c:out value="这是要打印到浏览器的常量"></c:out>
		<hr>
		<h3>
			作用二：输出变量的值
		</h3>
		<hr>
		<%
			String name = "张无忌";
			pageContext.setAttribute("name", name);
		%>
		<!-- jstl中嵌套EL表达式 -->
		<span>2.执行向浏览器输出变量(其中变量的值由EL表达式获取，即jstl中嵌套EL表达式)：</span>
		<c:out value="${name}"></c:out>
		<h3>
			作用三：输出默认值
		</h3>
		<hr>
		<%
			String addr = "西二旗";
		%>
		<span>3.执行向浏览器打印一个默认的地址(因为以上脚本片段未将变量存到pageContext中，此时设置一个default为其默认值)：</span>
		<c:out value="${addr}" default="中关村软件园"></c:out>
		<br>
		<span style="color: red;">注：如果已经将这个变量存到了pageContext中，则依照存入的值为准</span>
		<h3>
			作用四：HTML转义输出
		</h3>
		<hr>
		<span>4.执行向浏览器转义输出a标签(可以由escapeXml属性设置其是否转义输出：其值默认为：true即默认为转义，若值为：false则不转义输出)：</span>
		<c:out value="<a href='#'>百度一下</a>" escapeXml="true"></c:out>

		<hr>
		<h2>
			c:set标签的作用:
		</h2>
		<hr>
		<h3>
			作用一：设置或修改域中的属性值
		</h3>
		<!-- 其中的scope属性有4个值，默认值是：page 其他的是request session application 即：四大作用域 -->
		<!-- 以下代码相当于在page域中存了一个新的属性：属性名为：name ，属性值为：韦小宝 -->
		<c:set var="name" value="韦小宝" scope="page"></c:set>
		<!-- 以下代码修改了page域中的name的值 -->
		<c:set var="name" value="赵云.子龙"></c:set>
		<span>执行EL表达式来获取存入到page域中的name变量的值：</span>${name }
		<hr>
		<h3>
			作用二：设置或修改域中的Map的值
		</h3>
		<%
			Map<String, String> map = new HashMap();
			pageContext.setAttribute("map", map);
		%>
		<!-- 利用c:set来设置pageContext域中的map中的属性与值 -->
		<c:set target="${map}" property="cellphone" value="888888"></c:set>
		<!-- 以下代码修改了pageContext域中的map的cellphone的属性的值，页面将显示：66666666 -->
		<c:set target="${map}" property="cellphone" value="66666666"></c:set>
		<span>执行获取pageContext域中的map中cellphone属性的值：</span>${map.cellphone }
		<h3>
			作用三：修改域中的javabean的属性的值
		</h3>
		<%
			Person p = new Person();
			pageContext.setAttribute("p", p);
		%>
		<c:set target="${p}" property="name" value="奥巴马"></c:set>
		<c:set target="${p}" property="age" value="18"></c:set>
		<span>执行显示p中的name属性值：</span>${name }

		<h2>
			c:remove标签的作用:
		</h2>
		<hr>
		<p style="color: red;">
			注：c:remove标签用于删除各种Web域中的属性 如果不写scope属性的值，将会删除每个域中所有name的属性值。
		</p>
		<%
			pageContext.setAttribute("namesanguo", "司马懿");
			request.setAttribute("namesanguo", "诸葛孔明");
			session.setAttribute("namesanguo", "周瑜.公瑾");
			application.setAttribute("namesanguo", "曹操.孟德");
		%>
		<c:remove var="namesanguo" scope="page" />
		<c:remove var="namesanguo" scope="request" />
		<c:remove var="namesanguo" scope="session" />
		${namesanguo }

		<h2>
			c:catch标签的作用:
		</h2>
		<hr>
		<p style="color: red;">
			注：c:catch标签用于捕获嵌套在标签体中的内容抛出的异常:
		</p>
		<c:catch var="e">
			<%
				int i = 1 / 0;
			%>
		</c:catch>
		${e.message }
		<h2>
			c:if标签的作用：
		</h2>
		<hr>
		<p style="color: red :">
			注：c:if标签用于判断
		</p>
		<c:if test="${2>1}">
			<p>
				确实是2>1的！
			</p>
		</c:if>
		<h2>
			c:choose标签的作用：
		</h2><hr>
		<p style="color:red;">
			注：c:choose标签用于指定多个条件选择的组合边界，它必须与c:when和c:otherwise标签一起使用。
		</p>
		<%
			int day = 3;
			pageContext.setAttribute("day", day);
		%>
		<c:choose>
			<c:when test="${day==1}">
     		星期一
     	</c:when>
			<c:when test="${day==2}">
     		星期二
     	</c:when>
			<c:when test="${day==3}">
     		星期三
     	</c:when>
			<c:when test="${day==4}">
     		星期四
     	</c:when>
			<c:when test="${day==5}">
     		星期五
     	</c:when>
		<c:otherwise>
			周末休息日
		</c:otherwise>
		</c:choose>
		
		
		<h2>c:foreach标签的作用</h2><hr>
		<p style="color:red;">注：c:forEach标签用于对一个集合对象中的元素进行循环迭代操作，或者按指定的次数重复迭代执行标签体中的内容。</p>
		<h3>作用一：遍历数组中的数据</h3>
		<% String[] sanguorenwu = {"刘备","关羽","张飞","赵云"};
			pageContext.setAttribute("sanguorenwu",sanguorenwu);
		 %>
		 <p>打印三国人物数组中存入的人物：</p>
		<c:forEach items="${sanguorenwu}" var="sanguo">
		${sanguo }
		</c:forEach>
	
		<h3>作用二：遍历集合中的数据</h3><hr>
		<% 
			List list = new ArrayList();
			list.add("美国");
			list.add("中国");
			list.add("日本");
			list.add("俄罗斯");
			pageContext.setAttribute("list",list);
		 %>
		 <p>遍历打印list集合中的元素：</p>
		 <c:forEach items="${list}" var="city">
		 	${city }
		 </c:forEach>
		 
		 <h3>作用三：遍历Map中的数据</h3>
		 <p style="color:red;">注：hashMap:无顺序；LinkedHashMap：有顺序</p> 
		 <%
		 	Map mapnew = new LinkedHashMap();
		 	mapnew.put("name","曹操");
		 	mapnew.put("age","60");
		 	mapnew.put("gender","男");
		 	pageContext.setAttribute("mapnew",mapnew);
		  %>
		  <c:forEach items="${mapnew}" var="entry">
		  	${ entry.key}:${entry.value }<br>
		  </c:forEach>
		  <h3>作用四：可以循环执行指定内容若干次</h3>
		  <c:forEach begin="0" end="10" step="2" var="i">
		  	${i },
		  </c:forEach>
		  <h3>实验：遍历10到100的偶数，如果数字所在的位置是3的倍数，则数字显示为红色，其他数字显示为蓝色：</h3>
		  <c:forEach begin="10" end="100" step="2" var="x" varStatus="stat">
		  <c:if test="${stat.count % 3==0}">
		  	<font color="red">${x }</font>
		  </c:if>
		  <c:if test="${stat.count % 3!=0}">
		  	<font color="blue">${x }</font>
		  </c:if>
		  </c:forEach>
		  
		  <h2>c:import标签的作用:实现页面包含</h2><hr>
		  
		  <c:import url="/index.jsp"></c:import>
		  
		  <h2>c:redirect标签的作用：实现重定向功能</h2><hr>
		  <p style="color:red;">注：c:redirect标签中的context属性的值为web应用的名称，url属性的值为哪一个页面</p>
		  <%--<c:redirect url="/index.jsp" context="${pageContext.request.contextPath}"></c:redirect> --%>
		  
		  <h2>c:forTokens标签的作用</h2> 
		  <p style="color:red;">注：forTokens标签用来浏览一字符串中所有的成员，其成员是由自定义符号所分隔的</p>
		  <c:forTokens items="http~www~baidu~com" delims="~" var="ss">
		  	${ss }
		  </c:forTokens>
	</body>
</html>
