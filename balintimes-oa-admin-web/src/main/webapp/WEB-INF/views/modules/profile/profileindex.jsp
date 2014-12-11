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
				  <li class="active"><span class="glyphicon glyphicon-user"></span>个人</li>
				  <li class="active">个人信息</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#">个人信息</a></li>
				</ul>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<form:form modelAttribute="user" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="inputUsername" class="col-sm-2 control-label">用户名：</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="inputUsername"
								placeholder="用户名" value="${user.username}" disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="selectUsertype" class="col-sm-2 control-label">用户类型：</label>
						<div class="col-sm-6">
							<form:select path="user_type" id="genderOptions"
								class="form-control">
								<form:option value="">选择用户类型</form:option>
								<form:option value="1">普通用户</form:option>
								<form:option value="9">超级用户</form:option>
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label for="checkboxActive" class="col-sm-2 control-label">是否启用：</label>
						<div class="col-sm-6">
							<input type="checkbox" id="checkboxActive"
								${user.active eq '1'?' checked':''} disabled>
						</div>
					</div>
					<div class="form-group">
						<label for="inputUserremarks" class="col-sm-2 control-label">备注：</label>
						<div class="col-sm-6">
							<textarea id="inputUserremarks" class="form-control" rows="5">${user.remarks}</textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="inputUserremarks" class="col-sm-2 control-label">最后登陆：</label>
						<div class="col-sm-10">
							<p class="form-control-static">IP: ${user.login_ip}<br />时间：<fmt:formatDate value="${user.login_date}" type="both" dateStyle="full"/></p>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>