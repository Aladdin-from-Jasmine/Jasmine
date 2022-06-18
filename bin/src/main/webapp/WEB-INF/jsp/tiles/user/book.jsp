<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script>
	function bookDetail(bookId) {
		window.location.href = "http://localhost:8080/book/detail/"+ bookId;
	}
</script>
<div class="container">
	<h1>My Page</h1>
	<h3>내가 올린 책 📚</h3>
</div>

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