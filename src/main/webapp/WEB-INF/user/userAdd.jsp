<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags"  prefix="s"%>
  <!DOCTYPE html>
<html>
<head>
  <base href="<%=basePath%>">
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="Css/style.css" />
    <script type="text/javascript" src="/Js/jquery.js"></script>
    <script type="text/javascript" src="/Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="/Js/bootstrap.js"></script>
    <script type="text/javascript" src="/Js/ckform.js"></script>
    <script type="text/javascript" src="/Js/common.js"></script>

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
<form action="sys/user_saveUser" method="post" class="definewidth m20">
<table class="table table-bordered table-hover m10">
    <tr>
        <td  class="tableleft">用户名</td>
        <td><input type="text" name="username"></td>
    </tr>
   
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="text" name="pwd"/></td>
    </tr>
    
    <tr>
        <td class="tableleft">真实姓名</td>
        <td><input type="text" name="realname"/></td>
    </tr>
    
    
    <tr>
        <td class="tableleft">性别</td>
        <td>
            <input type="radio" name="sex" value="0" checked/> 男
            <input type="radio" name="sex" value="1"/> 女
        </td>
    </tr>
   
    
    <tr>
        <td class="tableleft">电话</td>
        <td><input type="text" name="phone"/></td>
    </tr>
 <tr>
   <td width="10%" class="tableleft">部门</td>
	        <td>
	            <select name="depid">
		            <s:iterator value="deptList" var="dept">
		            	<option value="<s:property value="id"/>">
		            		<s:property value="name"/>
		            	</option>
		            </s:iterator>
	            </select>
	        </td>
	    </tr>

    
    <tr> 
   <td class="tableleft">角色</td>
	        <td>
	        	<s:iterator value="roleList" var="role">
	        		<input type="checkbox" name="roles.id"
	        		value="<s:property value="id"/>"/>
	        		<s:property value="rolename"/>
	        		<br/>
	        	</s:iterator>
	        </td>
  	 
   </tr>
   
    <tr>
        <td class="tableleft"></td>
        <td>
	            <button type="submit"  >
	            保存</button> &nbsp;&nbsp;
	            <button type="button" class="btn btn-success"
	             name="backid" id="backid">
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