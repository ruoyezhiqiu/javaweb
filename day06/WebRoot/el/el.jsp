<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.wushengde.el.Person"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@taglib uri="http://www.wushengde180.com/MyELFunc" prefix="MyELFunc" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- EL表达式 -->
<html>
  <head>
  </head>
  <body>
  <h1 style="text-align:center;">EL表达式作用之一：获取数据</h1><hr>
  <b style="color:red;">注：EL表达式只能用来获取数据不能用来改变数据！</b>
  <h2>1.获取数据常量</h2><hr>
  <p>获取常量的类型: 字符串/数字/布尔类型,直接写在el表达式中,el直接进行输出</p>
   获取字符串：${"nice to meet you ! john" }<br>
   获取数字：${1234567890 }<br>
   布尔类型：${true }
   <h2>2.获取域中的变量</h2><hr>
   <p>获取域中的变量:如果el中写的是一个变量的名,则el会调用pageContext的findAttribute方法,
    在四大作用域中以给定的名字找对应的属性值,找到后进行输出,如果四个域中都找不到,什么都不输出</p>
    <% String name="张无忌";
    	pageContext.setAttribute("name",name);
     %>
  	获取域中变量名为name的值：${name }<br>
  	
     <h2>3.获取数组中的数据</h2><hr>
  	<% String[] names ={"张三丰","张翠山","张无忌","赵敏"}; 
  		pageContext.setAttribute("names",names);
  	%>
  	获取数组中的第一个元素：${names[0] }
  
   <h2>4.获取集合中的数据</h2><hr>
  	<% List<String> list = new ArrayList<String>();
  		list.add("郭嘉");
  		list.add("荀彧");
  		list.add("曹操");
  		pageContext.setAttribute("list",list);
  	 %>
  	获取集合中的第一个元素：${list[0] }
   <h2>5.获取MAP中的数据</h2><hr>
   <% Map<String,String> map = new HashMap();
   		map.put("name", "奥巴马");
		map.put("age", "18");
		map.put("gender", "男");
		map.put("address", "白宫");
  		pageContext.setAttribute("map",map);
    %>
   获取MAP中的键属性值：<br>
   姓名：${map["name"] }<br>
   年龄：${map["age"] }<br>
   性别：${map["gender"] }<br>
   地址：${map["address"] }
   
   <h2>6.获取javabean的属性值</h2><hr>
   <% Person p = new Person();
   	  p.setName("芙蓉姐姐");
   	  p.setAge(18);
   	  pageContext.setAttribute("p",p);
    %>
   获取javabean中属性值：需要定义一个Person类，然后设置其私有属性，并且创建其get/set方法<br>
   获取这个人的名字：${p.name }<br>
   获取这个人的年龄：${p.age }<br>
   
   
   <h1 style="text-align:center;">EL表达式作用之二：执行运算</h1><hr>
   
   <h2>1.EL中的算术运算:如果有非数字参与运算EL表达式会试图将非数字转换为数字后进行计算</h2><hr>
   执行1+1后的结果：${1+1 }<br>
   执行2-1后的结果：${2-1 }<br>
   执行1+“3”后的结果：${1+"3" }<br>
   
   <h2>2.EL中的比较运算：> < >= <= != </h2><hr>
   执行1==1 后的结果：${1==1 }<br>
   执行2==1 后的结果：${2==1 }<br>
   执行3>=2 后的结果：${3>=2 }<br>
   
   <h2>3.EL中的逻辑运算</h2><hr>
   执行1>2或者3>2的结果：${1>2 or 3>2 }
   
   <h2>4.EL中的三元运算符</h2><hr>
   执行2>1?1:2的结果：${2>1?1:2 }
   
   <h2>5.empty运算符：判断一个对象是否为null 或者一个字符串是否为空或集合内容是否为空或域总是否没有任何属性</h2><hr>
   <% String str = null;
   	  pageContext.setAttribute("str",str);
   	  List list02 = new ArrayList();
   	  list02.add("");
   	  pageContext.setAttribute("list02",list02);
    %>
    判断str是否为空：${empty str }<br>
    判断list02是否为空：${empty list02 }
   
   <h1 style="text-align:center;">EL表达式作用之三：获取常用的内置对象</h1><hr>  
   <b style="color:red;">注：EL中内置的对象不需要提前定义就可以直接使用的对象：其中内置了11个对象</b>
 
   		<p>pageContext -- 有了它可以很方便的获取jsp页面中的9大隐式对象
        
        <p>pageScope -- page域中属性组成的Map</p>
        <p>requestScope -- request域中属性组成的Map</p>
        <p>sessionScope -- session域中属性组成的Map</p>
        <p>applicationScope --application域中属性组成的Map</p>
        
        <p>param -- 所有请求参数组成的Map &lt String,String &gt</p>
        <p>paramValues -- 所有请求参数组成的Map &lt String,String[] &gt </p>
        
        <p>header -- 所有请求头组成的Map &lt String,String &gt </p>
        <p>headerValues -- 所有请求头组成的Map &lt String,String[] &gt </p>
        
        <p>cookie -- 所有cookie信息组成的Map &lt String,Cookie &gt </p>
        
        <p>initParam -- 所有web应用的初始化参数组成Map</p>
  		<h2>1.pageScope requestScope sessionScope applicationScope的使用</h2><hr>
  		<%
  		pageContext.setAttribute("name","张三");
  		request.setAttribute("name","李四");
  		session.setAttribute("name","王二");
  		application.setAttribute("name","麻子");
  		 %>
  		 1.执行显示pageScope中的内容：${pageScope.name }<br>
  		 2.执行显示requestScope中的内容：${requestScope.name }<br>
  		 3.执行显示sessionScope中的内容：${sessionScope.name }<br>
  		 4.执行显示application中的内容：${applicationScope.name }<br>
  		 <h2>2.获取请求参数的信息：在超链接后面加一些请求参数，然后在页面获取其中的内容</h2><hr>
  		 1.获取URL参数中的名字：${param.name }<br>
  		 2.获取URL参数中的年龄：${param.age }<br>
  		 3.获取URL参数中的爱好：${paramValues.like[1] }
  		 <h1 style="text-align:center;">EL表达式作用之四：调用java方法</h1><hr> 
  		  <b style="color:red;">注：一般来说， EL自定义函数开发与应用包括以下三个步骤： </b>
			<p>1.编写一个Java类的静态方法</p>
			<p>2.编写标签库描述符（tld）文件，在tld文件中描述自定义函数</p>
			<p>3.在JSP页面中导入和使用自定义函数</p>
  		 	<hr>
  		   <p>不需要大家自己会写调用方法的过程,只要会调用别人写好的标签库就可以了 fn标签库</p>
           <p>写一个类其中包含要被el调用的方法,这个方法必须是静态的方法</p>
           <p>写一个tld文件在其中对要被调用的静态方法进行一下描述</p>
           <p>在jsp页面中taglib指令将tld文件引入当前jsp页面,从而在jsp页面中就可以调用描述好的方法 </p>
  		 <hr>
  		 <p>示例：</p>
		<p>1.对给定的URL进行URL编码</p>
		<p>2.开发对html标签进行转义的el function</p>
		<hr>
		<%
		String str02 = URLEncoder.encode("中国","utf-8");
		String str03 = URLDecoder.decode(str02,"utf-8");
		 %>
		 1.执行打印str02(代表将“中国”两字以URL编码后的表现形式，此处使用了java代码不推荐)：<%=str02 %><br>
		 2.执行打印str03(代表将str02用URL解码后的表现形式，此处使用了java代码不推荐)：<%=str03 %><br>
  		<hr>
  		<h2>1.EL自定义java函数的实现</h2>
  		1.执行打印“北京”被URL以“utf-8”编码后的结果(此处使用EL自定义的Java函数减少使用java代码)：  ${MyELFunc:URLEnc("北京","utf-8") }<br>
  		<!-- 此处可以参考java培训课程中的day06中的资源下的标准标签库的word文档 -->
  		2.使用官方提供的函数库将一个字符串中包含的所有字符转换为小写形式：${fn:toLowerCase("htTP://wWw.BaIdU.coM") }<br>
  		3.使用官方提供的函数库将一个字符串中包含的所有字符转换为大写形式：${fn:toUpperCase("hTTP://wWw.BaIdU.coM") }
  </body>
</html>
