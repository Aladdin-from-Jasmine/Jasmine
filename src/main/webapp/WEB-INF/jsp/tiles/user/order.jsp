<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<h1>My Page</h1>
	<h3>order 💳</h3><br>
	<h3>auction</h3>

	<div class="row">
			<div class="col-lg-4 col-md-6 mb-4">
				<div class="post-entry-1 h-100">
					<div class="post-entry-1-contents">
						<table class="listTb" align="center">
							<tr class="listTb-tr1">
								<td class="listTb-1">ID</td>
								<td class="listTb-3">Total Price</td>
								<td class="listTb-2">Order Date</td>
							</tr>
							<c:forEach var="order" items="${orderList}" varStatus="status">
								<tr class="listTb-tr2">
									<td><a id="a2-btn" href="<c:url value='/order/detail'>
	  											<c:param name="orderId" value="${order.orderId}"/>
											  </c:url>">${order.orderId}</a>
									</td>
									<td><fmt:formatNumber value="${order.totalPrice}" pattern="#,##0" />원</td>
									<td><fmt:formatDate value="${order.orderDate}" pattern="yyyy/MM/dd hh:mm:ss" /></td>
								</tr>
							</c:forEach>
						</table>
						</div>
					</div>
				</div>
</div>