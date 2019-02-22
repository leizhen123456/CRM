<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>SSM高级整合</title>
</head>

<body>
		<a href="add.jsp"><h3 align="center">添加部门信息</h3></a>
	<table align="center" border="1" width="500">
		<tr>
			<th>编号</th>
			<th>名称</th>
			<th>总人数</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="dept">
			<tr align="center">
				<td>${dept.dno}</td>
				<td>${dept.dname}</td>
				<td>${dept.empCount}</td>
				<td>
					<a href="DeptServlet?action=update&id=${dept.dno}">修改</a>
					<a href="DeptServlet?action=del&id=${dept.dno}">删除</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
