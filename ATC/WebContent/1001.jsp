<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>剑来热销中</title>
<link rel="stylesheet" type="text/css" href="./css/sale.css">
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<style type="text/css">
.commentShow {
	width: 88%;
	height: auto;
	margin-left: 70px;
	margin-top: 30px;
}

.show {
	width: 88%;
	height: auto;
	background: rgba(152, 245, 255, 0.8);
}

.show div {
	padding: 20px;
}

.name {
	font-weight: bold;
}

.content span {
	font-size: 15px;
	word-break: break-all;
}

.time {
	font-size: 12px;
	display: inline-block;
}

.zan {
	display: inline-block;
	margin-left: 700px;
}

.zan span {
	font-size: 12px;
	opacity: 0.8;
	cursor: pointer;
}

.zan span:hover {
	opacity: 0.5

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
		<div id="login_regist" class="headers">
			<a href="userlogin">登录 | 注册</a> &nbsp;&nbsp;<a href="index.jsp">首页</a>
		</div>
	</div>
	<!-- 分割线 -->
	<div id="divice"></div>
	<!-- 页面位置信息-->
	<div id="book_posision">
		<small>当前位置: <a href="">武侠仙侠</a> > 剑来
		</small>
	</div>
	<!--图书图片-->
	<div id="book_image" class="bookinfo">
		<img src="image/剑来.JPG" alt="剑来" width="200" height="264">
	</div>
	<!--图书详细信息-->
	<div id="book_info" class="bookinfo">
		<div class="title">
			<strong>剑来</strong><i>TOP10</i>
		</div>
		<div class="label">
			<a href="">武侠仙侠</a> <a href="">古典仙侠</a>
		</div>
		<div class="number">
			<span>字数 <strong>459.9万</strong></span><span class="span">作者:
				烽火戏诸侯</span>&nbsp;&nbsp;<span class="span">总销量 <strong>0</strong></span>
		</div>
		<div class="introduction">
			<p>大千世界，无奇不有。我陈平安，唯有一剑，可搬山，倒海，降妖，镇魔，敕神，摘星，断江，摧城，开天！————我叫陈平安，平平安安的平安，我是一名剑客。</p>
		</div>
		<div class="buy">
			<span>价格: <strong>&yen;20.00</strong></span>&nbsp;&nbsp;&nbsp; <input
				type="number" min="1" max="99" value="1"> (库存:999件)</input> <input
				type="button" value="加入书包" class="add"></input>
		</div>
	</div>
	<div class="recommend">
		<span>精彩推荐</span>
	</div>
	<div class="recommend_books">
		<ul class="booklist">
			<li class="list"><a href=""><img src="image/万维.jpeg"
					width="150" height="214">
					<p>万维</p></a></li>
			<li class="list"><a href=""><img src="image/万道仙师.jpeg"
					width="150" height="214">
					<p>万道仙师</p></a></li>
			<li class="list"><a href=""><img src="image/太平客栈.jpeg"
					width="150" height="214">
					<p>太平客栈</p></a></li>
			<li class="list"><a href=""><img src="image/长宁帝君.jpeg"
					width="150" height="214">
					<p>长宁帝君</p></a></li>
			<li class="list"><a href=""><img src="image/透视医尊.jpeg"
					width="150" height="214">
					<p>透视医尊</p></a></li>
			<li class="list"><a href=""><img src="image/焦土黎明.jpeg"
					width="150" height="214">
					<p>焦土黎明</p></a></li>
		</ul>
	</div>
	<!--评论区-->
	<div class="comment">
		<span class="comment_title">剑来圈子</span> <span class="say">我要发表</span>
	</div>
	<div class="comment_write">
		<div class="sofa">快来抢沙发~</div>
		<div class="write">
			<form action="" method="get" id="commmend_form">
				<textarea maxlength="100" cols="80" rows="5" placeholder="请输入"
					form="commmend_form" class="comment_area" autofocus="autofocus"
					id="content" name="text"></textarea>
				<div>
					<span class="text_count"> 还能输入<span class="num_count"
						id="numCount">100</span>字
					</span> <input type="button" value="提交" form="commmend_form"
						class="commend_submit"></input>
				</div>
			</form>
		</div>
	</div>
	<!--评论展示区-->
	<div class="commentShow" id="comment_show">
		<div class="show">
			<div class="name">
				<span>Jack:</span>
			</div>
			<div class="content">
				<span>这个书很好看!</span>
			</div>
			<div class="time">
				<span>2019/6/28/17:18</span>
			</div>
			<div class="zan">
				<span>点赞 0</span>
			</div>
		</div>
	</div>
	<!--JS专区-->
	<script type="text/javascript">
		$("#content").keyup(function() {
			$length = $("#content").val().length;
			$result = 100 - $length;
			// 判断字数多少
			if ($length <= 100) {
				$("#numCount").text($result);
			}
		})
		$(".say").click(function() {
			$(".write").css("display", "block");
			$(".sofa").css("display", "none");
		})
	</script>
</body>
</html>