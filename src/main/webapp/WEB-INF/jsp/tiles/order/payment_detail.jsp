<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="site-section-cover">
	<div class="container">
		<div class="row align-items-center text-center justify-content-center">
			<div class="col-lg-6">
				<h1 class="text-white mb-4">My Page</h1>
				<p class="lead">회원 정보 조회 및 수정, 공동구매 및 경매에 등록한 목록이나 결제한 목록, 알림 등을 볼 수 있는 페이지</p>
			</div>
		</div>
	</div>
</div>


<div class="site-section">
	<section class="ftco-section ftco-car-details">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="car-details">
						<div class="text text-left">
							<span class="subheading" style="color:red;">&nbsp; ${message}</span><br />
							<h1>
								<b>세부 결제 내역</b>
							</h1>
							<br />
						<c:choose>
							<%-- <c:when test="${not empty order.groupBuy}">	
								<h3>
									<button disabled>공동구매</button>
									&nbsp; ${order.groupBuy.title}
								</h3>
							</c:when> --%>
							<c:when test="${not empty order.auction}">
								<h3>
									<button disabled>경매</button>
									&nbsp; ${order.auction.title}
								</h3>
							</c:when>
						</c:choose>
						</div>
						<br>

						<c:choose>
							<%-- <c:when test="${not empty order.groupBuy}">	
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100" style="width:1000px;">
									<div class="post-entry-1-contents" style="width:1000px;">
										<h4>
											<a href="<c:url value='../../groupBuy/detail.do'>
																<c:param name="groupBuyId" value="${order.groupBuy.groupBuyId}" />
													 </c:url>"> ${order.groupBuy.title}</a>
										</h4>
										<c:forEach var="lineGroupBuy" items="${order.lineGroupBuys}" varStatus="status"><br />
										<span class="meta d-inline-block mb-3"> 
											<span class="mx-2"> 옵션 : ${lineGroupBuy.selectOption}</span> &nbsp;&nbsp; 
											<span class="mx-2"> 수량 : ${lineGroupBuy.quantity}개</span> &nbsp;&nbsp;
											<span class="mx-2"> 금액 : ${lineGroupBuy.unitPrice}원</span>
										</span>
										</c:forEach>
									</div>
								</div>
								<br />
								<div class="d-flex">
									<h4>TotalPrice : ${order.totalPrice}원</h4>
									&nbsp;
								</div>
							</div>
							</c:when> --%>
							<c:when test="${not empty order.auction}">	
							<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100" style="width:1000px;">
									<div class="post-entry-1-contents" style="width:1000px;">
										<h4>
											<a href="<c:url value='../../auction/detail.do'>
																<c:param name="auctionId" value="${order.auction.auctionId}" />
													 </c:url>"> ${order.auction.title}</a>
										</h4>
	
										<span class="meta d-inline-block mb-3"> 
											<span class="mx-2"> 금액 : ${order.totalPrice}원</span> &nbsp;&nbsp;<br>
										</span>
									</div>
								</div>
								<br />
								<div class="d-flex">
									<h4>TotalPrice : ${order.totalPrice}원</h4>
									&nbsp;
								</div>
							</div>
							</c:when>
						</c:choose>
						<br>

						<div class="text text-left">
							<table class="table table-striped">
								<tbody>
									<tr>
										<th scope="row">카드정보</th>
										<td>${order.cardBank} &nbsp; ${order.cardNo}</td>
									</tr>
									<tr>
										<th scope="row">유효기간</th>
										<td>${order.validDate}</td>
									</tr>
									<tr>
										<th scope="row">CVC</th>
										<td>${order.cvc}</td>
									</tr>
									<tr>
										<th scope="row">주소</th>
										<td>${order.address}</td>
									</tr>
									<tr>
										<th scope="row">전화번호</th>
										<td>${order.phone}</td>
									</tr>
									<tr>
										<th scope="row">환불계좌</th>
										<td>${order.refundBank} &nbsp; ${order.refundAccount}</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br> <br>

						<div class="container">
							<a class="btn btn-primary py-3 px-5" href="<c:url value='/auction/list'>
																			<c:param name="menuId" value ="0" />
																	   </c:url>">목록</a>
							&nbsp;
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>




	