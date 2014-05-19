<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-1.10.2.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<script src="js/jquery-ui-1.10.4.js"></script>	
<style type="text/css">
div#container{width:100%}
div#header {background-color:#99bbbb;}
div#menu {background-color:#ffff99;height:100%;width:20%;float:left;}
div#content {background-color:#EEEEEE;height:100%;width:80%;float:left;}
</style>
</head>
<body>
<div id="container">
<div id="menu">
<ul>
<%-- <c:forEach var="user" items="${Users}">
<li value="${user.userId }"><a href="javascript:"><c:out value="${user.userName }"/><a/></li>
</c:forEach> --%>

</ul>
<div><c:out value="${user}" /></div>
</div>
<div id="content">

</div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	$("li").click(function(){
		htmlobj=$.ajax({url:"subscription/"+this.value+".do",async:false});
		$("#content").html(htmlobj.responseText);
	});
	
});
</script>
</html>