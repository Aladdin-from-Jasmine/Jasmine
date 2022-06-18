<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<body>
<h1>책 수정</h1>
 <form:form modelAttribute="bookForm" method="POST"
action="/book/update?bookId=${bookForm.bookId}" enctype="multipart/form-data">

<div class="book-form-sub">
상품 사진
<form:input type="file" path="report"/> 
<form:errors path="report" class="error" />
</div>

<br>

<div class="book-form-sub">
책 제목
<form:input path="title" value="${title}" class="form-control"/>
<form:errors path="title" class="error" />
</div>

<div class="book-form-sub">
<br>
ISBN
<form:input path="isbn" value="${isbn}" class="form-control"/>
<form:errors path="isbn" class="error" />
</div>

<div class="book-form-sub">
<br>
가격
<form:input path="price" value="${price}" class="form-control"/>
<form:errors path="price" class="error" />
</div>

<div class="book-form-sub">
<br>
작가
<form:input path="author" value="${author}" class="form-control"/>
<form:errors path="author" class="error" />
</div>

<div class="book-form-sub">
<br>
출판사
<form:input path="publisher" value="${publisher}" class="form-control"/>
<form:errors path="publisher" class="error" />
</div>

<div class="book-form-sub">
<br>
카테고리
<form:select path="categoryId" class="form-control">
<option value="categoryId">${categoryId}</option>
<form:options items="${genres}" itemValue="categoryId" itemLabel="genre"/>
</form:select> 
<form:errors path="categoryId" class="error" />
</div>


<div class="book-form-sub">
<br>
설명
<form:input path="description" value="${description}" class="form-control"/>
<form:errors path="description" class="error" />
</div>




<input type="submit" value="REGISTER" id="register-btn">
			
 </form:form> 
</body>
