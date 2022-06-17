<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<body>
<h1>책 등록</h1>
 <form:form modelAttribute="bookForm" method="POST"
action="/book/update" enctype="multipart/form-data">
<!-- book이랑 카테고리 조인..하고 user정보도 넘겨줘야할거같은데,,? -->



상품 사진
<img src="${bookForm.img}" width="300px" height="350px"/>

<form:input type="file" path="report"/> 


<br>


책 제목
<form:input path="title" value="${title}"/>
<br>
ISBN
<form:input path="isbn" value="${isbn}"/>
<br>
가격
<form:input path="price" value="${price}"/>

<br>
작가
<form:input path="author" value="${author}"/>

<br>
출판사
<form:input path="publisher" value="${publisher}"/>

<br>
카테고리
<form:select path="categoryId">
<option value="categoryId">${categoryId}</option>
<form:options items="${genres}" itemValue="categoryId" itemLabel="genre"/>
</form:select> 

<input type="submit" value="REGISTER" id="register-btn">
			
<!-- 근데 이런식으로 할거면,, category를 그냥 string으로 두는게 나을거같은뎅.. -->
<!--  근데 있는 카테고리만 써야하니까,, 이렇게 할 ㅜㅅ ㅏㅂㄲ에 없는건가,, -->
 </form:form> 
</body>
