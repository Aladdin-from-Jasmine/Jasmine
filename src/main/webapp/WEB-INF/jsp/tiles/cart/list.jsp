<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>



	function bookDetail(bookId) {
		window.location.href = "http://localhost:8080/book/detail/"+ bookId;
	}
	
	function cartDelete(bookId) {
		window.location.href = "http://localhost:8080/cart/delete/"+ bookId;
	}
	




</script>

	<h1>CART</h1>
		<div class="row">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="post-entry-1 h-100">
					<div class="post-entry-1-contents" align="center">
						<table class="listTb" align="center">
							<tr class="listTb-tr1">

								<td style="width:30%">책 사진</td>
								<td style="width:10%">제목</td>
								<td style="width:10%">등록자</td>
								<td style="width:10%">가격</td>

								<td style="width:20%">등록날짜</td>
								<td style="width:20%">개별결제</td>
								<td style="width:10%">삭제</td>

							</tr>
							<c:forEach var="book" items="${bookList}">
								<tr class="listTb-tr2" >
									<td onClick="bookDetail(${book.bookId})"><img src= "${book.img}" width="200px" height="200px"/></td>
									<td onClick="bookDetail(${book.bookId})">${book.title}</td>
									<td onClick="bookDetail(${book.bookId})">${book.userId}</td>
									<td onClick="bookDetail(${book.bookId})">
										<div class="price-wrap d-flex">
											<span class="meta d-inline-block mb-3"> &nbsp;
												${book.price}
											</span>
										</div>
									</td>
									<td>
										<fmt:formatDate value="${book.registerDate}" pattern="MM-dd HH:mm" />
									</td>

									

									<td><a  href="<c:url value='/order/book/create'>
		                                		 <c:param name="bookId" value="${book.bookId}"/>
		                               		</c:url>">결제하기</a></td>
						<td onClick="cartDelete(${book.bookId})">삭제하기</td>

								</tr>
							</c:forEach>
						</table>
							
						</div>
					</div>
				</div>
			<br/><br/>
		</div>
</div>
