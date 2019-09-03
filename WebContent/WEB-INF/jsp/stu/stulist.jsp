<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
</head>
<style type="text/css">
	th{width:200px}
	td{text-align:center;width:100px}
</style>
<script src=${pageContext.request.contextPath}/js/jquery-3.1.1.min.js></script>
<script type="text/javascript">
function add(){
	location.href="${pageContext.request.contextPath}/stu/addstu";
}

 function del(studentno){
  var result=confirm("是否删除?");
  if(result){
	  var url="${pageContext.request.contextPath}/stu/del";
	  var param={studentno:studentno};
	  $.post(url,param,function(data){
		  alert(data.content);
		  if(data.flag==1){
			  location.reload();
		  }
	  });  
  }
}

function update(studentno){
	location.href="${pageContext.request.contextPath}/stu/updatestu?studentno="+studentno;
} 
</script>
	<h1 style="padding-left: 40%">学生列表</h1>
	<hr />
	<input type="button" value="新增学生" onClick="add()" style="margin-left: 20%;">
	<table border="1px" style="margin-left: 10%;">
		<tr><th>学号</th><th>姓名</th><th>性别</th><th>年龄</th><th>班级编号</th><th colspan="2">操作</th></tr>
		<c:forEach items="${stus}" var="item">
			<tr><th>${item.studentno}</th><th>${item.username}</th><th>
			<c:if test="${item.sex==1}">
				男
			</c:if>
			<c:if test="${item.sex==0}">
				女
			</c:if>
			</th><th>${item.age}</th><th>${item.classno}</th><td><a href="#" onclick="update('${item.studentno}')">修改</a></td><td><a onclick="del('${item.studentno}')" href="#">删除</a></td></tr>
		</c:forEach>
	</table>

</body>
</html>