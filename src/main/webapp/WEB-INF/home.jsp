<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 

<!DOCTYPE HTML>
<html>
<head>
	  <base href="<%=basePath%>">
    <title>后台管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">root
    </span><a href="login.jsp" >[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">系统管理</div></li>		<li class="nav-item dl-selected"><div class="nav-item-inner nav-order">业务管理</div></li>

        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="assets/js/bui-min.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>
<script>
		BUI.use('common/main', function() {
			var config = [ {
				id : '1',
				menu : [ {
					text : '系统管理',
					items : [ {
						id : '12',
						text : '机构管理',
						href : 'Node/index.html'
					}, {
						id : '3',
						text : '角色管理',
						href : 'sys/role_query'
					}, {
						id : '4',
						text : '用户管理',
						href : 'sys/user_query'
					}, {
						id : '6',
						text : '菜单管理',
						href : 'sys/menu_query'
					} ]
				} ]
			}, {
				id : '7',
				homePage : '9',
				menu : [ {
					text : '车辆管理',
					items : [ {
						id : '9',
						text : '自有车辆',
						href : 'car/owned_query'
					}, {
						id : '9',
						text : '用车申请',
						href : 'car/app_init'
					},  {
						id : '9',
						text : '用车审批',
						href : 'car/app_query?state=000'
					}, {
						id : '9',
						text : '用车调度',
						href : 'car/app_dispatch'
					},{
						id : '9',
						text : '个人用车申请',
						href : 'car/app_query'
					} ]
				} ]
			} ];
			new PageUtil.MainPage({
				modulesConfig : config
			});
		});
	</script>
<div style="text-align:center;">
<p>来源：<a href="http://www.mycodes.net/" target="_blank">源码之家</a></p>
	
	</div>
</body>
</html>
