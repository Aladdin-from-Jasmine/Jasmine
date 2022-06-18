<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	function update() {
		request.setParameter("postId", ${community.postId});
		//form.action = targetUri;
		$("#signup-form-form").submit();
	}

</script>
<div class="container">
	<div id="signup-form">
		<h2 class="text-center">게시물 수정하기</h2>
		<br />
		<form:form modelAttribute="communityForm" method="POST" name="form" id="signup-form-form"
			action="/community/update" ><br />
			<table class="TB1" align="center">
				<tr>
					<td class="td1">
 						<label for="postId">PostId</label> 				
					</td>
					<td class="td2">
	  					<form:input path="community.postId" class="form-control" value="${community.postId}" readonly="true" />
	  					 <form:errors path="community.postId" cssClass="error" />
							<form:errors cssClass="error" /> 
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="userId">Writer</label>			
					</td>
					<td class="td2">
	 	 				<form:input path="community.userId" class="form-control" value="${community.userId}" readonly="true" />
						 <form:errors path="community.postId" cssClass="error" />
						 <form:errors cssClass="error" /> 
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="communityDate">생성 날짜</label>
					</td>
					<td class="td2">
						<fmt:formatDate value="${community.communityDate}" pattern="yyyy-MM-dd HH:mm" />
 						 <form:errors path="community.postId" cssClass="error" />
						<form:errors cssClass="error" /> 
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="title">Title</label>
					</td>
					<td class="td2">
						<form:input path="community.title" class="form-control"
						value="${community.title}" />
						<form:errors path="community.title" cssClass="error" />
						<form:errors cssClass="error" />
					</td>
				</tr>
				<tr>
					<td class="td1-4">
						<label for="name">Content</label></br>
					</td>
					<td class="td2">
						<form:textarea path="community.content_" cols="30" rows="10"
						class="form-control2"  />
						<form:errors path="community.content_" cssClass="error" />
					</td>
				</tr>			
			</table><br/>
			<div class="form-group" align="center">
 				<input type="submit" value="수정하기" id="register-btn">
				<a href="<c:url value='/community/detail'>
	  				<c:param name="postId" value="${community.postId}"/>
				</c:url>" id="a-btn">취소</a>
			</div>
		</form:form>
	</div>
</div>