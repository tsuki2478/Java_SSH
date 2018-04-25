<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css" href="Css/style.css" />
<script type="text/javascript" src="Js/jquery.js"></script>
<script type="text/javascript" src="Js/jquery.sorted.js"></script>
<script type="text/javascript" src="Js/bootstrap.js"></script>
<script type="text/javascript" src="Js/ckform.js"></script>
<script type="text/javascript" src="Js/common.js"></script>



<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>
</head>
<body>
	<form class="form-inline definewidth m20" action="sys/user_query"
		method="post">
		菜单名称： <input type="text" name="username" id="username"
			class="abc input-default" placeholder=""
			value="<s:property value="username"/>">&nbsp;&nbsp;
		<button type="submit" class="btn btn-primary">查询</button>
		&nbsp;&nbsp;
		<!--!/sys/menu_getMenuList  -->
<%-- 		<s:property value="#session.LOGIN_USER.userMenus.{menulink}"/> --%>
		<s:if test ="'/sys/menu_getMenuList' in #session.LOGIN_USER.userMenus.{menulink}">
		<button type="button" class="btn btn-success" id="addnew">新增菜单</button>
			</s:if>
	</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>菜单编号</th>
				<th>菜单名称</th>
				<th>地址</th>
				<th>父菜单编号</th>
				<th>权限名称</th>
				<th>描述</th>
				<th>操作</th>
			</tr>
		</thead>
		<s:iterator value="list.{? #this.pid==0}" var="level1">
			<tr>
				<td><s:property value="#level1.id" /></td>
				<td><s:property value="#level1.menuname" /></td>
				<td><s:property value="#level1.menulink" /></td>
				<td><s:property value="#level1.pid" /></td>
				<td><s:property value="#level1.securyname" /></td>
				<td><s:property value="#level1.memo" /></td>
				<td>
			<%-- 		<s:if test="'/sys/menu_updatePage' in #session.LOGIN_USER.userMenus.{menulink}"> --%>
				<a href="sys/menu_updatePage?id=<s:property value="#level1.id"/>">编辑</a>
				
			
				
				
				<s:if test="'/sys/menu_delete' in #session.LOGIN_USER.userMenus.{menulink}">
				<a href="sys/menu_delete?id=<s:property value="#level1.id"/>">删除</a>
				</s:if>
				</td>
				<!-- 根据一级菜单编号找到所属的二级菜单 -->
				<s:iterator value="list.{? #this.pid==#level1.id}" var="level2">
					<tr>
						<td style="padding-left: 30px;"><s:property
								value="#level2.id" /></td>
						<td style="padding-left: 30px;"><s:property
								value="#level2.menuname" /></td>
						<td><s:property value="#level2.menulink" /></td>
						<td style="padding-left: 30px;"><s:property
								value="#level2.pid" /></td>
						<td><s:property value="#level2.securyname" /></td>
						<td><s:property value="#level2.memo" /></td>
						<td>
				
							
					<%-- 		<s:if test="'/sys/menu_updatePage' in #session.LOGIN_USER.userMenus.{menulink}">
				<a href="sys/menu_updatePage?id=<s:property value="#level2.id"/>">编辑</a>
				</s:if> --%>
						<a href="sys/menu_updatePage?id=<s:property value="#level2.id"/>">编辑</a>
							
							<s:if test="'/sys/menu_delete' in #session.LOGIN_USER.userMenus.{menulink}">
							<a href="sys/menu_delete?id=<s:property value="#level2.id"/>">删除</a>
							</s:if>
						</td>
						<s:iterator value="list.{? #this.pid==#level2.id}" var="level3">
							<tr>
								<td style="padding-left: 60px;"><s:property
										value="#level3.id" /></td>
								<td style="padding-left: 60px;"><s:property
										value="#level3.menuname" /></td>
								<td><s:property value="#level3.menulink" /></td>
								<td style="padding-left: 60px;"><s:property
										value="#level3.pid" /></td>
								<td><s:property value="#level3.securyname" /></td>
								<td><s:property value="#level3.memo" /></td>
								<td>
					<a href="sys/menu_updatePage?id=<s:property value="#level3.id"/>">编辑</a>
								
									<s:if test="'/sys/menu_delete' in #session.LOGIN_USER.userMenus.{menulink}">
									<a href="sys/menu_delete?id=<s:property value="#level3.id"/>">删除</a>
								</s:if>
								</td>
							</tr>
						</s:iterator>
					</tr>
				</s:iterator>
			</tr>
		</s:iterator>

	</table>

</body>
</html>
<script>
	$(function() {

		$('#addnew').click(function() {

			window.location.href = "sys/menu_getMenuList";
		});

		$('#synchroData').click(function() {

			window.location.href = "sys/user_synchroUser";
		});

	});

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url = "index.html";

			window.location.href = url;

		}

	}
</script>
