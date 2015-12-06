<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/webjars/font-awesome/4.4.0/css/font-awesome.css"
	rel="stylesheet" />
<title>Insert title here</title>

<style type="text/css">
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Customer Form</h1>
	<c:url var="addCustomer" value="/customer/add"></c:url>

	<form:form action="${addCustomer}" commandName="customer">
		<div class="form-group">
			<table>
				<c:if test="${!empty customer.name}">
					<tr>
						<td><form:label path="customer_id"
								cssClass="control-label col-sm-2">
								<spring:message text="ID" />
							</form:label></td>
						<td><form:input path="customer_id" readonly="true" size="5"
								disabled="true" /> <form:hidden path="customer_id" /></td>

					</tr>

				</c:if>
				<tr>
					<td><form:label path="name" cssClass="control-label col-sm-2">
							<spring:message text="Name" />
						</form:label></td>
					<td><form:input path="name" /></td>
					<td align="left"><form:errors path="name" cssClass="error" /></td>
				</tr>

				<tr>
					<td><form:label path="address"
							cssClass="control-label col-sm-2">
							<spring:message text="Address" />
						</form:label></td>
					<td><form:input path="address" /></td>
					<td align="left"><form:errors path="address" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="department"
							cssClass="control-label col-sm-2">
							<spring:message text="Department" />
						</form:label></td>
					<td><form:select path="department">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${departmentList}" />
						</form:select></td>
					<td align="left"><form:errors path="department"
							cssClass="error"></form:errors></td>
				</tr>
				<tr>
<td></td>
					<td ><c:if test="${!empty customer.name}">
							<input type="submit" class="button btn-primary"
								value="<spring:message text="Edit Customer"/>" />
						</c:if> <c:if test="${empty customer.name}">
							<input type="submit" class="button btn-primary"
								value="<spring:message text="Add Customer"/>" />
						</c:if></td>
				</tr>

			</table>
		</div>
	</form:form>
	<h2>Customer Details</h2>
	<table class="table table-striped table-bordered table-hover">
		<tr class="info">
			<th width="80">Customer ID</th>
			<th width="120">Customer Name</th>
			<th width="120">Customer Address</th>
			<th width="120">Customer Department</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:if test="${!empty listCustomers}">
			<c:forEach items="${listCustomers}" var="customer">
				<tr>
					<td>${customer.customer_id}</td>
					<td>${customer.name}</td>
					<td>${customer.address}</td>
					<td>${customer.department}</td>
					<td><a
						href="<c:url value='/customer/edit/${customer.customer_id}' />"><button
								class="button btn-warning">
								<i class="fa fa-pencil-square-o">Edit</i>
							</button></a></td>
					<td><a
						href="<c:url value='/customer/delete/${customer.customer_id}' />"><button
								class="button btn-danger">
								<i class="fa fa-times">Delete</i>
							</button></a></td>

				</tr>
			</c:forEach>

		</c:if>
	</table>
</body>