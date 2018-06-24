<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js" /></script>
<script>
function keyValueRequest(){
	$.ajax({
		url:"${pageContext.request.contextPath}/doLogin.do",
		type:"POST",
		//contentType:"application/json; charset=utf-8",
		//keyValue数据格式
		data:$('#form1').serialize(),
		success: function(data){
			$('#JsonMsg').text(data.errMsg);
		}
	});
}
</script>
</head>

<body>
	<form id="form1" action="http://localhost:8080/project/doLogin.do" method="POST" >
		<input name="username" />	<br>
		<input name="password" />	<br>
		<button type="button" onclick="keyValueRequest()">提交</button>	
	</form>
	<span id="JsonMsg"></span>
</body>
</html>