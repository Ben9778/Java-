
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>home</title>
<style type="text/css">
	#div{
		position:absolute;
		top:200px;
		left:500px;
	}
	#search{
		width:300px;
	}
	.mouseOver{background:gray;}
	.mouseOut{background:white;}
</style>
</head>
<body>
	<div id="div">
		<input type="search" id="keyword" name="search" onkeyup="getText()"
		onblur="losefocuse()">
		<input type="button" value="百度一下" id="button">
		<div id="div1">
			<table id="table">
				<tbody id="tbody">
					
				</tbody>
			</table>
		</div>
	</div>
<!--script方法定义-->
	<script type="text/javascript">
		var xmlhttp;
		function getText(){
			
			var text=document.getElementById("keyword").value;
			if(text==""){
				clearContents();
				return;
			}
			xmlhttp=XMLhttp();
			var url="search?search="+escape(text);
			xmlhttp.open("GET",url,true);
			xmlhttp.send(null);	
			xmlhttp.onreadystatechange=callback;
		
		}
		<!--获取回调函数的JSON数据-->
		function callback(){
			if(xmlhttp.readyState==4){
				if(xmlhttp.status==200){
					var result=xmlhttp.responseText;
					var json=eval("("+result+")");
					setContens(json);
				}
			}
		}
		<!--定义XMLHttpRequest方法-->
		function XMLhttp(){
			var xml;
			if(window.XMLHttpRequest){
				xml=new XMLHttpRequest();
			}
			return xml;
		}
		<!--展示回调的数据-->
		function setContens(content){
			clearContents();
			var size=content.length;
			for(var i=0;i<size;i++){
				var node=content[i];
				var tr=document.createElement("tr");
				var td=document.createElement("td");
				td.setAttribute("border","0");
				td.setAttribute("backgroundColor","blue");
				tr.onmouseover=function(){
					this.className="mouseOver";
				}
				tr.onmouseout=function(){
					this.className="mouseOut";
				}
				
				var doc=document.createTextNode(node);
				var tb=document.getElementById("tbody");
				td.appendChild(doc);
				tr.appendChild(td);
				tb.appendChild(tr);
				td.onclick=function(){
					
				}
			}
		}
		<!--重新输入前清空表格数据-->
		function clearContents(){
			var ss=document.getElementById("tbody");
			var size=ss.childNodes.length;
			for(var i=size-1;i>=0;i--){
				ss.removeChild(ss.childNodes[i]);
			}
		}
		<!--输入框失去焦点处理-->
		function losefocuse(){
			clearContents();
		}
	</script>
</body>
</html>