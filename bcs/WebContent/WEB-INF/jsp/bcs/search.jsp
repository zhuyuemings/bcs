<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>婴儿监护系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="/bcs/css/templatemo_main.css">
<script src="/bcs/js/jquery.min.js"></script>
<script src="/bcs/js/bootstrap.min.js"></script>
<script src="/bcs/js/bootstrap-datetimepicker.min.js"></script>
<script src="/bcs/js/templatemo_script.js"></script>
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
				<li><a href="<c:url value='/web/home'/>"><i
						class="fa fa-home"></i>主页</a></li>
				<li><a href="<c:url value='/web/data'/>"><i
						class="fa fa-child"></i>实时数据</a></li>
				<li><a href="<c:url value='/web/video'/>"><i
						class="fa fa-camera"></i>实时视频</a></li>
				<li><a href="<c:url value='/web/charts'/>"><i
						class="fa fa-bar-chart-o"></i>数据总览</a></li>
				<li class="active"><a href="#"><i class="fa fa-cog"></i>阈值配置</a></li>
				<li><a href="#" data-toggle="modal" data-target="#confirmModal"><i
						class="fa fa-sign-out"></i>退出</a></li>
			</ul>
		</div>

		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">
				<div class="panel panel-default well">
					<div class="panel-heading">
						<h1>阈值数据</h1>
					</div>
					<table class="table">
						<thead>
							<tr>
								<th>设置时间</th>
								<th>温度(摄氏度)</th>
								<th>湿度(百分比)</th>
								<th>声音(分贝)</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td id="recordtime"><fmt:formatDate
										value="${sensorData.recordtime}"
										pattern="yyyy年MM月dd日 HH时mm分ss秒" /></td>
								<td id="temperature">${sensorData.temperature}</td>
								<td id="humidity">${sensorData.humidity}</td>
								<td id="sound">${sensorData.sound}</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div>
					<span>温度：</span><input id="temp" type="text"></input> <span>湿度：</span><input
						id="humi" type="text"></input> <span>声音：</span><input id="soun"
						type="text"></input> <input id="modify" type="button" value="修改"></input>
					<script type="text/javascript">
						$("#modify").click(function() {
							var temp = $("#temp").val();
							var humi = $("#humi").val();
							var soun = $("#soun").val();
							if(check(temp)){
								temp = parseInt(temp);
							}else{
								alert("格式错误！");
								$("#temp").focus();
								return;
							}
							if(check(humi)){
								humi = parseInt(humi);
							}else{
								alert("格式错误！");
								$("#humi").focus();
								return;
							}
							if(check(soun)){
								soun = parseInt(soun);
							}else{
								alert("格式错误！");
								$("#soun").focus();
								return;
							}
							var json = "temperature="+temp+"&humidity="+humi+"&sound="+soun;
							$.post("<c:url value='/web/modifyConfig'/>", json, function(jsonResult) {
								alert(jsonResult.message);
								location.reload();
							}, 'json');
						});

						function check(value) {
							var reg = /^[0-9]+$/;
							if (value.match(reg)) {
								return true;
							}
							return false;
						}
					</script>
				</div>
			</div>
		</div>
		<!-- Modal -->
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
						<a href="<c:url value='/web/logout'/>" class="btn btn-primary">确定</a>
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
</body>
</html>