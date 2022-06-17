<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	function deleteBook(){		
		if(confirm("책을 삭제하시겠습니까?")){
			form.submit();	
			alert("책을 삭제했습니다.");
		} 
	}
	
	function AddtoCart() {
		const openButton = document.getElementById("a-btn");
		const modal = document.querySelector(".modal");
		const overlay = modal.querySelector(".md_overlay");
		const closeButton = modal.querySelector("button");
		//동작함수
		const openModal = () => {
			modal.classList.remove("hidden");
		}
		const closeModal = () => {
			modal.classList.add("hidden");
		}
		//클릭 이벤트
		openButton.addEventListener("click", openModal);
		closeButton.addEventListener("click", closeModal);
		
	}
</script>

<div class="container">
	<div id="signup-form">
		<h2 class="text-center">책 상세 페이지</h2>
		<br />
		<form:form modelAttribute="bookForm" method="POST" name="form" 
		action="/book/delete/${bookId}" id="signup-form-form"><br />
			<table class="TB1" align="center">
				<tr>
					<td class="td1">
 						<label for="img">이미지</label> 				
					</td>
					<td class="td2">
	  					 <%-- <form:input path="community.postId" class="form-control" value="${community.postId}" readonly="true" />
						 <form:errors path="community.postId" cssClass="error" />
						 <form:errors cssClass="error" /> --%>
						 <img src= "${book.img}" width="300px" height="350px"/>
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="title">제목</label>			
					</td>
					<td class="td2">
						${book.title}
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="title">등록날짜</label>			
					</td>
					<td class="td2">
						<fmt:formatDate value="${book.registerDate}" pattern="yyyy-MM-dd HH:mm" />
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="userId">판매자 이름</label>
					</td>
					<td class="td2">
						${book.userId}
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="genre">카테고리</label>
					</td>
					<td class="td2">
						${genre}
						
					</td>
				</tr>
				<tr>
					<td class="td1">
						<label for="isbn">ISBN</label></br>
					</td>
					<td class="td2">
						${book.isbn}
					</td>
				</tr>		
				
				<tr>
					<td class="td1">
						<label for="isbn">가격</label></br>
					</td>
					<td class="td2">
						${book.price}원
					</td>
				</tr>
				
				<tr>
					<td class="td1">
						<label for="isbn">출판사</label></br>
					</td>
					<td class="td2">
						${book.publisher}
					</td>
				</tr>
					
					
				<tr>
					<td class="td1">
						<label for="isbn">작가</label></br>
					</td>
					<td class="td2">
						${book.author}
					</td>
				</tr>	
			</table><br/>
			<c:if test="${isUser==true || isManager==true}" >
				<div class="form-group" align="center">
					<a href="<c:url value='/book/update?bookId=${book.bookId}'></c:url>" id="a-btn">수정</a>
					<input id="a-btn" type="button" value="삭제" onClick="deleteBook()" />
			</c:if>
			<c:if test="${isUser==false && isManager==false}" >
				<div class="form-group" align="center">
					
					<input id="a-btn" type="button" value="카트에 담기" onClick="AddtoCart(${book.bookId})" />
					<div class="modal hidden">
						<div class="md_overlay"></div>
						<div class="md_content">
							<h1>샘플 모달창</h1>
							<div class="modal_text">
								장바구니에 담았습니다.
							</div>
							<button>X</button>
						</div>
					</div>
			</c:if>
			
					<a href="<c:url value='/book/list'/>" id="a-btn">목록</a>
				</div>
		</form:form>
	</div>
</div>