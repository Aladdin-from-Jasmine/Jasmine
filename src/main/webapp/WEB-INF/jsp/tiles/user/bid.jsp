<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<h1>My Page</h1>
	<h3>낙찰된 경매 ⌛</h3>
</div>
	<div>
		<c:forEach var="bid" items="${bidList}" varStatus="status">
			<div id="auctionForm">
					<h3>${bid.userId}</h3>
				</div>
		</c:forEach>
	</div>