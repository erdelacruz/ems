<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>EMS Employee Management System</title>

<style>
#employees {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#employees td, #employees th {
    border: 1px solid #ddd;
    text-align: left;
    padding: 8px;
}

#employees th {
    padding-top: 12px;
    padding-bottom: 12px;
    background-color: #4CAF50;
    color: white;
}
.error{
	font-size:12px;
	 color: red;
}


</style>

</head>
<body>
	
	<center><a href="/Logout"><button>LOGOUT</button></a></center>
	
	<fieldset>
		<legend>Employee ${result}</legend>
		<form:form method="post" commandName="SearchEmployeeForm" action="ExecuteSearchEmployee">
		<fieldset>
			<legend>Search Employee</legend>
			<table width="100%">
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstname"/> <form:errors path="firstname" cssClass="error"/></td>
					<td>Last Name :</td>
					<td><form:input path="lastname"/> <form:errors path="lastname" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Middle Name :</td>
					<td><form:input path="middlename"/> <form:errors path="middlename" cssClass="error"/></td>
					<td>Role :</td>
					<td>
						<form:select path="roleId">
							<form:option value="">Select Role:</form:option>
							<c:forEach var="role" items="${roles}">
								<form:option value="${role.id}">${role.roleName}</form:option>
							</c:forEach>
						</form:select>
						<form:errors path="roleId" cssClass="error"/>
					</td>
				</tr>
				<tr>
					<td colspan="4"><center><button type="submit">Search</button><center></td>
				</tr>
			</table>
		</fieldset>
		</form:form>
		
		
		<p style="color:#00b300;">${successMessage}</p>
		<p style="color:red;">${errorMessage}</p>
		
		<form:form method="post" commandName="BatchDeleteEmployeeForm" action="ExecuteBatchDeleteEmployee">
		<fieldset>
			<legend>List of Employees</legend>
			<div style="float:right; margin-bottom: 10px;">
			
			 
				<input type="button" onclick="location.href='Home';" value="DISPLAY ALL EMPLOYEES" />
				
				<sec:authorize access="hasRole('ADMIN')">	
					<input type="button" onclick="location.href='AddEmployee';" value="ADD NEW EMPLOYEE" />
					<button type="submit" onclick="return confirm('Are you sure, you want continue?');">BATCH DELETE</button>
				</sec:authorize>
			</div>
			
			<sec:authorize access="hasRole('ADMIN')">
				<table width="100%" id="employees">
							<tr>
								<td></td>
								<td>ID</td>
								<td>First Name</td>
								<td>Middle Name</td>
								<td>Last Name</td>
								<td>Gender</td>
								<td>Birth Date</td>
								<td>Employed</td>
								<td>G.W.A</td>
								<td>Role/Roles</td>
								<td>Action</td>
							</tr>
							
							<c:forEach var="employee" items="${listOfEmployees}">
								<tr>
									<td><form:checkbox path="ids" value="${employee.id}" /></td>
									<td>${employee.id}</td>
									<td>${employee.firstname}</td>
									<td>${employee.middlename}</td>
									<td>${employee.lastname}</td>
									<td>${employee.gender}</td>
									<td>${employee.getBirthDateAsString()}</td>
									<td>${employee.isEmployee() }</td>
									<td>${employee.generalWeightedAverage}</td>
									<td>
										<ul>
										<c:forEach var="role" items="${employee.selectedRoles}">
											<li>${role.roleName}</li>
										</c:forEach>
										</ul>
									</td>
									<td><a href="UpdateEmployee?id=${employee.id}">Update</a>
									 / <a href="DeleteEmployee?id=${employee.id}" onclick="return confirm('Are you sure you want to delete the record of ${employee.getFullname()}');">Delete</a></td>
								</tr>
							</c:forEach>
							
						</table>
					</sec:authorize>
					
					<sec:authorize access="hasRole('USER')">	
					<table width="100%" id="employees">
						<tr>
							<td>ID</td>
							<td>First Name</td>
							<td>Middle Name</td>
							<td>Last Name</td>
							<td>Gender</td>
							<td>Birth Date</td>
							<td>Employed</td>
							<td>G.W.A</td>
							<td>Role/Roles</td>
						</tr>
						
						<c:forEach var="employee" items="${listOfEmployees}">
							<tr>
								<td>${employee.id}</td>
								<td>${employee.firstname}</td>
								<td>${employee.middlename}</td>
								<td>${employee.lastname}</td>
								<td>${employee.gender}</td>
								<td>${employee.getBirthDateAsString()}</td>
								<td>${employee.isEmployee() }</td>
								<td>${employee.generalWeightedAverage}</td>
								<td>
									<ul>
									<c:forEach var="role" items="${employee.selectedRoles}">
										<li>${role.roleName}</li>
									</c:forEach>
									</ul>
								</td>
							</tr>
						</c:forEach>
						
					</table>
			</sec:authorize>
			
		</fieldset>
		</form:form>
	</fieldset>
	
</body>
</html>