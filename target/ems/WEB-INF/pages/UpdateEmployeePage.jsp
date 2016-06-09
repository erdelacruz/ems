<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EMS Employee Management System</title>
<style>
.error{
	font-size:12px;
	 color: red;
}
</style>
</head>
<body>
	<center><a href="Home"><button>BACK</button></a> | <a href="/Logout"><button>LOGOUT</button></a></center>
	
	<form:form method="post" action="ExecuteAddorUpdateEmployee" commandName="AddOrUpdateEmployeeForm">
	<input type="hidden" name="id" value="${employee.id}"/>
	<fieldset>
		<legend>Employee</legend>
		
		<fieldset>
			<legend>General Information</legend>
			<table width="100%">
				<tr>
					<td>First Name* :</td>
					<td><form:input path="firstname" value="${employee.firstname}"/> <form:errors path="firstname" cssClass="error"/></td>
					<td>Last Name* :</td>
					<td><form:input path="lastname" value="${employee.lastname}"/> <form:errors path="lastname" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Middle Name* :</td>
					<td><form:input path="middlename" value="${employee.middlename}"/> <form:errors path="middlename" cssClass="error"/></td>
					<td>Gender* :</td>
					<td>
						<input type="radio" name="gender" ${employee.gender.equalsIgnoreCase("MALE")?'checked':''} value="Male"/> Male
						<input type="radio" name="gender" ${employee.gender.equalsIgnoreCase("FEMALE")?'checked':''}  value="Female"/> Female
						 <form:errors path="gender" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td>Birth Date* :</td>
					<td><form:input path="birthDate" value="${employee.getBirthDateAsString()}"/> <form:errors path="birthDate" cssClass="error"/></td>
					<td>Employed* :</td>
					<td>
						
						<input type="radio" name="employed" ${employee.employed==true?'checked':''} value="true"/> Yes
						<input type="radio" name="employed" ${employee.employed==false?'checked':''}  value="false"/> No
						 <form:errors path="employed" cssClass="error"/>
						
					</td>
				</tr>
				<tr>
					<td>G.W.A* :</td>
					<td><form:input path="generalWeightedAverageAsString" value="${employee.generalWeightedAverage}"/>
					 <form:errors path="generalWeightedAverageAsString" cssClass="error"/>
					</td>
					<td></td>
					<td></td>
				</tr>
			</table>
			
			<fieldset style="width: 300px;">
				<legend>Role *</legend>
				 <form:errors path="rolesId" cssClass="error"/>
				<c:forEach var="role" items="${employee.roles}">
					<p><input type="checkbox" ${role.selected==true?'checked':''}  name="rolesId" value="${role.id}" />  ${role.roleName}</p>
				</c:forEach>
			</fieldset>
		</fieldset>
		
		<fieldset>
			<legend>Address</legend>
			
			<table width="100%" >
				<tr>
					<td>Street* :</td>
					<td><form:input path="street" value="${employee.street}"/>  <form:errors path="street" cssClass="error"/></td>
					<td>House No.* :</td>
					<td><form:input path="houseNumber" value="${employee.houseNumber}"/>  <form:errors path="houseNumber" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Barangay* :</td>
					<td><form:input path="barangay" value="${employee.barangay}"/>  <form:errors path="barangay" cssClass="error"/></td>
					<td>Subdivision :</td>
					<td><form:input path="subdivision" value="${employee.subdivision}"/></td>
				</tr>
				<tr>
					<td>City* :</td>
					<td><form:input path="city" value="${employee.city}"/>  <form:errors path="city" cssClass="error"/></td>
					<td>Zip Code* :</td>
					<td><form:input path="zipCode" value="${employee.zipCode}"/>  <form:errors path="zipCode" cssClass="error"/></td>
				</tr>
				
			</table>
		</fieldset>
		
		<fieldset>
			<legend>Contact</legend>
			
			<table width="100%" >
				<tr>
					<td>Type :</td>
					<td>
						
						<input type="radio" name="contactType" ${employee.contactType.equalsIgnoreCase("Mobile")?'checked':''} value="Mobile"/> Mobile
						<input type="radio" name="contactType" ${employee.contactType.equalsIgnoreCase("Phone")?'checked':''}  value="Phone"/> Phone
						
					</td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Contact Number :</td>
					<td><form:input path="contactNumber" value="${employee.contactNumber}"/></td>
					<td></td>
					<td></td>
				</tr>
				
			</table>
		</fieldset>
		<center><button type="submit"> Submit</button></center>
	</fieldset>
	
	</form:form>
</body>
</html>