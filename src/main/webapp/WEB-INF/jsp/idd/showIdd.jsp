<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!--http://localhost:8080/-->
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据分析页面</title>
    <!--引入echarts的js文件-->
    <script type="text/javascript" src="lib/echarts/echarts.min.js"></script>
    <script type="text/javascript" src="lib/echarts/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <h1>数据分析页面</h1>
    <div id="main" style="width: 1200px;height:550px;"></div>

</div>
</body>
<!--引入layui的js文件-->
<script src="js/idd/showIdd.js"></script>
</html>