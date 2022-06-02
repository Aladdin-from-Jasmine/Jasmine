<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<<<<<<< HEAD
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
=======
>>>>>>> branch 'hyunsoo2' of https://github.com/Aladdin-from-Jasmine/Jasmine.git
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<<<<<<< HEAD
=======
<%-- <%@ include file="../IncludeTop.jsp" %> 

<style>
	.error {
		color: #ff0000;
		/* font-weight: bold; */
	}
</style>
 --%>
>>>>>>> branch 'hyunsoo2' of https://github.com/Aladdin-from-Jasmine/Jasmine.git
<c:if test="${deleteComplete == 1}">
	<body onLoad="alert('회원탈퇴가 완료되었습니다.')">
</c:if>

<<<<<<< HEAD
<div class="container">
	<div id="login-form">
		<h2 class="text-center">LOGIN</h2>
		<br />
=======
<!-- <body bgcolor="black"> -->
	<div class="container" style="padding: 100px">
		<div class="row block-9 justify-content-center mb-5">
			<div class="col-md-8 mb-md-5">
>>>>>>> branch 'hyunsoo2' of https://github.com/Aladdin-from-Jasmine/Jasmine.git

<<<<<<< HEAD
		<form:form modelAttribute="loginForm" method="POST" action="login" id="signup-form-form">
			<form:errors cssClass="error" />
			<br />
			<div class="form-group">
				<label for="userId">ID</label>
				<form:input path="userId" class="form-control" placeholder="userId" />
				<form:errors path="userId" cssClass="error" />
=======
				<h2 class="text-center">Login</h2>
				<br/>
				
				<form:form modelAttribute="loginForm" method="POST" action="login" class="bg-light p-5 contact-form">
					<form:errors cssClass="error" /> <br />
					<div class="form-group">
						<label for="userId">ID</label> 
						<form:input path="userId" class="form-control" placeholder="userId" />
						<form:errors path="userId" cssClass="error" />
					</div>

					<div class="form-group">
						<label for="password">Password</label> 
						<form:input path="password" type="password" class="form-control" placeholder="Password" />
						<form:errors path="password" cssClass="error" />
					</div>
					<br />

					<div class="form-group" align="center">
						<input type="submit" value="Login" class="btn btn-primary py-3 px-5"> &nbsp;
				        <a class="btn btn-primary py-3 px-5" href="<c:url value='/user/register.do'></c:url>">Register</a>
					</div>
					
				</form:form>
>>>>>>> branch 'hyunsoo2' of https://github.com/Aladdin-from-Jasmine/Jasmine.git
			</div>

			<div class="form-group">
				<label for="password">Password</label>
				<form:input path="password" type="password" class="form-control"
					placeholder="Password" />
				<form:errors path="password" cssClass="error" />
			</div>
			<br />

			<div class="form-group" align="center">
				<input type="submit" value="Login" id="register-btn">
				&nbsp; <a id="login-register-btn" href="<c:url value='/user/register'></c:url>">Register</a>
			</div>

		</form:form>
	</div>
<<<<<<< HEAD

</div>
=======
<!-- </body>
</html> -->
>>>>>>> branch 'hyunsoo2' of https://github.com/Aladdin-from-Jasmine/Jasmine.git
