<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h1>用户</h1>
	<table>
		<tr>
			<td width="50">Id</td>
			<td width="150">First Name</td>
		</tr>
		<c:forEach items="${users}" var="user2">
			<tr>
				<td><c:out value="${user2.username}" /></td>
				<td><c:out value="${user2.password}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>