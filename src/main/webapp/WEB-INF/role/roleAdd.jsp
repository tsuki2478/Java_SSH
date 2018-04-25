<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
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

        @media (max-width: 980px) {
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
<form action="sys/role_saveRole" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover m10">
	   
	    <tr>
	        <td class="tableleft">角色名称</td>
	        <td><input type="text" name="rolename"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">角色描述</td>
	        <td><input type="text" name="demo"/></td>
	    </tr>
	    
	    <tr>
            <td class="tableleft">权限</td>
            <td>
                <ul>
                	<!-- 取出所有的一级菜单 -->
                  <s:iterator value="menusList.{? #this.pid == 0}" var="l1">
                  	 <li>
						<label class='checkbox inline'>
						<input type='checkbox' name='menus.id' value='<s:property value="#l1.id"/>' />
							<s:property value="#l1.menuname"/>
						</label>
						<ul>
							<!-- 取出对应的二级菜单 -->
							<s:iterator value="menusList.{? #this.pid ==#l1.id}" var="l2">
								<li>
									<label class='checkbox inline'>
									<input type='checkbox' name='menus.id' value='<s:property value="#l2.id"/>' />
										<s:property value="#l2.menuname"/>
									</label>
									<ul>
										<!-- 取出对应的三级菜单 -->
										<s:iterator var="l3" value="menusList.{? #this.pid == #l2.id}">
											<li>
												<label class='checkbox inline'>
												<input type='checkbox' name='menus.id' value='<s:property value="#l3.id"/>' />
													<s:property value="#l3.menuname"/>
												</label>
											</li>
										</s:iterator>
									</ul>
								</li>
							</s:iterator>
						</ul>
                     <li>
                  </s:iterator>
                </ul> 
            </td>
        </tr>
	    
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit"  class="btn btn-primary" >
	            保存</button> &nbsp;&nbsp;
	            <button type="button" class="btn btn-success" name="backid" id="backid">
	            返回列表</button>
	        </td>
	    </tr>
	</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="index.html";
		 });

    });
</script>