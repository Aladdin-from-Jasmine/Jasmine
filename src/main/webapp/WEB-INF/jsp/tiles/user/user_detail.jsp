<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script>
	function logoutCheck() {
		if (confirm("로그아웃 하시겠습니까?")) {
			location.href = "logout";
		}
	}

	function removeCheck() {
		if (confirm("정말 탈퇴하시겠습니까?")) {
			location.href = "delete";
		}
	}
</script>

<c:choose>
	<c:when test="${deleteComplete == -1}">
		<body onLoad="alert('작성한 공동구매/경매 중 마감되지 않은 게시글이 있어서 \n회원탈퇴가 불가합니다.')">
	</c:when>
	<c:when test="${deleteComplete == 0}">
		<body onLoad="alert('예상치 못한 문제로 회원탈퇴에 실패했습니다.')">
	</c:when>
	<c:when test="${updateComplete == 0}">
		<body onLoad="alert('예상치 못한 문제로 회원정보 수정에 실패했습니다.')">
	</c:when>
	<c:otherwise>
		<body>
	</c:otherwise>
</c:choose>

<h1>My Page</h1>
<div class="container">
	<div class="mypage-table-class">
		<table class="mypage-table">
			<tr>
				<th>Name</th>
				<td>${userForm.user.username}</td>
			</tr>
			<tr>
				<th>ID</th>
				<td>${userForm.user.userId}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${userForm.user.email}</td>
			</tr>
			<tr>
				<th>Phone</th>
				<td>${userForm.user.phone}</td>
			</tr>
			<tr>
				<th>Address</th>
				<td>${userForm.user.address}</td>
			</tr>

		</table>
	</div>

	<br> <br> 
	<a id="a-btn" href="<c:url value='/user/book'></c:url>">📚책</a> &nbsp; 
	<a id="a-btn" href="<c:url value='/user/auction'></c:url>">⌛경매</a> &nbsp; 
	<a id="a-btn" href="<c:url value='/user/bid'></c:url>">⌛낙찰된 경매</a> &nbsp; 
	<a id="a-btn" href="<c:url value='/user/order'></c:url>">💳결제</a> &nbsp; 
	<a id="a-btn" href="<c:url value='/user/update'></c:url>">💁🏻‍♀회원 정보 수정</a> &nbsp; 
	<br><br><br>
	<a id="check-btn" href="javascript:logoutCheck()">로그아웃</a> &nbsp; &nbsp; &nbsp; 
	<a id="check-btn" href="javascript:removeCheck()">회원 탈퇴</a>
</div>


