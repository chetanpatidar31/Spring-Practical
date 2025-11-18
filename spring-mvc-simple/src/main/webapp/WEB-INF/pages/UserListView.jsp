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
<title>User List</title>
</head>
<body>
	<%-- <%@include file="Header.jsp"%> --%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1>User List View</h1>
			<h2 style="color: red;">${errorMsg}</h2>
			<h2 style="color: green;">${successMsg }</h2>
			<sf:hidden path="pageNo" />
			<table>
				<tr>
					<td><sf:input path="firstName" />&nbsp; &nbsp;</td>
					<td><input type="submit" name="operation" value="search"></td>
				</tr>
			</table>
			<table style="width: 100%" border="1">
				<tr>
					<th>Select</th>
					<th>ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Login</th>
					<th>Password</th>
					<th>Address</th>
					<th>Edit</th>
				</tr>
				<c:forEach items="${list}" var="user">
					<tr align="center">
						<td><sf:checkbox path="ids" value="${user.id}" /></td>
						<td><c:out value="${user.id}"></c:out></td>
						<td><c:out value="${user.firstName }"></c:out></td>
						<td><c:out value="${user.lastName }"></c:out></td>
						<td><c:out value="${user.login }"></c:out></td>
						<td><c:out value="${user.password }"></c:out></td>
						<td><c:out value="${user.address }"></c:out></td>
						<td align="center"><a
							href="<c:url value="/ctl/User?id=${user.id}" />">edit</a></td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<table style="width: 100%">
				<tr>
					<td style="width: 30%"><input type="submit" name="operation"
						value="previous" ${form.pageNo ==1 ? 'disabled' : '' } /></td>
					<td align="center"><input type="submit" name="operation"
						value="delete"></td>
					<td style="text-align: right;"><input type="submit"
						name="operation" value="next"
						${list.size() < 5 ? 'disabled="disabled"' : ''}></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%-- <%@include file="Footer.jsp"%> --%>
</body>
</html>