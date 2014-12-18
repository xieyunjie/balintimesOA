<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>百灵时代OA-用户管理</title>
</head>
<body>
	<h5>用户管理Test！！</h5>
	<div class="container-fluid">
		<div class="row">
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th style="width: 100px;">用户id</th>
					<th style="width: 200px;">用户名称</th>
					<th>备注</th>
				</tr>
				<c:forEach items="${list}" var="user">
					<tr>
						<td>${user.id}</td>
						<td>${user.username}</td>
						<td>${user.remarks}</td>
					<tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>