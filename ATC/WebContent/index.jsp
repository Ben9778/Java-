<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,minimum-scale=1,user-scalable=no" />
<title>ATC书城</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<style type="text/css">
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	padding: 0px;
}
body{min-width:1200px;}
a {
	text-decoration: none;
	color: black;
}

.headers {
	text-align: center;
	display: inline-block;
}

.section {
	background: white;
	display: inline-block;
	margin-top: 20px;
	overflow: hidden;
}

.nod:hover {
	color: blue;
	text-decoration: underline;
}

.off {
	display: inline;
	width: 200px;
	height: 280px;
	padding: 20px;
}

.show {
	float: left;
	width: 240px;
	height: 320px;
}

.picture {
	width: 200px;
	height: 280px;
}

body {
	background: #FFF5EE
}

#header {
	background: white;
	width: 100%;
	height: 120px;
	overflow: hidden;
}

#logo {
	margin-left: 70px;
	margin-top: 20px;
}

#search {
	margin-left: 120px;
}

#search_text {
	width: 300px;
}

#count {
	margin-left: 150px;
}

#hotword {
	list-style: none;
	margin-left: -210px;
	margin-top: 3px;
}

#hotword>li {
	color: green;
	opacity: 0.6;
	display: inline;
	font-size: 10px;
}

#article {
	text-align: center;
}

#aside {
	width: 200px;
	height: 320px;
}

#play {
	width: 720px;
	height: 320px;
}

#rank {
	width: 150px;
	height: 320px;
}

ol>li {
	padding-top: 5px;
}

#aside ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

#aside ul>li {
	padding: 8px;
	margin-top: 20px;
}

#aside ul:hover {
	color: blue;
}

#play1 {
	width: 720px;
	height: 320px;
	position: relative;
}

#play2 {
	list-style: none;
	margin: 0;
	padding: 0;
	text-align: left;
	width: 1440px;
	overflow: hidden;
	position: absolute;
	animation-name: action;
	animation-delay: 3s;
	animation-duration: 9s;
	animation-iteration-count: infinite;
	animation-timing-function: linear;
}

#play2:hover {
	animation-play-state: paused;
}

@keyframes action { 100%{
	left: -720px;
}

}
#hd {
	background: white;
	margin-top: 30px;
}

#hd ul {
	list-style: none;
	text-align: center;
}

#title {
	background: black;
	color: white;
	text-align: center;
}

#foot {
	width: 100%;
	height: 200px;
	background: white;
}
</style>
</head>
<body>
	<div id="header">
		<div id="logo" class="headers">
			<h2>
				<a href="www.ATCstore.com" class="ld" target="blank">ATC书城<br>www.ATCstore.com
				</a>
			</h2>
		</div>
		<div id="search" class="headers">
			<input type="search" id="search_text"></input> <input type="button"
				id="search_button" value="搜索"></input>
			<ul id="hotword">
				<li>关键词:</li>
				<li><a href="" target="blank">玄幻</a></li>
				<li><a href="" target="blank">科技</a></li>
				<li><a href="" target="blank">旅游</a></li>
				<li><a href="" target="blank">摄影</a></li>
				<li><a href="" target="blank">体育</a></li>
			</ul>
		</div>
		<div id="count" class="headers">
			<%String message=(String)request.getSession().getAttribute("welcome");
				if(message==null){
					message="登陆|注册";
				}
			%>
			<p>
				<em><strong>全国服务热线:010-000001</strong></em>
			</p>
			<a 	href="login.jsp" target="blank" style="color: blue;"><%=message %></a> &nbsp;<a
				href="" target="blank" style="color: orange;">购物车</a> &nbsp;<a
				href="" target="blank" style="color: orange;">足迹</a> &nbsp;<a
				href="" target="blank" style="color: orange;">订单</a>
		</div>
	</div>
	<div id="article">
		<div id="aside" class="section">
			<ul>
				<li><a href="" class="nod" target="blank">穿越 / 玄幻 / 武侠</a></li>
				<li><a href="" class="nod" target="blank">历史 / 地理 / 政治</a></li>
				<li><a href="" class="nod" target="blank">体育 / 汽车 / 股票</a></li>
				<li><a href="" class="nod" target="blank">旅游 / 美食 / 摄影</a></li>
				<li><a href="" class="nod" target="blank">养生 / 保健 / 美容</a></li>
			</ul>
		</div>
		<div id="play" class="section">
			<div id="play1">
				<ul id="play2">
					<li class="show"><a href="" target="blank"><img
							src="image/万维.jpeg"></a></li>
					<li class="show"><a href="" target="blank"><img
							src="image/万道仙师.jpeg"></a></li>
					<li class="show"><a href="" target="blank"><img
							src="image/人间最得意.jpeg"></a></li>
					<li class="show"><a href="" target="blank"><img
							src="image/我是半妖.jpeg"></a></li>
					<li class="show"><a href="" target="blank"><img
							src="image/神级奶爸.jpeg"></a></li>
					<li class="show"><a href="" target="blank"><img
							src="image/长宁帝君.jpeg"></a></li>
				</ul>
			</div>
		</div>
		<div id="rank" class="section">
			<span style="color: red; font-size: 20px;">热销榜</span>
			<ol>
				<li><a href="" target="blank">长宁帝君</a></li>
				<li><a href="" target="blank">万道仙师</a></li>
				<li><a href="" target="blank">人间最得意</a></li>
				<li><a href="" target="blank">我是半妖</a></li>
				<li><a href="" target="blank">最强狂兵</a></li>
				<li><a href="" target="blank">透视医尊</a></li>
				<li><a href="" target="blank">焦土黎明</a></li>
				<li><a href="" target="blank">剑来</a></li>
				<li><a href="" target="blank">太平客栈</a></li>
				<li><a href="" target="blank">女儿神龙</a></li>
			</ol>
		</div>
	</div>
	<div id="title">
		<span><strong>| 10元活动区</strong></span>
	</div>
	<div id="hd">
		<ul>
			<li class="off"><a href="" target="blank"> <img
					src="image/剑来.jpg" class="picture">
			</a></li>
			<li class="off"><a href="" target="blank"> <img
					src="image/我的女儿是神龙.jpeg" class="picture">
			</a></li>
			<li class="off"><a href="" target="blank"> <img
					src="image/最强狂兵5.jpg" class="picture">
			</a></li>
			<li class="off"><a href="" target="blank"> <img
					src="image/太平客栈.jpeg" class="picture">
			</a></li>
			<li class="off"><a href="" target="blank"> <img
					src="image/焦土黎明.jpeg" class="picture">
			</a></li>
		</ul>
	</div>
	<div id="title1">
		<span><strong>| 即将上市</strong></span>
	</div>
	<div id="plan">
		<ul>
			<li class="off"><a href="" target="blank"><img
					src="image/剑来.jpg" class="picture"></a></li>
			<li class="off"><a href="" target="blank"><img
					src="image/我的女儿是神龙.jpeg" class="picture"></a></li>
		</ul>
	</div>
	<div id="foot"></div>
</body>
</html>