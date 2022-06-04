<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>	
<%-- <c:if test="${deleteComplete == 1}">
	<body onLoad="alert('회원탈퇴가 완료되었습니다.')">
</c:if> --%>

<div class="container">
	<div id="login-form">
		<h2 class="text-center">LOGIN</h2>
		<br />
				<form:form modelAttribute="loginForm" method="POST" action="/user/login" id="signup-form-form">
					<form:errors cssClass="error" /> <br />
					<table align="center">
					<tr text-align="right">
						<td>
							<div class="form-group">
								<label for="userId">ID</label> 
							</div>
						</td>
						<td>
							<form:input path="userId" class="form-control" placeholder="userId" />
							<form:errors path="userId" cssClass="error" />
						</td>
					</tr>
					<tr text-align="left">
						<td>
							<div class="form-group">
								<label for="password">Password</label>
							</div>
						</td>
						<td>
							<form:input path="password" type="password" class="form-control"
									placeholder="password" />
							<form:errors path="password" cssClass="error" />
						</td>
					</tr>
					</table>				
			<br />

			<div class="form-group" >
				<input type="submit" value="Login" id="register-btn">
				&nbsp; <a id="a-btn" href="<c:url value='/user/register'></c:url>">Register</a>
			</div>		
			</form:form>
	</div>
</div>
