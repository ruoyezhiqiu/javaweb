<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  <body>
  <%-- 以下代码属于jsp的声明用：“<%! 若干java代码 %>” 表示:翻译后变成了类的一个成员。 --%>
  <!-- 以下代码属于声明一个i作为jsp的成员变量 -->
  <%! int i =1; %>
  <!-- 以下代码属于声明一个方法作为jsp的成员方法，注：此方法不能调用九大内置对象，因为这九大内置对象未传入该方法！ -->
  <%! public void method(){}%>
  <!-- 以下代码属于声明一个静态代码块作为jsp的一部分，注:此静态代码块只在类加载时执行一次！ -->
  <%! static{} %>
  <!-- 以下代码属于声明一个构造代码块作为jsp的一部分，注:每当生成一个对象时执行该代码块一次！ -->
  <%! {} %>
  <!-- 以下代码属于声明一个内部类！ -->
  <%! class someclass{} %>

  </body>
</html>
