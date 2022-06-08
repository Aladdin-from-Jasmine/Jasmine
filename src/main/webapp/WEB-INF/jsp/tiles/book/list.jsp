<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
	function goLoginForm(){		
		if(confirm("로그인 후 가능한 기능입니다.")){
			window.location.href = "http://localhost:8080/user/login";
		}
	}
	

	
	function bookDetail(bookId) {
		window.location.href = "http://localhost:8080/book/detail/"+ bookId;
	}

	
	
</script>

<div class="container">
	<h1>Book List</h1>
</div>

	<div class="container">
	<c:if test="${!empty userSession.user}">
		<a id="auction-register-btn"
			href="<c:url value='/book/register'></c:url>">책 등록
		</a> <br/> <br/> <br/>
	</c:if>
	
	<c:if test="${empty userSession.user}">
		<input id="auction-register-btn" type="button" value="게시물 등록" onClick="goLoginForm()" />
		<br/> <br/> <br/>
	</c:if>
	
		<div class="row">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="post-entry-1 h-100">
					<div class="post-entry-1-contents">
						<table class="listTb" align="center">
							<tr class="listTb-tr1">
								<td class="listTb-1">책 사진</td>
								<td class="listTb-2">제목</td>
								<td class="listTb-3">등록자</td>
								<td class="listTb-2">가격</td>
							</tr>
							<c:forEach var="book" items="${bookList}">
								<tr class="listTb-tr2" onClick="bookDetail(${book.bookId})">
									<td><img src= "${book.img}" width="200px" height="200px"/></td>
									<td>${book.title}</td>
									<td>${book.userId}</td>
									<td>
										<div class="price-wrap d-flex">
											<span class="meta d-inline-block mb-3"> &nbsp;
												${book.price}
											</span>
										</div>
									</td>
								</tr>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
			<br/><br/>
		</div>
</div>
