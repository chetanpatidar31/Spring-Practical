<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<sf:form method="post" modelAttribute="form">
		<div align="center">
			<h1 style="color: navy">Login</h1>
			<h2 style="color: green">${successMsg}</h2>
			<h2 style="color: red">${errorMsg}</h2>
			<table>
				<tr>
					<th align="left">Login ID :</th>
					<td><sf:input path="login" placeholder="Enter Login Id" /></td>
					<td style="color : red;"><sf:errors path="login" /></td>
				</tr>
				<tr>
					<th align="left">Password :</th>
					<td><sf:password path="password" placeholder="Enter Password" /></td>
					<td style="color : red;"><sf:errors path="password" /></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signIn">
						<input type="submit" name="operation" value="signUp"></td>
				</tr>
			</table>
		</div>
	</sf:form>
	<%@include file="Footer.jsp"%>
</body>
</html>