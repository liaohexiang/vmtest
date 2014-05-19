<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE c:if PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VM service subscription</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet"
	href="css/jquery.ui.theme.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<style type="text/css">
div#container {
	width: 100%
}


div#menu {
	height: 100%;
	width: 20%;
	float: left;
}
</style>
</head>
<body>
	<div id="container">
		<div id="header" class="ui-widget-header ui-widget"><input type="button" id="subsribe" value="Subscribe"
				disabled="disabled" />&nbsp;&nbsp; | &nbsp;&nbsp; <span>Current User:&nbsp;&nbsp;</span><span id="cuser"></span><input
				type="hidden" id="cuserid" />
		</div>
		<div id="menu" class="ui-widget-content ui-widget">
			<ul>
				<c:forEach var="user" items="${Users}">
					<li value="${user.userId }"><a href="javascript:">${user.userName
							}</a></li>
				</c:forEach>

			</ul>
		</div>
		<div id="content" class="ui-widget"></div>
	</div>
	<div id="dialog" title="Subscription"></div>

	<script>
		$("#dialog").dialog({
			autoOpen : false,
			modal : true,
			buttons : [ {
				text : "Submit",
				click : subscribe
			}, {
				text : "Close",
				click : function() {
					$(this).dialog("close");
				}
			} ]
		});
		$("#subsribe").click(function() {
			$("#dialog").dialog("open");
		});
		function subscribe() {
			var param = "Services=";
			$(":checkbox").each(function() {
				if ($(this).prop("checked")) {
					param += $(this).val() + "-";
				}
			});
			$.ajax({
				url : "subscribe/" + $("#cuserid").val() + "?" + param,
				type : "POST",
				complete : function(xhr,status) {
					$("#dialog").dialog("close");
					htmlobj = $.ajax({
						url : $("#cuserid").val(),
						async : false
					});
					$("#content").html(htmlobj.responseText);
				}
			});
		}
	</script>
</body>
<script type="text/javascript">
	$(function() {
		$("li").click(function() {
			$("#subsribe").removeAttr("disabled");
			htmlobj = $.ajax({
				url : this.value,
				async : false
			});
			$("#content").html(htmlobj.responseText);
			$("#cuserid").val(this.value);
		});
		$("a").click(function() {
			$("#cuser").html(this.innerHTML);
		});
		$("#subsribe").click(function() {
			$("#dialog").dialog("open");
			htmlobj = $.ajax({
				url : "available/" + $("#cuserid").val(),
				async : false
			});
			$("#dialog").html(htmlobj.responseText);
		});
	});
	
</script>
</html>