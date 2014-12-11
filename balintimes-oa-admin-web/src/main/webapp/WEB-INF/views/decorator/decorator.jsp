<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title><sitemesh:write property='title' /></title>
<%@include file="/WEB-INF/views/include/resources_header.jsp"%>
<sitemesh:write property='head' />
</head>
<body>
	<%@include file="/WEB-INF/views/include/oa_header.jsp"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@include file="/WEB-INF/views/include/oa_leftMenu.jsp"%>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<sitemesh:write property='body' />
			</div>
		</div>
		<div class="row">
		</div>
	</div>

	<%@include file="/WEB-INF/views/include/oa_footer.jsp"%>

	<%@include file="/WEB-INF/views/include/resources_footer.jsp"%>
</body>
</html>