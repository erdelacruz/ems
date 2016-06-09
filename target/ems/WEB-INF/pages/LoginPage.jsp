<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EMS Employee Management System</title>
</head>
<body>
	<form action="Login" method="post">
	<!-- SPRING SECURITY -->
	<input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
	<fieldset>
		<legend>Login Form</legend>
		
		<c:if test="${param.error!=null}">
		   <p style="color:red;">Invalid Username or Password<p>
		</c:if>
		
		<table width="50%">
			<tr>
				<td>Username :</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td colspan="2"><center><input type="submit" value="Log in"/></center></td>
			</tr>
		</table>
	</fieldset>
	</form>
</body>
</html>