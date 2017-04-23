<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700"
	rel="stylesheet">
<!-- Animate.css -->
<link rel="stylesheet" href="/bcs/css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="/bcs/css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="/bcs/css/bootstrap.css">
<!-- Theme style  -->
<link rel="stylesheet" href="/bcs/css/style.css">
<!-- Modernizr JS -->
<script src="/bcs/js/modernizr-2.6.2.min.js"></script>
<title>婴儿监护系统</title>
</head>
<body>
	<div id="page">
		<div class="page-inner">
			<header id="gtco-header" class="gtco-cover" role="banner"
				style="background-image: url(/bcs/images/bgpic.jpg)">
				<div class="overlay"></div>
				<div class="gtco-container">
					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box"
							data-animate-effect="fadeInUp">
							<h1>Baby Care System</h1>
							<span class="intro-text-small">基于树莓派的婴儿监护系统后台管理</span>
						</div>
						<div class="col-md-4 col-md-push-1 animate-box"
							data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="login">
											<form id="loginForm" autocomplete="off">
												<div class="row form-group">
													<div class="col-md-12">
														<label for="username">用户名：</label> <input type="text"
															class="form-control" name="username" id="username">
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label for="userpwd">密码：</label> <input type="password"
															class="form-control" name="userpwd" id="userpwd">
													</div>
												</div>

												<div class="row form-group">
													<div class="col-md-12">
														<input class="btn btn-primary" type="button" value="登陆"
															id="login_btn">
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>

			<footer id="gtco-footer" role="contentinfo">
				<div class="gtco-container">
					<div class="row copyright">
						<div class="col-md-12">
							<p class="center-block">
								<small class="block">Copyright &copy; 2017 ymzhu All
									rights reserved.</small>
							</p>
						</div>
					</div>
				</div>
			</footer>
		</div>
	</div>
	<!-- jQuery -->
	<script src="/bcs/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="/bcs/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="/bcs/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="/bcs/js/owl.carousel.min.js"></script>
	<!-- Main -->
	<script src="/bcs/js/main.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			//监听登录按钮 提交表单
			$('#login_btn').click(function(){
				$(".alert").alert('close');
				if($('#username').val() == ""){
					addWarning("请输入用户名！");
					return;
				}
				if($('#userpwd').val() == ""){
					addWarning("请输入密码！");
					return;
				}
				var $form = $('#loginForm');
				$.post("<c:url value='/bcs/login/doLogin'/>", $form.serialize(), function(jsonResult) {
					if (jsonResult.status == 1) {
						addWarning(jsonResult.msg);
					} else if (jsonResult.status == -1) {
						addWarning(jsonResult.msg);
					}
				}, 'json');
			});
			
			//回车键模拟点击登录按钮
			$('#loginForm').keydown(function(e){
			     if(e.keyCode == 13){
			        $('#login_btn').click();
			     }
			 });
			
			//自动去除提示
			$("#username").click(function(){
				$(".alert").alert('close');
			});
			
			//自动去除提示
			$("#userpwd").click(function(){
				$(".alert").alert('close');
			});
		});
		
		//添加自定义提示
		function addWarning(str){
			var strHtml = '<div id="info" style="padding: 10px 30px; margin-bottom: 0px;" class="alert alert-info"><a class="close" data-dismiss="alert">&times;</a><strong>提示：</strong>'+ str + '</div>'
			$('#loginForm').append(strHtml);
		}
	</script>
</body>
</html>