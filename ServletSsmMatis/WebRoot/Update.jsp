<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>更改信息</title>
    

  </head>
  
  <body>
    <center>
   		<form method="post" action="DeptServlet?action=upd">
   		
    		<h1>更改信息</h1>
    		<br>
    		<br>编号： <input type="text" name = "dno"  value="${dept.dno}" />
    		<br>名称:<input type="text" name="dname" value="${dept.dname}">
    		<br>总人数:<input type="text" name="empCount" value="${dept.empCount}"/>
    		<br><br>
    		<input type="submit" value="提交">
    	</form>
    </center>
  </body>
</html>
