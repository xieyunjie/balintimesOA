<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>百灵时代OA-区域管理</title>
<script type="text/javascript">
	$(document).ready(function() {
		//设置默认焦点
		$("#name").focus();
		//设置校验错误焦点样式
		$(".text-danger").parent().addClass("has-error");
	});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ol class="breadcrumb">
					<li><a href="${ctx}/index"><span
							class="glyphicon glyphicon-home"></span> 首页</a></li>
					<li><a href="${ctx}/org/index"><span
							class="glyphicon glyphicon-globe"></span> 机构管理</a></li>
					<li class="active">区域管理</li>
				</ol>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation"><a href="${ctx}/org/area">区域列表</a></li>
					<li role="presentation" class="active"><a href="#">区域${not empty area.id?'修改':'添加'}</a></li>
				</ul>
			</div>
		</div>
		<br />

		<div class="row">
			<div class="col-sm-12 col-md-12">
				<form:form id="inputForm" modelAttribute="area"
					action="${ctx}/org/area/save" method="post" class="form-horizontal"
					role="form">
					<form:hidden path="id" />
					<div class="form-group">
						<label class="col-sm-2 control-label">上级区域:</label>
						<div class="col-sm-6">
							<area:select id="area" name="parent_id" value="${area.parent_id}"
								labelName="parent_name"
								labelValue="${area.parent_name}${area.parent_code}"
								disabled="false" />
							<form:errors path="parent_id" class="text-danger" />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label" for="name">区域名称:</label>
						<div class="col-sm-6">
							<form:input path="name" htmlEscape="false" maxlength="50"
								class="form-control required" />
							<form:errors path="name" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="code">区域编码:</label>
						<div class="col-sm-6">
							<form:input path="code" class="form-control required"
								htmlEscape="false" maxlength="50" />
							<form:errors path="code" class="text-danger" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="type">区域类型:</label>
						<div class="col-sm-6">
							<form:select path="type" class="form-control required">
								<form:options
									items="${dictUtils.getDictList('oasys_area_type')}"
									itemLabel="label" itemValue="value" htmlEscape="false" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="remarks">备注:</label>
						<div class="col-sm-6">
							<form:textarea path="remarks" htmlEscape="false" rows="3"
								maxlength="200" class="form-control required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label" for="remarks"></label>
						<div class="col-sm-6">
							<div class="form-actions">
								<input id="btnSubmit" class="btn btn-primary" type="submit"
									value="保 存" />&nbsp; <a href="${ctx}/org/area"
									class="btn btn-default" role="button">返回</a>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>

	</div>

</body>
</html>