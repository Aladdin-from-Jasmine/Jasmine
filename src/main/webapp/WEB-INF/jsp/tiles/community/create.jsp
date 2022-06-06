<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	function home(targetUri) {
		form.action = targetUri;
		form.submit();
	}

</script>
<div class="container">
	<div id="signup-form">
		<h2 class="text-center">게시물 등록</h2>
		<br />
		<form:form modelAttribute="communityForm" method="POST"
			action="/community/list" id="signup-form-form">
			<div class="form-group">
 				<label for="userId">Writer</label>
 				<form:input path="community.userId" class="form-control" placeholder="${userId}" readonly="true" />
 				<%-- <form:errors path="community.postId" cssClass="error" />
						<form:errors cssClass="error" /> --%>
			</div>
			<div class="form-group">
				<label for="title">Title</label>
				<form:input path="community.title" class="form-control"
					placeholder="제목을 입력하세요." />
				<%-- <form:errors path="community.title" cssClass="error" />
						<form:errors cssClass="error" /> --%>
			</div>

			<div class="form-group">
				<label for="name">Content</label></br>
				<form:textarea path="community.content_" cols="50" rows="10"
					class="form-control2" placeholder="내용을 입력하세요." />
				<%-- 	<form:errors path="community.content_" cssClass="error" />
 --%>
			</div>

			<div class="form-group" align="center">
				<input type="submit" value="REGISTER" id="register-btn">
			</div>

		</form:form>
	</div>
</div>