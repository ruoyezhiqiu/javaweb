<%@ page language="java" import="java.util.*" pageEncoding="utf-8" session="false" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- 以上的第一行属于jsp的指令:  	1.session属性的值设置为false则这个页面将不会使用session；
								2.errorPage属性的值设置的是：当前jsp页面出错时跳转的页面(将优先于配置文件展现)，一般在web.xml中统一配置这个错误信息；
-->
<!-- jsp中产生乱码的两种可能：1.产生于jsp翻译为servlet的过程中；
						   2.产生于servlet发送给浏览器的过程中；
						   两种乱码的解决方案：pageEncoding="utf-8"将解决这两种乱码
 -->
<html>
  <head>
  </head>
  <body>&nbsp;
  <% int a =1/0; %> 
  xxxx
  </body>
</html>
