<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="container">
	<h1>My Page</h1>

	<a id="a-btn" href="<c:url value='list'> <c:param name="menuId" value ="1" /> </c:url>"> 경매등록 목록 보기</a> 
	<a id="a-btn" href="<c:url value='list'> <c:param name="menuId" value ="2" /> </c:url>"> 책 구매/등록 목록 보기</a> 
	<a id="a-btn" href="<c:url value='list'> <c:param name="menuId" value ="0" /> </c:url>">결제 목록 보기</a> 

	<c:if test="${menuId eq 0}">
		<h2>
			<b>결제 목록 보기</b>
		</h2>
		<br>
	</c:if>
	<c:if test="${menuId eq 1}">
		<h2>
			<b>경매 등록 목록 보기</b>
		</h2>
		<br>
	</c:if>
	<c:if test="${menuId eq 2}">
		<h2>
			<b>책 구매/등록 목록 보기</b>
		</h2>
		<br>
	</c:if>


	<!-- 결제 목록 보기 -->
	<c:if test="${menuId eq 0}">
		<h3>경매 결제 목록</h3>
		<br />
		<div class="row">
			<c:forEach var="order" items="${auctionOrderList}" varStatus="status">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="post-entry-1 h-100">
						<a
							href="<c:url value='../auction/detail.do'>
												<c:param name="auctionId" value="${order.auctionId}" />
											</c:url>">
							<img src="${order.auction.img}" alt="Image" class="img-fluid">
						</a>
						<div class="post-entry-1-contents">

							<h2>
								<a
									href="<c:url value='../auction/detail.do'>
														<c:param name="auctionId" value="${order.auctionId}" />
													</c:url>">
									${order.auction.title}</a>
							</h2>

							<span class="meta d-inline-block mb-3"> <fmt:formatDate
									value="${order.orderDate}" pattern="yyyy-MM-dd" /> <span
								class="mx-2"> 총액 : ${order.totalPrice}원</span>
							</span><br /> <br />
						</div>
						<p style="text-align: right; padding: 20px;">
							<a
								href="<c:url value='../order/auction/detail.do'>
												<c:param name="orderId" value ="${order.orderId}" />
											</c:url>">
								상세보기 > </a>
						</p>
					</div>
				</div>
			</c:forEach>
		</div>

		<h3>공동구매 결제 목록</h3>
		<br />
		<div class="row">
			<c:forEach var="order" items="${groupBuyOrderList}"
				varStatus="status">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="post-entry-1 h-100">
						<a
							href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value="${order.groupBuyId}" />
											</c:url>">
							<img src="${order.groupBuy.img}" alt="Image" class="img-fluid">
						</a>
						<div class="post-entry-1-contents">
							<h2>
								<a
									href="<c:url value='../groupBuy/detail.do'>
														<c:param name="groupBuyId" value="${order.groupBuyId}" />
													</c:url>">
									${order.groupBuy.title}</a>
							</h2>

							<span class="meta d-inline-block mb-3"> <fmt:formatDate
									value="${order.orderDate}" pattern="yyyy-MM-dd" /> <span
								class="mx-2"> 총액 : ${order.totalPrice}원</span>
							</span>
						</div>
						<p style="text-align: right; padding: 20px;">
							<a
								href="<c:url value='../order/groupBuy/detail.do'>
												<c:param name="orderId" value ="${order.orderId}" />
											</c:url>">
								상세보기 > </a>
						</p>
					</div>

				</div>
			</c:forEach>
		</div>
	</c:if>

	<!-- 경매 목록 보기 -->
	<c:if test="${menuId eq 1}">
		<div class="row">
			<c:forEach var="auction" items="${auctionList}" varStatus="status">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="post-entry-1 h-100">
						<a
							href="<c:url value='../auction/detail.do'>
												<c:param name="auctionId" value ="${auction.auctionId}" />
											</c:url>">
							<img src="${auction.img}" alt="Image" class="img-fluid">
						</a>
						<div class="post-entry-1-contents">
							<div class="price-wrap d-flex" style="color: blue;">
								<c:if test="${auction.state eq 'proceeding'}">
									<h5>Proceeding</h5>
								</c:if>

								<c:if test="${auction.state eq 'closed'}">
									<h5>Closed</h5>
								</c:if>

								<span class="meta d-inline-block mb-3"> &nbsp; ~ <fmt:formatDate
										value="${auction.endDate}" pattern="yyyy-MM-dd" />
								</span>
							</div>
							<h2>
								<a
									href="<c:url value='../auction/detail.do'>
														<c:param name="auctionId" value ="${auction.auctionId}" />
													</c:url>">
									${auction.title} </a>
							</h2>
							<span class="meta d-inline-block mb-3"> <span>현재 최고
									금액</span> &nbsp; <a href="#"><fmt:formatNumber
										value="${auction.maxPrice}" pattern="#,###원" /></a>
							</span>

							<p>${auction.content}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>

	<!-- 공동구매 목록 보기 -->
	<c:if test="${menuId eq 2}">
		<div class="row">
			<c:forEach var="groupBuy" items="${groupBuyList}" varStatus="status">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="post-entry-1 h-100">
						<a
							href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value ="${groupBuy.groupBuyId}" />
											</c:url>">
							<img src="${groupBuy.img}" alt="Image" class="img-fluid">
						</a>
						<div style="float: right">조회수: ${groupBuy.count}&nbsp;&nbsp;</div>
						<div class="post-entry-1-contents">
							<div class="price-wrap d-flex" style="color: blue;">
								<c:if test="${groupBuy.state eq 'proceeding'}">
									<h5>Proceeding</h5>
								</c:if>
								<c:if test="${groupBuy.state eq 'achieved'}">
									<h5>Achieved</h5>
								</c:if>
								<c:if test="${groupBuy.state eq 'closed'}">
									<h5>Closed</h5>
								</c:if>

								<span class="meta d-inline-block mb-3"> &nbsp; ~ <fmt:formatDate
										value="${groupBuy.endDate}" pattern="yyyy-MM-dd" />
								</span>
							</div>
							<h2>
								<a
									href="<c:url value='../groupBuy/detail.do'>
												<c:param name="groupBuyId" value ="${groupBuy.groupBuyId}" />
											</c:url>">
									${groupBuy.title} </a>
							</h2>
							<span class="mx-2">가격</span> <a href="#"><fmt:formatNumber
									value="${groupBuy.price}" pattern="#,###원" /></a> <br /> <br />
							<span class="mx-2">달성률</span> <a href="#"><fmt:formatNumber
									value="${groupBuy.participants}" />명 / </a> <a href="#"><fmt:formatNumber
									value="${groupBuy.minNo}" />명</a> <a href="#"><fmt:formatNumber
									value="${groupBuy.rate}" />%</a>


							<p>${groupBuy.content}</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</c:if>
	<div class="col-12 mt-5 text-center">
		<span class="p-3">1</span> <a href="#" class="p-3">2</a> <a href="#"
			class="p-3">3</a> <a href="#" class="p-3">4</a>
	</div>

</div>
