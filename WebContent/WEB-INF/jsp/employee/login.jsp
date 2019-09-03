<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<script src=${pageContext.request.contextPath}/js/jquery-3.1.1.min.js></script>
<script type="text/javascript">
		function login_submit(){
			//异步请求的url
		var url="${pageContext.request.contextPath}/employee/login_submit ";
			//异步请求的参数(json格式)
			var username=$("#username").val();
			var password=$("#password").val();
		var param={username:username,password:password};
			//使用$.post方法进行异步提交
			//data为后台返回的数据
			$.post(url,param,function(data){
				alert(data);
			});
		}
	</script>
<body>
<form method="post" action="${pageContext.request.contextPath}/employee/login_submit" name="login">
<h1>用户登录</h1>
用户名：<input type=text name='username' id='username'> <br><br>
密&nbsp;&nbsp;&nbsp;码：<input type=password name='password' id='password'> <br><br>
<input type="submit" onclick="login_submit()" name="cmdOK" value="提  交">&nbsp; 
<input type="reset" name="cmdCancel" value="重  置">
</form>
</body>
</html>
