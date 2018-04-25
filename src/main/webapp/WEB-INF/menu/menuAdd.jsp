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
<form action="sys/menu_saveMenu" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover m10">
	   
	    <tr>
	        <td class="tableleft">菜单名称</td>
	        <td><input type="text" name="menuname"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">地址</td>
	        <td><input type="text" name="menulink"/></td>
	    </tr>
	    <tr>
	        <td class="tableleft">权限名称</td>
	        <td><input type="text" name="securyname"/></td>
	    </tr>
	     
	    <tr>
	        <td class="tableleft">描述</td>
	        <td><input type="text" name="memo"/></td>
	    </tr>
	     <tr>
	        <td width="10%" class="tableleft">父菜单</td>
	       
	       
	       
	        <td>
	            <select name="pid">
	            	<option value="0">---1级菜单----</option>
		            <s:iterator value="list.{? #this.menulink == null}" var="menu">
		            	<option value="<s:property value="id"/>">
		            		【
		            			<s:if test="#menu.pid==0">
		            				一级菜单
		            			</s:if>
		            			<s:else>
		            				二级菜单
		            			</s:else>
		            		】
		            		<s:property value="menuname"/>
		            	</option>
		            </s:iterator>
	            </select>
	        </td>
	    </tr>
	   
	  
	  
	    <tr>
	        <td class="tableleft"></td>
	        <td>
	            <button type="submit"  >
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