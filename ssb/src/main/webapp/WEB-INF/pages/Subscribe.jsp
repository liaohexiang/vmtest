<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div>
	<c:choose>
		<c:when test="${not empty Services}">
			<ul>
				<c:forEach var="service" items="${Services}">
					<li><input type="checkbox" value="${service.serviceId}"/><span>${service.serviceName}</span></li>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
			You have subscribed all services!
		</c:otherwise>
	</c:choose>


</div>