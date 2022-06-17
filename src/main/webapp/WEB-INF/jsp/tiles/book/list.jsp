<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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

<div align="center">
		<form method="POST" action="/book/list" >
			<input id="search-book-form" type="text" name="keyword" class="form-control" />
			<input id="search-book-form" type="submit" value="검색" id="register-btn">
		</form>
	</div>
	</br>

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
								<td class="listTb-2">책 사진</td>
								<td class="listTb-1">제목</td>
								<td class="listTb-1">등록자</td>
								<td class="listTb-1">가격</td>
								<td class="listTb-2">등록날짜</td>
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
									<td>
										<fmt:formatDate value="${book.registerDate}" pattern="MM-dd HH:mm" />
									</td>
									
								</tr>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
			<br/><br/>
		</div>
		
		<ul class="paging">
    <c:if test="${paging.prev}">
    	<span><a href='<c:url value="/book/list?page=${paging.startPage-1}"/>'>이전</a></span>
    </c:if>
    <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
    	<span><a href='<c:url value="/book/list?page=${num}"/>'>${num}</a></span>
    </c:forEach>
    <c:if test="${paging.next && paging.endPage>0}">
    	<span><a href='<c:url value="/book/list?page=${paging.endPage+1}"/>'>다음</a></span>
    </c:if>
</ul>
		
		
		
</div>
