<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	function deleteComm(){		
		if(confirm("게시물을 삭제하시겠습니까?")){
			form.submit();	
		} 
	}
</script>

<div class="container">
	<div id="signup-form">
		<h2 class="text-center">게시물 상세보기</h2>
		<br />
		<form:form modelAttribute="communityForm" method="POST" name="form" 
		action="/community/delete" id="signup-form-form"><br />
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
						${community.userId}
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
						${community.title}
						<form:errors path="community.title" cssClass="error" />
						<form:errors cssClass="error" />
					</td>
				</tr>
				<tr>
					<td class="td1-4">
						<label for="name">Content</label></br>
					</td>
					<td class="td2">
						${community.content_}
					 	<form:errors path="community.content_" cssClass="error" />
					</td>
				</tr>			
			</table><br/>
			<c:if test="${isUser==true || isManager==true}" >
				<div class="form-group" align="center">
					<a href="<c:url value='/community/update'>
	  					<c:param name="postId" value="${community.postId}"/>
					</c:url>" id="a-btn">수정</a>
					<input id="a-btn" type="button" value="삭제" onClick="deleteComm()" />
			</c:if>
					<a href="<c:url value='/community/list'/>" id="a-btn">목록</a>
				</div>
		</form:form>
	</div>
</div>