<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>百灵时代OA-个人信息</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ol class="breadcrumb">
				  <li><a href="${ctx}/index"><span class="glyphicon glyphicon-home"></span> 首页</a></li>
				  <li><a href="${ctx}/profile/index"><span class="glyphicon glyphicon-user"></span> 个人</a></li>
				  <li class="active">登录历史</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#">登陆历史</a></li>
				</ul>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<table class="table table-bordered table-striped table-hover">
					<tr>
						<td width="50">用户名</td>
						<td width="150">登陆日期</td>
						<td width="50">登陆IP</td>
						<td width="150">浏览器类型</td>
					</tr>
					<c:forEach items="${list}" var="loginLog">
						<tr>
							<td><c:out value="${loginLog.userName}" /></td>
							<td><fmt:formatDate value="${loginLog.loginDate}"
									type="both" dateStyle="full" /></td>
							<td><c:out value="${loginLog.loginIp}" /></td>
							<td><c:out value="${loginLog.browseUserAgent}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<form method="post" id="pagerForm" action="${ctx}/profile/log">
					<input type="hidden" name="userId" value="${userId}">
				</form>
				<page:createPager pageSize="${pageSize}" totalPage="${totalPage}"
					totalCount="${totalCount}" curPage="${pageNum}" formId="pagerForm" />
			</div>
		</div>
	</div>
</body>
</html>