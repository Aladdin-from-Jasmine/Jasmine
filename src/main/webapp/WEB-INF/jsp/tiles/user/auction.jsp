<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="container">
	<h1>My Page</h1>
	<h3>auction ⌛</h3>
</div>
<c:forEach var="auction" items="${auctionList}" varStatus="status">
	<c:param name="auctionId" value ="${auction.auctionId}" />
<%-- 		<img src="${auction.img}" alt="Image" class="img-fluid">  --%>
		<c:if test="${auction.state eq 'proceeding'}">
			<h5>Proceeding</h5>
		</c:if> 
		<c:if test="${auction.state eq 'closed'}">
			<h5>Closed</h5>
		</c:if> 
		<span> &nbsp; ~ 
			<fmt:formatDate value="${auction.endDate}" pattern="yyyy-MM-dd" /> 								
		</span> 
			<c:param name="auctionId" value="${auction.auctionId}" /> 
			<h2>${auction.title} </h2>
		<span>현재 최고 금액&nbsp; 
		<fmt:formatNumber value="${auction.maxPrice}" pattern="#,###원" />
		</span>
	<p>${auction.content}</p>
</c:forEach>