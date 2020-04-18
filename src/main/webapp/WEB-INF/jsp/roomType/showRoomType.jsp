<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>房型信息页面</title>
	<!--引入layui的样式文件-->
	<link rel="stylesheet" href="lib/layui/css/layui.css">
	<!--引入客房样式的css文件-->
	<link rel="stylesheet" href="css/back/showRooms.css">
	<!--引入layui的js文件-->
	<script src="lib/layui/layui.js"></script>
</head>
<body>
<jsp:include page="addUpdRoomType.jsp"/>

<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
	<legend>房屋类型管理</legend>
</fieldset>
<button id="addRoomTypeBtn" type="button" class="layui-btn layui-btn-radius" style="margin-left: 30px;margin-bottom: 20px;"><i class="layui-icon">&#xe654;</i>添加房间类型</button>
<div class="layui-collapse" lay-filter="test" id="collapseDiv"></div>
<div id="test1" style="float: right;margin-top: 15px;"></div>
</body>
<script src="js/roomType/showRoomType.js"></script>
</html>
