<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
	String webRoot = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
 
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>首页</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="renderer" content="webkit">
        <!-- 引入 JQuery  -->
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <!-- 引入 sockJS  -->
        <script type="text/javascript" src="http://cdn.sockjs.org/sockjs-0.3.min.js" ></script>
        <!-- 自定义JS文件 -->
        <script type="text/javascript" src="<%=webRoot%>/index.js"></script>

    </head>

    <body>

        <!-- 最外边框 -->
        <div style="margin: 20px auto; border: 1px solid ; width: 500px; height: 500px;">
            <!-- 消息展示框 -->
            <div id="msg" style="width: 100%; height: 70%;overflow: auto;"></div>
            <!-- 消息编辑框 -->
            <textarea id="tx" style="width: 99%; height: 20%;"></textarea>
            <!-- 消息发送按钮 -->
            <button id="TXBTN" style="width: 100%; height: 9%;">发送数据</button>
        </div>


    </body>

</html>