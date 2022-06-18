<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<h1>책 등록</h1>

	<spring:hasBindErrors name="bookForm"></spring:hasBindErrors>
<div class="container">
	<form:form modelAttribute="bookForm" method="POST" name="bookForm"
		action="/book/register" enctype="multipart/form-data">

		<div class="auction-form-sub">
			상품 사진
			<form:input type="file" path="report" />
		</div>

		<div class="auction-form-sub">
			<label for="auction.title">책 제목</label>
			<form:input path="title" class="form-control" />
			<form:errors path="title" class="error" />
		</div>

		<div class="auction-form-sub">
			<br> ISBN
			<form:input path="isbn" class="form-control" />
			<form:errors path="isbn" class="error" />
		</div>

		<div class="auction-form-sub">
			<br> 가격
			<form:input path="price" class="form-control" />
			<form:errors path="price" class="error" />
		</div>

		<div class="auction-form-sub">
			<br> 작가
			<form:input path="author" class="form-control" />
			<form:errors path="author" class="error" />
		</div>

		<div class="auction-form-sub">
			<br> 출판사
			<form:input path="publisher" class="form-control" />
			<form:errors path="publisher" class="error" />
		</div>

		<div class="auction-form-sub">
			<br> 카테고리
			<form:select path="categoryId" class="form-control">
				<option value="0">카테고리를 선택해주세요.</option>
				<form:options items="${genres}" itemValue="categoryId"
					itemLabel="genre" />
			</form:select>
			<form:errors path="categoryId" class="error" />
		</div>

		<input type="submit" value="REGISTER" id="register-btn">
	</form:form>
	</div>