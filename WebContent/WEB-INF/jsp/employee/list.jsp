<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>雇员列表</title>
</head>
<style type="text/css">
	th{width:200px}
	td{text-align:center}
</style>
<script src=${pageContext.request.contextPath}/js/jquery-3.1.1.min.js></script>
<script type="text/javascript">
function add(){
	location.href="${pageContext.request.contextPath}/employee/add";
}

function del(username){
  var result=confirm("是否删除?");
  if(result){
	  var url="${pageContext.request.contextPath}/employee/del";
	  var param={username:username};
	  $.post(url,param,function(data){
		  alert(data.content);
		  if(data.flag==1){
			  location.reload();
		  }
	  });  
  }
}

function update(username){
	location.href="${pageContext.request.contextPath}/employee/update?username="+username;
}
</script>
	<h1 style="padding-left: 40%">雇员列表</h1>
	<hr />
	<input type="button" value="新增雇员" onClick="add()" style="margin-left: 20%;">
	<table border="1px" style="margin-left: 20%;">
		<tr><th>用户名</th><th>性别</th><th>年龄</th><th>所属部门</th><th colspan="2">操作</th></tr>
		<c:forEach items="${employees}" var="item">
			<tr><th>${item.username}</th><th>
			<c:if test="${item.sex==1}">
				男
			</c:if>
			<c:if test="${item.sex==0}">
				女
			</c:if>
			</th><th>${item.age}</th><th>${item.dept.deptname}</th><td><a href="#" onclick="update('${item.username}')">修改</a></td><td><a onclick="del('${item.username}')" href="#">删除</a></td></tr>
		</c:forEach>
	</table>

</body>
</html>