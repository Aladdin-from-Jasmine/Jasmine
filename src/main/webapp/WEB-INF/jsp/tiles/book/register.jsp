<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<body>
	<h1>책 등록</h1>
	<form:form modelAttribute="bookForm" method="POST"
		action="/book/register" enctype="multipart/form-data">

상품 사진
<form:input type="file" path="report" /> 


책 제목
<form:input path="title" />
		<br>
ISBN
<form:input path="isbn" />
		<br>
가격
<form:input path="price" />

		<br>
작가
<form:input path="author" />

		<br>
출판사
<form:input path="publisher" />

		<br>
카테고리
<form:select path="categoryId">
			<option value="">카테고리를 선택해주세요.</option>
			<form:options items="${genres}" itemValue="categoryId"
				itemLabel="genre" />
		</form:select>

		<input type="submit" value="REGISTER" id="register-btn">
	</form:form>
</body>
