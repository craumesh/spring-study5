<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<hr>

<input type="button" id="btnSend" value="정보 전송하기">

<script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.min.js"></script>

<script>
	$(document).ready(function(){
		$("#btnSend").click(function(){
			var member = {
				"userid":"admin",
				"userpw":"1234",
				"username":"관리자",
				"useremail":"admin@admin.com"
			};
			
			$.ajax({
				url: "/sample/info",
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(member), // json타입 문자열로 전송
				success:function(){
					alert("안녕!");
				},
				error:function(){
					alert("못안녕!");
				}
			});
		});
	});
</script>

</body>
</html>
