<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<!--head部分-->
<head>
	<title>shiro权限管理系统</title>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="stylesheet" href="/layui/css/layui.css"/>
</head>
<body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <!--头-->
        <div class="layui-body">
            <div class="layui-container">
                <div class="layui-row">
                    <div class="layui-col-xs9">
						<table>
						    <tr>
						        <th>用户名</th>
						        <th>手机号</th>
						        <th>注册时间</th>
						        <th>操作</th>
						    </tr>
						    <#list results as item>
						        <tr>
						            <td>${item.username}</td>
						            <td>${item.telephone}</td>
						            <td>${item.entry_date?string('yyyy-MM-dd HH:mm:ss')}</td>
						            <td>
					                    <a href="/user/add?userid=${item.id}">添加</a>
					                    <a href="/user/mod?userid=${item.id}">修改</a>
						            </td>
						        </tr>
						    </#list>
						</table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script type="text/javascript" src="/js/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="/layui/layui.js"></script>
</html>