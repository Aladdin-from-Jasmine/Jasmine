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

<h1>결제 내역</h1></br>
							
<div>
	<c:if test="${!empty message}">
		<h3 style="color:red;">${message}</h3>
	</c:if><br /></br>
	<div class="container">
		<c:if test="${not empty order.auction}">
			<div>
				<h2 class="orderForm-h2" style="color: #f57ad4"><button disabled>경매</button> &nbsp;
					<a href="<c:url value='/auction/detail'>
								<c:param name="auctionId" value="${order.auction.auctionId}" />
							</c:url>"> ${order.auction.title}</a>&nbsp;&nbsp;&nbsp;
					TotalPrice : ${order.totalPrice}원</h2>
			</div>
		</c:if>
		<c:if test="${empty order.auction}">
			<div>
			<h2 class="orderForm-h2">
				<table>
					<tr>
						<td style="color:#2974ff; width:50%; text-align:center;" onClick="bookDetail(${order.book.bookId})">
							<button disabled>책</button> &nbsp;
							${order.book.title}
						</td>
						<th style="font-size:20px; color: #f57ad4; text-align:center;">totalPrice : ${order.totalPrice}원</th>
					</tr>
				</table>	
			</h2>
			</div>
		</c:if>
			<div id="orderForm">
				<table class="TB5" align="center">
					<tr>
						<th class="listTb-tr2" scope="row">카드정보</th>
						<td>${order.cardBank} &nbsp; ${order.cardNo}</td>
					</tr>
					<tr>
						<th class="listTb-tr2" scope="row">유효기간</th>
						<td>${order.validDate}</td>
					</tr>
					<tr>
						<th class="listTb-tr2" scope="row">CVC</th>
						<td>${order.cvc}</td>
					</tr>
					<tr>
						<th class="listTb-tr2" scope="row">주소</th>
						<td>${order.address}</td>
					</tr>
					<tr>
						<th class="listTb-tr2" scope="row">전화번호</th>
						<td>${order.phone}</td>
					</tr>
					<tr>
						<th class="listTb-tr2" scope="row">환불계좌</th>
						<td>${order.refundBank} &nbsp; ${order.refundAccount}</td>
					</tr>
				</table>
			</div>
		
	</div> </br> </br>
	
	<div class="container">
		<a id="auction-register-btn" href="<c:url value='/user/order'>
												<c:param name="menuId" value ="0" />
											</c:url>">목록</a> &nbsp;
	</div>
</div>					




	