<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE Demo</title>
</head>
<body>
	<div id="msgFrompPush"></div>
	<script type="text/javascript" src="<c:url value="assets/js/jquery-3.2.1.min.js"/>"></script>
	<script type="text/javascript">
		if (!!window.EventSource) {//1 EventSource对象只有新式浏览器才有(Chrome, Firefox等)，EventSource是SSE的客户端
			var source = new EventSource('push');
			s = '';
			source.addEventListener('message', function(e){//2添加SSE客户端监听，在此获得服务器推送的消息
				s+=e.data+"<br/>";
				$("#msgFrompPush").html(s);
			});
			
			source.addEventListener('open', function(e){
				console.log("连接断开。");
			},false);
			
			source.addEventListener('error', function(e) {
				if (e.readyState == EventSource.CLOSED) {
					console.log("连接关闭。");
				} else {
					console.log(e.readyStata);
				}
			},false);
		} else {
			console.log("你的浏览器不支持SSE");
		}
	</script>
</body>
</html>
