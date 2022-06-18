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
<div align="center">
				<form method="POST"
				action="/book/list" >
		<input id="search-auction-form" type="text" name="keyword" class="form-control" />
			<input id="search-auction-form" type="submit" value="검색" id="register-btn">
				</form>
				<br><br><br>
			</div>
	<div class="container">
	<c:if test="${!empty userSession.user}">
		<a id="auction-register-btn"
			href="<c:url value='/book/register'></c:url>">책 등록
		</a> 
	</c:if>
			<br><br><br>		
	<c:if test="${empty userSession.user}">
		<input id="auction-register-btn" type="button" value="게시물 등록" onClick="goLoginForm()" />
		<br/> <br/> <br/>
	</c:if>
	
<%-- 	총 ${listSize} 건의 검색결과가 있습니다. --%>
<!--  
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
								<td class="listTb-2">등록날짜</td>
							</tr>
							<c:forEach var="book" items="${bookList.pageList}">
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
							<c:if test="${!bookList.firstPage}">
	          <a href="/book/list?page=previous" style=""><font color="#d164c4"><B>&lt;&lt;
	                Prev</B></font></a>
	        </c:if> 
	        <c:if test="${!bookList.lastPage}">
	          <a href="/book/list?page=next"><font color="#d164c4"><B>Next
	                &gt;&gt;</B></font></a>
	        </c:if>
						</div>
					</div>
				</div>
			<br/><br/>
		</div>
	-->	
	<div>
		<c:forEach var="book" items="${bookList.pageList}" varStatus="status">
			<div id="auctionForm">
				<table class="TB3" align="center">
					<tr>
						<td rowspan="5">
							<img src="${book.img}" alt="Image" width="200px" height="200px">
						</td>
						<td>
							<h3>
								Title :&nbsp;
								<a href="javascript:void(0);" onclick="bookDetail(${book.bookId})">${book.title}</a>                        
							</h3>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<span>userId : ${book.userId} &nbsp;	
							</span>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<span>작가 : ${book.author} &nbsp;	
							</span>
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<span> <span>가격 : </span> &nbsp; 
									<fmt:formatNumber value="${book.price}" pattern="#,###원" />
							</span>	
						</td>
					</tr>
					<tr>
						<td text-align="center">
							<p>등록 날짜 : <fmt:formatDate value="${book.registerDate}" pattern="MM-dd HH:mm" /></p>
						</td>
					</tr>		
				</table>
			</div>
		</c:forEach>
		<c:if test="${!bookList.firstPage}">
	          <a href="/book/list?page=previous" style=""><font color="#d164c4"><B>&lt;&lt;
	                Prev</B></font></a>
	        </c:if> 
	        <c:if test="${!bookList.lastPage}">
	          <a href="/book/list?page=next"><font color="#d164c4"><B>Next
	                &gt;&gt;</B></font></a>
	        </c:if>
	</div>

</div>
