<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<c:choose>
	<c:when test="${msgtype == 'primary'}">
		<c:set var="color" value="blue" />
	</c:when>
	<c:when test="${msgtype == 'success'}">
		<c:set var="color" value="green" />
	</c:when>
	<c:when test="${msgtype == 'info'}">
		<c:set var="color" value="green" />
	</c:when>
	<c:when test="${msgtype == 'warning'}">
		<c:set var="color" value="yellow" />
	</c:when>
	<c:when test="${msgtype =='danger'}">
		<c:set var="color" value="yellow" />
	</c:when>
	<c:when test="${msgtype == 'error'}">
		<c:set var="color" value="red" />
	</c:when>
	<c:otherwise>
		<c:set var="color" value="black" />
	</c:otherwise>
</c:choose>

<script type="text/javascript">
	// Notice closes after 5 Second
	function notice5Sec() {
		new jBox('Notice', {
			content : '${msg}',
			autoClose : 5000,
			color : '${color}'
		});
	}
	notice5Sec();
</script>

