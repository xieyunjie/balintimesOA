<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>百灵时代OA-登陆</title>
<style type="text/css">
body {
	background: url(${ctx}/resources/img/bg-login.jpg) !important;
}
</style>
</head>
<body>
	<div class="container-fluid-full">
		<div class="row-fluid">

			<div class="row-fluid">
				<div class="login-box">
					<!-- 
					<div class="icons">
						<a href="index.html"><i class="halflings-icon home"></i></a> <a
							href="#"><i class="halflings-icon cog"></i></a>
					</div>
					 -->
					<h2>百灵时代OA-系统登陆</h2>
					<form class="form-horizontal" action="${ctx}/index" method="get">
						<fieldset>

							<div class="input-prepend" title="Username">
								<span class="add-on"><i class="halflings-icon user"></i></span>
								<input class="input-large span10" name="username" id="username"
									type="text" placeholder="请输入用户名" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password">
								<span class="add-on"><i class="halflings-icon lock"></i></span>
								<input class="input-large span10" name="password" id="password"
									type="password" placeholder="请输入密码" />
							</div>
							<div class="clearfix"></div>
							
							<!-- 
							<label class="remember" for="remember"><input
								type="checkbox" id="remember" />记住我?</label>
							 -->
							 
							<div class="button-login">
								<button type="submit" class="btn btn-primary">登陆</button>
							</div>
							<div class="clearfix"></div>
					</form>
					<hr>
					<h3>忘记密码?</h3>
					<p>
						点击这里, <a href="#">找回密码</a>.
					</p>
				</div>
				<!--/span-->
			</div>
			<!--/row-->
		</div>
		<!--/.fluid-container-->
	</div>
	<!--/fluid-row-->
</body>
</html>