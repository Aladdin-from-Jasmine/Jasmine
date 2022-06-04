<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<div class="container">
	<h1>My Page</h1>
	<h3>update 💁🏻‍♀</h3>

	<form:form modelAttribute="userForm" method="POST" action="update"
		id="updateform">

		<div class="form-group">
			<label for="email">Email</label>
			<form:input path="user.email" class="form-control" readonly="true" />
			<br />
		</div>

		<div class="form-group">
			<label for="password">Password</label>
			<form:input path="user.password" type="password" class="form-control" />
			<form:errors path="user.password" cssClass="error" />
			<br />
		</div>

		<div class="form-group">
			<label for="password">Check Password</label>
			<form:input path="repeatedPassword" type="password"
				class="form-control" />
			<form:errors path="repeatedPassword" cssClass="error" />
			<br />
		</div>

		<div class="form-group">
			<label for="userName">Name</label>
			<form:input path="user.username" class="form-control" readonly="true" />
			<br />
		</div>

		<div class="form-group">
			<label for="phone">Phone</label>
			<form:input path="user.phone" class="form-control" />
			<form:errors path="user.phone" cssClass="error" />
			<br />
		</div>

		<div class="form-group">
			<label>Address</label>
			<form:input path="user.address" class="form-control" />
			<br />
		</div>

		<div class="form-group">
			<input type="submit" value="Save" id="register-btn"> <a
				id="a-btn" href="<c:url value='/user/detail'></c:url>">Cancel</a>
		</div>
	</form:form>

</div>
