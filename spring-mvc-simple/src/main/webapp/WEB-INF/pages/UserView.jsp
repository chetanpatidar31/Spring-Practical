<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User View</title>
</head>
<body>
	<%-- <%@include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<c:if test="${form.id>0}">
				<h1 style="color: navy;">Update User</h1>
			</c:if>
			<c:if test="${form.id==0 }">
				<h1 style="color: navy;">Add User</h1>
			</c:if>
			<h2 style="color: green;">${successMsg}</h2>
			<h2 style="color: red;">${errorMsg}</h2>
			<table>
				<tr>
					<th align="left">First Name :</th>
					<td><sf:input path="firstName" placeholder="Enter First Name" /></td>
					<td style="color: red;"><sf:errors path="firstName" /></td>
				</tr>
				<tr>
					<th align="left">Last Name :</th>
					<td><sf:input path="lastName" placeholder="Enter Last Name" /></td>
					<td style="color: red;"><sf:errors path="lastName" /></td>
				</tr>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="Enter Login Id" /></td>
					<td style="color: red;"><sf:errors path="login" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:input path="password" placeholder="Enter Password" /></td>
					<td style="color: red;"><sf:errors path="password" /></td>
				</tr>
				<tr>
					<th align="left">Address :</th>
					<td><sf:input path="address" placeholder="Enter Your Address" /></td>
					<td style="color: red;"><sf:errors path="address" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="${form.id == 0  ? 'save' : 'update'}"></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%-- <%@include file="Footer.jsp"%> --%>
</body>
</html>