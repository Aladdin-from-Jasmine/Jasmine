<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
	function home(targetUri) {
		form.action = targetUri;
		form.submit(); 
	}

</script>
<div class="container">
	<div id="signup-form">
		<h2 class="text-center">SIGN UP</h2>
		<br />
		<spring:hasBindErrors name="userForm"></spring:hasBindErrors>
		<form:form modelAttribute="userForm" method="POST"
			action="/user/register" id="signup-form-form">
			<div class="form-group">
				<label for="name">ID</label>
				<form:input path="user.userId" class="form-control" />
				<c:if test="${sameIdExist==true}"  >
					<p class="error"> 이미 존재하는 아이디입니다. </p>
				</c:if>
				<form:errors path="user.userId" class="error" />
			</div>
			<div class="form-group">
				<label for="name">Email</label>
				<form:input path="user.email" class="form-control"
					placeholder="ex) 20170000@dongduk.ac.kr" />
				 <form:errors path="user.email" class="error" />
			</div>

			<div class="form-group">
				<label for="name">Password</label>
				<form:input path="user.password" type="password"
					class="form-control" placeholder="Password" />
				<form:errors path="user.password" class="error" />
			</div>

			<div class="form-group">
				<label for="name">Check Password</label>
				<form:input path="repeatedPassword" type="password"
					class="form-control" placeholder="Password" />
				<form:errors path="repeatedPassword" class="error" />
			</div>

			<div class="form-group">
				<label for="name">Name</label>
				<form:input path="user.username" class="form-control"
					placeholder="Name" />
				<form:errors path="user.username" class="error" />
			</div>

			<div class="form-group">
				<label for="name">Phone</label>
				<form:input path="user.phone" class="form-control"
					placeholder="ex) 010-0000-0000" />
				<form:errors path="user.phone" class="error" />
			</div>

			<div class="form-group">
				<label for="name">Address</label>
				<form:input path="user.address" class="form-control" />
			</div>

			<br />

			<div class="form-group" align="center">
				<input type="submit" value="REGISTER" id="register-btn">
			</div>

		</form:form>
	</div>
</div>