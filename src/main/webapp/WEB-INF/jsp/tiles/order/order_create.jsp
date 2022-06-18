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


<h1>결제</h1></br></br></br>
<div>
	<div class="container">
		<h2 class="orderForm-h2">주문 상품 확인</h2>
		<div id="orderForm">
			<table class="TB4" align="center">
				<tr>
					<!-- 경매 결제 -->
					<c:if test="${isAuction == true}">
						<td class="listTb-2">
							상품명 : <a href="<c:url value='/auction/detail'>
												<c:param name="auctionId" value="${orderForm.order.auctionId}" />
											</c:url>">${orderForm.order.auction.title}</a>
						</td>
						<td>금액 : ${orderForm.order.totalPrice}원</td>
						<td style="font-weight: bold">TotalPrice : ${orderForm.order.totalPrice}원</td>
					</c:if>
					<!-- 책 결제 -->
					<c:if test="${isAuction == false}">
						<td style="color:#2974ff" class="listTb-2" onClick="bookDetail(${orderForm.order.book.bookId})">
							상품명 : ${orderForm.order.book.title}</a>
						</td>
						<td>금액 : ${orderForm.order.totalPrice}원</td>
						<td style="font-weight: bold">TotalPrice : ${orderForm.order.totalPrice}원</td>
					</c:if>
				</tr>
			</table>
		</div>
	</div>
	<div class="container">
		<h2 class="orderForm-h2">결제 정보 입력</h2>
		<div id="orderForm">
			<table class="TB5" align="center">
				<form:form modelAttribute="orderForm" method="POST" 
				action="/order/create">
					<form:input type="hidden" path="order.orderId" value="${order.userId}"/>
					<tr>
						<td class="listTb-tr2">카드정보</td>
						<td>
							<form:select path="order.cardBank" items="${cardBanks}" />
							<form:errors path="order.cardBank" class="error" />
							<form:input path="order.cardNo" type="text" style="width:250px"
								class="form-control" placeholder="카드번호 ex) 1234-1234-1234-1234" />
							<form:errors path="order.cardNo" cssClass="error" />
						</td>
					</tr>
					<tr>
						<td class="listTb-tr2">유효기간</td>
						<td>
							<form:input path="order.validDate" type="text"
								class="form-control" placeholder="MM/YY ex) 12/34" />
							<form:errors path="order.validDate" class="error" />
						</td>
					</tr>
					<tr>
						<td class="listTb-tr2">CVC</td>
						<td>
							<form:input path="order.cvc" type="text" 
								class="form-control" placeholder="cvc ex) 123" />
							<form:errors path="order.cvc" class="error" />	
						</td>
					</tr>
					<tr>
						<td class="listTb-tr2">전화번호</td>
						<td>
							<form:input path="order.phone" type="text"
								class="form-control" placeholder="phone ex) 010-1234-5678" />
							<form:errors path="order.phone" class="error" />
						</td>
					</tr>
					<tr>
						<td class="listTb-tr2">주소</td>
						<td>
							<form:input	path="order.address" type="text" class="form-control" />
							<form:errors path="order.address" class="error" />
						</td>
					</tr>
					<tr>
						<td class="listTb-tr2">환불계좌</td>
						<td>
							<form:select path="order.refundBank" >
								<option value="" disabled>은행</option>
								<form:options items="${cardBanks}" />
							</form:select>
							<form:errors path="order.refundBank" class="error" />	
							<form:input path="order.refundAccount" type="text" style="width:250px"
								class="form-control" placeholder="환불계좌 ex) 123-1234-1234" />
							<form:errors path="order.refundAccount" class="error" />	 
						</td>
					</tr>
				</table>
				</br></br>
				<div  align="center">
					<input id="auction-register-btn" type="submit" value="Order" > &nbsp;
					<c:if test="${isAuction == true}">
						<a id="auction-register-btn" href="<c:url value='/auction/detail'>
		                                 <c:param name="auctionId" value="${orderForm.order.auction.auctionId}"/>
		                               </c:url>">Cancel</a> 
		            </c:if>
		            <c:if test="${isAuction == false}">
						<a id="auction-register-btn" href="<c:url value='/user/cart' />">Cancel</a> 
		            </c:if>
				</div>
			</form:form>
		</div>	
				<%--<c:choose>
					 <c:when test="${not empty orderForm.order.lineGroupBuys}">  
						<div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100" style="width:1000px;">
									<div class="post-entry-1-contents" style="width:1000px;">
										<h4>
											<a href="<c:url value='../../groupBuy/detail.do'>
															<c:param name="groupBuyId" value="${orderForm.order.groupBuyId}" />
													 </c:url>"> ${orderForm.order.groupBuy.title}</a>
										</h4>
										<c:forEach var="lineGroupBuy" items="${orderForm.order.lineGroupBuys}" varStatus="status"><br />
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
									<h4>TotalPrice : ${orderForm.order.totalPrice}원</h4> &nbsp;
								</div>
						</div>
						
					</c:when>
					<c:otherwise>--%> <!-- auction이 담긴 orderForm이 넘어옴 -->
							<%-- <div class="col-lg-4 col-md-6 mb-4">
								<div class="post-entry-1 h-100" style="width:1000px;">
									<div class="post-entry-1-contents" style="width:1000px;">
										<h3>
											<a href="<c:url value='../auction/detail.do'>
															<c:param name="auctionId" value="${orderForm.order.auction.auctionId}" />
													 </c:url>"> ${orderForm.order.auction.title}</a>
										</h3>
		
										<span class="meta d-inline-block mb-3">
											<span class="mx-2"> 금액 : ${orderForm.order.totalPrice}원</span> <br>
										</span>
									</div>
								</div><br />
								<div class="d-flex">
									<h4>TotalPrice : ${orderForm.order.totalPrice}원</h4> &nbsp;
								</div>
							</div> --%>
					<%-- </c:otherwise>
				</c:choose> --%>
	</div>
</div>
		
