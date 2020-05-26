<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>管理员登陆</title>
<style type="text/css">
body {
	width: 1000px;
	margin: 0;
	padding: 0;
	background-image: url("image/admin.jpg");
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-attachment: fixed;
	z-index: -100px;
}

div {
	width: 300px;
	height: 350px;
	margin-left: 500px;
	margin-top: 180px;
	background: rgba(255, 255, 240, 0.5);
	border-radius: 10px;
	overflow: hidden;
}

form {
	margin-top: 40px;
	margin-left: 20px;
}

p {
	font-size: 20px;
	font-weight: bold;
}

#admin {
	text-align: center;
}

#auto {
	font-size: 15px;
	color: red;
}

.self {
	width: 15px;
	height: 15px;
	text-align: center;
}

.input {
	width: 200px;
	height: 30px;
	border-radius: 10px;
	outline: none;
	font-size: 20px;
}

.submit {
	width: 250px;
	height: 40px;
	outline: none;
	margin-left: 5px;
	border-radius: 5px;
	background: rgba(132, 112, 255, 0.8);
	color: white;
	font-size: 20px;
	font-weight: bold;
	outline: none;
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
		<form action="" method="post">
			<p id="admin">管 理 员 登 陆</p>
			<p>
				账 号 <input type="text" class="input" autofocus="autofocus"
					autocomplete="autocomplete"></input>
			</p>
			<p>
				密 码 <input type="password" class="input"></input>
			</p>
			<p id="auto">
				<input type="checkBox" class="self">7天内自动登录</input>
			</p>
			<input type="submit" value="登 陆" class="submit"></input><br>
		</form>
	</div>
</body>
</html>