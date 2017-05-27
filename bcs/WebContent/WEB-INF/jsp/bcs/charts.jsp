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
<script src="/bcs/js/jquery.min.js"></script>
	<script src="/bcs/js/bootstrap.min.js"></script>
	<script src="/bcs/js/templatemo_script.js"></script>
	<script src="/bcs/js/echarts.min.js"></script>
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
				<li class="active"><a href="#"><i class="fa fa-bar-chart-o"></i>数据总览</a></li>
				<li><a href="<c:url value='/web/search'/>"><i
						class="fa fa-cog"></i>阈值配置</a></li>
				<li><a href="#" data-toggle="modal" data-target="#confirmModal"><i
						class="fa fa-sign-out"></i>退出</a></li>
			</ul>
		</div>

		<div class="templatemo-content-wrapper">
			<div class="templatemo-content">
				<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
				<div class="form-horizontal" align="center">
					<div id="sensor_echart" style="width: 600px; height: 400px; margin-top: 30px;"></div>
				</div>
				<script type="text/javascript">
					// 基于准备好的dom，初始化echarts实例
					var myChart = echarts.init(document.getElementById('sensor_echart'));
					var temp = ${temp};
					var humi = ${humi};
					option = {
						title : {
							text : "婴儿监护数据总览"
						},
						tooltip : {
							trigger : 'axis',
						},
						xAxis : {
							type : 'time',
							splitLine : {
								show : false
							},
							axisLine : {
								lineStyle : {
									color : '#0087ED',
									width : 2,
								}
							}
						},
						yAxis : {
							type : 'value',
							splitLine : {
								show : false
							},
							axisLine : {
								lineStyle : {
									color : '#0087ED',
									width : 2,
								}
							}
						},
						toolbox : {
							left : 'right',
							feature : {
								mark : {},
								dataZoom : {},
								dataView : {
									readOnly : true
								},
								restore : {},
								saveAsImage : {
									title : '右键另存为图片'
								},
							}
						},
						dataZoom : [ {
							type : 'inside',
							start : 0,
							end : 100
						}, {
							show : true,
							type : 'slider',
							y : '90%',
							start : 0,
							end : 100
						} ],
						series : [ {
							name : '温度',
							type : 'line',
							showSymbol : false,
							hoverAnimation : false,
							data : temp,
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								}, {
									type : 'min',
									name : '最小值'
								} ]
							}
						},{
							name : '湿度',
							type : 'line',
							showSymbol : false,
							hoverAnimation : false,
							data : humi,
							markPoint : {
								data : [ {
									type : 'max',
									name : '最大值'
								}, {
									type : 'min',
									name : '最小值'
								} ]
							}
						}]
					};

					// 使用刚指定的配置项和数据显示图表。
					myChart.setOption(option);
				</script>
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