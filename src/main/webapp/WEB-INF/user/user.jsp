<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 这里需要设置 -->
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<!-- 地址要看情况。。。。 -->
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
	用户名称：
	 <input type="text" name="username" id="username"
    class="abc input-default" placeholder="" value="<s:property value="username"/>">&nbsp;&nbsp;  
    <button type="submit" class="btn btn-primary">查询</button>&nbsp;&nbsp; 
    <button type="button" class="btn btn-success" id="addnew">新增用户</button>
      <button type="button" class="btn btn-success" id="synchroData">同步用户</button> 
</form>
	<table class="table table-bordered table-hover definewidth m10">
		<thead>
			<tr>
				<th>用户id</th>
				<th>用户名称</th>
				<th>真实姓名</th>
				<th>性别</th>
				<th>部门</th>
				<th>电话</th>
				<th>操作</th>
			</tr>
		</thead>

		<!--  修改成循环数据-->
		<s:iterator value="pageModel.result" var="user">
			<tr>
				<td><s:property value="id" /></td>
				<td><s:property value="username" /></td>
				<td><s:property value="realname" /></td>
				<td><s:property value="sex" /></td>
				<td><s:property value="depid" /></td>
				<td><s:property value="phone" /></td>
				<td> 
				  <a href="sys/user_updatePage?id=<s:property value="id"/>">编辑</a>
				<a href="javascript:del(<s:property value="id"/>);">删除</a>
				<td>
			</tr>
			 
		</s:iterator>
	</table>
	<div style="text-align: right;margin-top: 5px; margin-right: 20px;">
		<form action="sys/user_query" method="post" id="pager">
			<input type="hidden" name="pageSize" id="pageSize"
				value="${pageModel.pageSize}"> <input type="hidden"
				name="currentPage" id="currentPage" 
				value="${pageModel.currentPage}">
		</form>
		<!--引用。。  -->
		<%@include file="../../pageBar.jsp"%>
		</div>
</body>
</html>
<script>
	 $(function () {
        

		$('#addnew').click(function(){

				window.location.href="sys/user_queryData";
		 });
		 
		$('#synchroData').click(function(){

				window.location.href="sys/user_synchroUser";
		 });

    });

	function del(id) {

		if (confirm("确定要删除吗？")) {

			var url ="sys/user_delete?id="+id;

			window.location.href = url;

		}

	}

</script>
