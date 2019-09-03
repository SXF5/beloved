<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改学生</title>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("input[name=sex][value=${stu.sex}]").attr("checked",true);
})

function updateStu(){
	var url = "${pageContext.request.contextPath}/stu/update_submit";
	var param = $("#form").serialize();
	$.post(url, param, function(data) {
		alert(data.content);
		if(data.flag==1){
			location.href="${pageContext.request.contextPath}/stu/stulist";
		}
	});
}
</script>
<body>
<h1 style="padding-left: 40%">修改学生</h1>
	<hr />
	<form id="form" style="padding-left: 40%">
		<h2>学号：</h2>
		<input type="text" name="studentno" readonly value="${stu.studentno}" />
		<h2>姓名：</h2>
		<input type="text" name="username" readonly value="${stu.username}" />
		<h2>性别：</h2>
		<input type="radio" name="sex" value="0" />女<input type="radio"
			name="sex" value="1" />男
		<h2>年龄：</h2>
		<input type="text" name="age" value="${stu.age}"/>
		<h2>班级编号：</h2>
		<input type="text" name="classno" value="${stu.classno}"/>
		<br /> <input
			style="margin-top: 50px; width: 200px; height: 50px; font-size: 20px"
			type="button" onclick="updateStu()" value="提交学生信息">
	</form>
</body>
</html>