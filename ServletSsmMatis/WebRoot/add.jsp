<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>新增信息</title>
    

  </head>
  
  <body>
    	<center>
   		<form method="post" action="DeptServlet?action=add">
    		<h1>新增信息</h1>
    		名称:<input type="text" name="dname">
    		<br>
    		总人数:<input type="text" name="empCount">
    		<input type="submit" value="提交">
    	</form>
    </center>
  </body>
</html>
