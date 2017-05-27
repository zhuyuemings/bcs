<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>婴儿监护系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="/bcs/css/templatemo_main.css">
</head>
<body>
	<div class="navbar navbar-inverse" role="navigation">
		<div class="navbar-header">
			<div class="logo">
				<h1>基于树莓派的婴儿监护系统后台管理</h1>
			</div>
		</div>
	</div>
	<div class="template-page-wrapper">
		<div class="navbar-collapse collapse templatemo-sidebar">
			<ul class="templatemo-sidebar-menu">
				<li class="active"><a href="#"><i class="fa fa-home"></i>主页</a></li>
				<li><a href="<c:url value='/web/data'/>"><i class="fa fa-child"></i>实时数据</a></li>
				<li><a href="<c:url value='/web/video'/>"><i class="fa fa-camera"></i>实时视频</a></li>
				<li><a href="<c:url value='/web/charts'/>"><i class="fa fa-bar-chart-o"></i>数据总览</a></li>
				<li><a href="<c:url value='/web/search'/>"><i class="fa fa-cog"></i>阈值配置</a></li>
				<li><a href="#" data-toggle="modal" data-target="#confirmModal"><i class="fa fa-sign-out"></i>退出</a></li>
			</ul>
		</div>

		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">
				<div class="well">
					<h1>Hello, world!</h1>
					<h1>基于树莓派的婴儿监护系统简介</h1>
					<p>本系统将采用树莓派为载体，将几个相关传感器模块的独立功能和相关服务整合在其上运行。系统包括尿湿检测模块、温度检测模块、声音检测模块、无线传输模块、视频模块等。以低功耗的树莓派作为主控，利用温度传感器监测被窝温度判断婴儿是否踢被、利用湿度传感器测尿湿、利用声音传感器监测婴儿啼哭，利用视频模块对婴儿进行实时查看数据经树莓派处理后由无线传输模块发送给接收端，当监测数据超出阈值时进行报警，除此之外还可以打开手机看到婴儿的实时动态。</p>
					<p>...</p>
				</div>
			</div>
		</div>
		
		<div class="modal fade" id="confirmModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">确定退出吗?</h4>
					</div>
					<div class="modal-footer">
						<a href="<c:url value='/user/logout'/>" class="btn btn-primary">确定</a>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
			</div>
		</div>
		<footer class="templatemo-footer">
			<div class="templatemo-copyright">
				<p>Copyright &copy; 2017 ymzhu All rights reserved.</p>
			</div>
		</footer>
	</div>

	<script src="/bcs/js/jquery.min.js"></script>
	<script src="/bcs/js/bootstrap.min.js"></script>
	<script src="/bcs/js/Chart.min.js"></script>
	<script src="/bcs/js/templatemo_script.js"></script>
</body>
</html>