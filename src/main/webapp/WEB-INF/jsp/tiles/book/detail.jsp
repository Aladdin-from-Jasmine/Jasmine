
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h1>책 상세 페이지</h1>


		<table class="mypage-table">
			
			<tr>
				<th>이미지</th>
				<td><img src= "${book.img}" /></td>
			</tr>
			
			
			
			
			<tr>
				<th>제목</th>
				<td>${book.title}</td>
			</tr>
			<tr>
				<th>판매자 이름</th>
				<td>${book.userId}</td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td>${genre}</td>
			</tr>
			<tr>
				<th>ISBN</th>
				<td>${book.isbn}</td>
			</tr>
			<tr>
				<th>가격</th>
				<td>${book.price}</td>
			</tr>
			<tr>
				<th>출판사</th>
				<td>${book.publisher}</td>
			</tr>
			<tr>
				<th>작가</th>
				<td>${book.author}</td>
			</tr>
		</table>




<!-- //////////////////////// -->



