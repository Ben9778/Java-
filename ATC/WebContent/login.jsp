<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>用户登录注册</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}

body {
	background: gray;
}

a {
	text-decoration: none;
	color: black;
}

strong {
	color: blue;
	font-size: 30px;
}

.span {
	float: left;
	width: 160px;
	height: 30px;
	text-align: center;
	color: white;
	font-size: 20px;
	font-weight: bold;
}

.login {
	background: rgba(84, 139, 84, 0.8);
	cursor: pointer;
}

.regist {
	background: rgba(0, 238, 118, 0.8);
	cursor: pointer;
}

#header {
	width: 100%;
	height: 20%;
	background: white;
	overflow: hidden;
}

.headers {
	display: inline-block;
	text-align: center;
}

.div0 {
	margin-left: 70px;
	margin-top: 20px;
}

.div1 {
	width: 300px;
	margin-left: 150px;
	background: rgba(100, 149, 237, 0.6);
}

.div2 {
	margin-left: 200px;
}

.backHome {
	width: 100px;
	height: 30px;
	font-size: 15px;
	border-radius: 5px;
	background: rgba(78, 238, 148, 0.7);
	color: black;
	cursor: pointer;
}

#section {
	width: 100%;
	height: 60%;
	background-size: 100% 100%;
	background-attachment: fixed;
	background-image: url("image/login.jpg");
	background-repeat: no-repeat;
	overflow: hidden;
}

#section1 {
	width: 320px;
	height: 350px;
	margin-left: 500px;
	margin-top: 30px;
	background: rgba(70, 130, 180, 0.5);
	border-radius: 10px;
	overflow: hidden;
}

form {
	margin-top: 60px;
	margin-left: 20px;
}

.input {
	width: 200px;
	height: 25px;
	border-radius: 5px;
	outline: none;
	font-size: 15px;
}

.in {
	font-weight: bold;
	font-size: 15px;
}

.auto {
	font-size: 13px;
	color: rgb(0, 0, 205);
}

.forget {
	text-decoration: underline;
	color: rgb(0, 0, 205);
}

.forget:hover {
	color: black;
}

#forget {
	margin-left: 50px;
}

.submit {
	width: 280px;
	height: 40px;
	border-radius: 5px;
	background: rgba(0, 0, 205, 0.8);
	outline: none;
	cursor: pointer;
	font-size: 20px;
	font-weight: bold;
	color: white;
}

#regist {
	display: none;
}
</style>
</head>
<body>
	
	<div id="header">
		<div class="headers div0">
			<h2>
				<a href="www.ATCstore.com" target="blank">ATC书城<br>www.ATCstore.com
				</a>
			</h2>
		</div>
		<div class="headers div1">
			<em><strong>购书就上ATC</strong></em>
		</div>
		<div class="headers div2">
			<p>
				<em><strong>全国服务热线:010-000001</strong></em>
			</p>
			<button class="backHome">返回首页</button>
		</div>
	</div>
	<div id="section">
		<div id="section1">
			<span class="login span">登 陆</span> <span class="regist span">注
				册</span>
			<%  String error=(String)request.getAttribute("ErrorMessage");
				if(error==null){
					error="";
				}
			%>
			<form action="userlogin" method="post" id="login">
				<p class="in">
					用 户* <input type="text" class="input" autofocus="autofocus" name="userName">
					</input>
				</p>
				<p class="in">
					密 码* <input type="password" class="input" name="password"></input>
				</p>
				<p class="auto">
					<input type="checkBox" class="self" name="login_auto"
						value="7天内自动登录">7天内自动登录</input> <span id="forget"><a
						href="" class="forget">忘记密码</a>|<a href="" class="forget">忘记账号</a></span>
				</p>
				<p>
					验 证 <input type="text" class="verify"></input>
				</p>
				<input type="submit" value="登 陆" class="submit"></input><br>
			</form>
			<form action="userRegist" method="post" id="regist">
				<p class="in">
					用户名* <input type="text" class="input" autofocus="autofocus" name="userName">
					</input>
				</p>
				<p class="in">
					密 码* <input type="password" class="input" name="password"></input>
				</p>
				<p class="in">
					确认密码* <input type="password" class="conform" name="confirm"></input>
				</p>
				<p class="in">
					邮 箱 <input type="email" class="email" name="email"></input>
				</p>
				<input type="submit" value="注 册" class="submit"></input><br>
			</form>
				<%=error %>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".regist").click(function() {
				$("#login").css("display", "none");
				$("#regist").css("display", "block");
				$("#section1").css("background", "rgba(78,238,148,0.5)");
				$(this).css("background", "rgba(84 ,139, 84,0.8)");
				$(".login").css("background", "rgba(0 ,238, 118,0.8)");
			})
			$(".login").click(function() {
				$("#login").css("display", "block");
				$("#regist").css("display", "none");
				$("#section1").css("background", "rgba(70,130,180,0.5)");
				$(this).css("background", "rgba(84 ,139, 84,0.8)");
				$(".regist").css("background", "rgba(0 ,238, 118,0.8)");
			})
		})
	</script>
</body>
</html>