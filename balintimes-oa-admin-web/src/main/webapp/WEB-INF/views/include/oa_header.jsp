
<%@ page contentType="text/html;charset=UTF-8"%>

<!-- topbar starts -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Balintimes.OA</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${ctx}/org/index"><span class="glyphicon glyphicon-globe"></span> 机构管理</a></li>
				<li><a href="${ctx}/sys/index"><span class="glyphicon glyphicon-cog"></span> 系统设置</a></li>
				<li><a href="#about"><span class="glyphicon glyphicon-stats"></span> 日志监控</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">其他 <span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#">其他</a></li>
						<li><a href="#">其他</a></li>
						<li><a href="#">其他</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">其他</li>
						<li><a href="#">其他</a></li>
						<li><a href="#">其他</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="${ctx}/index">
						<span class="glyphicon glyphicon-home"></span> 首页
					</a>
				</li>

				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<span class="glyphicon glyphicon-user"></span>
						个人 
						<span class="caret"></span></a>
					<ul class="dropdown-menu" role="menu">
						<li><a href="${ctx}/profile/index"><span class="glyphicon glyphicon-user"></span> 个人信息</a></li>
						<li><a href="${ctx}/profile/log"><span class="glyphicon glyphicon-time"></span> 登陆历史</a></li>
						<li><a href="${ctx}/profile/editpassword"><span class="glyphicon glyphicon-lock"></span> 修改密码</a></li>
						<li class="divider"></li>
						<li><a href="${ctx}/logout"><span class="glyphicon glyphicon-log-out"></span> 注銷</a></li>
					</ul>
				</li>
			</ul>

			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="查找...">
			</form>
		</div>
	</div>
</nav>
<!-- topbar ends -->