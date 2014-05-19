<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE c:if PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
table.imagetable {
	color:#333333;
	border-width: 1px;
	border-color: #999999;
	border-collapse: collapse;
}
table.imagetable thead {
	background:#b5cfd2 url('cell-blue.jpg');
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
table.imagetable td {
	
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #999999;
}
</style>
<c:choose>
	<c:when test="${not empty Services}">
		<table class="imagetable">
			<thead>
				<tr>
					<td>Service Id</td>
					<td>Service Name</td>
					<td>Description</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="service" items="${Services}">
				<tr>
					<td>${service.serviceId}</td>
					<td>${service.serviceName}</td>
					<td>${service.description}</td>
					<td><input type="button" value="Unsubscribe"
						tag="${service.serviceId}" /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<p>you haven not subscribe any service!</p>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	$("[tag]").click(function() {
		var param = "ServiceId=" + $(this).attr("tag");
		$.ajax({
			url : "unsubscribe/" + $("#cuserid").val() + "?" + param,
			type : "POST",
			complete : function(xhr, status) {
				htmlobj = $.ajax({
					url : "/ssb/" + $("#cuserid").val(),
					async : false
				});
				$("#content").html(htmlobj.responseText);
			}
		});
	});
</script>


