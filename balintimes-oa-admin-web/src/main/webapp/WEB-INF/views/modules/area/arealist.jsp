<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>百灵时代OA-区域管理</title>
<script type="text/javascript">
	$(document).ready(function() {
		$("#treeTable").treetable({
			expandable: true,
			initialState: 'expanded'
		});
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
			<tags:message />
			<div class="col-sm-12 col-md-12">
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#">区域列表</a></li>
					<li role="presentation"><a href="${ctx}/org/area/form">区域添加</a></li>
				</ul>
			</div>
		</div>
		<br />
		<div class="row">
			<div class="col-sm-12 col-md-12">
				<a href="#" onclick="$('#treeTable').treetable('collapseAll');return false;"><span class="glyphicon glyphicon-collapse-up"></span> 全部折叠</a>&nbsp;
				<a href="#" onclick="$('#treeTable').treetable('expandAll');return false;"><span class="glyphicon glyphicon-collapse-down"></span> 全部展开</a>
				<table id="treeTable"
					class="table table-striped table-bordered table-hover">
					<tr>
						<th>区域名称</th>
						<th>区域编码</th>
						<th>区域类型</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${list}" var="area">
						<tr data-tt-id ="${area.id}"
							data-tt-parent-id="${area.parent_id ne requestScope.area.id?area.parent_id:'0'}">
							<td><a href="${ctx}/org/area/form?id=${area.id}">${area.name}</a></td>
							<td>${area.code}</td>
							<td>${dictUtils.getDictLabel(area.type, 'oasys_area_type', '无')}</td>
							<td>${area.remarks}</td>
							<td>
								<a href="${ctx}/org/area/form?id=${area.id}"><span class="glyphicon glyphicon-edit"></span> 修改</a>
								<a href="${ctx}/org/area/delete?id=${area.id}" onclick="return confirm('要删除该区域及所有子区域项吗？', this.href)"><span class="glyphicon glyphicon-remove"></span> 删除</a> 
								<a href="${ctx}/org/area/form?parent_id=${area.id}"><span class="glyphicon glyphicon-plus"></span> 添加下级区域</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>
</body>
</html>